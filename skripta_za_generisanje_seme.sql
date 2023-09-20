CREATE DATABASE  IF NOT EXISTS `f1_infsys` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `f1_infsys`;
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
-- Table structure for table `angazman`
--

DROP TABLE IF EXISTS `angazman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `angazman` (
  `Uloga` varchar(45) NOT NULL,
  `IdAngazmana` int NOT NULL AUTO_INCREMENT,
  `Plata` decimal(10,0) NOT NULL,
  `Pocetak` date NOT NULL,
  `Kraj` date NOT NULL,
  `IdZaposlenog` int NOT NULL,
  `IdKonstruktora` int NOT NULL,
  PRIMARY KEY (`IdAngazmana`),
  KEY `fk_Angazman_Konstruktor1_idx` (`IdKonstruktora`),
  KEY `fk_Angazman_Zaposleni1` (`IdZaposlenog`),
  CONSTRAINT `fk_Angazman_Konstruktor1` FOREIGN KEY (`IdKonstruktora`) REFERENCES `konstruktor` (`IdKonstruktora`),
  CONSTRAINT `fk_Angazman_Zaposleni1` FOREIGN KEY (`IdZaposlenog`) REFERENCES `zaposleni` (`IdZaposlenog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `konstruktor`
--

DROP TABLE IF EXISTS `konstruktor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `konstruktor` (
  `IdKonstruktora` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(100) NOT NULL,
  `Mjesto` varchar(45) NOT NULL,
  `Zemlja` varchar(45) NOT NULL,
  `IdProizvodjacaMotora` int NOT NULL,
  PRIMARY KEY (`IdKonstruktora`),
  KEY `fk_Konstruktor_Proizvodjac motora1_idx` (`IdProizvodjacaMotora`),
  CONSTRAINT `fk_Konstruktor_Proizvodjac motora1` FOREIGN KEY (`IdProizvodjacaMotora`) REFERENCES `proizvodjac_motora` (`IdProizvodjacaMotora`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `konstruktorov_sponzorski_ugovor`
--

DROP TABLE IF EXISTS `konstruktorov_sponzorski_ugovor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `konstruktorov_sponzorski_ugovor` (
  `Konstruktor_IdKonstruktora` int NOT NULL,
  `Sponzor_IdSponzora` int NOT NULL,
  `VrijednostUgovora` decimal(10,0) NOT NULL,
  PRIMARY KEY (`Konstruktor_IdKonstruktora`,`Sponzor_IdSponzora`),
  KEY `fk_Konstruktor_has_Sponzor_Sponzor1_idx` (`Sponzor_IdSponzora`),
  KEY `fk_Konstruktor_has_Sponzor_Konstruktor1_idx` (`Konstruktor_IdKonstruktora`),
  CONSTRAINT `fk_Konstruktor_has_Sponzor_Konstruktor1` FOREIGN KEY (`Konstruktor_IdKonstruktora`) REFERENCES `konstruktor` (`IdKonstruktora`),
  CONSTRAINT `fk_Konstruktor_has_Sponzor_Sponzor1` FOREIGN KEY (`Sponzor_IdSponzora`) REFERENCES `sponzor` (`IdSponzora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `koristene_komponente`
--

DROP TABLE IF EXISTS `koristene_komponente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `koristene_komponente` (
  `BrojMotoraSUS` int NOT NULL,
  `BrojBaterije` int NOT NULL,
  `BrojAuspuha` int NOT NULL,
  `BrojKontrolneElektronike` int NOT NULL,
  `BrojMGU-H` int NOT NULL,
  `BrojMGU-K` int NOT NULL,
  `BrojTurbine` int NOT NULL,
  `Vozac_IdVozaca` int NOT NULL,
  `Sezona_IdSezone` int NOT NULL,
  `Konstruktor_IdKonstruktora` int NOT NULL,
  PRIMARY KEY (`Vozac_IdVozaca`,`Sezona_IdSezone`,`Konstruktor_IdKonstruktora`),
  KEY `fk_KoristeneKomponente_Sezona1_idx` (`Sezona_IdSezone`),
  KEY `fk_KoristeneKomponente_Konstruktor1_idx` (`Konstruktor_IdKonstruktora`),
  CONSTRAINT `fk_KoristeneKomponente_Konstruktor1` FOREIGN KEY (`Konstruktor_IdKonstruktora`) REFERENCES `konstruktor` (`IdKonstruktora`),
  CONSTRAINT `fk_KoristeneKomponente_Sezona1` FOREIGN KEY (`Sezona_IdSezone`) REFERENCES `sezona` (`IdSezone`),
  CONSTRAINT `fk_KoristeneKomponente_Vozac1` FOREIGN KEY (`Vozac_IdVozaca`) REFERENCES `vozac` (`IdVozaca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `poredak_u_konkurenciji_konstruktora`
--

DROP TABLE IF EXISTS `poredak_u_konkurenciji_konstruktora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poredak_u_konkurenciji_konstruktora` (
  `Konstruktor_IdKonstruktora` int NOT NULL,
  `Sezona_IdSezone` int NOT NULL,
  `BrojPoena` int NOT NULL,
  `PozicijaUSampionatu` varchar(45) NOT NULL,
  PRIMARY KEY (`Konstruktor_IdKonstruktora`,`Sezona_IdSezone`),
  KEY `fk_Konstruktor_has_Sezona_Sezona1_idx` (`Sezona_IdSezone`),
  KEY `fk_Konstruktor_has_Sezona_Konstruktor1_idx` (`Konstruktor_IdKonstruktora`),
  CONSTRAINT `fk_Konstruktor_has_Sezona_Konstruktor1` FOREIGN KEY (`Konstruktor_IdKonstruktora`) REFERENCES `konstruktor` (`IdKonstruktora`),
  CONSTRAINT `fk_Konstruktor_has_Sezona_Sezona1` FOREIGN KEY (`Sezona_IdSezone`) REFERENCES `sezona` (`IdSezone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `poredak_u_konkurenciji_vozaca`
--

DROP TABLE IF EXISTS `poredak_u_konkurenciji_vozaca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poredak_u_konkurenciji_vozaca` (
  `Vozac_IdVozaca` int NOT NULL,
  `Sezona_IdSezone` int NOT NULL,
  `BrojPoena` int NOT NULL,
  PRIMARY KEY (`Vozac_IdVozaca`,`Sezona_IdSezone`),
  KEY `fk_Vozac_has_Sezona_Sezona1_idx` (`Sezona_IdSezone`),
  KEY `fk_Vozac_has_Sezona_Vozac1_idx` (`Vozac_IdVozaca`),
  CONSTRAINT `fk_Vozac_has_Sezona_Sezona1` FOREIGN KEY (`Sezona_IdSezone`) REFERENCES `sezona` (`IdSezone`),
  CONSTRAINT `fk_Vozac_has_Sezona_Vozac1` FOREIGN KEY (`Vozac_IdVozaca`) REFERENCES `vozac` (`IdVozaca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proizvodjac_motora`
--

DROP TABLE IF EXISTS `proizvodjac_motora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proizvodjac_motora` (
  `IdProizvodjacaMotora` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(60) NOT NULL,
  `Mjesto` varchar(45) NOT NULL,
  `Zemlja` varchar(45) NOT NULL,
  PRIMARY KEY (`IdProizvodjacaMotora`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rezultat`
--

DROP TABLE IF EXISTS `rezultat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rezultat` (
  `Vozac_IdVozaca` int NOT NULL,
  `Trkacki vikend_IdTrkackogVikenda` int NOT NULL,
  `StartnaPozicija` int NOT NULL,
  `KrajnjaPozicija` int NOT NULL,
  `Vrijeme` time DEFAULT NULL,
  `NajbrziKrug` tinyint NOT NULL,
  `Poeni` int NOT NULL,
  `Konstruktor_IdKonstruktora` int NOT NULL,
  PRIMARY KEY (`Vozac_IdVozaca`,`Trkacki vikend_IdTrkackogVikenda`),
  KEY `fk_Vozac_has_Trkacki vikend_Trkacki vikend1_idx` (`Trkacki vikend_IdTrkackogVikenda`),
  KEY `fk_Vozac_has_Trkacki vikend_Vozac1_idx` (`Vozac_IdVozaca`),
  KEY `fk_Rezultat_Konstruktor1_idx` (`Konstruktor_IdKonstruktora`),
  CONSTRAINT `fk_Rezultat_Konstruktor1` FOREIGN KEY (`Konstruktor_IdKonstruktora`) REFERENCES `konstruktor` (`IdKonstruktora`),
  CONSTRAINT `fk_Vozac_has_Trkacki vikend_Trkacki vikend1` FOREIGN KEY (`Trkacki vikend_IdTrkackogVikenda`) REFERENCES `trkacki_vikend` (`IdTrkackogVikenda`),
  CONSTRAINT `fk_Vozac_has_Trkacki vikend_Vozac1` FOREIGN KEY (`Vozac_IdVozaca`) REFERENCES `vozac` (`IdVozaca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Table structure for table `sezona`
--

DROP TABLE IF EXISTS `sezona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sezona` (
  `IdSezone` int NOT NULL AUTO_INCREMENT,
  `Godina` int NOT NULL,
  `BrojTrka` int NOT NULL,
  PRIMARY KEY (`IdSezone`),
  UNIQUE KEY `Godina_UNIQUE` (`Godina`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sponzor`
--

DROP TABLE IF EXISTS `sponzor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sponzor` (
  `IdSponzora` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdSponzora`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `staza`
--

DROP TABLE IF EXISTS `staza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staza` (
  `IdStaze` int NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(100) NOT NULL,
  `Mjesto` varchar(45) NOT NULL,
  `Drzava` varchar(45) NOT NULL,
  `Kapacitet` int NOT NULL,
  `IsUlicna` tinyint NOT NULL,
  `DuzinaKruga` float NOT NULL,
  `BrojKrugova` int NOT NULL,
  PRIMARY KEY (`IdStaze`),
  UNIQUE KEY `Naziv_UNIQUE` (`Naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trkacki_vikend`
--

DROP TABLE IF EXISTS `trkacki_vikend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trkacki_vikend` (
  `IdTrkackogVikenda` int NOT NULL AUTO_INCREMENT,
  `RedniBroj` int NOT NULL,
  `NazivVelikeNagrade` varchar(60) NOT NULL,
  `DatumPocetka` date NOT NULL,
  `DatumKraja` date NOT NULL,
  `VrijemeTrke` time NOT NULL,
  `VrijemeKvalifikacija` time NOT NULL,
  `VrijemePrvogTreninga` time NOT NULL,
  `VrijemeDrugogTreninga` time NOT NULL,
  `VrijemeTrecegTreninga` time DEFAULT NULL,
  `Staza_IdStaze` int NOT NULL,
  `Sezona_IdSezone` int NOT NULL,
  PRIMARY KEY (`IdTrkackogVikenda`),
  UNIQUE KEY `RedniBroj_UNIQUE` (`RedniBroj`),
  UNIQUE KEY `NazivVelikeNagrade_UNIQUE` (`NazivVelikeNagrade`),
  UNIQUE KEY `DatumPocetka_UNIQUE` (`DatumPocetka`),
  UNIQUE KEY `DatumKraja_UNIQUE` (`DatumKraja`),
  KEY `fk_Trkacki vikend_Staza1_idx` (`Staza_IdStaze`),
  KEY `fk_Trkacki vikend_Sezona1_idx` (`Sezona_IdSezone`),
  CONSTRAINT `fk_Trkacki vikend_Sezona1` FOREIGN KEY (`Sezona_IdSezone`) REFERENCES `sezona` (`IdSezone`),
  CONSTRAINT `fk_Trkacki vikend_Staza1` FOREIGN KEY (`Staza_IdStaze`) REFERENCES `staza` (`IdStaze`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vozac`
--

DROP TABLE IF EXISTS `vozac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vozac` (
  `IdVozaca` int NOT NULL AUTO_INCREMENT,
  `Ime` varchar(45) NOT NULL,
  `Prezime` varchar(45) NOT NULL,
  `Zemlja` varchar(45) NOT NULL,
  `Plata` decimal(10,0) NOT NULL,
  `PreostaloTrajanjeUgovora` int NOT NULL,
  `IdKonstruktora` int NOT NULL,
  PRIMARY KEY (`IdVozaca`),
  KEY `fk_Vozac_Konstruktor1_idx` (`IdKonstruktora`),
  CONSTRAINT `fk_Vozac_Konstruktor1` FOREIGN KEY (`IdKonstruktora`) REFERENCES `konstruktor` (`IdKonstruktora`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vozacev_sponzorski_ugovor`
--

DROP TABLE IF EXISTS `vozacev_sponzorski_ugovor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vozacev_sponzorski_ugovor` (
  `Vozac_IdVozaca` int NOT NULL,
  `Sponzor_IdSponzora` int NOT NULL,
  `VrijednostUgovora` decimal(10,0) NOT NULL,
  PRIMARY KEY (`Vozac_IdVozaca`,`Sponzor_IdSponzora`),
  KEY `fk_Vozac_has_Sponzor_Sponzor1_idx` (`Sponzor_IdSponzora`),
  KEY `fk_Vozac_has_Sponzor_Vozac1_idx` (`Vozac_IdVozaca`),
  CONSTRAINT `fk_Vozac_has_Sponzor_Sponzor1` FOREIGN KEY (`Sponzor_IdSponzora`) REFERENCES `sponzor` (`IdSponzora`),
  CONSTRAINT `fk_Vozac_has_Sponzor_Vozac1` FOREIGN KEY (`Vozac_IdVozaca`) REFERENCES `vozac` (`IdVozaca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `zaposleni`
--

DROP TABLE IF EXISTS `zaposleni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zaposleni` (
  `IdZaposlenog` int NOT NULL AUTO_INCREMENT,
  `Ime` varchar(45) NOT NULL,
  `Prezime` varchar(45) NOT NULL,
  PRIMARY KEY (`IdZaposlenog`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'f1_infsys'
--

--

-- Dump completed on 2023-05-28 23:57:59
