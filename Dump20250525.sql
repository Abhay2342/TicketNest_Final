CREATE DATABASE  IF NOT EXISTS `ticketnest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ticketnest`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: ticketnest
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `cinemas`
--

DROP TABLE IF EXISTS `cinemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinemas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `merchant_id` int DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `merchant_id` (`merchant_id`),
  CONSTRAINT `cinemas_ibfk_1` FOREIGN KEY (`merchant_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinemas`
--

LOCK TABLES `cinemas` WRITE;
/*!40000 ALTER TABLE `cinemas` DISABLE KEYS */;
INSERT INTO `cinemas` VALUES (2,'CineWorld',3,'123 Main St, Cityville','A premier cinema with multiple screens.','2025-04-18 09:01:38'),(3,'iMAX',3,'Phagwara','Best Cinema in the city','2025-04-19 16:43:55'),(5,'MDB',3,'Jalandhar','Finest Place','2025-04-19 17:48:07'),(6,'Merchant123 iMax',16,'Bellandur','Best Cinema in the area','2025-05-25 09:12:46');
/*!40000 ALTER TABLE `cinemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration_minutes` int DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Raid 2','the movie is based on the true story of a Chinese naval task force that rescued over 1,000 Chinese civilians from Yemen during the 2015 Yemeni Civil War.',125,'Crime','English','2010-07-16','2025-04-18 09:05:41','https://stat5.bollywoodhungama.in/wp-content/uploads/2021/12/Raid2-1.jpg'),(2,'Inception','A mind-bending thriller about dreams within dreams.',148,'Science Fiction','English','2010-07-16','2025-04-18 09:28:12','https://m.media-amazon.com/images/I/91cVXf75GXL._AC_UF1000,1000_QL80_DpWeblab_.jpg'),(7,'Moana','Life of an unknown girl',123,'Animation','English','2025-06-10','2025-04-20 02:46:00','https://threepennypress.org/wp-content/uploads/2016/11/moana-poster.jpg'),(8,'Sinners','Trying to leave their troubled lives behind, twin brothers return to their Mississippi hometown to start again, only to discover that an even greater evil is waiting to welcome them back.',135,'Horror','English, Hindi','2025-05-15','2025-05-25 09:56:06','https://mlpnk72yciwc.i.optimole.com/cqhiHLc.IIZS~2ef73/w:auto/h:auto/q:75/https://bleedingcool.com/wp-content/uploads/2025/03/GmA989AbIAA9xPj.jpg');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otp_verifications`
--

