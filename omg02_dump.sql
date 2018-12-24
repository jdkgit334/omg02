-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: omg02
-- ------------------------------------------------------
-- Server version	5.7.24-log

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
-- Table structure for table `shops`
--

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` longtext NOT NULL,
  `category` varchar(255) NOT NULL,
  `close_at1` varchar(255) NOT NULL,
  `close_at2` varchar(255) NOT NULL,
  `content` longtext,
  `created_at` datetime NOT NULL,
  `disclose` int(11) NOT NULL,
  `holiday` varchar(255) NOT NULL,
  `homepage` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `open_at1` varchar(255) NOT NULL,
  `open_at2` varchar(255) NOT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9m6a3cpysuftixf1c0r740nw` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops`
--

LOCK TABLES `shops` WRITE;
/*!40000 ALTER TABLE `shops` DISABLE KEYS */;
INSERT INTO `shops` VALUES (6,'茨城県東茨城郡大洗町磯浜町東8253-10','魚介・海鮮料理','15:00','15:00','定休日の月曜日が祝日と重なる場合、代わりに翌日が休日','2018-12-23 23:02:13',1,'月','','大洗町漁協　かあちゃんの店','10:00','10:00','029-267-5760','2018-12-23 23:02:13',1),(7,'茨城県東茨城郡大洗町磯浜町173-2','日本料理','00:00','00:00','15：00～17：00中休み ※土日は通し営業\r\n中休み及び閉店30分前にLO','2018-12-23 23:13:34',1,'なし','','悠久','00:00','00:00','029-219-9733','2018-12-23 23:34:17',1),(8,'dsfsdfaf','日本料理','00:00','00:00','','2018-12-24 13:15:12',1,'なし','','sdfsda','00:00','00:00','','2018-12-24 13:15:12',2);
/*!40000 ALTER TABLE `shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_flag` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `delete_flag` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h1vneshxbwkd1ailk02vdy2qu` (`code`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,0,'test03','2018-12-23 21:36:45',0,'test03','5BA0F665043982BAB921D3F268D29BCCB186C80137E6307C7C7B9C71E4B9F6E8','2018-12-23 21:36:45'),(2,1,'admin100','2018-12-23 21:39:18',0,'admin100','08425258523BD036DD7F851898640C2A923A714766425C20B8F5627FEF78D579','2018-12-23 21:39:18'),(3,0,'test04','2018-12-23 21:59:58',1,'test044','30107CFF64F3AA1C2827F3D7B8EA3D6950D84504D8BAE334E46C5E0829F8981B','2018-12-23 22:04:26'),(4,0,'test05','2018-12-23 22:40:48',0,'test05','ADCA1409B08858804ED69B4C9A8B3C9C4DCC9E6838EB3169EA5E5819614B0570','2018-12-23 22:40:48'),(5,0,'test06','2018-12-23 22:56:00',0,'test06','4FD42CE01BB20D0E03EEF68E07848739531C832E198900017CFBDAD91CF4F495','2018-12-23 22:56:00'),(6,0,'test17','2018-12-24 12:55:18',0,'test17','452A35FBE521D3E448C9B614616A85583A1E4FA4FA50CCD5CDCD60703F602400','2018-12-24 12:55:18');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-24 13:17:25
