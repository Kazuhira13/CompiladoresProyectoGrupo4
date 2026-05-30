import argparse
import json
import csv
import os
import re
import shutil
from dataclasses import dataclass, field
from typing import List, Optional
from uuid import UUID
from semantic_analyzer import SemanticAnalyzer
@dataclass
class FieldDef:
    name: str
    dtype: str
    reference: Optional[str] = None
    constraints: dict = field(default_factory=dict)

@dataclass
class EntityDef:
    name: str
    fields: List[FieldDef] = field(default_factory=list)
    indexes: List[str] = field(default_factory=list)
    api_options: List[str] = field(default_factory=list)
    ui_options: List[str] = field(default_factory=list)

TYPES = {"uuid", "string", "int", "decimal", "bool", "date"}

class DSLException(Exception):
    pass

def parse_dsl(path: str) -> EntityDef:
    with open(path, "r", encoding="utf-8") as f:
        raw_lines = f.readlines()

    lines = []
    for line in raw_lines:
        line = line.split("//", 1)[0].strip()
        if line:
            lines.append(line)

    if not lines or not lines[0].startswith("entity "):
        raise DSLException("La primera linea debe iniciar con: entity NombreEntidad")

    entity_name = lines[0].split()[1]
    entity = EntityDef(entity_name)
    section = None

    for line in lines[1:]:
        if line == "fields:":
            section = "fields"
            continue

        if line.startswith("indexes:"):
            section = "indexes"
            entity.indexes = [x.strip() for x in line.split(":", 1)[1].split(",") if x.strip()]
            continue

        if line.startswith("api "):
            section = None
            entity.api_options = line.split()[1:]
            continue

        if line.startswith("ui "):
            section = None
            entity.ui_options = line.split()[1:]
            continue

        if section == "fields":
            entity.fields.append(parse_field(line))
        else:
            raise DSLException(f"Linea no reconocida: {line}")

    return entity

def parse_field(line: str) -> FieldDef:
    parts = line.split()
    if len(parts) < 2:
        raise DSLException(f"Campo invalido: {line}")
    name, dtype = parts[0], parts[1]
    index = 2
    ref = None
    if dtype == "reference":
        if len(parts) < 3:
            raise DSLException(f"El campo reference necesita una entidad: {line}")
        ref = parts[2]
        index = 3
    elif dtype not in TYPES:
        raise DSLException(f"Tipo de dato no soportado en campo {name}: {dtype}")
    constraints = {}
    while index < len(parts):
        token = parts[index]
        if token in ("pk", "required", "unique"):
            constraints[token] = True
        elif token.startswith("min="):
            constraints["min"] = int(token.split("=", 1)[1])
        elif token.startswith("default="):
            constraints["default"] = token.split("=", 1)[1]
        elif token.startswith(">"):
            constraints["gt"] = float(token[1:])
        elif token.startswith("<"):
            constraints["lt"] = float(token[1:])
        else:
            raise DSLException(f"Restriccion no reconocida en {name}: {token}")
        index += 1
    return FieldDef(name, dtype, ref, constraints)

def validate_entity(entity: EntityDef) -> None:
    names = [f.name for f in entity.fields]
    if len(names) != len(set(names)):
        raise DSLException("No se permiten campos repetidos")
    pk = [f for f in entity.fields if f.constraints.get("pk")]
    if len(pk) != 1:
        raise DSLException("La entidad debe tener exactamente un campo pk")
    for idx in entity.indexes:
        if idx not in names:
            raise DSLException(f"El indice '{idx}' no existe en fields")
    for f in entity.fields:
        if "min" in f.constraints and f.dtype != "string":
            raise DSLException(f"La restriccion min solo aplica a string: {f.name}")
        if ("gt" in f.constraints or "lt" in f.constraints) and f.dtype not in ("int", "decimal"):
            raise DSLException(f"Las restricciones > o < solo aplican a numeros: {f.name}")

def reset_output() -> None:
    if os.path.exists("output"):
        shutil.rmtree("output")

    for folder in [
        "output/sql",
        "output/csharp",
        "output/python",
        "output/javascript",
        "output/ui",
        "output/bulk",
        "output/intermediate"
    ]:
        os.makedirs(folder, exist_ok=True)

