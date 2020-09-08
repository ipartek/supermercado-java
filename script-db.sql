-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: supermercado
-- ------------------------------------------------------
-- Server version	5.7.31-0ubuntu0.18.04.1

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (5,'Batidoras y picadoras'),(7,'cervezas'),(1,'comestibles'),(18,'Cromos'),(20,'Donde esta esta?'),(3,'Electronica'),(21,'funcionara?'),(8,'galletas'),(19,'Ordenadores'),(22,'pepito'),(16,'Piruleta'),(2,'Platos Cocinados'),(6,'Té y café'),(4,'verano');
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
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (15,'acelgas con Jamon con brillo',6,0.00,'https://i.blogs.es/6b70d4/acelgas-arco-jamon/1366_2000.jpg',1,'2020-07-13 12:26:38','2020-07-30 20:02:29'),(26,'alubias a la Tolosana',6,6.00,'https://www.cocinatis.com/media/photologue/photos/cache/CTIS123-receta-alubias-blancas-verduras-paso-6_desktop_step.jpg',2,'2020-07-13 12:26:38','2020-07-13 12:26:38'),(27,'Tortilla de patatas',6,2.35,'https://www.hogarmania.com/archivos/201610/tortilla-patatas-xl-668x400x80xX.jpg',2,'2020-07-13 12:26:38',NULL),(28,'Piruleta',6,2.36,'https://picsum.photos/100/100',1,'2020-07-20 11:53:25',NULL),(30,'Kinder Bueno',6,2.75,'https://picsum.photos/100/100',1,'2020-07-20 12:03:15',NULL),(32,'Ya teneis una nueva pelea',6,2.50,'https://picsum.photos/100/100',3,'2020-07-20 12:10:34',NULL),(34,'Producto Editado, eplochos y Electronica',6,8.88,'https://picsum.photos/100/100',3,'2020-07-23 09:28:39',NULL),(35,'nuevo electro',6,0.00,'https://picsum.photos/100/100',3,'2020-07-30 09:06:18',NULL),(38,'Cafetera italiana',1,8.99,'imagenes/cafetera-italiana-regular--3.jpg',5,'2020-07-30 19:38:30','2020-07-30 20:02:29'),(39,'Cafetera DeLonghi Icona Vintage',1,149.00,'imagenes/cafetera-delonghi-icona-vintage-regular.jpg',5,'2020-07-30 19:38:30','2020-07-30 20:02:29'),(40,'Cafetera de acero inoxidable Oxford',1,19.99,'imagenes/cafetera-de-acero-inoxidable-oxford-regular.jpg',5,'2020-07-30 19:38:30','2020-07-30 20:02:29'),(41,'1906® Cerveza reserva especial',1,3.99,'imagenes/1906-cerveza-reserva-especial-regular--2.jpg',5,'2020-07-30 19:49:11','2020-07-30 20:02:29'),(42,'Galletas Safari chocolate',1,0.89,'imagenes/galletas-safari-chocolate-regular.jpg',8,'2020-07-30 19:55:01','2020-07-30 20:02:29'),(43,'Galletas ecológicas',1,0.99,'imagenes/galletas-ecologicas-regular--7.jpg',8,'2020-07-30 19:55:01','2020-07-30 20:02:29'),(44,'Galletas de espelta ecológicas',1,0.99,'imagenes/galletas-de-espelta-ecologicas-regular.jpg',8,'2020-07-30 19:55:01','2020-07-30 20:02:29'),(45,'Daveiga® Galletas marineras',1,1.99,'imagenes/daveiga-galletas-marineras-regular.jpg',8,'2020-07-30 19:55:01','2020-07-30 20:02:29'),(46,'Galletitas ecológicas con frutos secos',1,1.99,'imagenes/galletitas-ecologicas-con-frutos-secos-regular--4.jpg',8,'2020-07-30 19:55:01','2020-07-30 20:02:29'),(47,'Cocktail de galletitas saladas',1,1.19,'imagenes/cocktail-de-galletitas-saladas-regular.jpg',8,'2020-07-30 19:55:01','2020-07-30 20:02:29'),(48,'Picadora eléctrica de carne multifuncional 350 W',1,39.99,'imagenes/picadora-electrica-de-carne-multifuncional-350-w-regular.jpg',5,'2020-07-30 19:55:01','2020-07-30 20:02:29'),(49,'Multicereales ecológicos',1,2.49,'imagenes/multicereales-ecologicos-regular--4.jpg',5,'2020-07-30 19:55:01','2020-07-30 20:02:29'),(51,'Mahou® Cerveza tostada 0,0',1,0.50,'imagenes/mahou-cerveza-tostada-0-0-regular.jpg',7,'2020-07-30 19:56:26','2020-07-30 20:02:29'),(52,'Mahou® Cerveza radler',1,0.55,'imagenes/mahou-cerveza-radler-regular--1.jpg',7,'2020-07-30 19:56:26','2020-07-30 20:02:29'),(53,'Guinness® Cerveza negra',1,1.95,'imagenes/guinness-cerveza-negra-regular--1.jpg',7,'2020-07-30 19:56:26','2020-07-30 20:02:29'),(54,'San Miguel® Cerveza especial',1,4.85,'imagenes/san-miguel-cerveza-especial-regular--2.jpg',7,'2020-07-30 19:56:26','2020-07-30 20:02:29'),(55,'San Miguel® Cerveza 1516',1,0.65,'imagenes/san-miguel-cerveza-1516-regular.jpg',7,'2020-07-30 19:56:26','2020-07-30 20:02:29'),(56,'San Miguel® Cerveza Magna',1,0.59,'imagenes/san-miguel-cerveza-magna-regular--1.jpg',7,'2020-07-30 19:56:26','2020-07-30 20:02:29'),(57,'San Miguel® Cerveza 0,0%',1,0.50,'imagenes/san-miguel-cerveza-0-0-regular--2.jpg',7,'2020-07-30 19:56:26','2020-07-30 20:02:29'),(58,'Alhambra® Cerveza',1,1.09,'imagenes/alhambra-cerveza-regular--2.jpg',7,'2020-07-30 19:56:26','2020-07-30 20:02:29'),(59,'Estrella Galicia® Cerveza',1,5.49,'imagenes/estrella-galicia-cerveza-regular--2.jpg',7,'2020-07-30 19:56:26','2020-07-30 20:02:29'),(60,'Polo hombre',1,6.00,'imagenes/polo-hombre-regular.jpg',4,'2020-07-30 20:02:15','2020-07-30 20:02:29'),(61,'Pijama de verano cuello de redondo hombre',1,4.99,'imagenes/pijama-de-verano-cuello-de-redondo-hombre-regular.jpg',4,'2020-07-30 20:02:15','2020-07-30 20:02:29'),(62,'Pijama de verano botones y bolsillo hombre',1,4.99,'imagenes/pijama-de-verano-botones-y-bolsillo-hombre-regular.jpg',4,'2020-07-30 20:02:15','2020-07-30 20:02:29'),(63,'Pantalón corto vaquero mujer',1,7.00,'imagenes/pantalon-corto-vaquero-mujer-regular.jpg',4,'2020-07-30 20:02:15','2020-07-30 20:02:29'),(64,'Tinto de verano 0,0 sabor limón',1,0.75,'imagenes/tinto-de-verano-0-0-sabor-limon-regular.jpg',4,'2020-07-30 20:02:15','2020-07-30 20:02:29'),(65,'Pantalón corto de deporte hombre',1,6.00,'imagenes/pantalon-corto-de-deporte-hombre-regular--8.jpg',4,'2020-07-30 20:02:15','2020-07-30 20:02:29'),(66,'Pantalón corto deportivo hombre',1,5.00,'imagenes/pantalon-corto-deportivo-hombre-regular--7.jpg',4,'2020-07-30 20:02:15','2020-07-30 20:02:29'),(67,'Pantalón corto de trabajo hombre',1,9.99,'imagenes/pantalon-corto-de-trabajo-hombre-regular.jpg',4,'2020-07-30 20:02:15','2020-07-30 20:02:29'),(68,'Conjunto de verano infantil rosado 3 piezas',1,6.99,'imagenes/conjunto-de-verano-infantil-rosado-3-piezas-regular.jpg',4,'2020-07-30 20:02:15','2020-07-30 20:02:29'),(69,'Pijama de verano azul oscuro mujer',1,4.99,'imagenes/pijama-de-verano-azul-oscuro-mujer-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(70,'Pijama de verano azul claro mujer',1,4.99,'imagenes/pijama-de-verano-azul-claro-mujer-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(71,'Pijama verano hombre',1,7.99,'imagenes/pijama-verano-hombre-regular--6.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(72,'Camiseta de tirantes deportiva mujer',1,4.99,'imagenes/camiseta-de-tirantes-deportiva-mujer-regular--12.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(73,'Pijama verano mujer',1,8.99,'imagenes/pijama-verano-mujer-regular--18.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(74,'Pantalón corto júnior oscuro',1,6.00,'imagenes/pantalon-corto-junior-oscuro-regular--11.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(76,'Pijama corto hombre',1,7.00,'imagenes/pijama-corto-hombre-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(78,'Camiseta manga corta hombre tallas grandes',1,3.00,'imagenes/camiseta-manga-corta-hombre-tallas-grandes-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(79,'Conjunto de verano infantil 3 piezas',1,6.99,'imagenes/conjunto-de-verano-infantil-3-piezas-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(80,'Pijama de verano blanco mujer',1,4.99,'imagenes/pijama-de-verano-blanco-mujer-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(81,'Pijama de verano rojo mujer',1,4.99,'imagenes/pijama-de-verano-rojo-mujer-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(82,'Camisetas de tirantes mujer pack 3',1,8.00,'imagenes/camisetas-de-tirantes-mujer-pack-3-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(83,'Pijama corto mujer',1,7.00,'imagenes/pijama-corto-mujer-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(85,'Pantalón corto técnico',1,5.99,'imagenes/pantalon-corto-tecnico-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(87,'Camiseta manga corta técnica mujer',1,3.99,'imagenes/camiseta-manga-corta-tecnica-mujer-regular--12.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(88,'Pantalón corto mujer',1,4.00,'imagenes/pantalon-corto-mujer-regular--11.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(89,'Camiseta manga corta mujer',1,3.99,'imagenes/camiseta-manga-corta-mujer-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(90,'Camiseta de manga corta hombre',1,4.00,'imagenes/camiseta-de-manga-corta-hombre-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(91,'Camisetas manga corta mujer',1,4.00,'imagenes/camisetas-manga-corta-mujer-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(92,'Vestido de lino manga corta mujer',1,9.99,'imagenes/vestido-de-lino-manga-corta-mujer-regular.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(93,'Camiseta deportiva manga corta hombre',1,5.00,'imagenes/camiseta-deportiva-manga-corta-hombre-regular--9.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(94,'Camiseta deportiva manga corta mujer',1,5.00,'imagenes/camiseta-deportiva-manga-corta-mujer-regular--12.jpg',4,'2020-07-30 20:02:16','2020-07-30 20:02:29'),(95,'Estrella Galicia 1907 Red',6,1.45,'imagenes/black-1.png',7,'2020-09-01 12:05:18','2020-09-01 12:00:00'),(96,'kkkkkkk',6,12.00,'https://picsum.photos/100/100',5,'2020-09-04 12:41:12',NULL),(97,'git imagen',6,12.00,'https://picsum.photos/100/100',5,'2020-09-04 13:02:33',NULL),(98,'sadasdasd',6,12.00,'https://picsum.photos/100/100',5,'2020-09-04 13:53:58',NULL),(99,'Galletas Tosta Rica',6,3.25,'imagenes/tosta rica.jpg',8,'2020-09-07 08:16:47',NULL);
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
  `fecha_nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_rol` (`id_rol`),
  CONSTRAINT `FK_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=881 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e',2,NULL),(6,'pepe','e10adc3949ba59abbe56e057f20f883e',1,NULL),(7,'manolito gafotas 77','e10adc3949ba59abbe56e057f20f883e',1,NULL),(8,'Dummy','e10adc3949ba59abbe56e057f20f883e',1,NULL),(784,'Magee','e10adc3949ba59abbe56e057f20f883e',1,'2019-03-21'),(785,'Kermit','e10adc3949ba59abbe56e057f20f883e',1,'2021-02-19'),(786,'Oleg','e10adc3949ba59abbe56e057f20f883e',1,'2021-02-27'),(787,'Cassidy','e10adc3949ba59abbe56e057f20f883e',1,'2019-11-18'),(788,'Aaron','e10adc3949ba59abbe56e057f20f883e',1,'2020-08-01'),(789,'Hedwig','e10adc3949ba59abbe56e057f20f883e',1,'2020-09-21'),(790,'Alan','e10adc3949ba59abbe56e057f20f883e',1,'2019-09-18'),(791,'Emery','e10adc3949ba59abbe56e057f20f883e',1,'2020-03-25'),(792,'Macy','e10adc3949ba59abbe56e057f20f883e',1,'2020-09-24'),(793,'Walker','e10adc3949ba59abbe56e057f20f883e',1,'2019-04-30'),(794,'Xavier','e10adc3949ba59abbe56e057f20f883e',1,'2019-05-27'),(795,'Dale','e10adc3949ba59abbe56e057f20f883e',1,'2019-10-14'),(796,'Cole','e10adc3949ba59abbe56e057f20f883e',1,'2019-05-07'),(797,'Zephr','e10adc3949ba59abbe56e057f20f883e',1,'2019-04-25'),(798,'Charissa','e10adc3949ba59abbe56e057f20f883e',1,'2019-05-25'),(799,'Lance','e10adc3949ba59abbe56e057f20f883e',1,'2020-04-26'),(800,'David','e10adc3949ba59abbe56e057f20f883e',1,'2020-09-20'),(801,'Ezra','e10adc3949ba59abbe56e057f20f883e',1,'2020-07-04'),(802,'Quinn','e10adc3949ba59abbe56e057f20f883e',1,'2020-05-08'),(803,'Cherokee','e10adc3949ba59abbe56e057f20f883e',1,'2021-02-23'),(804,'Cody','e10adc3949ba59abbe56e057f20f883e',1,'2021-02-11'),(805,'Katelyn','e10adc3949ba59abbe56e057f20f883e',1,'2019-10-04'),(806,'Carly','e10adc3949ba59abbe56e057f20f883e',1,'2020-04-02'),(807,'Asher','e10adc3949ba59abbe56e057f20f883e',1,'2019-12-24'),(808,'Larissa','e10adc3949ba59abbe56e057f20f883e',1,'2020-03-04'),(809,'Teegan','e10adc3949ba59abbe56e057f20f883e',1,'2019-07-09'),(810,'Courtney','e10adc3949ba59abbe56e057f20f883e',1,'2019-06-03'),(811,'Rhona','e10adc3949ba59abbe56e057f20f883e',1,'2019-10-08'),(812,'Caldwell','e10adc3949ba59abbe56e057f20f883e',1,'2020-07-12'),(813,'Wendy','e10adc3949ba59abbe56e057f20f883e',1,'2020-03-26'),(814,'Rajah','e10adc3949ba59abbe56e057f20f883e',1,'2020-03-17'),(815,'Evan','e10adc3949ba59abbe56e057f20f883e',1,'2019-10-30'),(816,'Danielle','e10adc3949ba59abbe56e057f20f883e',1,'2021-03-07'),(817,'Camilla','e10adc3949ba59abbe56e057f20f883e',1,'2020-10-06'),(818,'Tana','e10adc3949ba59abbe56e057f20f883e',1,'2019-03-17'),(819,'Lunea','e10adc3949ba59abbe56e057f20f883e',1,'2019-06-21'),(820,'Leslie','e10adc3949ba59abbe56e057f20f883e',1,'2019-08-18'),(821,'Cruz','e10adc3949ba59abbe56e057f20f883e',1,'2019-05-12'),(822,'Eden','e10adc3949ba59abbe56e057f20f883e',1,'2019-05-25'),(823,'Byron','e10adc3949ba59abbe56e057f20f883e',1,'2020-06-22'),(824,'Ryder','e10adc3949ba59abbe56e057f20f883e',1,'2019-05-29'),(825,'Ronan','e10adc3949ba59abbe56e057f20f883e',1,'2019-06-26'),(826,'Norman','e10adc3949ba59abbe56e057f20f883e',1,'2020-07-04'),(827,'Whoopi','e10adc3949ba59abbe56e057f20f883e',1,'2019-07-30'),(828,'Honorato','e10adc3949ba59abbe56e057f20f883e',1,'2020-01-12'),(829,'Tallulah','e10adc3949ba59abbe56e057f20f883e',1,'2019-10-30'),(830,'Gloria','e10adc3949ba59abbe56e057f20f883e',1,'2019-04-29'),(831,'Ira','e10adc3949ba59abbe56e057f20f883e',1,'2019-08-26'),(832,'Barry','e10adc3949ba59abbe56e057f20f883e',1,'2019-11-06'),(833,'Callum','e10adc3949ba59abbe56e057f20f883e',1,'2020-01-30'),(834,'Zia','e10adc3949ba59abbe56e057f20f883e',1,'2020-05-15'),(835,'Logan','e10adc3949ba59abbe56e057f20f883e',1,'2021-03-15'),(836,'Xena','e10adc3949ba59abbe56e057f20f883e',1,'2020-11-02'),(837,'Paul','e10adc3949ba59abbe56e057f20f883e',1,'2020-12-06'),(838,'Elmo','e10adc3949ba59abbe56e057f20f883e',1,'2020-12-08'),(839,'Gil','e10adc3949ba59abbe56e057f20f883e',1,'2020-10-01'),(840,'Eliana','e10adc3949ba59abbe56e057f20f883e',1,'2020-07-14'),(841,'Ursula','e10adc3949ba59abbe56e057f20f883e',1,'2019-03-17'),(842,'Colby','e10adc3949ba59abbe56e057f20f883e',1,'2019-09-18'),(843,'Basil','e10adc3949ba59abbe56e057f20f883e',1,'2019-08-25'),(844,'Justine','e10adc3949ba59abbe56e057f20f883e',1,'2020-02-20'),(845,'Craig','e10adc3949ba59abbe56e057f20f883e',1,'2020-10-29'),(846,'Candace','e10adc3949ba59abbe56e057f20f883e',1,'2020-04-19'),(847,'Burton','e10adc3949ba59abbe56e057f20f883e',1,'2019-08-30'),(848,'Sean','e10adc3949ba59abbe56e057f20f883e',1,'2021-03-09'),(849,'Urielle','e10adc3949ba59abbe56e057f20f883e',1,'2020-01-17'),(850,'Tanek','e10adc3949ba59abbe56e057f20f883e',1,'2020-12-08'),(851,'Guy','e10adc3949ba59abbe56e057f20f883e',1,'2020-11-23'),(852,'Uta','e10adc3949ba59abbe56e057f20f883e',1,'2020-11-26'),(853,'Desiree','e10adc3949ba59abbe56e057f20f883e',1,'2020-07-28'),(854,'Kenneth','e10adc3949ba59abbe56e057f20f883e',1,'2019-04-20'),(855,'Talon','e10adc3949ba59abbe56e057f20f883e',1,'2019-12-23'),(856,'Yuli','e10adc3949ba59abbe56e057f20f883e',1,'2020-09-19'),(857,'Jennifer','e10adc3949ba59abbe56e057f20f883e',1,'2019-11-30'),(858,'Camille','e10adc3949ba59abbe56e057f20f883e',1,'2020-07-02'),(859,'Amos','e10adc3949ba59abbe56e057f20f883e',1,'2020-07-22'),(860,'Fallon','e10adc3949ba59abbe56e057f20f883e',1,'2019-07-16'),(861,'Micah','e10adc3949ba59abbe56e057f20f883e',1,'2020-11-02'),(862,'Darius','e10adc3949ba59abbe56e057f20f883e',1,'2019-06-27'),(863,'Audra','e10adc3949ba59abbe56e057f20f883e',1,'2019-09-19'),(864,'Jonas','e10adc3949ba59abbe56e057f20f883e',1,'2020-07-01'),(866,'Daryl','e10adc3949ba59abbe56e057f20f883e',1,'2019-10-21'),(867,'Xyla','e10adc3949ba59abbe56e057f20f883e',1,'2021-02-22'),(868,'Caesar','e10adc3949ba59abbe56e057f20f883e',1,'2019-10-03'),(869,'Carolyn','e10adc3949ba59abbe56e057f20f883e',1,'2020-03-11'),(870,'Wanda','e10adc3949ba59abbe56e057f20f883e',1,'2021-03-08'),(871,'Porter','e10adc3949ba59abbe56e057f20f883e',1,'2019-03-23'),(872,'Jordan','e10adc3949ba59abbe56e057f20f883e',1,'2019-07-27'),(873,'Cadman','e10adc3949ba59abbe56e057f20f883e',1,'2019-12-27'),(874,'Hiram','e10adc3949ba59abbe56e057f20f883e',1,'2020-05-12'),(876,'Oscar','e10adc3949ba59abbe56e057f20f883e',1,'2019-03-20'),(877,'Levi','e10adc3949ba59abbe56e057f20f883e',1,'2021-03-04'),(878,'Bell','e10adc3949ba59abbe56e057f20f883e',1,'2020-03-27'),(879,'Shoshana','e10adc3949ba59abbe56e057f20f883e',1,'2020-09-23'),(880,'Lani','e10adc3949ba59abbe56e057f20f883e',1,'2019-10-16');
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
-- Dumping routines for database 'supermercado'
--
/*!50003 DROP FUNCTION IF EXISTS `fn_ejemplo_case` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` FUNCTION `fn_ejemplo_case`( pIdioma VARCHAR(2) ) RETURNS varchar(50) CHARSET latin1
BEGIN
	
	DECLARE saludo VARCHAR(50) DEFAULT '';	

	CASE pIdioma 
		WHEN 'es' THEN BEGIN
			SET saludo = 'Bien Venido';
		END;	
	
		WHEN 'eu' THEN BEGIN
			SET saludo = 'Ongi Etorri';
		END;
	
		WHEN 'en' THEN BEGIN
			SET saludo = 'Wellcome';
		END;
	
		ELSE BEGIN
			SET saludo = 'Lo siento, no conozoco el idioma';
		END;	
	
	END CASE;

    RETURN saludo;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fn_hola_mundo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` FUNCTION `fn_hola_mundo`() RETURNS varchar(100) CHARSET latin1
BEGIN
	
	RETURN 'Hola Mundo, soy el retorno de la función';
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fn_saludar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` FUNCTION `fn_saludar`(pNombre VARCHAR(100) ) RETURNS varchar(100) CHARSET latin1
BEGIN
	
   DECLARE salida VARCHAR(100) DEFAULT 'Lo siento pero no se tu nombre';
		
   IF pNombre IS NOT NULL AND "" <> TRIM(pNombre) THEN

      	SET salida = CONCAT('Hola ', pNombre);
   
   END IF;

   RETURN salida;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `fn_saludar_idioma` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` FUNCTION `fn_saludar_idioma`( pNombre VARCHAR(100), pIdioma VARCHAR(2) ) RETURNS varchar(100) CHARSET latin1
BEGIN
	
	 DECLARE saludo VARCHAR(50);
 
	 IF pNombre is NULL OR pNombre = '' THEN 
		SET pNombre = 'Anonimo';
	 END IF;
	
	 CASE pIdioma
	  WHEN 'es' THEN SET saludo = CONCAT('Hola, ', pNombre);
	  WHEN 'eu' THEN SET saludo = CONCAT('Kaixo, ', pNombre);
	  WHEN 'en' THEN SET saludo = CONCAT('Hello, ', pNombre);
	  ELSE BEGIN
		 SET saludo = CONCAT('ERROR: Idioma desconocido ', pIdioma); 	
      END;		  
	 END CASE;
	 
	 RETURN saludo;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_categoria_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` PROCEDURE `pa_categoria_delete`( IN pId INT )
BEGIN
	DELETE FROM categoria WHERE id = pId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_categoria_insertar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` PROCEDURE `pa_categoria_insertar`( IN pNombre VARCHAR(100), OUT pIdGenerado INT )
BEGIN
	
	
	
	INSERT INTO categoria ( nombre ) VALUES ( TRIM(pNombre) );

	
	SET pIdGenerado = LAST_INSERT_ID();
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_categoria_listar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` PROCEDURE `pa_categoria_listar`()
BEGIN
	
	
	SELECT id, nombre FROM categoria ORDER BY nombre ASC; 
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_categoria_por_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` PROCEDURE `pa_categoria_por_id`( IN pId INT )
BEGIN
	
	SELECT id, nombre FROM categoria WHERE id = pId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_categoria_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` PROCEDURE `pa_categoria_update`(IN pNombre VARCHAR(100), IN pId INT)
BEGIN
	
	UPDATE categoria SET nombre = TRIM(pNombre) WHERE id = pId;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_productos_por_categoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`debian-sys-maint`@`localhost` PROCEDURE `pa_productos_por_categoria`( IN idCategoria INT, IN numReg INT )
BEGIN
	
	
	SELECT 
		u.id 'usuario_id', 
		u.nombre 'usuario_nombre', 
		p.id  'producto_id', 
		p.nombre 'producto_nombre', 
		precio, 
		imagen, 
		c.id 'categoria_id', 
		c.nombre 'categoria_nombre' 
	FROM 
		producto p , categoria c, usuario u 
	WHERE 
		p.id_categoria  = c.id AND p.id_usuario = u.id 	
		AND fecha_validado IS NOT NULL 
		AND c.id = idCategoria  
		ORDER BY p.id DESC LIMIT numReg ;	
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

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

-- Dump completed on 2020-09-08 11:46:38