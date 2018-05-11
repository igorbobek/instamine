-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: instamine
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `src` longtext NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user_I_idx` (`id_user`),
  CONSTRAINT `id_user_I` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'https://ci.phncdn.com/is-static/images/categories/(m=q4KQRRSbeXs28zjadqg)(mh=d2kUZlU5j4zxVgSp)17.jpg',1,'1992-02-02 00:00:00'),(2,'https://ci.phncdn.com/is-static/images/categories/(m=q4KQRRSbeXs28zjadqg)(mh=d2kUZlU5j4zxVgSp)17.jpg',1,'1992-02-02 00:00:00'),(3,'https://ci.phncdn.com/is-static/images/categories/(m=q4KQRRSbeXs28zjadqg)(mh=d2kUZlU5j4zxVgSp)17.jpg',1,'1992-02-02 00:00:00'),(4,'https://ci.phncdn.com/is-static/images/categories/(m=q4KQRRSbeXs28zjadqg)(mh=d2kUZlU5j4zxVgSp)17.jpg',1,'1992-02-02 00:00:00'),(5,'https://ci.phncdn.com/is-static/images/categories/(m=q4KQRRSbeXs28zjadqg)(mh=d2kUZlU5j4zxVgSp)17.jpg',1,'1992-02-02 00:00:00'),(6,'https://pp.userapi.com/c845523/v845523984/49efc/XruwG1sCRwQ.jpg',1,'1992-02-02 00:00:00'),(8,'http://loveread.ec/img/photo_books/73268.jpg',1,'2018-05-11 05:54:58'),(9,'https://jobs.tut.by/employer-logo/951744.jpeg',1,'2018-05-11 05:57:04'),(10,'https://vk.com/images/camera_200.png',1,'2018-05-11 06:07:48'),(12,'https://pp.userapi.com/c846216/v846216210/45b77/3TdlMZWyO_w.jpg',10,'2018-05-11 07:13:58');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-11  7:15:12