def sql_type(f: FieldDef) -> str:
    if f.dtype == "uuid": return "UNIQUEIDENTIFIER"
    if f.dtype == "string": return "NVARCHAR(255)"
    if f.dtype == "int": return "INT"
    if f.dtype == "decimal": return "DECIMAL(18,2)"
    if f.dtype == "bool": return "BIT"
    if f.dtype == "date": return "DATETIME2"
    if f.dtype == "reference": return "INT"
    return "NVARCHAR(255)"

def cs_type(f: FieldDef) -> str:
    return {"uuid":"Guid", "string":"string", "int":"int", "decimal":"decimal", "bool":"bool", "date":"DateTime", "reference":"int"}[f.dtype]

def py_type(f: FieldDef) -> str:
    return {"uuid":"str", "string":"str", "int":"int", "decimal":"float", "bool":"bool", "date":"str", "reference":"int"}[f.dtype]

def js_default(f: FieldDef) -> str:
    if "default" in f.constraints: return f.constraints["default"]
    if f.dtype in ("int", "decimal", "reference"): return "0"
    if f.dtype == "bool": return "false"
    return "''"

def generate_sql(entity: EntityDef) -> None:
    cols = []
    checks = []

    for f in entity.fields:
        line = f"    {f.name} {sql_type(f)}"

        if f.constraints.get("pk"):
            line += " PRIMARY KEY"

        if f.constraints.get("required"):
            line += " NOT NULL"

        if "default" in f.constraints:
            line += f" DEFAULT {f.constraints['default']}"

        cols.append(line)

        if f.constraints.get("gt") is not None:
            checks.append(f"    CHECK ({f.name} > {f.constraints['gt']:g})")

        if f.constraints.get("lt") is not None:
            checks.append(f"    CHECK ({f.name} < {f.constraints['lt']:g})")

        if f.constraints.get("min") is not None:
            checks.append(f"    CHECK (LEN({f.name}) >= {f.constraints['min']})")

    script = f"CREATE TABLE {entity.name} (\n" + ",\n".join(cols + checks) + "\n);\n"

    for idx in entity.indexes:
        script += f"\nCREATE INDEX IX_{entity.name}_{idx} ON {entity.name}({idx});\n"

    with open(f"output/sql/{entity.name}.sql", "w", encoding="utf-8") as f:
        f.write(script)

def generate_csharp(entity: EntityDef) -> None:
    props = "\n".join([f"    public {cs_type(x)} {x.name[:1].upper()+x.name[1:]} {{ get; set; }}" for x in entity.fields])
    model = f"namespace CRUDForge.Generated;\n\npublic class {entity.name}\n{{\n{props}\n}}\n"
    controller = f'''using Microsoft.AspNetCore.Mvc;\n\nnamespace CRUDForge.Generated;\n\n[ApiController]\n[Route("api/[controller]")]\npublic class {entity.name}Controller : ControllerBase\n{{\n    [HttpGet]\n    public IActionResult Seleccionar() => Ok("Listado de {entity.name}");\n\n    [HttpPost]\n    public IActionResult Insertar([FromBody] {entity.name} item) => Ok(item);\n\n    [HttpPut("{{id}}") ]\n    public IActionResult Actualizar(string id, [FromBody] {entity.name} item) => Ok(item);\n\n    [HttpDelete("{{id}}") ]\n    public IActionResult Borrar(string id) => Ok($"Registro {{id}} eliminado");\n}}\n'''
    with open(f"output/csharp/{entity.name}.cs", "w", encoding="utf-8") as f: f.write(model)
    with open(f"output/csharp/{entity.name}Controller.cs", "w", encoding="utf-8") as f: f.write(controller)

