-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.20-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para cycybank
CREATE DATABASE IF NOT EXISTS `cycybank` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cycybank`;


-- Volcando estructura para tabla cycybank.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) NOT NULL DEFAULT '0',
  `contraseña` varchar(16) NOT NULL DEFAULT '0',
  `nombre` varchar(50) NOT NULL,
  `dni` char(9) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cycybank.cliente: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Volcando estructura para tabla cycybank.cuentabancaria
CREATE TABLE IF NOT EXISTS `cuentabancaria` (
  `idCuenta` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` int(11) NOT NULL DEFAULT '0',
  `saldo` decimal(10,2) NOT NULL DEFAULT '0.00',
  `fechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sucursalBancaria` varchar(50) NOT NULL,
  PRIMARY KEY (`idCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cycybank.cuentabancaria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cuentabancaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentabancaria` ENABLE KEYS */;


-- Volcando estructura para tabla cycybank.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) NOT NULL,
  `contraseña` varchar(16) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `sucursal` varchar(50) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cycybank.empleado: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;


-- Volcando estructura para tabla cycybank.entidadbancaria
CREATE TABLE IF NOT EXISTS `entidadbancaria` (
  `idEntidadBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEntidad` varchar(50) NOT NULL DEFAULT '0',
  `codigoEntidad` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idEntidadBancaria`),
  UNIQUE KEY `codigoEntidad` (`codigoEntidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cycybank.entidadbancaria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `entidadbancaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `entidadbancaria` ENABLE KEYS */;


-- Volcando estructura para tabla cycybank.movimientobancario
CREATE TABLE IF NOT EXISTS `movimientobancario` (
  `idMovimientoBancario` int(11) NOT NULL AUTO_INCREMENT,
  `cuentaOrigen` int(11) NOT NULL,
  `cuentaDestino` int(11) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `motivo` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idMovimientoBancario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cycybank.movimientobancario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `movimientobancario` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientobancario` ENABLE KEYS */;


-- Volcando estructura para tabla cycybank.sucursal
CREATE TABLE IF NOT EXISTS `sucursal` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `localizacion` varchar(50) NOT NULL DEFAULT '0',
  `codigoSucursal` varchar(50) NOT NULL DEFAULT '0',
  `entidadBancaria` int(11) NOT NULL DEFAULT '0',
  `nombreSucursal` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idSucursal`),
  UNIQUE KEY `codigoSucursal` (`codigoSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla cycybank.sucursal: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` (`idSucursal`, `localizacion`, `codigoSucursal`, `entidadBancaria`, `nombreSucursal`) VALUES
	(1, 'Pamplona', '98272', 2, 'La Caixa'),
	(2, 'Valencia', '98652', 1, 'Santander'),
	(3, 'Cuenca', '65423', 2, 'Bankia'),
	(4, 'Valencia', '12313', 1, 'Sandia'),
	(5, 'Madrid', '98323', 1, 'Bankia'),
	(6, 'Madrid', '22143', 2, 'Queso'),
	(7, 'Madrid', '31212', 1, 'Pan'),
	(8, 'Barcelona', '87654', 1, 'Jamon'),
	(9, 'Castelon', '72766', 2, 'Politicos');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

