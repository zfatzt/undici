CREATE DATABASE  IF NOT EXISTS `undici` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `undici`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: undici
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `strasse` varchar(50) NOT NULL,
  `hausnummer` int(11) NOT NULL,
  `plz` int(11) NOT NULL,
  `ort` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresse`
--

LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
INSERT INTO `adresse` VALUES (1,'Bühlfedstrasse',9,8965,'Berikon');
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bestellung`
--

DROP TABLE IF EXISTS `bestellung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bestellung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `getraenk_id` int(11) NOT NULL,
  `anzahlpizza` int(11) NOT NULL,
  `pizza_id` int(11) NOT NULL,
  `zahlung` varchar(45) NOT NULL,
  `kunde_id` int(11) NOT NULL,
  `gesamtpreis` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `kunde_id` (`kunde_id`),
  KEY `getraenk_id` (`getraenk_id`),
  KEY `pizza_id` (`pizza_id`),
  CONSTRAINT `bestellung_ibfk_1` FOREIGN KEY (`kunde_id`) REFERENCES `kunde` (`id`),
  CONSTRAINT `bestellung_ibfk_2` FOREIGN KEY (`getraenk_id`) REFERENCES `getraenk` (`id`),
  CONSTRAINT `bestellung_ibfk_3` FOREIGN KEY (`pizza_id`) REFERENCES `pizza` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bestellung`
--

LOCK TABLES `bestellung` WRITE;
/*!40000 ALTER TABLE `bestellung` DISABLE KEYS */;
/*!40000 ALTER TABLE `bestellung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `getraenk`
--

DROP TABLE IF EXISTS `getraenk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `getraenk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `getraenk` varchar(45) NOT NULL,
  `preis` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `getraenk`
--

LOCK TABLES `getraenk` WRITE;
/*!40000 ALTER TABLE `getraenk` DISABLE KEYS */;
INSERT INTO `getraenk` VALUES (1,'Coca Cola',4),(2,'Coca-Cola zero',4),(3,'Coca-Cola light',4),(4,'Fanta',4),(5,'Sprite',4),(6,'Valser Wasser',2);
/*!40000 ALTER TABLE `getraenk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kunde`
--

DROP TABLE IF EXISTS `kunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kunde` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anrede` varchar(50) NOT NULL,
  `vorname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `passwort` varchar(45) NOT NULL,
  `telefon` varchar(16) NOT NULL,
  `kreditkartenNr` varchar(45) NOT NULL,
  `adresse_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `adresse_id` (`adresse_id`),
  CONSTRAINT `kunde_ibfk_1` FOREIGN KEY (`adresse_id`) REFERENCES `adresse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kunde`
--

LOCK TABLES `kunde` WRITE;
/*!40000 ALTER TABLE `kunde` DISABLE KEYS */;
INSERT INTO `kunde` VALUES (1,'Herr','Tobias','Fatzer','tobias.fatzer@bbcag.ch','Toby1234','+41 76 689 68 89','26+64161',1);
/*!40000 ALTER TABLE `kunde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pizza` varchar(45) NOT NULL,
  `preis` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza`
--

LOCK TABLES `pizza` WRITE;
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
INSERT INTO `pizza` VALUES (1,'Margheritta',16),(2,'Funghi',19),(3,'Salame',20),(4,'Salame Picante',20),(5,'Calzone',20),(6,'Quatro Formagi',21),(7,'Prosciutto',20),(8,'Hawaii',20),(9,'Napoli',18),(10,'Quatro Stagioni',20),(11,'frutti di mare',20);
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_zutat`
--

DROP TABLE IF EXISTS `pizza_zutat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_zutat` (
  `pizza_id` int(11) NOT NULL,
  `zutat_id` int(11) NOT NULL,
  PRIMARY KEY (`pizza_id`,`zutat_id`),
  KEY `zutat_id` (`zutat_id`),
  CONSTRAINT `pizza_zutat_ibfk_1` FOREIGN KEY (`zutat_id`) REFERENCES `zutat` (`id`),
  CONSTRAINT `pizza_zutat_ibfk_2` FOREIGN KEY (`pizza_id`) REFERENCES `pizza` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_zutat`
--

LOCK TABLES `pizza_zutat` WRITE;
/*!40000 ALTER TABLE `pizza_zutat` DISABLE KEYS */;
INSERT INTO `pizza_zutat` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(11,3),(8,4),(10,5),(2,9),(10,9),(5,11),(6,12),(5,13),(7,13),(8,13),(10,13),(9,14),(6,17),(11,18),(6,21),(4,22),(10,23),(3,26),(4,27);
/*!40000 ALTER TABLE `pizza_zutat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zutat`
--

DROP TABLE IF EXISTS `zutat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zutat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zutat` varchar(45) NOT NULL,
  `preis` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zutat`
--

LOCK TABLES `zutat` WRITE;
/*!40000 ALTER TABLE `zutat` DISABLE KEYS */;
INSERT INTO `zutat` VALUES (1,'Tomatensauce',2),(2,'Mozzarella',2),(3,'Oregano',2),(4,'Ananas',1),(5,'Artischocken',2),(6,'Auberginen',2),(7,'Blattspinat',2),(8,'Broccoli',2),(9,'Champignons',2),(10,'Crevetten Black Tiger',3),(11,'Ei',2),(12,'Gorgonzola',2),(13,'Hinterschinken',3),(14,'Kapern',1),(15,'Knoblauch',1),(16,'Mais',1),(17,'Mascarpone',2),(18,'Meeresfrüchte',3),(19,'Mozzarella extra',2),(20,'Oliven',1),(21,'Grana Padano',2),(22,'Peperocini',1),(23,'Peperoni',1),(24,'Rohschinknen',5),(25,'Rucola',2),(26,'Salami',3),(27,'Scharfe Salami',3),(28,'Speck',3),(29,'Steinpilze',3),(30,'Tomatenscheiben',2),(31,'Zwiebeln',1);
/*!40000 ALTER TABLE `zutat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-09  8:57:24