def generate_python(entity: EntityDef) -> None:
    cols = []
    for f in entity.fields:
        coltype = {"uuid":"String", "string":"String", "int":"Integer", "decimal":"Numeric", "bool":"Boolean", "date":"DateTime", "reference":"Integer"}[f.dtype]
        args = []
        if f.constraints.get("pk"): args.append("primary_key=True")
        if f.constraints.get("required"): args.append("nullable=False")
        if "default" in f.constraints: args.append(f"default={repr(f.constraints['default'])}")
        cols.append(f"    {f.name} = Column({coltype}, {', '.join(args)})".rstrip(", "))
    code = f'''from sqlalchemy import Column, String, Integer, Numeric, Boolean, DateTime\nfrom sqlalchemy.orm import declarative_base\n\nBase = declarative_base()\n\nclass {entity.name}(Base):\n    __tablename__ = "{entity.name.lower()}"\n{chr(10).join(cols)}\n'''
    api = f'''from fastapi import FastAPI\n\napp = FastAPI(title="CRUDForge API")\n\n@app.get("/{entity.name.lower()}")\ndef seleccionar_{entity.name.lower()}(page:int=1, search:str=""):\n    return {{"entity":"{entity.name}", "page":page, "search":search}}\n\n@app.post("/{entity.name.lower()}")\ndef insertar_{entity.name.lower()}(item:dict):\n    return item\n\n@app.put("/{entity.name.lower()}/{{id}}")\ndef actualizar_{entity.name.lower()}(id:str, item:dict):\n    return item\n\n@app.delete("/{entity.name.lower()}/{{id}}")\ndef borrar_{entity.name.lower()}(id:str):\n    return {{"deleted": id}}\n'''
    with open(f"output/python/{entity.name}_model.py", "w", encoding="utf-8") as f: f.write(code)
    with open(f"output/python/{entity.name}_api.py", "w", encoding="utf-8") as f: f.write(api)

def generate_javascript(entity: EntityDef) -> None:
    example = ",\n".join([f"  {x.name}: {js_default(x)}" for x in entity.fields])
    code = f'''const express = require('express');\nconst router = express.Router();\n\nconst ejemplo{entity.name} = {{\n{example}\n}};\n\nrouter.get('/{entity.name.lower()}', (req, res) => res.json([ejemplo{entity.name}]));\nrouter.post('/{entity.name.lower()}', (req, res) => res.json(req.body));\nrouter.put('/{entity.name.lower()}/:id', (req, res) => res.json(req.body));\nrouter.delete('/{entity.name.lower()}/:id', (req, res) => res.json({{ deleted: req.params.id }}));\n\nmodule.exports = router;\n'''
    with open(f"output/javascript/{entity.name}.routes.js", "w", encoding="utf-8") as f: f.write(code)

def generate_ui(entity: EntityDef) -> None:
    headers = "".join([f"<th>{f.name}</th>" for f in entity.fields])
    inputs = "\n".join([f'<label>{f.name}</label><input name="{f.name}" placeholder="{f.name}">' for f in entity.fields])
    html = f'''<!doctype html>\n<html lang="es">\n<head><meta charset="utf-8"><title>CRUDForge - {entity.name}</title></head>\n<body>\n<h1>CRUD generado para {entity.name}</h1>\n<input placeholder="Buscar...">\n<form>\n{inputs}\n<button>Guardar</button>\n</form>\n<table border="1">\n<thead><tr>{headers}<th>Acciones</th></tr></thead>\n<tbody><tr><td colspan="{len(entity.fields)+1}">Datos generados por CRUDForge</td></tr></tbody>\n</table>\n</body>\n</html>\n'''
    with open(f"output/ui/{entity.name}.html", "w", encoding="utf-8") as f: f.write(html)

def validate_bulk(entity: EntityDef, path: str) -> None:
    errors = []
    with open(path, newline="", encoding="utf-8") as f:
        rows = list(csv.DictReader(f))
    field_map = {f.name: f for f in entity.fields}
    for i, row in enumerate(rows, start=2):
        for f in entity.fields:
            value = row.get(f.name, "")
            if f.constraints.get("required") and value == "": errors.append(f"Fila {i}: {f.name} es requerido")
            try:
                if f.dtype == "uuid" and value: UUID(value)
                if f.dtype == "int" and value: int(value)
                if f.dtype == "decimal" and value: float(value)
                if "min" in f.constraints and len(value) < f.constraints["min"]: errors.append(f"Fila {i}: {f.name} no cumple min={f.constraints['min']}")
                if "gt" in f.constraints and value and float(value) <= f.constraints["gt"]: errors.append(f"Fila {i}: {f.name} debe ser > {f.constraints['gt']}")
            except ValueError:
                errors.append(f"Fila {i}: {f.name} tiene formato invalido")
    report = "VALIDACION MASIVA CORRECTA\n" if not errors else "ERRORES EN VALIDACION MASIVA\n" + "\n".join(errors)
    with open("output/bulk/reporte_validacion.txt", "w", encoding="utf-8") as f: f.write(report)
    if errors:
        raise DSLException(report)

