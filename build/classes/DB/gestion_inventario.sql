-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-09-2025 a las 22:42:26
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_inventario`
--
CREATE DATABASE IF NOT EXISTS `gestion_inventario` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gestion_inventario`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados_producto`
--

CREATE TABLE IF NOT EXISTS `estados_producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estados_producto`
--

INSERT INTO `estados_producto` (`id`, `nombre`) VALUES
(1, 'Activo'),
(3, 'Agotado'),
(2, 'Inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `estado_id` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `estado_id` (`estado_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `categoria`, `precio`, `stock`, `estado_id`) VALUES
(1, 'tablet lenovo', 'ipad barata', 'Tablets', 400000.00, 1, 1),
(2, 'Auriculares Bluetooth', 'Auriculares inalámbricos con micrófono y cancelación de ruido', 'Audio', 120.50, 1, 1),
(3, 'Funda Protectora', 'Funda de silicona antideslizante para celular', 'Accesorios', 15.00, 1, 1),
(4, 'Power Bank 10000mAh', 'Batería portátil con doble salida USB', 'Seleccionar', 80.75, 3, 1),
(5, 'Cable HDMI 2m', 'Cable HDMI de alta velocidad compatible con 4K', 'Cables', 25.00, 1, 1),
(6, 'vannesa medina', 'aaca segguimos', 'Portatil', 20000.00, 6, 1),
(7, 'kevin aleexander', 'ajja', 'Computador escritorio', 30000.00, 1, 1),
(8, 'lenovo 5', 'bueno', 'Portatil', 5000000.00, 4, 1),
(9, 'lenovo think', 'desc', 'Celulares', 300000.00, 4, 1),
(10, 'lauarararra', 'linda', 'Tablets', 30.00, 22, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `numero_documento` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  PRIMARY KEY (`numero_documento`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`numero_documento`, `nombre`, `apellido`, `correo`, `contrasena`, `telefono`) VALUES
('1000234565', 'pedro', 'roas', 'pedro', '21', '5465'),
('1000555555', 'KEVIN', 'SABOGAL', 'kevin@gmail.com', 'Kevin', '235235234'),
('1022938044', 'HAROLD', 'HERNANDEZ', 'hharold855@gmail.com', 'Hd1022', '3212709274'),
('1111262797', 'vane', 'medina', 'vane@gmail.com', '322', '345');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`estado_id`) REFERENCES `estados_producto` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
