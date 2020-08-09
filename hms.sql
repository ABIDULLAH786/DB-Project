-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: hms
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Temporary view structure for view `boys`
--

DROP TABLE IF EXISTS `boys`;
/*!50001 DROP VIEW IF EXISTS `boys`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `boys` AS SELECT 
 1 AS `student_id`,
 1 AS `student_name`,
 1 AS `student_father_name`,
 1 AS `department`,
 1 AS `address`,
 1 AS `cell_no`,
 1 AS `student_DOB`,
 1 AS `hostel_id`,
 1 AS `room_id`,
 1 AS `gender`,
 1 AS `Hostel Location`,
 1 AS `Hostel Cooker`,
 1 AS `Cooker Phone`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `boys_hostel`
--

DROP TABLE IF EXISTS `boys_hostel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boys_hostel` (
  `hostel_id` int NOT NULL,
  `no_of_rooms` int NOT NULL,
  `no_of_student` int NOT NULL,
  `annual_expences` int NOT NULL,
  `location` varchar(35) NOT NULL,
  KEY `hostel_id` (`hostel_id`),
  CONSTRAINT `boys_hostel_ibfk_1` FOREIGN KEY (`hostel_id`) REFERENCES `hostel` (`hostel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boys_hostel`
--

LOCK TABLES `boys_hostel` WRITE;
/*!40000 ALTER TABLE `boys_hostel` DISABLE KEYS */;
INSERT INTO `boys_hostel` VALUES (2,200,100,200000,'Main Campus');
/*!40000 ALTER TABLE `boys_hostel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee`
--

DROP TABLE IF EXISTS `fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fee` (
  `fee_month_year` varchar(40) NOT NULL,
  `student_id` varchar(15) NOT NULL,
  PRIMARY KEY (`fee_month_year`,`student_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `fee_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee`
--

LOCK TABLES `fee` WRITE;
/*!40000 ALTER TABLE `fee` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `girls_hostel`
--

DROP TABLE IF EXISTS `girls_hostel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `girls_hostel` (
  `hostel_id` int NOT NULL,
  `no_of_rooms` int NOT NULL,
  `no_of_student` int NOT NULL,
  `annual_expences` int NOT NULL,
  `location` varchar(35) NOT NULL,
  KEY `hostel_id` (`hostel_id`),
  CONSTRAINT `girls_hostel_ibfk_1` FOREIGN KEY (`hostel_id`) REFERENCES `hostel` (`hostel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `girls_hostel`
--

LOCK TABLES `girls_hostel` WRITE;
/*!40000 ALTER TABLE `girls_hostel` DISABLE KEYS */;
INSERT INTO `girls_hostel` VALUES (1,50,150,1500000,'Main Campus');
/*!40000 ALTER TABLE `girls_hostel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hostel`
--

DROP TABLE IF EXISTS `hostel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hostel` (
  `hostel_id` int NOT NULL,
  `no_of_rooms` int NOT NULL,
  `no_of_student` int NOT NULL,
  `annual_expences` int NOT NULL,
  `location` varchar(35) NOT NULL,
  `hostetl_status` varchar(10) NOT NULL,
  PRIMARY KEY (`hostel_id`),
  CONSTRAINT `hostel_chk_1` CHECK ((`hostel_id` > 0)),
  CONSTRAINT `hostel_chk_2` CHECK ((`hostetl_status` in (_utf8mb4'Girls',_utf8mb4'Boys')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hostel`
--

LOCK TABLES `hostel` WRITE;
/*!40000 ALTER TABLE `hostel` DISABLE KEYS */;
INSERT INTO `hostel` VALUES (1,50,150,1500000,'Main Campus','Girls'),(2,200,100,200000,'Main Campus','Boys');
/*!40000 ALTER TABLE `hostel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mess`
--

DROP TABLE IF EXISTS `mess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mess` (
  `mess_incharge_Id` varchar(12) NOT NULL,
  `cook_id` varchar(12) NOT NULL,
  `monthly_avg_expence` int NOT NULL,
  `mess_bf_timing` time NOT NULL,
  `mess_dinner_timing` time NOT NULL,
  `sunday_bf_timing` time NOT NULL,
  PRIMARY KEY (`mess_incharge_Id`),
  KEY `cook_id` (`cook_id`),
  CONSTRAINT `mess_ibfk_1` FOREIGN KEY (`cook_id`) REFERENCES `staff` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mess`
--

LOCK TABLES `mess` WRITE;
/*!40000 ALTER TABLE `mess` DISABLE KEYS */;
/*!40000 ALTER TABLE `mess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `room_id` int NOT NULL,
  `capacity` int NOT NULL,
  `hostel_id` int NOT NULL,
  PRIMARY KEY (`room_id`),
  KEY `hostel_id` (`hostel_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hostel_id`) REFERENCES `boys_hostel` (`hostel_id`),
  CONSTRAINT `room_chk_1` CHECK (((`capacity` >= 0) and (`capacity` <= 3)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (2,3,2);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `emp_id` varchar(12) NOT NULL,
  `emp_name` varchar(40) NOT NULL,
  `emp_address` varchar(100) DEFAULT NULL,
  `emp_salary` decimal(10,3) DEFAULT NULL,
  `emp_cellno` varchar(20) NOT NULL,
  `hostel_id` int NOT NULL,
  `emp_gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `hostel_id` (`hostel_id`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`hostel_id`) REFERENCES `boys_hostel` (`hostel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('535','Abdul Shakoor','Akhuwat Sociaty',20000.000,'03344278404',2,'Male');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` varchar(15) NOT NULL,
  `student_name` varchar(40) NOT NULL,
  `student_father_name` varchar(40) DEFAULT NULL,
  `department` varchar(30) NOT NULL,
  `address` varchar(40) NOT NULL,
  `cell_no` varchar(20) NOT NULL,
  `student_DOB` date NOT NULL,
  `hostel_id` int NOT NULL,
  `room_id` int NOT NULL,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`student_id`),
  KEY `hostel_id` (`hostel_id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`hostel_id`) REFERENCES `hostel` (`hostel_id`),
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('023-18-0034','Muhammad Farhan','Faiz Muhammad','CS','Sukur City','03112487244','0016-07-23',2,2,'Male'),('053-18-0015','Abidullah','Sultan Muhammad','SE','Quetta','03112487204','1999-01-17',2,2,'Male'),('053-19-0015','Irfan','Khan','CS','Quetta','03032864172','1988-08-14',2,2,'Male');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hms'
--

--
-- Final view structure for view `boys`
--

/*!50001 DROP VIEW IF EXISTS `boys`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `boys` AS select `s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name`,`s`.`student_father_name` AS `student_father_name`,`s`.`department` AS `department`,`s`.`address` AS `address`,`s`.`cell_no` AS `cell_no`,`s`.`student_DOB` AS `student_DOB`,`s`.`hostel_id` AS `hostel_id`,`s`.`room_id` AS `room_id`,`s`.`gender` AS `gender`,`h`.`location` AS `Hostel Location`,`hs`.`emp_name` AS `Hostel Cooker`,`hs`.`emp_cellno` AS `Cooker Phone` from ((`student` `s` join `boys_hostel` `h` on((`s`.`hostel_id` = `h`.`hostel_id`))) join `staff` `hs` on((`hs`.`hostel_id` = `h`.`hostel_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-08 18:12:16
