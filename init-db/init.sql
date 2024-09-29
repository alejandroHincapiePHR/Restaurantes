CREATE DATABASE IF NOT EXISTS gammapedidos;
USE gammapedidos;

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