def generate_intermediate_code(entity: EntityDef) -> None:
    os.makedirs("output/intermediate", exist_ok=True)

    intermediate = {
        "entity": entity.name,
        "fields": [
            {
                "name": f.name,
                "type": f.dtype,
                "reference": f.reference,
                "constraints": f.constraints
            }
            for f in entity.fields
        ],
        "indexes": entity.indexes,
        "api_options": entity.api_options,
        "ui_options": entity.ui_options
    }

    with open(f"output/intermediate/{entity.name}_ir.json", "w", encoding="utf-8") as file:
        json.dump(intermediate, file, indent=4, ensure_ascii=False)

def entity_to_dict(entity):
    return {
        "name": entity.name,
        "fields": [
            {
                "name": f.name,
                "type": f.dtype,
                "pk": f.constraints.get("pk", False),
                "required": f.constraints.get("required", False),
                "min": f.constraints.get("min"),
                "gt": f.constraints.get("gt"),
                "default": f.constraints.get("default")
            }
            for f in entity.fields
        ],
        "indexes": entity.indexes
    }


def run_semantic_analysis(entity):
    analyzer = SemanticAnalyzer()
    errors = analyzer.analyze(entity_to_dict(entity))

    if errors:
        print("\n❌ ERRORES SEMÁNTICOS:")
        print("-----------------------")
        for e in errors:
            print(f"- {e}")
        return False

    print("\n✅ Análisis semántico correcto")
    return True


def command_check(args):
    entity = parse_dsl(args.input)

    print("🔎 Verificando archivo DSL...")
    print(f"Archivo: {args.input}")
    print(f"Entidad detectada: {entity.name}")

    if not run_semantic_analysis(entity):
        exit(1)

    print("✅ El archivo DSL es válido.")


def command_build(args):
    entity = parse_dsl(args.input)

    print("⚙️ Compilando archivo DSL...")
    print(f"Archivo: {args.input}")
    print(f"Entidad detectada: {entity.name}")

    if not run_semantic_analysis(entity):
        exit(1)

    reset_output()

    generate_intermediate_code(entity)
    generate_sql(entity)

    if "csharp" in args.languages:
        generate_csharp(entity)

    if "python" in args.languages:
        generate_python(entity)

    if "javascript" in args.languages:
        generate_javascript(entity)

    if "generate" in entity.ui_options:
        generate_ui(entity)

    if args.bulk:
        validate_bulk(entity, args.bulk)

    print("\n✅ CRUDForge ejecutado correctamente")
    print(f"Entidad: {entity.name}")
    print("Archivos generados en la carpeta output/")
    print("Código intermedio generado en output/intermediate/")


def main():
    parser = argparse.ArgumentParser(
        description="CRUDForge - Compilador para generar operaciones CRUD desde un DSL"
    )

    subparsers = parser.add_subparsers(
        dest="command",
        help="Comandos disponibles"
    )

    build_parser = subparsers.add_parser(
        "build",
        help="Compila un archivo .crudf y genera código"
    )
    build_parser.add_argument("input", help="Archivo .crudf")
    build_parser.add_argument(
        "--languages",
        nargs="+",
        default=["csharp", "python", "javascript"],
        choices=["csharp", "python", "javascript"],
        help="Lenguajes de salida"
    )
    build_parser.add_argument(
        "--bulk",
        help="CSV para ingreso masivo",
        default=None
    )
    build_parser.set_defaults(func=command_build)

    check_parser = subparsers.add_parser(
        "check",
        help="Valida el archivo .crudf sin generar código"
    )
    check_parser.add_argument("input", help="Archivo .crudf")
    check_parser.set_defaults(func=command_check)

    args = parser.parse_args()

    if not hasattr(args, "func"):
        parser.print_help()
        exit(1)

    args.func(args)

if __name__ == "__main__":
    try:
        main()
    except DSLException as ex:
        print("ERROR CRUDForge:")
        print(ex)
        raise SystemExit(1)
