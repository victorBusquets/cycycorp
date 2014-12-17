CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) NOT NULL DEFAULT '0',
  `contraseña` varchar(16) NOT NULL DEFAULT '0',
  `nombre` varchar(50) NOT NULL,
  `dni` char(9) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

CREATE TABLE `cuenta` (
  `idCuenta` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` int(11) NOT NULL DEFAULT '0',
  `saldo` decimal(10,2) NOT NULL DEFAULT '0.00',
  `fechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sucursalBancaria` varchar(50) NOT NULL,
  PRIMARY KEY (`idCuenta`),
  KEY `FKCliente` (`cliente`),
  KEY `FKSucursal` (`sucursalBancaria`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) NOT NULL,
  `contraseña` varchar(16) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `sucursal` varchar(50) NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `entidadbancaria` (
  `idEntidadBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEntidad` varchar(50) NOT NULL DEFAULT '0',
  `codigoEntidad` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idEntidadBancaria`),
  UNIQUE KEY `codigoEntidad` (`codigoEntidad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `movimientobancario` (
  `idMovimientoBancario` int(11) NOT NULL AUTO_INCREMENT,
  `cuentaOrigen` int(11) NOT NULL,
  `cuentaDestino` int(11) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `motivo` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idMovimientoBancario`),
  KEY `FKOrigen` (`cuentaOrigen`),
  KEY `FKDestino` (`cuentaDestino`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `sucursal` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `localizacion` varchar(50) NOT NULL DEFAULT '0',
  `codigoSucursal` varchar(50) NOT NULL DEFAULT '0',
  `entidadBancaria` varchar(50) NOT NULL DEFAULT '0',
  `nombreSucursal` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idSucursal`),
  UNIQUE KEY `codigoSucursal` (`codigoSucursal`),
  KEY `FKEntidad` (`entidadBancaria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
