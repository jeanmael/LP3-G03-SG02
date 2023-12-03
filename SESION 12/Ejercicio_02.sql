CREATE DATABASE IF NOT EXISTS Ejercicio2;

USE Ejercicio2;

CREATE TABLE IF NOT EXISTS personas (
    id INT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    email VARCHAR(255),
    telefono VARCHAR(20)
);
