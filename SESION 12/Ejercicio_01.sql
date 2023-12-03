-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-12-2023 a las 17:22:10
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: personas
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla autores
--

CREATE TABLE autores (
  id int(11) NOT NULL,
  primer_nombre varchar(50) DEFAULT NULL,
  primer_apellido varchar(50) DEFAULT NULL,
  edad int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla autores
--

INSERT INTO autores (id, primer_nombre, primer_apellido, edad) VALUES
(1, 'Jhon', 'Doe', 25),
(2, 'Ryan', 'Smith', 30),
(3, 'Emily', 'Johnson', 22),
(4, 'Alice', 'Smith', 28),
(5, 'Bob', 'Johnson', 35),
(6, 'Catherine', 'Brown', 40),
(7, 'David', 'Miller', 32),
(8, 'Eva', 'Davis', 29),
(9, 'Frank', 'Wilson', 45),
(10, 'Grace', 'Taylor', 38),
(11, 'Henry', 'Clark', 26),
(12, 'Isabel', 'Moore', 33),
(13, 'Jack', 'Anderson', 41);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla autores
--
ALTER TABLE autores
  ADD PRIMARY KEY (id);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla autores
--
ALTER TABLE autores
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
