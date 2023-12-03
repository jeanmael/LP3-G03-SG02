SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE autores (
  id int(11) NOT NULL,
  primer_nombre varchar(50) DEFAULT NULL,
  primer_apellido varchar(50) DEFAULT NULL,
  edad int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

ALTER TABLE autores
  ADD PRIMARY KEY (id);

ALTER TABLE autores
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

COMMIT;

