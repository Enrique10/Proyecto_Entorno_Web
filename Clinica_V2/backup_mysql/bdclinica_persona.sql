CREATE DATABASE  IF NOT EXISTS `bdclinica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdclinica`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: bdclinica
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id_psn` int(11) NOT NULL DEFAULT '1',
  `dni_psn` varchar(15) DEFAULT NULL,
  `nomb_psn` varchar(50) DEFAULT NULL,
  `apepat_psn` varchar(30) DEFAULT NULL,
  `apemat_psn` varchar(30) DEFAULT NULL,
  `sexo_psn` char(1) DEFAULT NULL,
  `fecnac_psn` date DEFAULT NULL,
  `lugnac_psn` varchar(50) DEFAULT NULL,
  `depa_psn` varchar(30) DEFAULT NULL,
  `prov_psn` varchar(30) DEFAULT NULL,
  `dist_psn` varchar(30) DEFAULT NULL,
  `dire_psn` varchar(50) DEFAULT NULL,
  `telef_psn` varchar(15) DEFAULT NULL,
  `movil_psn` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_psn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'1','1','1','1','F','2013-10-17','1','1','1','1','1','1','1'),(2,'45434565','GERARDO JOSE','PACHECO','CARBAJAL','M','2013-10-17','2','1','1','1','2','2','2');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-06 17:58:32
