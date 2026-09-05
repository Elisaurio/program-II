DROP DATABASE IF EXISTS facturacion_db;
CREATE DATABASE facturacion_db;
USE facturacion_db;

CREATE TABLE puestos (
    id_puesto     INT AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(50) NOT NULL,
    salario_base  FLOAT NOT NULL
);

CREATE TABLE marcas (
    id_marca INT AUTO_INCREMENT PRIMARY KEY,
    nombre   VARCHAR(50) NOT NULL
);

CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nit        VARCHAR(20) UNIQUE,
    nombre     VARCHAR(100) NOT NULL,
    apellidos  VARCHAR(100) NOT NULL,
    email      VARCHAR(100)
);

CREATE TABLE empleados (
    id_empleado         INT AUTO_INCREMENT PRIMARY KEY,
    id_puesto           INT NOT NULL,
    nombre              VARCHAR(100) NOT NULL,
    apellidos           VARCHAR(100) NOT NULL,
    fecha_contratacion  DATE,
    FOREIGN KEY (id_puesto) REFERENCES puestos(id_puesto)
);

CREATE TABLE productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    id_marca    INT NOT NULL,
    nombre      VARCHAR(100) NOT NULL,
    precio      FLOAT NOT NULL,
    stock       INT NOT NULL,
    FOREIGN KEY (id_marca) REFERENCES marcas(id_marca)
);

CREATE TABLE facturas (
    id_factura  INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente  INT NOT NULL,
    id_empleado INT NOT NULL,
    fecha       DATETIME NOT NULL,
    total       FLOAT NOT NULL,
    FOREIGN KEY (id_cliente)  REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)
);

CREATE TABLE detalle_facturas (
    id_detalle      INT AUTO_INCREMENT PRIMARY KEY,
    id_factura      INT NOT NULL,
    id_producto     INT NOT NULL,
    cantidad        INT NOT NULL,
    precio_unitario FLOAT NOT NULL,
    subtotal        FLOAT NOT NULL,
    FOREIGN KEY (id_factura)  REFERENCES facturas(id_factura),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Pruebas

INSERT INTO puestos (nombre, salario_base) VALUES
('Vendedor', 2500.00),
('Cajero', 2200.00),
('Gerente', 4500.00);

INSERT INTO marcas (nombre) VALUES
('Samsung'),
('LG'),
('Sony');

INSERT INTO clientes (nit, nombre, apellidos, email) VALUES
('1234567-8', 'Ana', 'García', 'ana.garcia@correo.com'),
('2345678-9', 'Luis', 'Pérez', 'luis.perez@correo.com'),
('3456789-0', 'María', 'López', 'maria.lopez@correo.com');

INSERT INTO empleados (id_puesto, nombre, apellidos, fecha_contratacion) VALUES
(1, 'Carlos', 'Ramírez', '2022-03-15'),
(2, 'Sofía', 'Hernández', '2023-06-01'),
(3, 'Jorge', 'Martínez', '2021-11-20');

INSERT INTO productos (id_marca, nombre, precio, stock) VALUES
(1, 'Televisor Samsung 55"', 3200.00, 15),
(2, 'Refrigeradora LG', 4800.00, 8),
(3, 'Parlante Sony', 650.00, 25);

INSERT INTO facturas (id_cliente, id_empleado, fecha, total) VALUES
(1, 1, '2024-01-10 10:30:00', 3200.00),
(2, 2, '2024-01-12 15:00:00', 5450.00),
(3, 3, '2024-01-15 09:45:00', 1300.00);

INSERT INTO detalle_facturas (id_factura, id_producto, cantidad, precio_unitario, subtotal) VALUES
(1, 1, 1, 3200.00, 3200.00),
(2, 2, 1, 4800.00, 4800.00),
(2, 3, 1, 650.00, 650.00),
(3, 3, 2, 650.00, 1300.00);
