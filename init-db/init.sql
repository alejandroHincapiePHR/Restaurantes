CREATE DATABASE IF NOT EXISTS gamma_pedidos;
USE gamma_pedidos;

-- Crear la tabla Cliente
CREATE TABLE IF NOT EXISTS cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    ubicacion VARCHAR(5) NOT NULL
);

CREATE TABLE restaurante (
    id_restaurante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Crear tabla Plato
CREATE TABLE plato (
    id_plato INT AUTO_INCREMENT PRIMARY KEY,
    id_restaurante INT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_restaurante) REFERENCES restaurante(id_restaurante) ON DELETE CASCADE
);

-- Crear la tabla Pedido (con la relación correcta a Cliente)
CREATE TABLE IF NOT EXISTS pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    estado ENUM('CREADO', 'PAGADO', 'ACEPTADO', 'PREPARACION', 'ENVIADO', 'RECIBIDO') NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE
);

-- Crear la tabla intermedia Pedido_Plato
CREATE TABLE IF NOT EXISTS pedido_plato (
    id_pedido INT NOT NULL,
    id_plato INT NOT NULL,
    PRIMARY KEY (id_pedido, id_plato),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido) ON DELETE CASCADE,
    FOREIGN KEY (id_plato) REFERENCES plato(id_plato) ON DELETE CASCADE
);


-- Insertar datos de ejemplo para Restaurantes
INSERT INTO restaurante (nombre, email) VALUES
('Restaurante El Sabor Colombiano', 'info@elsaborcolombiano.com'),
('Restaurante La Cazuela', 'contacto@lacazuela.com'),
('Restaurante Tierra Colombiana', 'reservas@tierracolombiana.com');

-- Insertar datos de ejemplo para Platos
INSERT INTO plato (id_restaurante, nombre, precio) VALUES
(1, 'Bandeja Paisa', 12.50),
(1, 'Ajiaco', 10.00),
(1, 'Arepa con Queso', 4.00),
(2, 'Sancocho de Gallina', 11.00),
(2, 'Chorizo con Arepa', 6.50),
(3, 'Lechona', 13.00),
(3, 'Tamales', 9.00),
(3, 'Papas Criollas', 3.50);

INSERT INTO cliente (nombre, email, ubicacion) VALUES
('Juan Pérez', 'juan.perez@example.com', 'A22'),
('María García', 'maria.garcia@example.com', 'B12'),
('Luis Fernández', 'luis.fernandez@example.com', 'C15');

-- Insertar un pedido para Juan Pérez (id_cliente = 1)
INSERT INTO pedido (id_cliente, estado) VALUES (1, 'CREADO');

-- Insertar la relación entre el pedido y los platos
INSERT INTO pedido_plato (id_pedido, id_plato) VALUES
(1, 1),  -- Pizza Margherita
(1, 2);  -- Ensalada César

-- Insertar otro pedido para María García (id_cliente = 2)
INSERT INTO pedido (id_cliente, estado) VALUES (2, 'PAGADO');

-- Insertar la relación entre el segundo pedido y los platos
INSERT INTO pedido_plato (id_pedido, id_plato) VALUES
(2, 2),  -- Ensalada César
(2, 3);  -- Hamburguesa Clásica