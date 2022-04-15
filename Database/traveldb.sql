CREATE DATABASE  IF NOT EXISTS `traveldb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `traveldb`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: traveldb
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `catalog`
--

DROP TABLE IF EXISTS `catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `picture_id` int DEFAULT NULL,
  `news_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_catalog_picture_idx` (`picture_id`),
  KEY `fk_catalog_news_idx` (`news_id`),
  CONSTRAINT `fk_catalog_news` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_catalog_picture` FOREIGN KEY (`picture_id`) REFERENCES `picture` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Mỗi tin tức du lịch có nhiều hình ảnh, mỗi hình ảnh có thể thuộc nhiều tin tức.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog`
--

LOCK TABLES `catalog` WRITE;
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `prefix` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `province_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_district_province_idx` (`province_id`),
  CONSTRAINT `fk_district_province` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=710 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Quận, huyện';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,'Bình Chánh','Huyện',1),(2,'Bình Tân','Quận',1),(3,'Bình Thạnh','Quận',1),(4,'Cần Giờ','Huyện',1),(5,'Củ Chi','Huyện',1),(6,'Gò Vấp','Quận',1),(7,'Hóc Môn','Huyện',1),(8,'Nhà Bè','Huyện',1),(9,'Phú Nhuận','Quận',1),(10,'Quận 1','',1),(11,'Quận 10','',1),(12,'Quận 11','',1),(13,'Quận 12','',1),(14,'Quận 2','',1),(15,'Quận 3','',1),(16,'Quận 4','',1),(17,'Quận 5','',1),(18,'Quận 6','',1),(19,'Quận 7','',1),(20,'Quận 8','',1),(21,'Quận 9','',1),(22,'Tân Bình','Quận',1),(23,'Tân Phú','Quận',1),(24,'Thủ Đức','Quận',1),(25,'Ba Đình','Quận',2),(26,'Ba Vì','Huyện',2),(27,'Bắc Từ Liêm','Quận',2),(28,'Cầu Giấy','Quận',2),(29,'Chương Mỹ','Huyện',2),(30,'Đan Phượng','Huyện',2),(31,'Đông Anh','Huyện',2),(32,'Đống Đa','Quận',2),(33,'Gia Lâm','Huyện',2),(34,'Hà Đông','Quận',2),(35,'Hai Bà Trưng','Quận',2),(36,'Hoài Đức','Huyện',2),(37,'Hoàn Kiếm','Quận',2),(38,'Hoàng Mai','Quận',2),(39,'Long Biên','Quận',2),(40,'Mê Linh','Huyện',2),(41,'Mỹ Đức','Huyện',2),(42,'Nam Từ Liêm','Quận',2),(43,'Phú Xuyên','Huyện',2),(44,'Phúc Thọ','Huyện',2),(45,'Quốc Oai','Huyện',2),(46,'Sóc Sơn','Huyện',2),(47,'Sơn Tây','Thị xã',2),(48,'Tây Hồ','Quận',2),(49,'Thạch Thất','Huyện',2),(50,'Thanh Oai','Huyện',2),(51,'Thanh Trì','Huyện',2),(52,'Thanh Xuân','Quận',2),(53,'Thường Tín','Huyện',2),(54,'Ứng Hòa','Huyện',2),(55,'Cẩm Lệ','Quận',3),(56,'Hải Châu','Quận',3),(57,'Hòa Vang','Huyện',3),(58,'Hoàng Sa','Huyện',3),(59,'Liên Chiểu','Quận',3),(60,'Ngũ Hành Sơn','Quận',3),(61,'Sơn Trà','Quận',3),(62,'Thanh Khê','Quận',3),(63,'Bàu Bàng','Huyện',4),(64,'Bến Cát','Thị xã',4),(65,'Dầu Tiếng','Huyện',4),(66,'Dĩ An','Thị xã',4),(67,'Phú Giáo','Huyện',4),(68,'Tân Uyên','Huyện',4),(69,'Thủ Dầu Một','Thị xã',4),(70,'Thuận An','Huyện',4),(71,'Biên Hòa','Thành phố',5),(72,'Cẩm Mỹ','Huyện',5),(73,'Định Quán','Huyện',5),(74,'Long Khánh','Thị xã',5),(75,'Long Thành','Huyện',5),(76,'Nhơn Trạch','Huyện',5),(77,'Tân Phú','Quận',5),(78,'Thống Nhất','Huyện',5),(79,'Trảng Bom','Huyện',5),(80,'Vĩnh Cửu','Huyện',5),(81,'Xuân Lộc','Huyện',5),(82,'Cam Lâm','Huyện',6),(83,'Cam Ranh','Thành phố',6),(84,'Diên Khánh','Huyện',6),(85,'Khánh Sơn','Huyện',6),(86,'Khánh Vĩnh','Huyện',6),(87,'Nha Trang','Thành phố',6),(88,'Ninh Hòa','Thị xã',6),(89,'Trường Sa','Huyện',6),(90,'Vạn Ninh','Huyện',6),(91,'An Dương','Huyện',7),(92,'An Lão','Huyện',7),(93,'Bạch Long Vĩ','Huyện',7),(94,'Cát Hải','Huyện',7),(95,'Đồ Sơn','Quận',7),(96,'Dương Kinh','Quận',7),(97,'Hải An','Quận',7),(98,'Hồng Bàng','Quận',7),(99,'Kiến An','Quận',7),(100,'Kiến Thụy','Huyện',7),(101,'Lê Chân','Quận',7),(102,'Ngô Quyền','Quận',7),(103,'Thủy Nguyên','Huyện',7),(104,'Tiên Lãng','Huyện',7),(105,'Vĩnh Bảo','Huyện',7),(106,'Bến Lức','Huyện',8),(107,'Cần Đước','Huyện',8),(108,'Cần Giuộc','Huyện',8),(109,'Châu Thành','Huyện',8),(110,'Đức Hòa','Huyện',8),(111,'Đức Huệ','Huyện',8),(112,'Kiến Tường','Thị xã',8),(113,'Mộc Hóa','Huyện',8),(114,'Tân An','Thành phố',8),(115,'Tân Hưng','Huyện',8),(116,'Tân Thạnh','Huyện',8),(117,'Tân Trụ','Huyện',8),(118,'Thạnh Hóa','Huyện',8),(119,'Thủ Thừa','Huyện',8),(120,'Vĩnh Hưng','Huyện',8),(121,'Bắc Trà My','Huyện',9),(122,'Đại Lộc','Huyện',9),(123,'Điện Bàn','Huyện',9),(124,'Đông Giang','Huyện',9),(125,'Duy Xuyên','Huyện',9),(126,'Hiệp Đức','Huyện',9),(127,'Hội An','Thành phố',9),(128,'Nam Giang','Huyện',9),(129,'Nam Trà My','Huyện',9),(130,'Nông Sơn','Huyện',9),(131,'Núi Thành','Huyện',9),(132,'Phú Ninh','Huyện',9),(133,'Phước Sơn','Huyện',9),(134,'Quế Sơn','Huyện',9),(135,'Tam Kỳ','Thành phố',9),(136,'Tây Giang','Huyện',9),(137,'Thăng Bình','Huyện',9),(138,'Tiên Phước','Huyện',9),(139,'Bà Rịa','Thị xã',10),(140,'Châu Đức','Huyện',10),(141,'Côn Đảo','Huyện',10),(142,'Đất Đỏ','Huyện',10),(143,'Long Điền','Huyện',10),(144,'Tân Thành','Huyện',10),(145,'Vũng Tàu','Thành phố',10),(146,'Xuyên Mộc','Huyện',10),(147,'Buôn Đôn','Huyện',11),(148,'Buôn Hồ','Thị xã',11),(149,'Buôn Ma Thuột','Thành phố',11),(150,'Cư Kuin','Huyện',11),(151,'Cư M\'gar','Huyện',11),(152,'Ea H\'Leo','Huyện',11),(153,'Ea Kar','Huyện',11),(154,'Ea Súp','Huyện',11),(155,'Krông Ana','Huyện',11),(156,'Krông Bông','Huyện',11),(157,'Krông Buk','Huyện',11),(158,'Krông Năng','Huyện',11),(159,'Krông Pắc','Huyện',11),(160,'Lăk','Huyện',11),(161,'M\'Đrăk','Huyện',11),(162,' Thới Lai','Huyện',12),(163,'Bình Thủy','Quận',12),(164,'Cái Răng','Quận',12),(165,'Cờ Đỏ','Huyện',12),(166,'Ninh Kiều','Quận',12),(167,'Ô Môn','Quận',12),(168,'Phong Điền','Huyện',12),(169,'Thốt Nốt','Quận',12),(170,'Vĩnh Thạnh','Huyện',12),(171,'Bắc Bình','Huyện',13),(172,'Đảo Phú Quý','Huyện',13),(173,'Đức Linh','Huyện',13),(174,'Hàm Tân','Huyện',13),(175,'Hàm Thuận Bắc','Huyện',13),(176,'Hàm Thuận Nam','Huyện',13),(177,'La Gi','Thị xã',13),(178,'Phan Thiết','Thành phố',13),(179,'Tánh Linh','Huyện',13),(180,'Tuy Phong','Huyện',13),(181,'Bảo Lâm','Huyện',14),(182,'Bảo Lộc','Thành phố',14),(183,'Cát Tiên','Huyện',14),(184,'Đạ Huoai','Huyện',14),(185,'Đà Lạt','Thành phố',14),(186,'Đạ Tẻh','Huyện',14),(187,'Đam Rông','Huyện',14),(188,'Di Linh','Huyện',14),(189,'Đơn Dương','Huyện',14),(190,'Đức Trọng','Huyện',14),(191,'Lạc Dương','Huyện',14),(192,'Lâm Hà','Huyện',14),(193,'A Lưới','Huyện',15),(194,'Huế','Thành phố',15),(195,'Hương Thủy','Thị xã',15),(196,'Hương Trà','Huyện',15),(197,'Nam Đông','Huyện',15),(198,'Phong Điền','Huyện',15),(199,'Phú Lộc','Huyện',15),(200,'Phú Vang','Huyện',15),(201,'Quảng Điền','Huyện',15),(202,'An Biên','Huyện',16),(203,'An Minh','Huyện',16),(204,'Châu Thành','Huyện',16),(205,'Giang Thành','Huyện',16),(206,'Giồng Riềng','Huyện',16),(207,'Gò Quao','Huyện',16),(208,'Hà Tiên','Thị xã',16),(209,'Hòn Đất','Huyện',16),(210,'Kiên Hải','Huyện',16),(211,'Kiên Lương','Huyện',16),(212,'Phú Quốc','Huyện',16),(213,'Rạch Giá','Thành phố',16),(214,'Tân Hiệp','Huyện',16),(215,'U minh Thượng','Huyện',16),(216,'Vĩnh Thuận','Huyện',16),(217,'Bắc Ninh','Thành phố',17),(218,'Gia Bình','Huyện',17),(219,'Lương Tài','Huyện',17),(220,'Quế Võ','Huyện',17),(221,'Thuận Thành','Huyện',17),(222,'Tiên Du','Huyện',17),(223,'Từ Sơn','Thị xã',17),(224,'Yên Phong','Huyện',17),(225,'Ba Chẽ','Huyện',18),(226,'Bình Liêu','Huyện',18),(227,'Cẩm Phả','Thành phố',18),(228,'Cô Tô','Huyện',18),(229,'Đầm Hà','Huyện',18),(230,'Đông Triều','Huyện',18),(231,'Hạ Long','Thành phố',18),(232,'Hải Hà','Huyện',18),(233,'Hoành Bồ','Huyện',18),(234,'Móng Cái','Thành phố',18),(235,'Quảng Yên','Huyện',18),(236,'Tiên Yên','Huyện',18),(237,'Uông Bí','Thị xã',18),(238,'Vân Đồn','Huyện',18),(239,'Bá Thước','Huyện',19),(240,'Bỉm Sơn','Thị xã',19),(241,'Cẩm Thủy','Huyện',19),(242,'Đông Sơn','Huyện',19),(243,'Hà Trung','Huyện',19),(244,'Hậu Lộc','Huyện',19),(245,'Hoằng Hóa','Huyện',19),(246,'Lang Chánh','Huyện',19),(247,'Mường Lát','Huyện',19),(248,'Nga Sơn','Huyện',19),(249,'Ngọc Lặc','Huyện',19),(250,'Như Thanh','Huyện',19),(251,'Như Xuân','Huyện',19),(252,'Nông Cống','Huyện',19),(253,'Quan Hóa','Huyện',19),(254,'Quan Sơn','Huyện',19),(255,'Quảng Xương','Huyện',19),(256,'Sầm Sơn','Thị xã',19),(257,'Thạch Thành','Huyện',19),(258,'Thanh Hóa','Thành phố',19),(259,'Thiệu Hóa','Huyện',19),(260,'Thọ Xuân','Huyện',19),(261,'Thường Xuân','Huyện',19),(262,'Tĩnh Gia','Huyện',19),(263,'Triệu Sơn','Huyện',19),(264,'Vĩnh Lộc','Huyện',19),(265,'Yên Định','Huyện',19),(266,'Anh Sơn','Huyện',20),(267,'Con Cuông','Huyện',20),(268,'Cửa Lò','Thị xã',20),(269,'Diễn Châu','Huyện',20),(270,'Đô Lương','Huyện',20),(271,'Hoàng Mai','Thị xã',20),(272,'Hưng Nguyên','Huyện',20),(273,'Kỳ Sơn','Huyện',20),(274,'Nam Đàn','Huyện',20),(275,'Nghi Lộc','Huyện',20),(276,'Nghĩa Đàn','Huyện',20),(277,'Quế Phong','Huyện',20),(278,'Quỳ Châu','Huyện',20),(279,'Quỳ Hợp','Huyện',20),(280,'Quỳnh Lưu','Huyện',20),(281,'Tân Kỳ','Huyện',20),(282,'Thái Hòa','Thị xã',20),(283,'Thanh Chương','Huyện',20),(284,'Tương Dương','Huyện',20),(285,'Vinh','Thành phố',20),(286,'Yên Thành','Huyện',20),(287,'Bình Giang','Huyện',21),(288,'Cẩm Giàng','Huyện',21),(289,'Chí Linh','Thị xã',21),(290,'Gia Lộc','Huyện',21),(291,'Hải Dương','Thành phố',21),(292,'Kim Thành','Huyện',21),(293,'Kinh Môn','Huyện',21),(294,'Nam Sách','Huyện',21),(295,'Ninh Giang','Huyện',21),(296,'Thanh Hà','Huyện',21),(297,'Thanh Miện','Huyện',21),(298,'Tứ Kỳ','Huyện',21),(299,'An Khê','Thị xã',22),(300,'AYun Pa','Thị xã',22),(301,'Chư Păh','Huyện',22),(302,'Chư Pưh','Huyện',22),(303,'Chư Sê','Huyện',22),(304,'ChưPRông','Huyện',22),(305,'Đăk Đoa','Huyện',22),(306,'Đăk Pơ','Huyện',22),(307,'Đức Cơ','Huyện',22),(308,'Ia Grai','Huyện',22),(309,'Ia Pa','Huyện',22),(310,'KBang','Huyện',22),(311,'Kông Chro','Huyện',22),(312,'Krông Pa','Huyện',22),(313,'Mang Yang','Huyện',22),(314,'Phú Thiện','Huyện',22),(315,'Plei Ku','Thành phố',22),(316,'Bình Long','Thị xã',23),(317,'Bù Đăng','Huyện',23),(318,'Bù Đốp','Huyện',23),(319,'Bù Gia Mập','Huyện',23),(320,'Chơn Thành','Huyện',23),(321,'Đồng Phú','Huyện',23),(322,'Đồng Xoài','Thị xã',23),(323,'Hớn Quản','Huyện',23),(324,'Lộc Ninh','Huyện',23),(325,'Phú Riềng','Huyện',23),(326,'Phước Long','Thị xã',23),(327,'Ân Thi','Huyện',24),(328,'Hưng Yên','Thành phố',24),(329,'Khoái Châu','Huyện',24),(330,'Kim Động','Huyện',24),(331,'Mỹ Hào','Huyện',24),(332,'Phù Cừ','Huyện',24),(333,'Tiên Lữ','Huyện',24),(334,'Văn Giang','Huyện',24),(335,'Văn Lâm','Huyện',24),(336,'Yên Mỹ','Huyện',24),(337,'An Lão','Huyện',25),(338,'An Nhơn','Huyện',25),(339,'Hoài Ân','Huyện',25),(340,'Hoài Nhơn','Huyện',25),(341,'Phù Cát','Huyện',25),(342,'Phù Mỹ','Huyện',25),(343,'Quy Nhơn','Thành phố',25),(344,'Tây Sơn','Huyện',25),(345,'Tuy Phước','Huyện',25),(346,'Vân Canh','Huyện',25),(347,'Vĩnh Thạnh','Huyện',25),(348,'Cái Bè','Huyện',26),(349,'Cai Lậy','Thị xã',26),(350,'Châu Thành','Huyện',26),(351,'Chợ Gạo','Huyện',26),(352,'Gò Công','Thị xã',26),(353,'Gò Công Đông','Huyện',26),(354,'Gò Công Tây','Huyện',26),(355,'Huyện Cai Lậy','Huyện',26),(356,'Mỹ Tho','Thành phố',26),(357,'Tân Phú Đông','Huyện',26),(358,'Tân Phước','Huyện',26),(359,'Đông Hưng','Huyện',27),(360,'Hưng Hà','Huyện',27),(361,'Kiến Xương','Huyện',27),(362,'Quỳnh Phụ','Huyện',27),(363,'Thái Bình','Thành phố',27),(364,'Thái Thuỵ','Huyện',27),(365,'Tiền Hải','Huyện',27),(366,'Vũ Thư','Huyện',27),(367,'Bắc Giang','Thành phố',28),(368,'Hiệp Hòa','Huyện',28),(369,'Lạng Giang','Huyện',28),(370,'Lục Nam','Huyện',28),(371,'Lục Ngạn','Huyện',28),(372,'Sơn Động','Huyện',28),(373,'Tân Yên','Huyện',28),(374,'Việt Yên','Huyện',28),(375,'Yên Dũng','Huyện',28),(376,'Yên Thế','Huyện',28),(377,'Cao Phong','Huyện',29),(378,'Đà Bắc','Huyện',29),(379,'Hòa Bình','Thành phố',29),(380,'Kim Bôi','Huyện',29),(381,'Kỳ Sơn','Huyện',29),(382,'Lạc Sơn','Huyện',29),(383,'Lạc Thủy','Huyện',29),(384,'Lương Sơn','Huyện',29),(385,'Mai Châu','Huyện',29),(386,'Tân Lạc','Huyện',29),(387,'Yên Thủy','Huyện',29),(388,'An Phú','Huyện',30),(389,'Châu Đốc','Thị xã',30),(390,'Châu Phú','Huyện',30),(391,'Châu Thành','Huyện',30),(392,'Chợ Mới','Huyện',30),(393,'Long Xuyên','Thành phố',30),(394,'Phú Tân','Huyện',30),(395,'Tân Châu','Thị xã',30),(396,'Thoại Sơn','Huyện',30),(397,'Tịnh Biên','Huyện',30),(398,'Tri Tôn','Huyện',30),(399,'Bình Xuyên','Huyện',31),(400,'Lập Thạch','Huyện',31),(401,'Phúc Yên','Thị xã',31),(402,'Sông Lô','Huyện',31),(403,'Tam Đảo','Huyện',31),(404,'Tam Dương','Huyện',31),(405,'Vĩnh Tường','Huyện',31),(406,'Vĩnh Yên','Thành phố',31),(407,'Yên Lạc','Huyện',31),(408,'Bến Cầu','Huyện',32),(409,'Châu Thành','Huyện',32),(410,'Dương Minh Châu','Huyện',32),(411,'Gò Dầu','Huyện',32),(412,'Hòa Thành','Huyện',32),(413,'Tân Biên','Huyện',32),(414,'Tân Châu','Huyện',32),(415,'Tây Ninh','Thị xã',32),(416,'Trảng Bàng','Huyện',32),(417,'Đại Từ','Huyện',33),(418,'Định Hóa','Huyện',33),(419,'Đồng Hỷ','Huyện',33),(420,'Phổ Yên','Huyện',33),(421,'Phú Bình','Huyện',33),(422,'Phú Lương','Huyện',33),(423,'Sông Công','Thị xã',33),(424,'Thái Nguyên','Thành phố',33),(425,'Võ Nhai','Huyện',33),(426,'Bắc Hà','Huyện',34),(427,'Bảo Thắng','Huyện',34),(428,'Bảo Yên','Huyện',34),(429,'Bát Xát','Huyện',34),(430,'Lào Cai','Thành phố',34),(431,'Mường Khương','Huyện',34),(432,'Sa Pa','Huyện',34),(433,'Văn Bàn','Huyện',34),(434,'Xi Ma Cai','Huyện',34),(435,'Giao Thủy','Huyện',35),(436,'Hải Hậu','Huyện',35),(437,'Mỹ Lộc','Huyện',35),(438,'Nam Định','Thành phố',35),(439,'Nam Trực','Huyện',35),(440,'Nghĩa Hưng','Huyện',35),(441,'Trực Ninh','Huyện',35),(442,'Vụ Bản','Huyện',35),(443,'Xuân Trường','Huyện',35),(444,'Ý Yên','Huyện',35),(445,'Ba Tơ','Huyện',36),(446,'Bình Sơn','Huyện',36),(447,'Đức Phổ','Huyện',36),(448,'Lý Sơn','Huyện',36),(449,'Minh Long','Huyện',36),(450,'Mộ Đức','Huyện',36),(451,'Nghĩa Hành','Huyện',36),(452,'Quảng Ngãi','Thành phố',36),(453,'Sơn Hà','Huyện',36),(454,'Sơn Tây','Huyện',36),(455,'Sơn Tịnh','Huyện',36),(456,'Tây Trà','Huyện',36),(457,'Trà Bồng','Huyện',36),(458,'Tư Nghĩa','Huyện',36),(459,'Ba Tri','Huyện',37),(460,'Bến Tre','Thành phố',37),(461,'Bình Đại','Huyện',37),(462,'Châu Thành','Huyện',37),(463,'Chợ Lách','Huyện',37),(464,'Giồng Trôm','Huyện',37),(465,'Mỏ Cày Bắc','Huyện',37),(466,'Mỏ Cày Nam','Huyện',37),(467,'Thạnh Phú','Huyện',37),(468,'Cư Jút','Huyện',38),(469,'Dăk GLong','Huyện',38),(470,'Dăk Mil','Huyện',38),(471,'Dăk R\'Lấp','Huyện',38),(472,'Dăk Song','Huyện',38),(473,'Gia Nghĩa','Thị xã',38),(474,'Krông Nô','Huyện',38),(475,'Tuy Đức','Huyện',38),(476,'Cà Mau','Thành phố',39),(477,'Cái Nước','Huyện',39),(478,'Đầm Dơi','Huyện',39),(479,'Năm Căn','Huyện',39),(480,'Ngọc Hiển','Huyện',39),(481,'Phú Tân','Huyện',39),(482,'Thới Bình','Huyện',39),(483,'Trần Văn Thời','Huyện',39),(484,'U Minh','Huyện',39),(485,'Bình Minh','Huyện',40),(486,'Bình Tân','Quận',40),(487,'Long Hồ','Huyện',40),(488,'Mang Thít','Huyện',40),(489,'Tam Bình','Huyện',40),(490,'Trà Ôn','Huyện',40),(491,'Vĩnh Long','Thành phố',40),(492,'Vũng Liêm','Huyện',40),(493,'Gia Viễn','Huyện',41),(494,'Hoa Lư','Huyện',41),(495,'Kim Sơn','Huyện',41),(496,'Nho Quan','Huyện',41),(497,'Ninh Bình','Thành phố',41),(498,'Tam Điệp','Thị xã',41),(499,'Yên Khánh','Huyện',41),(500,'Yên Mô','Huyện',41),(501,'Cẩm Khê','Huyện',42),(502,'Đoan Hùng','Huyện',42),(503,'Hạ Hòa','Huyện',42),(504,'Lâm Thao','Huyện',42),(505,'Phù Ninh','Huyện',42),(506,'Phú Thọ','Thị xã',42),(507,'Tam Nông','Huyện',42),(508,'Tân Sơn','Huyện',42),(509,'Thanh Ba','Huyện',42),(510,'Thanh Sơn','Huyện',42),(511,'Thanh Thủy','Huyện',42),(512,'Việt Trì','Thành phố',42),(513,'Yên Lập','Huyện',42),(514,'Bác Ái','Huyện',43),(515,'Ninh Hải','Huyện',43),(516,'Ninh Phước','Huyện',43),(517,'Ninh Sơn','Huyện',43),(518,'Phan Rang - Tháp Chàm','Thành phố',43),(519,'Thuận Bắc','Huyện',43),(520,'Thuận Nam','Huyện',43),(521,'Đông Hòa','Huyện',44),(522,'Đồng Xuân','Huyện',44),(523,'Phú Hòa','Huyện',44),(524,'Sơn Hòa','Huyện',44),(525,'Sông Cầu','Thị xã',44),(526,'Sông Hinh','Huyện',44),(527,'Tây Hòa','Huyện',44),(528,'Tuy An','Huyện',44),(529,'Tuy Hòa','Thành phố',44),(530,'Bình Lục','Huyện',45),(531,'Duy Tiên','Huyện',45),(532,'Kim Bảng','Huyện',45),(533,'Lý Nhân','Huyện',45),(534,'Phủ Lý','Thành phố',45),(535,'Thanh Liêm','Huyện',45),(536,'Cẩm Xuyên','Huyện',46),(537,'Can Lộc','Huyện',46),(538,'Đức Thọ','Huyện',46),(539,'Hà Tĩnh','Thành phố',46),(540,'Hồng Lĩnh','Thị xã',46),(541,'Hương Khê','Huyện',46),(542,'Hương Sơn','Huyện',46),(543,'Kỳ Anh','Huyện',46),(544,'Lộc Hà','Huyện',46),(545,'Nghi Xuân','Huyện',46),(546,'Thạch Hà','Huyện',46),(547,'Vũ Quang','Huyện',46),(548,'Cao Lãnh','Thành phố',47),(549,'Châu Thành','Huyện',47),(550,'Hồng Ngự','Thị xã',47),(551,'Huyện Cao Lãnh','Huyện',47),(552,'Huyện Hồng Ngự','Huyện',47),(553,'Lai Vung','Huyện',47),(554,'Lấp Vò','Huyện',47),(555,'Sa Đéc','Thị xã',47),(556,'Tam Nông','Huyện',47),(557,'Tân Hồng','Huyện',47),(558,'Thanh Bình','Huyện',47),(559,'Tháp Mười','Huyện',47),(560,'Châu Thành','Huyện',48),(561,'Cù Lao Dung','Huyện',48),(562,'Kế Sách','Huyện',48),(563,'Long Phú','Huyện',48),(564,'Mỹ Tú','Huyện',48),(565,'Mỹ Xuyên','Huyện',48),(566,'Ngã Năm','Huyện',48),(567,'Sóc Trăng','Thành phố',48),(568,'Thạnh Trị','Huyện',48),(569,'Trần Đề','Huyện',48),(570,'Vĩnh Châu','Huyện',48),(571,'Đăk Glei','Huyện',49),(572,'Đăk Hà','Huyện',49),(573,'Đăk Tô','Huyện',49),(574,'Ia H\'Drai','Huyện',49),(575,'Kon Plông','Huyện',49),(576,'Kon Rẫy','Huyện',49),(577,'KonTum','Thành phố',49),(578,'Ngọc Hồi','Huyện',49),(579,'Sa Thầy','Huyện',49),(580,'Tu Mơ Rông','Huyện',49),(581,'Ba Đồn','Thị xã',50),(582,'Bố Trạch','Huyện',50),(583,'Đồng Hới','Thành phố',50),(584,'Lệ Thủy','Huyện',50),(585,'Minh Hóa','Huyện',50),(586,'Quảng Ninh','Huyện',50),(587,'Quảng Trạch','Huyện',50),(588,'Tuyên Hóa','Huyện',50),(589,'Cam Lộ','Huyện',51),(590,'Đa Krông','Huyện',51),(591,'Đảo Cồn cỏ','Huyện',51),(592,'Đông Hà','Thành phố',51),(593,'Gio Linh','Huyện',51),(594,'Hải Lăng','Huyện',51),(595,'Hướng Hóa','Huyện',51),(596,'Quảng Trị','Thị xã',51),(597,'Triệu Phong','Huyện',51),(598,'Vĩnh Linh','Huyện',51),(599,'Càng Long','Huyện',52),(600,'Cầu Kè','Huyện',52),(601,'Cầu Ngang','Huyện',52),(602,'Châu Thành','Huyện',52),(603,'Duyên Hải','Huyện',52),(604,'Tiểu Cần','Huyện',52),(605,'Trà Cú','Huyện',52),(606,'Trà Vinh','Thành phố',52),(607,'Châu Thành','Huyện',53),(608,'Châu Thành A','Huyện',53),(609,'Long Mỹ','Huyện',53),(610,'Ngã Bảy','Thị xã',53),(611,'Phụng Hiệp','Huyện',53),(612,'Vị Thanh','Thành phố',53),(613,'Vị Thủy','Huyện',53),(614,'Bắc Yên','Huyện',54),(615,'Mai Sơn','Huyện',54),(616,'Mộc Châu','Huyện',54),(617,'Mường La','Huyện',54),(618,'Phù Yên','Huyện',54),(619,'Quỳnh Nhai','Huyện',54),(620,'Sơn La','Thành phố',54),(621,'Sông Mã','Huyện',54),(622,'Sốp Cộp','Huyện',54),(623,'Thuận Châu','Huyện',54),(624,'Vân Hồ','Huyện',54),(625,'Yên Châu','Huyện',54),(626,'Bạc Liêu','Thành phố',55),(627,'Đông Hải','Huyện',55),(628,'Giá Rai','Huyện',55),(629,'Hòa Bình','Huyện',55),(630,'Hồng Dân','Huyện',55),(631,'Phước Long','Huyện',55),(632,'Vĩnh Lợi','Huyện',55),(633,'Lục Yên','Huyện',56),(634,'Mù Cang Chải','Huyện',56),(635,'Nghĩa Lộ','Thị xã',56),(636,'Trạm Tấu','Huyện',56),(637,'Trấn Yên','Huyện',56),(638,'Văn Chấn','Huyện',56),(639,'Văn Yên','Huyện',56),(640,'Yên Bái','Thành phố',56),(641,'Yên Bình','Huyện',56),(642,'Chiêm Hóa','Huyện',57),(643,'Hàm Yên','Huyện',57),(644,'Lâm Bình','Huyện',57),(645,'Na Hang','Huyện',57),(646,'Sơn Dương','Huyện',57),(647,'Tuyên Quang','Thành phố',57),(648,'Yên Sơn','Huyện',57),(649,'Điện Biên','Huyện',58),(650,'Điện Biên Đông','Huyện',58),(651,'Điện Biên Phủ','Thành phố',58),(652,'Mường Ảng','Huyện',58),(653,'Mường Chà','Huyện',58),(654,'Mường Lay','Thị xã',58),(655,'Mường Nhé','Huyện',58),(656,'Nậm Pồ','Huyện',58),(657,'Tủa Chùa','Huyện',58),(658,'Tuần Giáo','Huyện',58),(659,'Lai Châu','Thị xã',59),(660,'Mường Tè','Huyện',59),(661,'Nậm Nhùn','Huyện',59),(662,'Phong Thổ','Huyện',59),(663,'Sìn Hồ','Huyện',59),(664,'Tam Đường','Huyện',59),(665,'Tân Uyên','Huyện',59),(666,'Than Uyên','Huyện',59),(667,'Bắc Sơn','Huyện',60),(668,'Bình Gia','Huyện',60),(669,'Cao Lộc','Huyện',60),(670,'Chi Lăng','Huyện',60),(671,'Đình Lập','Huyện',60),(672,'Hữu Lũng','Huyện',60),(673,'Lạng Sơn','Thành phố',60),(674,'Lộc Bình','Huyện',60),(675,'Tràng Định','Huyện',60),(676,'Văn Lãng','Huyện',60),(677,'Văn Quan','Huyện',60),(678,'Bắc Mê','Huyện',61),(679,'Bắc Quang','Huyện',61),(680,'Đồng Văn','Huyện',61),(681,'Hà Giang','Thành phố',61),(682,'Hoàng Su Phì','Huyện',61),(683,'Mèo Vạc','Huyện',61),(684,'Quản Bạ','Huyện',61),(685,'Quang Bình','Huyện',61),(686,'Vị Xuyên','Huyện',61),(687,'Xín Mần','Huyện',61),(688,'Yên Minh','Huyện',61),(689,'Ba Bể','Huyện',62),(690,'Bắc Kạn','Thị xã',62),(691,'Bạch Thông','Huyện',62),(692,'Chợ Đồn','Huyện',62),(693,'Chợ Mới','Huyện',62),(694,'Na Rì','Huyện',62),(695,'Ngân Sơn','Huyện',62),(696,'Pác Nặm','Huyện',62),(697,'Bảo Lạc','Huyện',63),(698,'Bảo Lâm','Huyện',63),(699,'Cao Bằng','Thị xã',63),(700,'Hạ Lang','Huyện',63),(701,'Hà Quảng','Huyện',63),(702,'Hòa An','Huyện',63),(703,'Nguyên Bình','Huyện',63),(704,'Phục Hòa','Huyện',63),(705,'Quảng Uyên','Huyện',63),(706,'Thạch An','Huyện',63),(707,'Thông Nông','Huyện',63),(708,'Trà Lĩnh','Huyện',63),(709,'Trùng Khánh','Huyện',63);
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duration`
--

DROP TABLE IF EXISTS `duration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `duration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity_days` int NOT NULL,
  `quantity_nights` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Thời gian đi: số ngày ở, số đêm ở';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duration`
