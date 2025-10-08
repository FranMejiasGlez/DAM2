CREATE DATABASE tienda;
USE tienda;


 CREATE TABLE CLIENTES (
    ID_CLIENTE INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100),
    TELEFONO VARCHAR(20)
);

-- Tabla PRODUCTOS
CREATE TABLE PRODUCTOS (
    ID_PRODUCTO INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL,
    PRECIO DECIMAL(10,2) NOT NULL
);

-- Tabla PEDIDOS
CREATE TABLE PEDIDOS (
    ID_PEDIDO INT AUTO_INCREMENT PRIMARY KEY,
    ID_CLIENTE INT NOT NULL,
    FECHA DATE NOT NULL,
    CONSTRAINT FK_PEDIDOS_CLIENTES FOREIGN KEY (ID_CLIENTE)
        REFERENCES CLIENTES(ID_CLIENTE)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Tabla INCLUYEN (detalle de pedidos)
CREATE TABLE INCLUYEN (
    ID_PRODUCTO INT NOT NULL,
    ID_PEDIDO INT NOT NULL,
    CANTIDAD INT NOT NULL,
    PRIMARY KEY (ID_PRODUCTO, ID_PEDIDO),
    CONSTRAINT FK_INCLUYEN_PRODUCTOS FOREIGN KEY (ID_PRODUCTO)
        REFERENCES PRODUCTOS(ID_PRODUCTO)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT FK_INCLUYEN_PEDIDOS FOREIGN KEY (ID_PEDIDO)
        REFERENCES PEDIDOS(ID_PEDIDO)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

INSERT INTO CLIENTES (NOMBRE, EMAIL, TELEFONO) VALUES
('Juan Pérez', 'juan.perez@email.com', '611111111'),
('María García', 'maria.garcia@email.com', '622222222'),
('Carlos López', 'carlos.lopez@email.com', '633333333'),
('Ana Martínez', 'ana.martinez@email.com', '644444444'),
('Pedro Sánchez', 'pedro.sanchez@email.com', '655555555');

INSERT INTO PRODUCTOS (NOMBRE, PRECIO) VALUES
('Tarta de Chocolate', 25.50),
('Tarta de Queso', 22.75),
('Croissants (6 unidades)', 8.99),
('Magdalenas Caseras (12 unidades)', 12.50),
('Pan de Molde Integral', 4.25),
('Galletas de Mantequilla (500g)', 9.99),
('Brownies de Chocolate (8 unidades)', 15.75),
('Tarta de Manzana', 20.00),
('Eclairs de Chocolate (6 unidades)', 13.50),
('Donuts (6 unidades)', 7.99),
('Tarta Red Velvet', 28.00),
('Palmeras de Hojaldre (4 unidades)', 6.50);

-- Insertar pedidos
INSERT INTO PEDIDOS (ID_CLIENTE, FECHA) VALUES
(1, '2024-01-15'),  -- María González
(2, '2024-01-16'),  -- Carlos Rodríguez
(3, '2024-01-17'),  -- Ana López
(1, '2024-01-18'),  -- María González (segundo pedido)
(4, '2024-01-19');  -- Pedro Martínez

-- Insertar detalles de pedidos (qué productos incluye cada pedido)
INSERT INTO INCLUYEN (ID_PRODUCTO, ID_PEDIDO, CANTIDAD) VALUES
(1, 1, 1),   -- Pedido 1: 1 Tarta de Chocolate
(3, 1, 2),   -- Pedido 1: 2 paquetes de Croissants
(7, 2, 1),   -- Pedido 2: 1 caja de Brownies
(2, 3, 1),   -- Pedido 3: 1 Tarta de Queso
(4, 3, 1),   -- Pedido 3: 1 paquete de Magdalenas
(8, 4, 1),   -- Pedido 4: 1 Tarta de Manzana
(10, 4, 2),  -- Pedido 4: 2 paquetes de Donuts
(5, 5, 1),   -- Pedido 5: 1 Pan de Molde
(6, 5, 1);   -- Pedido 5: 1 paquete de Galletas