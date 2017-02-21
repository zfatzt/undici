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
INSERT INTO `adresse` VALUES (1,'Lieslisloo',25,8965,'Berikon');
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
  `getraenke` varchar(45) NOT NULL,
  `pizza` varchar(45) NOT NULL,
  `zahlung` varchar(45) NOT NULL,
  `kunde_id` int(11) NOT NULL,
  `gesamtpreis` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `kunde_id` (`kunde_id`),
  CONSTRAINT `bestellung_ibfk_1` FOREIGN KEY (`kunde_id`) REFERENCES `kunde` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bestellung`
--

LOCK TABLES `bestellung` WRITE;
/*!40000 ALTER TABLE `bestellung` DISABLE KEYS */;
INSERT INTO `bestellung` VALUES (3,'Fanta','Margherita','Barzahlung',5,193.25),(4,'Fanta','Margherita','Barzahlung',5,193.25),(5,'Fanta','Margherita','Barzahlung',5,193.25),(6,'Fanta','Margherita','Barzahlung',5,193.25),(7,'Fanta','Margherita','Barzahlung',5,193.25),(8,'Fanta','Margherita','Barzahlung',5,193.25),(9,'Fanta','Margherita','Barzahlung',5,193.25),(10,'Fanta','Margherita','Barzahlung',5,193.25),(11,'Fanta','Margherita','Barzahlung',5,193.25),(12,'Fanta','Margherita','Barzahlung',5,193.25),(13,'Fanta','Margherita','Barzahlung',5,193.25),(14,'Fanta','Margherita','Barzahlung',5,193.25),(15,'Fanta','Margherita','Barzahlung',5,193.25),(16,'Fanta','Margherita','Barzahlung',5,193.25),(17,'Fanta','Margherita','Barzahlung',5,193.25);
/*!40000 ALTER TABLE `bestellung` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kunde`
--

LOCK TABLES `kunde` WRITE;
/*!40000 ALTER TABLE `kunde` DISABLE KEYS */;
INSERT INTO `kunde` VALUES (5,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','hdaohf','+4546496641663','7656786567',1),(6,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','hdaohf','+4546496641663','7656786567',1),(7,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','hdaohf','+4546496641663','7656786567',1),(8,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','hdaohf','+4546496641663','7656786567',1),(10,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(11,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(12,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(13,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(14,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(15,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(16,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(17,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(18,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(19,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(20,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(21,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(22,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(23,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(24,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(25,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1),(26,'Herr','Tobias','Fatzer','tobias.fatzer@bluewin.ch','Toby1234','+41 76 682 68 89','561313033',1);
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

-- Dump completed on 2017-02-08 10:22:17