DROP TABLE IF EXISTS `otp_verifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `otp_verifications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `otp_code` varchar(255) DEFAULT NULL,
  `is_verified` bit(1) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `expires_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `otp_verifications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otp_verifications`
--

LOCK TABLES `otp_verifications` WRITE;
/*!40000 ALTER TABLE `otp_verifications` DISABLE KEYS */;
INSERT INTO `otp_verifications` VALUES (1,3,'123456',_binary '\0','2025-04-19 06:41:56','2025-04-26 06:41:56');
/*!40000 ALTER TABLE `otp_verifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ticket_id` int DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `payment_method` enum('UPI','CREDIT_CARD','DEBIT_CARD','NET_BANKING') NOT NULL,
  `payment_status` enum('PENDING','SUCCESS','FAILED') DEFAULT 'PENDING',
  `payment_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `ticket_id` (`ticket_id`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `show_timings`
--

DROP TABLE IF EXISTS `show_timings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `show_timings` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cinema_id` int DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  `show_date` date DEFAULT NULL,
  `show_time` time DEFAULT NULL,
  `ticket_price` double DEFAULT NULL,
  `total_seats` int DEFAULT NULL,
  `available_seats` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` int DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `payment_time` datetime(6) DEFAULT NULL,
  `ticket_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cinema_id` (`cinema_id`),
  KEY `movie_id` (`movie_id`),
  CONSTRAINT `show_timings_ibfk_1` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `show_timings_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `show_timings`
--

LOCK TABLES `show_timings` WRITE;
/*!40000 ALTER TABLE `show_timings` DISABLE KEYS */;
INSERT INTO `show_timings` VALUES (7,2,1,'2025-10-10','15:00:00',10.5,100,100,'2025-04-18 09:28:59',NULL,NULL,NULL,NULL,NULL),(8,2,2,'2025-10-10','15:00:00',10.5,100,100,'2025-04-18 09:29:37',NULL,NULL,NULL,NULL,NULL),(9,3,7,'2025-04-25','10:35:00',245,120,120,'2025-04-20 03:01:49',NULL,NULL,NULL,NULL,NULL),(10,6,8,'2025-05-29','18:30:00',125,120,120,'2025-05-25 09:56:48',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `show_timings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `show_id` int DEFAULT NULL,
  `booking_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `seats_booked` int DEFAULT NULL,
  `qr_code` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `booking_timing` datetime(6) DEFAULT NULL,
  `seat_numbers` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `show_id` (`show_id`),
  CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `tickets_ibfk_2` FOREIGN KEY (`show_id`) REFERENCES `show_timings` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,4,7,'2025-04-18 14:21:33',70,'23423212','Confirmed','2025-04-18 19:51:33.007404',NULL),(5,4,9,'2025-04-20 12:19:01',3,'78c525dc-a65b-47ee-afd8-272f207447fd','CONFIRMED','2025-04-20 17:49:01.120686','A1, C2, D2'),(6,4,9,'2025-04-20 12:24:01',4,'0e84c622-1181-4fd9-a46c-637d9c0e9781','CONFIRMED','2025-04-20 17:54:01.473756','A1, D1, D2, C2'),(7,4,9,'2025-04-26 04:10:26',3,'a9f64d96-865b-4782-9263-18371904c472','CONFIRMED','2025-04-26 09:40:26.686712','B2, B4, B6'),(19,4,9,'2025-05-24 16:30:51',0,'d8a9e158-cdcd-4853-885b-3f6609f1a00c','CONFIRMED',NULL,'');
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'Merchant','merchant2342@gmail.com','$2a$12$4zAGfuOe.SFqMoWe8P/X.uh6f9G4RMaz.PDIJrUXfPr/pJj0XIWdW','9814030414','MERCHANT','2025-04-18 07:25:53','merchant2342'),(4,'Client','client2342@gmail.com','$2a$2a$12$SJsxSy32F/TESHrFuGzibO4a6BdwhdmZhHtl9vfBbpnsW80QhgJSW','8103398414','CLIENT','2025-04-18 14:19:41','client2342'),(5,'Abhay Suryawanshi','choudharyabhay2342@gmail.com','$2a$10$KX5WMyQuWuzJiPbRMWvSLuWq8zv54umNHUhhNeyQtMq59Y5fVuHQS','8103398414','CLIENT','2025-04-19 10:49:16',NULL),(8,'Pappu','pappu2342@gmail.com','$2a$10$I5GY7MX78TZdvUR.6ytWQudW48twL24mSw5ixYLsfT9IuGVQXo/li','1234567890','MERCHANT','2025-05-23 10:37:49','pappu2342'),(13,'hii','hii2342@gmail.com','$2a$12$.m5S2BYvVNzg2gjFNbYjS.XVdjonUG1/QnF72GBb9f6ZnqONW.Xru','8103398414','MERCHANT',NULL,'hii2342'),(14,'abhay','abhay123@gmail.com','$2a$12$NKoQoaELqdIoOqQ.rV5WDe/7MYNmGo3fYIhMqrnSytZOvHEU730Pa','1234567890','CLIENT',NULL,'abhay123'),(15,'Test123','test123@gmail.com','$2a$10$O4mI7q2FEJZRgpkcm5EDT.phumY9M/eKZV0EZHedNe5/5y1ckT/iu','8103398414','MERCHANT','2025-05-25 06:18:12','test123'),(16,'Merchant123','merchant123@gmail.com','$2a$10$Ap2fmnfNn46QNND/.jf2MuT.7eC63S2/7mR4DtXuDYCIc9wWFgvCu','8103398414','MERCHANT','2025-05-25 08:55:19','merchant123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-25 15:36:10
