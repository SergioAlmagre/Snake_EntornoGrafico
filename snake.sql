-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2023 a las 22:26:04
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
-- Base de datos: `snake`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `id_comida` int(4) NOT NULL,
  `caducidad` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`id_comida`, `caducidad`) VALUES
(1, 10),
(2, 7),
(3, 5),
(4, 9),
(5, 3),
(6, 10),
(7, 1),
(8, 3),
(9, 2),
(10, 3),
(11, 6),
(12, 9),
(13, 4),
(14, 8),
(15, 2),
(16, 7),
(17, 10),
(18, 5),
(19, 9),
(20, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `elemento`
--

CREATE TABLE `elemento` (
  `id_elemento` int(6) NOT NULL,
  `vida` int(6) NOT NULL,
  `posicion` int(6) NOT NULL,
  `color` varchar(200) NOT NULL,
  `tipo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `elemento`
--

INSERT INTO `elemento` (`id_elemento`, `vida`, `posicion`, `color`, `tipo`) VALUES
(1, 85, 0, 'verde', 2),
(2, 30, 0, 'amarillo', 1),
(3, 75, 0, 'verde', 3),
(4, 45, 0, 'azul', 2),
(5, 10, 0, 'rojo', 1),
(6, 95, 0, 'verde', 3),
(7, 50, 0, 'azul', 2),
(8, 20, 0, 'naranja', 1),
(9, 65, 0, 'verde', 2),
(10, 5, 0, 'rojo', 3),
(11, 40, 0, 'azul', 1),
(12, 90, 0, 'verde', 2),
(13, 15, 0, 'rojo', 3),
(14, 70, 0, 'verde', 1),
(15, 55, 0, 'azul', 3),
(16, 80, 0, 'verde', 2),
(17, 35, 0, 'amarillo', 1),
(18, 25, 0, 'naranja', 2),
(19, 60, 0, 'verde', 3),
(20, 50, 0, 'azul', 1),
(21, 75, 0, 'verde', 3),
(22, 40, 0, 'azul', 2),
(23, 10, 0, 'rojo', 1),
(24, 95, 0, 'verde', 2),
(25, 30, 0, 'amarillo', 3),
(26, 80, 0, 'verde', 1),
(27, 20, 0, 'naranja', 2),
(28, 65, 0, 'verde', 3),
(29, 50, 0, 'azul', 1),
(30, 5, 0, 'rojo', 2),
(31, 60, 0, 'verde', 1),
(32, 35, 0, 'amarillo', 2),
(33, 25, 0, 'naranja', 3),
(34, 70, 0, 'verde', 1),
(35, 45, 0, 'azul', 3),
(36, 90, 0, 'verde', 2),
(37, 15, 0, 'rojo', 1),
(38, 85, 0, 'verde', 3),
(39, 50, 0, 'azul', 2),
(40, 10, 0, 'rojo', 1),
(41, 75, 0, 'verde', 3),
(42, 40, 0, 'azul', 2),
(43, 10, 0, 'rojo', 1),
(44, 95, 0, 'verde', 2),
(45, 30, 0, 'amarillo', 3),
(46, 80, 0, 'verde', 1),
(47, 20, 0, 'naranja', 2),
(48, 65, 0, 'verde', 3),
(49, 50, 0, 'azul', 1),
(50, 5, 0, 'rojo', 2),
(51, 60, 0, 'verde', 1),
(52, 35, 0, 'amarillo', 2),
(53, 25, 0, 'naranja', 3),
(54, 70, 0, 'verde', 1),
(55, 45, 0, 'azul', 3),
(56, 90, 0, 'verde', 2),
(57, 15, 0, 'rojo', 1),
(58, 85, 0, 'verde', 3),
(59, 50, 0, 'azul', 2),
(60, 10, 0, 'rojo', 1),
(61, 75, 0, 'verde', 3),
(62, 40, 0, 'azul', 2),
(63, 10, 0, 'rojo', 1),
(64, 95, 0, 'verde', 2),
(65, 30, 0, 'amarillo', 3),
(66, 80, 0, 'verde', 1),
(67, 20, 0, 'naranja', 2),
(68, 65, 0, 'verde', 3),
(69, 50, 0, 'azul', 1),
(70, 5, 0, 'rojo', 2),
(71, 60, 0, 'verde', 1),
(72, 35, 0, 'amarillo', 2),
(73, 25, 0, 'naranja', 3),
(74, 70, 0, 'verde', 1),
(75, 45, 0, 'azul', 3),
(76, 90, 0, 'verde', 2),
(77, 15, 0, 'rojo', 1),
(78, 85, 0, 'verde', 3),
(79, 50, 0, 'azul', 2),
(80, 10, 0, 'rojo', 1),
(81, 75, 0, 'verde', 3),
(82, 40, 0, 'azul', 2),
(83, 10, 0, 'rojo', 1),
(84, 95, 0, 'verde', 2),
(85, 30, 0, 'amarillo', 3),
(86, 80, 0, 'verde', 1),
(87, 20, 0, 'naranja', 2),
(88, 65, 0, 'verde', 3),
(89, 50, 0, 'azul', 1),
(90, 5, 0, 'rojo', 2),
(91, 60, 0, 'verde', 1),
(92, 35, 0, 'amarillo', 2),
(93, 25, 0, 'naranja', 3),
(94, 70, 0, 'verde', 1),
(95, 45, 0, 'azul', 3),
(96, 90, 0, 'verde', 2),
(97, 15, 0, 'rojo', 1),
(98, 85, 0, 'verde', 3),
(99, 50, 0, 'azul', 2),
(100, 10, 0, 'rojo', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fruta`
--

CREATE TABLE `fruta` (
  `id_comida` int(4) NOT NULL,
  `minerales` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fruta`
--

INSERT INTO `fruta` (`id_comida`, `minerales`) VALUES
(1, 15),
(2, 10),
(3, 18),
(4, 6),
(5, 12),
(16, 12),
(17, 20),
(18, 6),
(19, 15),
(20, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nombre` varchar(100) NOT NULL,
  `dni` varchar(11) NOT NULL,
  `nivel` int(3) NOT NULL,
  `victorias` int(6) NOT NULL,
  `derrotas` int(6) NOT NULL,
  `tipo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombre`, `dni`, `nivel`, `victorias`, `derrotas`, `tipo`) VALUES
('Alejandro Fernández', '101010101J', 10, 200, 10, 0),
('Ana Martínez', '111111111A', 8, 120, 50, 1),
('Juan Pérez', '123456789A', 5, 10, 5, 1),
('Carlos Rodríguez', '222222222B', 5, 80, 90, 0),
('Luis Torres', '234567891G', 1, 0, 12, 0),
('Laura Rodríguez', '321654987D', 7, 20, 2, 1),
('María García', '333333333C', 3, 30, 20, 1),
('Miguel González', '345678912I', 2, 3, 1, 0),
('Pedro López', '444444444D', 6, 100, 80, 0),
('Carlos García', '456789123C', 2, 1, 3, 1),
('Laura Sánchez', '555555555E', 9, 180, 20, 1),
('Ana Sánchez', '654987321F', 6, 15, 10, 1),
('José Torres', '666666666F', 2, 10, 40, 0),
('Sofía Ramírez', '678912345H', 3, 6, 4, 1),
('Sofía Ramírez', '777777777G', 7, 150, 70, 1),
('Pedro Martínez', '789123456E', 4, 8, 6, 0),
('Juan González', '888888888H', 4, 50, 60, 0),
('Elena Vargas', '891234567J', 5, 12, 8, 1),
('María López', '987654321B', 3, 2, 8, 0),
('admin', 'admin', 1, 5, 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `veneno`
--

CREATE TABLE `veneno` (
  `id_comida` int(4) NOT NULL,
  `toxicos` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `veneno`
--

INSERT INTO `veneno` (`id_comida`, `toxicos`) VALUES
(6, 5),
(7, 12),
(8, 8),
(9, 17),
(10, 2),
(11, 8),
(12, 15),
(13, 3),
(14, 10),
(15, 18);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`id_comida`);

--
-- Indices de la tabla `elemento`
--
ALTER TABLE `elemento`
  ADD PRIMARY KEY (`id_elemento`);

--
-- Indices de la tabla `fruta`
--
ALTER TABLE `fruta`
  ADD PRIMARY KEY (`id_comida`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `veneno`
--
ALTER TABLE `veneno`
  ADD PRIMARY KEY (`id_comida`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
