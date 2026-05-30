CREATE TABLE Producto (
    id UNIQUEIDENTIFIER PRIMARY KEY,
    nombre NVARCHAR(255) NOT NULL,
    precio DECIMAL(18,2),
    stock INT DEFAULT 0,
    categoria INT,
    CHECK (LEN(nombre) >= 5),
    CHECK (precio > 0)
);

CREATE INDEX IX_Producto_nombre ON Producto(nombre);

CREATE INDEX IX_Producto_precio ON Producto(precio);
