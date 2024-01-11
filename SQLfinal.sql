CREATE DATABASE  IF NOT EXISTS `mascota` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mascota`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mascota
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascota` (
  `id_mascota` bigint NOT NULL AUTO_INCREMENT,
  `edad` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_propietario` bigint DEFAULT NULL,
  `id_raza` bigint DEFAULT NULL,
  PRIMARY KEY (`id_mascota`),
  KEY `FKsssk96eor25ho8ox5ivrj7xcg` (`id_propietario`),
  KEY `FK9cqkh7an5j21jva0pr59hk1nc` (`id_raza`),
  CONSTRAINT `FK9cqkh7an5j21jva0pr59hk1nc` FOREIGN KEY (`id_raza`) REFERENCES `raza` (`id_raza`),
  CONSTRAINT `FKsssk96eor25ho8ox5ivrj7xcg` FOREIGN KEY (`id_propietario`) REFERENCES `propietario` (`id_propietario`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
INSERT INTO `mascota` VALUES (4,2,'sammy',1,1),(6,3,'Luna',2,1),(8,3,'perla',3,1),(9,1,'lolo',3,3),(11,3,'rambo',4,2),(12,1,'Coco',3,4),(13,4,'Manchi',5,2),(14,2,'Baloo',4,6),(15,8,'Milo',6,3),(16,3,'Nina',7,5),(17,1,'Oreo',6,6),(18,5,'Lola',7,4),(19,2,'Sparky',NULL,NULL),(22,3,'Coco',NULL,NULL);
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietario`
--

DROP TABLE IF EXISTS `propietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propietario` (
  `id_propietario` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_propietario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietario`
--

LOCK TABLES `propietario` WRITE;
/*!40000 ALTER TABLE `propietario` DISABLE KEYS */;
INSERT INTO `propietario` VALUES (1,'manuel','987654321','Calle marquez','correo@propietario.com'),(2,'Juan Perez','123456789','Calle Principal 123','juan@example.com'),(3,'Ana Rodriguez','987654321','Avenida Central 456','ana@example.com'),(4,'Carlos Garcia','555555555','Plaza Mayor 789','carlos@example.com'),(5,'Claudia Lopez','5468465','calle 25 marzo','claudialopez24@example.com'),(6,'Irma Miranda','254687884','calle Mexico ','Irmamir@example.com'),(7,'Andreina Martinez','6855659','calle Santo domingo ','AndreinaMar@example.com');
/*!40000 ALTER TABLE `propietario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raza`
--

DROP TABLE IF EXISTS `raza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raza` (
  `id_raza` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `origen` varchar(255) DEFAULT NULL,
  `expectativa_vida` int DEFAULT NULL,
  PRIMARY KEY (`id_raza`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raza`
--

LOCK TABLES `raza` WRITE;
/*!40000 ALTER TABLE `raza` DISABLE KEYS */;
INSERT INTO `raza` VALUES (1,'Beagle','perros robustos y atrevidos son afables,','Inglaterra (Reino Unido)',12),(2,'Labrador Retriever','Perros amigables y familiares, buenos compañeros.','Terranova (Canadá)',12),(3,'German Shepherd','Perros inteligentes y leales, utilizados en roles de trabajo.','Alemania',11),(4,'Golden Retriever','Perros cariñosos y obedientes, populares como mascotas.','Escocia (Reino Unido)',11),(5,'Persa','Gatos de pelo largo y aspecto aristocrático.','Persia',15),(6,'Siamés','Gatos elegantes con pelaje corto, ojos azules y cola larga.','Tailandia',14),(7,'Bengala','Gatos con pelaje manchado y apariencia similar a la de los leopardos.','Estados Unidos',12),(8,'Maine Coon','Gatos grandes y peludos, conocidos como los \"gigantes amigables\".','Estados Unidos',13);
/*!40000 ALTER TABLE `raza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visita_veterinaria`
--

DROP TABLE IF EXISTS `visita_veterinaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visita_veterinaria` (
  `id_visita` bigint NOT NULL AUTO_INCREMENT,
  `id_mascota` bigint NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `razon_visita` varchar(255) DEFAULT NULL,
  `diagnostico` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_visita`),
  KEY `FK_visita_veterinaria_mascota` (`id_mascota`),
  CONSTRAINT `FK_visita_veterinaria_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `mascota` (`id_mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visita_veterinaria`
--

LOCK TABLES `visita_veterinaria` WRITE;
/*!40000 ALTER TABLE `visita_veterinaria` DISABLE KEYS */;
INSERT INTO `visita_veterinaria` VALUES (2,4,'2024-01-10 12:00:00','Control anual','Mascota saludable'),(4,4,'2024-01-10 12:00:00','Control anual','Mascota saludable'),(5,11,'2024-01-11 14:30:00','Problemas digestivos','Recetado tratamiento'),(6,6,'2024-01-12 10:15:00','Vacunación','Inmunizado correctamente'),(8,4,'2024-01-10 12:00:00','Control anual','Mascota saludable'),(9,11,'2024-01-11 14:30:00','Problemas digestivos','Recetado tratamiento'),(10,6,'2024-01-12 10:15:00','Vacunación','Inmunizado correctamente'),(11,8,'2024-01-13 16:45:00','Lesión en la pata','Requiere reposo y medicación'),(12,14,'2024-01-14 11:30:00','Vacunación anual','Mascota protegida'),(13,9,'2024-01-15 13:20:00','Problemas respiratorios','Recetado tratamiento'),(14,18,'2024-01-16 09:45:00','Control de peso','Mascota en buen estado físico');
/*!40000 ALTER TABLE `visita_veterinaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mascota'
--

--
-- Dumping routines for database 'mascota'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-10 13:27:44
