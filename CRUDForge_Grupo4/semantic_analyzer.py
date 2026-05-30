class SemanticAnalyzer:

    def __init__(self):
        self.errors = []

    def analyze(self, entity):
        self.errors = []

        self.check_entity_name(entity)
        self.check_fields_exist(entity)
        self.check_duplicate_fields(entity)
        self.check_primary_key(entity)
        self.check_valid_types(entity)
        self.check_valid_constraints(entity)
        self.check_default_values(entity)
        self.check_indexes(entity)

        return self.errors

    def check_entity_name(self, entity):
        if not entity.get("name"):
            self.errors.append("La entidad debe tener un nombre")

    def check_fields_exist(self, entity):
        if "fields" not in entity or len(entity["fields"]) == 0:
            self.errors.append("La entidad debe tener al menos un campo")

    def check_duplicate_fields(self, entity):
        names = set()

        for field in entity.get("fields", []):
            if field["name"] in names:
                self.errors.append(f"Campo duplicado: {field['name']}")
            names.add(field["name"])

    def check_primary_key(self, entity):
        primary_keys = [
            field for field in entity.get("fields", [])
            if field.get("pk") is True
        ]

        if len(primary_keys) == 0:
            self.errors.append("La entidad debe tener un campo primary key")

        if len(primary_keys) > 1:
            self.errors.append("La entidad no debe tener más de un primary key")

    def check_valid_types(self, entity):
        valid_types = ["uuid", "string", "decimal", "int", "datetime", "bool", "date", "reference"]

        for field in entity.get("fields", []):
            if field["type"] not in valid_types:
                self.errors.append(
                    f"Tipo de dato inválido en el campo {field['name']}: {field['type']}"
                )

    def check_valid_constraints(self, entity):
        for field in entity.get("fields", []):
            field_type = field["type"]

            if field.get("gt") is not None and field_type not in ["int", "decimal"]:
                self.errors.append(
                    f"El campo {field['name']} no puede usar > porque no es numérico"
                )

            if field.get("min") is not None and field_type != "string":
                self.errors.append(
                    f"El campo {field['name']} no puede usar min porque no es texto"
                )

            if field.get("pk") is True and field_type not in ["uuid", "int"]:
                self.errors.append(
                    f"El campo {field['name']} es primary key, por eso debería ser uuid o int"
                )

    def check_default_values(self, entity):
        for field in entity.get("fields", []):
            value = field.get("default")
            field_type = field["type"]

            if value is None:
                continue

            if field_type == "int":
                try:
                    int(value)
                except ValueError:
                    self.errors.append(
                        f"El valor default del campo {field['name']} debe ser entero"
                    )

            if field_type == "decimal":
                try:
                    float(value)
                except ValueError:
                    self.errors.append(
                        f"El valor default del campo {field['name']} debe ser decimal"
                    )

    def check_indexes(self, entity):
        field_names = [field["name"] for field in entity.get("fields", [])]

        for index in entity.get("indexes", []):
            if index not in field_names:
                self.errors.append(
                    f"El índice '{index}' no existe como campo dentro de la entidad"
                )