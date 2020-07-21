-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: supermercado
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `supermercado`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `supermercado` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `supermercado`;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `categoria_UN` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'comestibles'),(3,'Electronica'),(2,'Platos Cocinados');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL DEFAULT '0.00',
  `imagen` varchar(255) NOT NULL DEFAULT 'https://picsum.photos/100/100',
  `id_categoria` int(11) NOT NULL,
  `fecha_creacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_validado` datetime DEFAULT NULL COMMENT 'si tiene valor NULL este producto no es visible en la parte publica, tiene que ser validado por un administrador',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_usuario` (`id_usuario`),
  KEY `FK_categoria` (`id_categoria`),
  CONSTRAINT `FK_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (15,'acelgas con Jamon con brillo',1,0.00,'https://i.blogs.es/6b70d4/acelgas-arco-jamon/1366_2000.jpg',1,'2020-07-13 12:26:38',NULL),(16,'patatas',1,0.66,'https://ep01.epimg.net/elcomidista/imagenes/2017/02/22/articulo/1487804099_363696_1487804800_sumario_normal.jpg',1,'2020-07-13 12:26:38',NULL),(26,'alubias a la vizcaina',6,6.45,'https://www.cocinatis.com/media/photologue/photos/cache/CTIS123-receta-alubias-blancas-verduras-paso-6_desktop_step.jpg',2,'2020-07-13 12:26:38','2020-07-13 12:58:23'),(27,'Tortilla de patatas',6,2.35,'https://www.hogarmania.com/archivos/201610/tortilla-patatas-xl-668x400x80xX.jpg',2,'2020-07-13 12:26:38','2020-07-13 12:58:23'),(28,'Piruleta',6,2.36,'https://picsum.photos/100/100',1,'2020-07-20 11:53:25',NULL),(30,'Kinder Bueno',6,2.75,'https://picsum.photos/100/100',1,'2020-07-20 12:03:15',NULL),(32,'Ya teneis una nueva pelea',6,2.50,'https://picsum.photos/100/100',3,'2020-07-20 12:10:34',NULL);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '1: Usuario normal   2: Administrador',
  `nombre` varchar(15) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (2,'administrador'),(1,'usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `contrasenia` varchar(50) NOT NULL DEFAULT '0',
  `id_rol` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_rol` (`id_rol`),
  CONSTRAINT `FK_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e',2),(6,'pepe','e10adc3949ba59abbe56e057f20f883e',1),(7,'manolito gafotas 77','e10adc3949ba59abbe56e057f20f883e',1),(8,'Dummy','e10adc3949ba59abbe56e057f20f883e',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_producto`
--

DROP TABLE IF EXISTS `v_producto`;
/*!50001 DROP VIEW IF EXISTS `v_producto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_producto` AS SELECT 
 1 AS `id`,
 1 AS `nombre`,
 1 AS `precio`,
 1 AS `categoria`,
 1 AS `usuario`,
 1 AS `rol`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_usuario_productos`
--

DROP TABLE IF EXISTS `v_usuario_productos`;
/*!50001 DROP VIEW IF EXISTS `v_usuario_productos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_usuario_productos` AS SELECT 
 1 AS `id_usuario`,
 1 AS `total`,
 1 AS `aprobado`,
 1 AS `pendiente`*/;
SET character_set_client = @saved_cs_client;

--
-- Current Database: `supermercado`
--

USE `supermercado`;

--
-- Final view structure for view `v_producto`
--

/*!50001 DROP VIEW IF EXISTS `v_producto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`debian-sys-maint`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_producto` AS select `p`.`id` AS `id`,`p`.`nombre` AS `nombre`,`p`.`precio` AS `precio`,`c`.`nombre` AS `categoria`,`u`.`nombre` AS `usuario`,`r`.`nombre` AS `rol` from (((`producto` `p` join `categoria` `c`) join `usuario` `u`) join `rol` `r`) where ((`p`.`id_categoria` = `c`.`id`) and (`u`.`id` = `p`.`id_usuario`) and (`u`.`id_rol` = `r`.`id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_usuario_productos`
--

/*!50001 DROP VIEW IF EXISTS `v_usuario_productos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`debian-sys-maint`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_usuario_productos` AS select `p`.`id_usuario` AS `id_usuario`,count(`p`.`id_usuario`) AS `total`,count(`p`.`fecha_validado`) AS `aprobado`,sum(isnull(`p`.`fecha_validado`)) AS `pendiente` from `producto` `p` group by `p`.`id_usuario` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-21 12:58:51