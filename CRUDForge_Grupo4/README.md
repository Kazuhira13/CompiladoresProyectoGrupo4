# CRUDForge

CRUDForge es un compilador que permite definir entidades mediante un lenguaje propio (DSL) y generar automáticamente código CRUD completo.

Nota: La API generada es funcional a nivel de endpoints. Actualmente no persiste datos en base de datos, pero demuestra la generación automática de servicios REST.

---

## ¿Qué hace?

A partir de un archivo `.crudf`, el sistema genera:

- SQL (tablas e índices)
- APIs (C#, Python, JavaScript)
- UI básica en HTML
- Validaciones automáticas

---

## Ejemplo DSL

```txt
entity Producto
fields:
id uuid pk
nombre string required min=5
precio decimal >0
stock int default=0
categoria reference Categoria
indexes: nombre, precio
api full with pagination search
ui generate with filters sortable
```

---

## Código Intermedio

CRUDForge genera una representación intermedia en JSON antes de generar el código final.

Archivo:

```txt
output/intermediate/Producto_ir.json
```

Esto permite separar:

- Parsing
- Análisis semántico
- Generación de código

---

## Instalación

```bash
pip install -e .
```

---

## CLI

### Validar archivo DSL

```bash
python main.py check producto_malo.crudf
```

### Compilar proyecto

```bash
python main.py build input\producto.crudf
```

### Generar lenguajes específicos

```bash
python main.py build input\producto.crudf --languages csharp python
```

---

## Optimizaciones

### 1. Generación selectiva de lenguajes

El usuario puede elegir qué lenguajes desea generar.

```bash
python main.py build input\producto.crudf --languages csharp python
```

Esto evita generar archivos innecesarios.

### 2. Generación condicional de UI

La interfaz HTML solo se genera si el DSL incluye:

```txt
ui generate with filters sortable
```

Esto evita generar UI innecesaria.

### 3. Generación limpia de restricciones SQL

El generador solo crea restricciones SQL cuando realmente existen en el DSL.

Ejemplo:

```txt
precio decimal >0
```

Genera:

```sql
CHECK (precio > 0)
```

Esto permite generar SQL más limpio y legible.

---

## Limitaciones

La API generada actualmente es demostrativa.

Los endpoints funcionan correctamente mediante FastAPI y Swagger, pero aún no persisten datos en una base de datos real.

---

## Tecnologías Utilizadas

- Python
- ANTLR 4
- FastAPI
- Swagger
- argparse
- JSON
- HTML
- SQL

---

## Fases del Compilador Implementadas

- Análisis Léxico
- Análisis Sintáctico
- Análisis Semántico
- Código Intermedio
- Generación de Código Objeto

---

## Gramática

La gramática del lenguaje fue implementada utilizando ANTLR en el archivo:

```txt
CRUDForge.g4
```

---

## Instalación desde PyPI

CRUDForge fue publicado como paquete Python y puede instalarse con:

```bash
pip install crudforge
```

Luego puede ejecutarse con:

```bash
crudforge --help
crudforge check producto_malo.crudf
crudforge build input\producto.crudf
```

En Windows, si el comando `crudforge` no se reconoce, puede ejecutarse con la ruta completa:

```bash
C:\Users\tgpp1\AppData\Roaming\Python\Python314\Scripts\crudforge.exe --help
```

---

## Autores
- Integrantes del Grupo 4