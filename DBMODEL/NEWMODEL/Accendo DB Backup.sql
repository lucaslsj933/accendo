-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: accendodbnew
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `idAluno` int NOT NULL AUTO_INCREMENT,
  `pessoa_idPessoa` varchar(50) NOT NULL,
  `etapa` varchar(45) DEFAULT NULL,
  `serie` int DEFAULT NULL,
  `turma_idTurma` int NOT NULL,
  PRIMARY KEY (`idAluno`,`pessoa_idPessoa`,`turma_idTurma`),
  KEY `fk_aluno_pessoa1_idx` (`pessoa_idPessoa`),
  KEY `fk_aluno_turma1_idx` (`turma_idTurma`),
  CONSTRAINT `fk_aluno_pessoa1` FOREIGN KEY (`pessoa_idPessoa`) REFERENCES `pessoa` (`idPessoa`),
  CONSTRAINT `fk_aluno_turma1` FOREIGN KEY (`turma_idTurma`) REFERENCES `turma` (`idTurma`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'A1111','Fundamental',9,1),(2,'A2222','Fundamental',9,1),(3,'A1113','Fundamental',8,2),(4,'A0000','Fundamental',9,1),(5,'A1','Fundamental',9,1),(6,'A2','Fundamental',9,1),(7,'A3','Fundamental',9,1),(8,'A4','Fundamental',9,1),(9,'A5','Fundamental',9,1),(10,'A6','Fundamental',9,1),(11,'A7','Fundamental',9,1),(12,'A8','Fundamental',9,1),(13,'A9','Fundamental',9,1),(14,'A10','Fundamental',9,1),(15,'A11','Fundamental',9,1),(16,'A12','Fundamental',9,1),(17,'A13','Fundamental',9,1),(18,'A14','Fundamental',9,1),(19,'A15','Fundamental',9,1),(20,'A16','Fundamental',9,1),(21,'A17','Fundamental',9,1),(22,'A18','Fundamental',9,1),(23,'A19','Fundamental',9,1),(24,'A20','Fundamental',9,1);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `idMateria` int NOT NULL AUTO_INCREMENT,
  `nomeMateria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMateria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (1,'Matemática'),(2,'Português'),(3,'Ciências'),(4,'História'),(5,'Geografia'),(6,'Lógica');
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nota` (
  `idNota` int NOT NULL AUTO_INCREMENT,
  `valor` float DEFAULT NULL,
  `ta` int DEFAULT NULL,
  `materia_idMateria` int NOT NULL,
  `aluno_idAluno` int NOT NULL,
  `pessoa_idPessoa` varchar(50) NOT NULL,
  PRIMARY KEY (`idNota`,`materia_idMateria`,`aluno_idAluno`,`pessoa_idPessoa`),
  KEY `fk_nota_materia_idx` (`materia_idMateria`),
  KEY `fk_nota_aluno1_idx` (`aluno_idAluno`,`pessoa_idPessoa`),
  CONSTRAINT `fk_nota_aluno1` FOREIGN KEY (`aluno_idAluno`, `pessoa_idPessoa`) REFERENCES `aluno` (`idAluno`, `pessoa_idPessoa`),
  CONSTRAINT `fk_nota_materia` FOREIGN KEY (`materia_idMateria`) REFERENCES `materia` (`idMateria`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` VALUES (1,9.5,1,1,1,'A1111'),(2,8,1,2,1,'A1111'),(3,8.5,2,1,1,'A1111'),(4,8.5,2,2,1,'A1111'),(5,9,3,1,1,'A1111'),(6,10,4,1,1,'A1111'),(7,9,3,2,1,'A1111'),(8,8,4,2,1,'A1111'),(9,10,1,3,1,'A1111'),(10,9,2,3,1,'A1111'),(11,9,1,4,1,'A1111'),(12,8,2,4,1,'A1111'),(13,9,1,5,1,'A1111'),(14,8,2,5,1,'A1111'),(15,10,3,3,1,'A1111'),(16,9,4,3,1,'A1111'),(17,9,1,1,2,'A2222'),(18,8,2,1,2,'A2222'),(19,10,1,2,2,'A2222'),(20,9,2,2,2,'A2222'),(21,8.43493,1,1,4,'A0000'),(22,7.0721,1,1,5,'A1'),(23,6.60054,1,1,6,'A2'),(24,6.78642,1,1,7,'A3'),(25,9.13046,1,1,8,'A4'),(26,5.29303,1,1,9,'A5'),(27,9.07378,1,1,10,'A6'),(28,9.4898,1,1,11,'A7'),(29,5.22767,1,1,12,'A8'),(30,7.66894,1,1,13,'A9'),(31,7.66168,1,1,14,'A10'),(32,5.30159,1,1,15,'A11'),(33,8.52291,1,1,16,'A12'),(34,6.70976,1,1,17,'A13'),(35,7.98008,1,1,18,'A14'),(36,9.77114,1,1,19,'A15'),(37,9.91544,1,1,20,'A16'),(38,5.2638,1,1,21,'A17'),(39,6.57269,1,1,22,'A18'),(40,7.07202,1,1,23,'A19'),(41,5.64204,1,1,24,'A20'),(42,8,1,1,3,'A1113'),(43,9,2,1,3,'A1113');
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `idPessoa` varchar(50) NOT NULL,
  `tipoPessoa` varchar(45) DEFAULT NULL,
  `passwordPessoa` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `rg` varchar(9) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `flag` tinyint DEFAULT NULL,
  PRIMARY KEY (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES ('A0000','a','12345','Teste 0','M',21,'RG0000','CPF0000',1),('A1','a','12345','Teste 1','M',21,'RG1','CPF1',1),('A10','a','12345','Teste 10','M',21,'RG10','CPF10',1),('A11','a','12345','Teste 11','M',21,'RG11','CPF11',1),('A1111','a','12345','Lucas Santos de Jesus','M',21,'RG1111','CPF1111',1),('A1113','a','12345','Davy de Souza','M',20,'RG1112','CPF1112',1),('A12','a','12345','Teste 12','M',21,'RG12','CPF12',1),('A13','a','12345','Teste 13','M',21,'RG13','CPF13',1),('A14','a','12345','Teste 14','M',21,'RG14','CPF14',1),('A15','a','12345','Teste 15','M',21,'RG15','CPF15',1),('A16','a','12345','Teste 16','M',21,'RG16','CPF16',1),('A17','a','12345','Teste 17','M',21,'RG17','CPF17',1),('A18','a','12345','Teste 18','M',21,'RG18','CPF18',1),('A19','a','12345','Teste 19','M',21,'RG19','CPF19',1),('A2','a','12345','Teste 2','M',21,'RG2','CPF2',1),('A20','a','12345','Teste 20','M',21,'RG20','CPF20',1),('A2222','a','12345','Gabriel Ferreira','M',20,'RG2222','CPF2222',1),('A3','a','12345','Teste 3','M',21,'RG3','CPF3',1),('A4','a','12345','Teste 4','M',21,'RG4','CPF4',1),('A5','a','12345','Teste 5','M',21,'RG5','CPF5',1),('A6','a','12345','Teste 6','M',21,'RG6','CPF6',1),('A7','a','12345','Teste 7','M',21,'RG7','CPF7',1),('A8','a','12345','Teste 8','M',21,'RG8','CPF8',1),('A9','a','12345','Teste 9','M',21,'RG9','CPF9',1),('P1111','p','12345','Thiago Macedo','M',28,'RGP1111','CPFP1111',1),('P2222','p','12345','Flávio Ferreira','M',30,'RGP2222','CPFP2222',1);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `idProfessor` int NOT NULL AUTO_INCREMENT,
  `pessoa_idPessoa` varchar(50) NOT NULL,
  `graduacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProfessor`,`pessoa_idPessoa`),
  KEY `fk_professor_pessoa1_idx` (`pessoa_idPessoa`),
  CONSTRAINT `fk_professor_pessoa1` FOREIGN KEY (`pessoa_idPessoa`) REFERENCES `pessoa` (`idPessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1,'P1111','Matemática'),(2,'P2222','Português');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor_has_materia`
--

DROP TABLE IF EXISTS `professor_has_materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor_has_materia` (
  `professor_idProfessor` int NOT NULL,
  `professor_pessoa_idPessoa` varchar(50) NOT NULL,
  `materia_idMateria` int NOT NULL,
  PRIMARY KEY (`professor_idProfessor`,`professor_pessoa_idPessoa`,`materia_idMateria`),
  KEY `fk_professor_has_materia_materia1_idx` (`materia_idMateria`),
  KEY `fk_professor_has_materia_professor1_idx` (`professor_idProfessor`,`professor_pessoa_idPessoa`),
  CONSTRAINT `fk_professor_has_materia_materia1` FOREIGN KEY (`materia_idMateria`) REFERENCES `materia` (`idMateria`),
  CONSTRAINT `fk_professor_has_materia_professor1` FOREIGN KEY (`professor_idProfessor`, `professor_pessoa_idPessoa`) REFERENCES `professor` (`idProfessor`, `pessoa_idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_has_materia`
--

LOCK TABLES `professor_has_materia` WRITE;
/*!40000 ALTER TABLE `professor_has_materia` DISABLE KEYS */;
INSERT INTO `professor_has_materia` VALUES (1,'P1111',1),(1,'P1111',6);
/*!40000 ALTER TABLE `professor_has_materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor_has_turma`
--

DROP TABLE IF EXISTS `professor_has_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor_has_turma` (
  `professor_idProfessor` int NOT NULL,
  `professor_pessoa_idPessoa` varchar(50) NOT NULL,
  `turma_idTurma` int NOT NULL,
  PRIMARY KEY (`professor_idProfessor`,`professor_pessoa_idPessoa`,`turma_idTurma`),
  KEY `fk_professor_has_turma_professor1_idx` (`professor_idProfessor`,`professor_pessoa_idPessoa`),
  KEY `fk_professor_has_turma_turma1_idx` (`turma_idTurma`),
  CONSTRAINT `fk_professor_has_turma_professor1` FOREIGN KEY (`professor_idProfessor`, `professor_pessoa_idPessoa`) REFERENCES `professor` (`idProfessor`, `pessoa_idPessoa`),
  CONSTRAINT `fk_professor_has_turma_turma1` FOREIGN KEY (`turma_idTurma`) REFERENCES `turma` (`idTurma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor_has_turma`
--

LOCK TABLES `professor_has_turma` WRITE;
/*!40000 ALTER TABLE `professor_has_turma` DISABLE KEYS */;
INSERT INTO `professor_has_turma` VALUES (1,'P1111',1),(2,'P2222',1),(1,'P1111',2);
/*!40000 ALTER TABLE `professor_has_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma` (
  `idTurma` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `ano` year DEFAULT NULL,
  PRIMARY KEY (`idTurma`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'901',2021),(2,'801',2021);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_has_materia`
--

DROP TABLE IF EXISTS `turma_has_materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma_has_materia` (
  `turma_idTurma` int NOT NULL,
  `materia_idMateria` int NOT NULL,
  PRIMARY KEY (`turma_idTurma`,`materia_idMateria`),
  KEY `fk_turma_has_materia_materia1_idx` (`materia_idMateria`),
  KEY `fk_turma_has_materia_turma1_idx` (`turma_idTurma`),
  CONSTRAINT `fk_turma_has_materia_materia1` FOREIGN KEY (`materia_idMateria`) REFERENCES `materia` (`idMateria`),
  CONSTRAINT `fk_turma_has_materia_turma1` FOREIGN KEY (`turma_idTurma`) REFERENCES `turma` (`idTurma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_has_materia`
--

LOCK TABLES `turma_has_materia` WRITE;
/*!40000 ALTER TABLE `turma_has_materia` DISABLE KEYS */;
INSERT INTO `turma_has_materia` VALUES (1,1),(2,1),(1,6);
/*!40000 ALTER TABLE `turma_has_materia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-29 16:55:19
