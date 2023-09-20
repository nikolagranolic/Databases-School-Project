-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: f1_infsys
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `angazman`
--

LOCK TABLES `angazman` WRITE;
/*!40000 ALTER TABLE `angazman` DISABLE KEYS */;
/*!40000 ALTER TABLE `angazman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `konstruktor`
--

LOCK TABLES `konstruktor` WRITE;
/*!40000 ALTER TABLE `konstruktor` DISABLE KEYS */;
INSERT INTO `konstruktor` VALUES (5,'Aston Martin F1','Silverstone','UK',1),(6,'Mercedes AMG F1','Brackley','UK',1),(7,'Scuderia Ferrari','Maranello','Italy',2),(9,'Alpine','Entstone','UK',4),(10,'Red Bull Racing','Milton Keynes','UK',3),(11,'Alfa Romeo','Hinwil','Switzerland',2),(12,'Haas','Kannapolis','USA',2),(13,'McLaren','Woking','UK',1),(14,'Williams Racing','Grove','UK',1),(17,'Alpha Tauri','Faenza','Italy',3);
/*!40000 ALTER TABLE `konstruktor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `konstruktorov_sponzorski_ugovor`
--

LOCK TABLES `konstruktorov_sponzorski_ugovor` WRITE;
/*!40000 ALTER TABLE `konstruktorov_sponzorski_ugovor` DISABLE KEYS */;
/*!40000 ALTER TABLE `konstruktorov_sponzorski_ugovor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `koristene_komponente`
--

LOCK TABLES `koristene_komponente` WRITE;
/*!40000 ALTER TABLE `koristene_komponente` DISABLE KEYS */;
/*!40000 ALTER TABLE `koristene_komponente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `poredak_u_konkurenciji_konstruktora`
--

LOCK TABLES `poredak_u_konkurenciji_konstruktora` WRITE;
/*!40000 ALTER TABLE `poredak_u_konkurenciji_konstruktora` DISABLE KEYS */;
/*!40000 ALTER TABLE `poredak_u_konkurenciji_konstruktora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `poredak_u_konkurenciji_vozaca`
--

LOCK TABLES `poredak_u_konkurenciji_vozaca` WRITE;
/*!40000 ALTER TABLE `poredak_u_konkurenciji_vozaca` DISABLE KEYS */;
INSERT INTO `poredak_u_konkurenciji_vozaca` VALUES (1,4,1);
/*!40000 ALTER TABLE `poredak_u_konkurenciji_vozaca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `proizvodjac_motora`
--

LOCK TABLES `proizvodjac_motora` WRITE;
/*!40000 ALTER TABLE `proizvodjac_motora` DISABLE KEYS */;
INSERT INTO `proizvodjac_motora` VALUES (1,'Mercedes','Brixworth','UK'),(2,'Ferrari','Maranello','Italy'),(3,'RBPT Honda','Sakura','Japan'),(4,'Renault','Viry','France');
/*!40000 ALTER TABLE `proizvodjac_motora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rezultat`
--

LOCK TABLES `rezultat` WRITE;
/*!40000 ALTER TABLE `rezultat` DISABLE KEYS */;
INSERT INTO `rezultat` VALUES (1,4,2,10,'01:32:00',1,1,6);
/*!40000 ALTER TABLE `rezultat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sezona`
--

LOCK TABLES `sezona` WRITE;
/*!40000 ALTER TABLE `sezona` DISABLE KEYS */;
INSERT INTO `sezona` VALUES (1,2021,22),(2,2022,22),(4,2023,23);
/*!40000 ALTER TABLE `sezona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sponzor`
--

LOCK TABLES `sponzor` WRITE;
/*!40000 ALTER TABLE `sponzor` DISABLE KEYS */;
INSERT INTO `sponzor` VALUES (1,'Petronas'),(2,'Ineos'),(3,'Honda'),(4,'Aramco'),(5,'Orlen');
/*!40000 ALTER TABLE `sponzor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `staza`
--

LOCK TABLES `staza` WRITE;
/*!40000 ALTER TABLE `staza` DISABLE KEYS */;
INSERT INTO `staza` VALUES (1,'Circuit de Spa-Francorchamps','Stavelot','Belgium',70000,0,7.004,44),(2,'Las Vegas Strip Circuit','Las Vegas','USA',70000,1,6.12,50),(3,'Miami International Autodrome','Miami','USA',70000,1,5.412,57);
/*!40000 ALTER TABLE `staza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trkacki_vikend`
--

LOCK TABLES `trkacki_vikend` WRITE;
/*!40000 ALTER TABLE `trkacki_vikend` DISABLE KEYS */;
INSERT INTO `trkacki_vikend` VALUES (1,1,'Belgian Grand Prix','2023-07-28','2023-08-01','10:00:00','10:00:00','10:00:00','10:00:00','10:00:00',1,4),(3,2,'Italian Grand Prix','2022-02-02','2022-02-04','10:00:00','10:00:00','10:00:00','10:00:00','10:00:00',2,4),(4,3,'Monaco Grand Prix','2023-05-27','2023-05-29','10:00:00','10:00:00','10:00:00','10:00:00','10:00:00',3,4);
/*!40000 ALTER TABLE `trkacki_vikend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vozac`
--

LOCK TABLES `vozac` WRITE;
/*!40000 ALTER TABLE `vozac` DISABLE KEYS */;
INSERT INTO `vozac` VALUES (1,'Lewis','Hamilton','UK',40000000,1,6),(2,'George','Russell','UK',9000000,2,6),(3,'Max','Verstappen','Netherlands',45000000,5,10),(4,'Sergio','Perez','Mexico',20000000,2,10),(5,'Charles','Leclerc','Monaco',25000000,3,7),(6,'Carlos','Sainz','Spain',15000000,2,7),(7,'Fernando','Alonso','Spain',30000000,3,5),(8,'Esteban','Ocon','France',10000000,2,9),(9,'Lance','Stroll','Canada',10000000,2,5),(10,'Pierre','Gasly','France',10000000,2,9),(12,'Lando','Norris','UK',10000000,3,13),(13,'Daniel','Ricciardo','Australia',5000000,2,10);
/*!40000 ALTER TABLE `vozac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vozacev_sponzorski_ugovor`
--

LOCK TABLES `vozacev_sponzorski_ugovor` WRITE;
/*!40000 ALTER TABLE `vozacev_sponzorski_ugovor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vozacev_sponzorski_ugovor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `zaposleni`
--

LOCK TABLES `zaposleni` WRITE;
/*!40000 ALTER TABLE `zaposleni` DISABLE KEYS */;
INSERT INTO `zaposleni` VALUES (1,'Toto','Wolff'),(2,'Christian','Horner'),(3,'James','Allison'),(4,'Adrian','Newey');
/*!40000 ALTER TABLE `zaposleni` ENABLE KEYS */;
UNLOCK TABLES;

-- Dump completed on 2023-05-29  0:12:49