--

LOCK TABLES `duration` WRITE;
/*!40000 ALTER TABLE `duration` DISABLE KEYS */;
/*!40000 ALTER TABLE `duration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tour_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `rating` decimal(1,0) NOT NULL,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_feedback_user_idx` (`user_id`),
  KEY `fk_feedback_tour_idx` (`tour_id`),
  CONSTRAINT `fk_feedback_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_feedback_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Người dùng có thể đánh giá tour và bình luận.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` int NOT NULL,
  `location_id` int DEFAULT NULL,
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_hotel_location_idx` (`location_id`),
  CONSTRAINT `fk_hotel_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Khách sạn: tên khách sạn, địa chỉ, số điện thoại';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `province_id` int DEFAULT NULL,
  `district_id` int DEFAULT NULL,
  `ward_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_location_province_idx` (`province_id`),
  KEY `fk_location_district_idx` (`district_id`),
  KEY `fk_location_ward_idx` (`ward_id`),
  CONSTRAINT `fk_location_district` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_location_province` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_location_ward` FOREIGN KEY (`ward_id`) REFERENCES `ward` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Vị trí: tỉnh, huyện, xã';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `means`
--

DROP TABLE IF EXISTS `means`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `means` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` enum('CARS','SHIPS','CANEOING','YACHT','AIRLINES') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'CARS',
  `status` enum('USING','REPAIRING','AVAILABLE') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'AVAILABLE',
  `capacity` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Phương tiện: tên phương tiện, loại phương tiện (ô tô, tàu, xuồng, du thuyền, máy bay) , trạng thái (đang sử dụng, đang sửa chữa, sẵn dùng), sức chứa';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `means`
--

LOCK TABLES `means` WRITE;
/*!40000 ALTER TABLE `means` DISABLE KEYS */;
/*!40000 ALTER TABLE `means` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `quantity_likes` int NOT NULL DEFAULT '0',
  `quantity_views` int NOT NULL DEFAULT '0',
  `posted_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `title_UNIQUE` (`title`),
  KEY `fk_news_user_idx` (`user_id`),
  CONSTRAINT `fk_news_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Tin tức du lịch: tiêu đề, nội dung, số lượt like, số lượt xem, ngày đăng, ngày chỉnh sửa, người đăng';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `path` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `caption` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `path_UNIQUE` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Hình ảnh: đường dẫn hình ảnh, tên hình ảnh';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `location_id` int DEFAULT NULL,
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_place_location_idx` (`location_id`),
  CONSTRAINT `fk_place_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Địa điểm tham quan: tên địa điểm, địa chỉ, mô tả về địa điểm';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `province` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Tỉnh, thành phố trực thuộc trung ương';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (30,'An Giang'),(10,'Bà Rịa Vũng Tàu'),(28,'Bắc Giang'),(62,'Bắc Kạn'),(55,'Bạc Liêu'),(17,'Bắc Ninh'),(37,'Bến Tre'),(4,'Bình Dương'),(25,'Bình Định'),(23,'Bình Phước'),(13,'Bình Thuận  '),(39,'Cà Mau'),(12,'Cần Thơ'),(63,'Cao Bằng'),(3,'Đà Nẵng'),(11,'Đắk Lắk'),(38,'Đắk Nông'),(58,'Điện Biên'),(5,'Đồng Nai'),(47,'Đồng Tháp'),(22,'Gia Lai'),(61,'Hà Giang'),(45,'Hà Nam'),(2,'Hà Nội'),(46,'Hà Tĩnh'),(21,'Hải Dương'),(7,'Hải Phòng'),(53,'Hậu Giang'),(1,'Hồ Chí Minh'),(29,'Hòa Bình'),(24,'Hưng Yên'),(6,'Khánh Hòa'),(16,'Kiên Giang'),(49,'Kon Tum'),(59,'Lai Châu'),(14,'Lâm Đồng'),(60,'Lạng Sơn'),(34,'Lào Cai'),(8,'Long An'),(35,'Nam Định'),(20,'Nghệ An'),(41,'Ninh Bình'),(43,'Ninh Thuận'),(42,'Phú Thọ'),(44,'Phú Yên'),(50,'Quảng Bình'),(9,'Quảng Nam'),(36,'Quảng Ngãi'),(18,'Quảng Ninh'),(51,'Quảng Trị'),(48,'Sóc Trăng'),(54,'Sơn La'),(32,'Tây Ninh'),(27,'Thái Bình'),(33,'Thái Nguyên'),(19,'Thanh Hóa'),(15,'Thừa Thiên Huế'),(26,'Tiền Giang'),(52,'Trà Vinh'),(57,'Tuyên Quang'),(40,'Vĩnh Long'),(31,'Vĩnh Phúc'),(56,'Yên Bái');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reaction`
--

DROP TABLE IF EXISTS `reaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reaction` (
  `id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int DEFAULT NULL,
  `news_id` int DEFAULT NULL,
  `is_like` bit(1) NOT NULL DEFAULT b'0',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_reaction_user_idx` (`user_id`),
  KEY `fk_reaction_news_idx` (`news_id`),
  CONSTRAINT `fk_reaction_news` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_reaction_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Người dùng có thể like và bình luận trên tin tức.\nTương tác với tin tức: like (true/false), bình luận, ngày tạo, ngày cập nhật';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reaction`
--

LOCK TABLES `reaction` WRITE;
/*!40000 ALTER TABLE `reaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `reaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surcharge`
--

DROP TABLE IF EXISTS `surcharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surcharge` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `percentage` float NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Phụ thu: tên phụ thu, tỷ lệ phụ thu (%)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surcharge`
--

LOCK TABLES `surcharge` WRITE;
/*!40000 ALTER TABLE `surcharge` DISABLE KEYS */;
/*!40000 ALTER TABLE `surcharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour`
--

DROP TABLE IF EXISTS `tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(12,0) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `trip_id` int DEFAULT NULL,
  `duration_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tour_trip_idx` (`trip_id`),
  KEY `fk_tour_schedule_idx` (`duration_id`),
  KEY `fk_tour_category_idx` (`category_id`),
  CONSTRAINT `fk_tour_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tour_duration` FOREIGN KEY (`duration_id`) REFERENCES `duration` (`id`),
  CONSTRAINT `fk_tour_trip` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Tour du lịch: tên tour, giá tour, mô tả tour, chuyến đi, thời gian đi';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour`
--

LOCK TABLES `tour` WRITE;
/*!40000 ALTER TABLE `tour` DISABLE KEYS */;
INSERT INTO `tour` VALUES (1,'Tour Đà Nẵng 1N: Suối Khoáng Thần Tài',490,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_booking`
--

DROP TABLE IF EXISTS `tour_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour_booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `tour_id` int DEFAULT NULL,
  `booking_date` datetime NOT NULL,
  `departure_date` datetime NOT NULL,
  `departure_location_id` int DEFAULT NULL,
  `departure_address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `quantity_adults` int NOT NULL DEFAULT '1',
  `quantity_children` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tour_booking_location_idx` (`departure_location_id`),
  KEY `fk_tour_booking_tour_idx` (`tour_id`),
  CONSTRAINT `fk_tour_booking_location` FOREIGN KEY (`departure_location_id`) REFERENCES `location` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tour_booking_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Thông tin đặt tour: khách hàng, tour du lịch,  ngày đặt, ngày khởi hành, nơi đón khách, số người lớn, số trẻ em';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_booking`
--

LOCK TABLES `tour_booking` WRITE;
/*!40000 ALTER TABLE `tour_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `tour_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_detail`
--

DROP TABLE IF EXISTS `tour_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tour_id` int NOT NULL,
  `place_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tour_detail_tour_idx` (`tour_id`),
  KEY `fk_tour_detail_place_idx` (`place_id`),
  CONSTRAINT `fk_tour_detail_place` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tour_detail_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Mỗi tour có thể có nhiều địa điểm tham quan.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_detail`
--

LOCK TABLES `tour_detail` WRITE;
/*!40000 ALTER TABLE `tour_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `tour_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_ticket`
--

DROP TABLE IF EXISTS `tour_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour_ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` enum('ADULT','CHILDREN') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'ADULT',
  `price` decimal(12,0) NOT NULL,
  `surcharge_id` int DEFAULT NULL,
  `is_payment` bit(1) NOT NULL DEFAULT b'0',
  `tour_booking_id` int DEFAULT NULL,
  `total` decimal(12,0) NOT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tour_ticket_surcharge_idx` (`surcharge_id`),
  KEY `fk_tour_ticket_tour_booking_idx` (`tour_booking_id`),
  KEY `fk_tour_ticket_user_employee_idx` (`employee_id`),
  CONSTRAINT `fk_tour_ticket_surcharge` FOREIGN KEY (`surcharge_id`) REFERENCES `surcharge` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tour_ticket_tour_booking` FOREIGN KEY (`tour_booking_id`) REFERENCES `tour_booking` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tour_ticket_user_employee` FOREIGN KEY (`employee_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Vé tour:  loại vé (người lớn/trẻ em), giá vé, phụ thu (nếu có), thanh toán (true/false), thông tin đặt tour, nhân viên bán vé.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_ticket`
--

LOCK TABLES `tour_ticket` WRITE;
/*!40000 ALTER TABLE `tour_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `tour_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transport` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tour_id` int DEFAULT NULL,
  `means_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_transport_means_idx` (`means_id`),
  KEY `fk_transport_tour_idx` (`tour_id`),
  CONSTRAINT `fk_transport_means` FOREIGN KEY (`means_id`) REFERENCES `means` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_transport_tour` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Mỗi tour du lịch có nhiều phương tiện di chuyển.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport`
--

LOCK TABLES `transport` WRITE;
/*!40000 ALTER TABLE `transport` DISABLE KEYS */;
/*!40000 ALTER TABLE `transport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `departure_province_id` int DEFAULT NULL,
  `destination_province_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_trip_province_idx` (`departure_province_id`),
  KEY `fk_trip_province_idx1` (`destination_province_id`),
  CONSTRAINT `fk_trip_province_departure` FOREIGN KEY (`departure_province_id`) REFERENCES `province` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_trip_province_destination` FOREIGN KEY (`destination_province_id`) REFERENCES `province` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Chuyến đi: nơi khởi hành, nơi đến.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` bit(1) DEFAULT b'1',
  `user_role` enum('ADMIN','EMPLOYEE','CUSTOMER') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'CUSTOMER',
  `user_info_id` int DEFAULT NULL,
  `first_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `user_info_id_UNIQUE` (`user_info_id`),
  CONSTRAINT `fk_user_userinfo_id` FOREIGN KEY (`user_info_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Người dùng: tên đăng nhập, mật khẩu, email, hình đại diện, ngày tạo, ngày cập nhật, trạng thái hoạt động (true/false), phân quyền người dùng (quản trị viên, nhân viên, khách hàng)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$h4vQPQWOXAh0RE3dLpru2uDLrw/PqEa9Ns5Y3FwCwrSqu7.Ubbr96','admin@gmail.com',NULL,'2022-04-06 21:06:14','2022-04-06 21:06:14',NULL,'CUSTOMER',NULL,'Hieu','La');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gender` enum('MALE','FEMALE','OTHER') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'MALE',
  `day_of_birth` datetime DEFAULT NULL,
  `citizenship` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `location_id` int DEFAULT NULL,
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_info_location_idx` (`location_id`),
  CONSTRAINT `fk_info_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ward`
--

DROP TABLE IF EXISTS `ward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ward` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `prefix` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `province_id` int DEFAULT NULL,
  `district_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_ward_district_idx` (`district_id`),
  KEY `fk_ward_province_idx` (`province_id`),
  CONSTRAINT `fk_ward_district` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_ward_province` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Xã, phường';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ward`
--

LOCK TABLES `ward` WRITE;
/*!40000 ALTER TABLE `ward` DISABLE KEYS */;
/*!40000 ALTER TABLE `ward` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-15 16:18:37
