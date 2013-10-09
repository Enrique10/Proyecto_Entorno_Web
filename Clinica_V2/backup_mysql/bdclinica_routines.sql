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
-- Dumping routines for database 'bdclinica'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_ins_medico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ins_medico`(pdni_psn	varchar(15), pnomb_psn	varchar(50), papepat_psn	varchar(30),
papemat_psn	varchar(30), psexo_psn	char(1),pfecnac_psn	date, plugnac_psn	varchar(50),pdepa_psn	varchar(30),
pprov_psn	varchar(30),pdist_psn	varchar(30),pdire_psn	varchar(50),ptelef_psn	varchar(15),pmovil_psn	varchar(15),
pid_pf int ,pid_espe int)
BEGIN

declare pid_psn	int;
declare pid_emp	int;

    set pid_psn = (select valor_bs from base where id_bs = 1);
    set pid_emp = (select valor_bs from base where id_bs = 3);
    
    insert into persona values(pid_psn, pdni_psn, pnomb_psn, papepat_psn, papemat_psn, psexo_psn, 
    pfecnac_psn, plugnac_psn, pdepa_psn, pprov_psn, pdist_psn, pdire_psn, ptelef_psn, pmovil_psn,
    pid_pf,pid_espe);
    
    insert into empleado values(pid_emp, pid_pf, pid_psn, pid_espe);
    
    update base set valor_bs = valor_bs + 1 where id_bs = 1;
    update base set valor_bs = valor_bs + 1 where id_bs = 3;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ins_paciente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ins_paciente`(pdni_psn	varchar(15), pnomb_psn	varchar(50), papepat_psn	varchar(30),
papemat_psn	varchar(30), psexo_psn	char(1),pfecnac_psn	date, plugnac_psn	varchar(50),pdepa_psn	varchar(30),
pprov_psn	varchar(30),pdist_psn	varchar(30),pdire_psn	varchar(50),ptelef_psn	varchar(15),pmovil_psn	varchar(15))
BEGIN

declare pid_psn	int;
declare pid_paci	int;

    set pid_psn = (select valor_bs from base where id_bs = 1);
    set pid_paci = (select valor_bs from base where id_bs = 2);
    
    insert into persona values(pid_psn, pdni_psn, pnomb_psn, papepat_psn, papemat_psn, psexo_psn, 
    pfecnac_psn, plugnac_psn, pdepa_psn, pprov_psn, pdist_psn, pdire_psn, ptelef_psn, pmovil_psn);
    
    insert into paciente values(pid_paci, pid_psn, current_date);
    
    update base set valor_bs = valor_bs + 1 where id_bs = 1;
    update base set valor_bs = valor_bs + 1 where id_bs = 2;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_upd_paciente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_upd_paciente`(pid_psn int, pdni_psn	varchar(15), pnomb_psn	varchar(50), papepat_psn	varchar(30),
papemat_psn	varchar(30), psexo_psn	char(1),pfecnac_psn	date, plugnac_psn	varchar(50),pdepa_psn	varchar(30),
pprov_psn	varchar(30),pdist_psn	varchar(30),pdire_psn	varchar(50),ptelef_psn	varchar(15),pmovil_psn	varchar(15))
BEGIN
    
    update persona set dni_psn=pdni_psn, nomb_psn=pnomb_psn, apepat_psn=papepat_psn, 
    apemat_psn=papemat_psn, sexo_psn=psexo_psn, fecnac_psn=pfecnac_psn, lugnac_psn=plugnac_psn, 
    depa_psn=pdepa_psn, prov_psn=pprov_psn, dist_psn=pdist_psn, dire_psn=pdire_psn, 
    telef_psn=ptelef_psn, movil_psn=pmovil_psn where id_psn=pid_psn;     

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-06 17:58:38
