-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agama`
--

DROP TABLE IF EXISTS `agama`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agama` (
  `IDAgama` char(2) NOT NULL,
  `namaAgama` varchar(10) DEFAULT NULL,
  `detilAgama` varchar(120) DEFAULT NULL,
  `buffHP` smallint DEFAULT '0',
  `buffMP` smallint DEFAULT '0',
  `buffPAtk` smallint DEFAULT '0',
  `buffPDef` smallint DEFAULT '0',
  `buffMAtk` smallint DEFAULT '0',
  `buffMDef` smallint DEFAULT '0',
  `buffAtkS` smallint DEFAULT '0',
  `buffSta` smallint DEFAULT '0',
  `buffStaR` smallint DEFAULT '0',
  `buffMPR` smallint DEFAULT '0',
  `buffCrit` smallint DEFAULT '0',
  PRIMARY KEY (`IDAgama`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agama`
--

LOCK TABLES `agama` WRITE;
/*!40000 ALTER TABLE `agama` DISABLE KEYS */;
INSERT INTO `agama` VALUES ('AK','Akatosh','The Dragon God of Time and the chief god of the pantheon. Bleeses player with 10% faster MP Regen',0,0,0,0,0,0,0,0,0,10,0),('AR','Arkay','The God of Life & Death. Blesses the player with 25 points to HP',25,0,0,0,0,0,0,0,0,0,0),('DI','Dibella','The Goddess of Beauty. Blesses the player with 10 points to Crit',0,0,0,0,0,0,0,0,0,0,10),('JU','Julianos','The God of Wisdom and Logic. Blesses the player with 25 points to MP',0,25,0,0,0,0,0,0,0,0,0),('KY','Kynareth','The Goddess of Nature. Blesses the player with 25 points to Stamina',0,0,0,0,0,0,0,0,25,0,0),('MA','Mara','The Mother Goddess and Goddess of Love. Blesses the player with 10 points Stamina Regen',0,0,0,0,0,0,0,10,0,0,0),('ST','Stendarr','The God of Mercy and Justice. Blesses the player with 5 points Physical and Magical Def',0,0,0,5,0,5,0,0,0,0,0),('TA','Talos','The Hero-God of War and Governance. Blesses the player with 5 points Physical and Magical Att',0,0,5,0,5,0,0,0,0,0,0),('ZE','Zenithar','The God of Work and Commerce. Blesses the player with 10 points Attack Speed',0,0,0,0,0,0,10,0,0,0,0);
/*!40000 ALTER TABLE `agama` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detil_ras_kelas`
--

DROP TABLE IF EXISTS `detil_ras_kelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detil_ras_kelas` (
  `IDRas` char(2) NOT NULL,
  `IDKelas` char(2) NOT NULL,
  PRIMARY KEY (`IDRas`,`IDKelas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detil_ras_kelas`
--

LOCK TABLES `detil_ras_kelas` WRITE;
/*!40000 ALTER TABLE `detil_ras_kelas` DISABLE KEYS */;
INSERT INTO `detil_ras_kelas` VALUES ('DB','DK'),('DB','PA'),('DB','WI'),('DW','PA'),('DW','SA'),('DW','TH'),('EL','AS'),('EL','AV'),('EL','NE'),('EL','RA'),('EL','SH'),('EL','TH'),('HD','AV'),('HD','DK'),('HD','NE'),('HD','RA'),('HD','TH'),('HO','AS'),('HO','AV'),('HO','BE'),('HO','DK'),('HO','FI'),('HO','TH'),('HU','AS'),('HU','BE'),('HU','DK'),('HU','FI'),('HU','PA'),('HU','RA'),('HU','SA'),('HU','SH'),('HU','TH'),('HU','WI'),('ME','SA'),('ME','SH'),('ME','WI');
/*!40000 ALTER TABLE `detil_ras_kelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hero`
--

DROP TABLE IF EXISTS `hero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hero` (
  `IDHero` char(8) NOT NULL,
  `IDTanda` char(2) DEFAULT NULL,
  `IDKelas` char(2) DEFAULT NULL,
  `IDRas` char(2) DEFAULT NULL,
  `namaHero` varchar(30) DEFAULT NULL,
  `creationDate` date DEFAULT NULL,
  `IDAgama` char(2) DEFAULT NULL,
  PRIMARY KEY (`IDHero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hero`
--

LOCK TABLES `hero` WRITE;
/*!40000 ALTER TABLE `hero` DISABLE KEYS */;
INSERT INTO `hero` VALUES ('ATNEHD2','AT','AV','EL','Contohhh','2022-11-14','JU'),('LAARHU01','LA','RA','HU','Contoh1','2022-10-07','AK'),('STBEHO3','ST','BE','HO','Hero nih','2022-12-08','TA'),('STFIHO1','ST','FI','HO','Hero','2022-11-14',NULL);
/*!40000 ALTER TABLE `hero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kelas`
--

DROP TABLE IF EXISTS `kelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kelas` (
  `IDKelas` char(2) NOT NULL,
  `basedOf` char(2) DEFAULT NULL,
  `namaKelas` varchar(15) DEFAULT NULL,
  `ketKelas` varchar(120) DEFAULT NULL,
  `skill` varchar(25) DEFAULT NULL,
  `ketSkill` varchar(120) DEFAULT NULL,
  `minStr` tinyint DEFAULT '0',
  `minAgi` tinyint DEFAULT '0',
  `minDex` tinyint DEFAULT '0',
  `minCon` tinyint DEFAULT '0',
  `minInt` tinyint DEFAULT '0',
  `minWis` tinyint DEFAULT '0',
  `minLuck` tinyint DEFAULT '0',
  `maxStr` tinyint DEFAULT '16',
  `maxAgi` tinyint DEFAULT '16',
  `maxDex` tinyint DEFAULT '16',
  `maxCon` tinyint DEFAULT '16',
  `maxInt` tinyint DEFAULT '16',
  `maxWis` tinyint DEFAULT '16',
  `maxLuck` tinyint DEFAULT '16',
  `addHP` tinyint DEFAULT '0',
  `addMP` tinyint DEFAULT '0',
  `addPAtk` tinyint DEFAULT '0',
  `addPDef` tinyint DEFAULT '0',
  `addMAtk` tinyint DEFAULT '0',
  `addMDef` tinyint DEFAULT '0',
  `addAtkS` tinyint DEFAULT '0',
  `addSta` tinyint DEFAULT '0',
  `addStaR` tinyint DEFAULT '0',
  `addMPR` tinyint DEFAULT '0',
  `addCrit` tinyint DEFAULT '0',
  PRIMARY KEY (`IDKelas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kelas`
--

LOCK TABLES `kelas` WRITE;
/*!40000 ALTER TABLE `kelas` DISABLE KEYS */;
INSERT INTO `kelas` VALUES ('AR',NULL,'Archer','Specialize in mid to long range melee using bow and arrow',NULL,NULL,0,0,0,0,0,0,0,16,16,16,16,16,16,16,-10,0,10,-10,0,-10,10,10,10,0,10),('AS','RO','Assassin','Hired killers who deal in death. Some say they\'re death itself. Where ever they go, pile of corpses follow suits','Azrael','The angel of death has come to collect thy soul. Grant insta-death to a single enemy that cannot be ressurected',7,9,10,5,6,6,6,16,16,16,16,16,16,16,-10,0,-5,-20,-10,-20,25,25,15,5,40),('AV','PR','Avenger','Priest that has seen the evil\'s of the world. Their hatred to all living beings drive them to purge others ','Dante\'s Inferno','Recreate the living hell that is describe in Dante\'s Inferno. Decimates the surrounding area into 7 depths of hell',5,7,5,8,6,0,8,16,16,16,16,16,8,16,25,5,5,-25,20,10,-5,5,-10,15,0),('BA',NULL,'Barbarian','Fearsome warriors that use rage and raw power to overcome obstacle',NULL,NULL,0,0,0,0,0,0,0,16,16,16,16,16,16,16,20,-10,15,-15,-10,-10,10,10,10,0,0),('BE','BA','Berseker','Those who cast away their intelligence and doubles down on their rage','Guts','Chance of resurrecting with 20% health when HP reach 0',10,10,7,10,0,5,5,16,16,16,16,11,16,16,50,-15,35,-20,-25,-15,20,40,-10,-15,0),('DK','WA','Dark Knight','Warriors that walk the path of darkness and death. They boast their powerful melee abilities.','Judgement Cut','A technique that cuts through space itself, creates a dimensional rift in a sphere shape',10,7,6,10,5,6,5,16,16,16,16,16,16,16,20,-20,25,20,-25,-10,10,20,10,-10,-5),('FI','BA','Fighters','Why use one weapon, when you have two hands?','Six Paths, Five Rings','When dual wielding isn\'t enough, Fighter uses 6 arms to reach the impossible',10,10,10,7,5,5,5,16,16,16,16,16,16,16,35,-20,15,-25,-20,-25,40,20,30,-15,10),('MA',NULL,'Mage','Owns great talent for arcane spellcasting, though they haven\'t tap the full power of it',NULL,NULL,0,0,0,0,0,0,0,16,16,16,16,16,16,16,0,10,-5,-5,10,10,0,0,-10,10,0),('NE','MA','Necromancer','Ruler of Death and Undeath. They cast away their humanity in pursuit of the forbidden power','Ia Shub Nigguruth','Release an AoE insta-death spell. These sacrifices then summon Shub-Nigguruth that aids in battle.',5,6,6,5,10,0,7,16,16,16,16,16,8,16,-10,35,-15,-15,35,-10,-5,-5,-10,35,10),('PA','WA','Paladin','Warriors that walks the path of light and life. Padadin swore to protect others, by using their own body','Numeral of The Saint','Greatly increases own attack, defense, and HP when the sun is up ',8,6,5,10,5,10,5,16,16,16,16,16,16,16,20,-20,15,25,-25,20,-10,20,10,-10,0),('PR',NULL,'Priest','Those who dedicated their life to serve their gods. When they pray, the gods answers',NULL,NULL,0,0,0,0,0,0,0,16,16,16,16,16,16,16,0,10,0,-5,5,15,-10,-10,5,10,0),('RA','AR','Ranger','Ranger focus on thinning down large horde of enemy. They excels at forest and mountain-like terrain','God\'s Wrath','Unleash a volley of arrows that rain downs from the heavens and explode on impact',7,10,7,5,9,6,5,16,16,16,16,16,16,16,-10,0,10,-20,15,-10,25,10,20,0,5),('RO',NULL,'Rogue','Masters of stealth and prefer to attack when their enemies are least aware',NULL,NULL,0,0,0,0,0,0,0,16,16,16,16,16,16,16,-5,0,-10,-10,0,-5,10,10,10,0,15),('SA','PR','Saint','Priest who are chosen by the gods. They can communicate directly to the gods, who aid them in battle ','Deus In Regnium','Summon the highest ranked angel, Seraph Empyrean, to aid in battle',5,7,6,6,7,10,8,16,16,16,16,16,16,16,5,15,-20,-20,15,40,-15,-10,15,20,0),('SH','AR','Sharpshooter','One Shot One Kill is their motto. Sharpshooter excels at plain-like terrain','Caladbolg','Fire a spiral-like arrow that penetrates any target by creating a twisting distortion in space',6,8,10,5,9,6,5,16,16,16,16,16,16,16,-10,5,10,-20,20,-10,-10,20,10,0,30),('TH','RO','Thief','A rouge who favors speed over anything else. Their pursuit for gold surpass the pursuit on taking lives','Midas\' Touch','Uncanny ability for making money in every venture',7,9,7,6,6,6,9,16,16,16,16,16,16,16,-10,10,-10,-15,0,-15,25,10,20,0,30),('WA',NULL,'Warrior','Excels at fighting their rivals in close-range combat with their high HP and Defense',NULL,NULL,0,0,0,0,0,0,0,16,16,16,16,16,16,16,10,-10,10,10,-5,-5,0,10,10,-10,0),('WI','MA','Wizard','Mages that has tapped on their full power and mastered all chemical elements','Apocalypse Abyss','A Forbidden Spell that calls forth 4 tornado, each of which raged with one of the four classical chemical elements',5,6,6,5,10,9,7,16,16,16,16,16,16,16,-10,25,-15,-15,25,20,-5,-5,-10,25,10);
/*!40000 ALTER TABLE `kelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ras`
--

DROP TABLE IF EXISTS `ras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ras` (
  `IDRas` char(2) NOT NULL,
  `namaRas` varchar(10) DEFAULT NULL,
  `baseStr` tinyint DEFAULT '0',
  `baseAgi` tinyint DEFAULT '0',
  `baseDex` tinyint DEFAULT '0',
  `baseCon` tinyint DEFAULT '0',
  `baseInt` tinyint DEFAULT '0',
  `baseWis` tinyint DEFAULT '0',
  `baseLuck` tinyint DEFAULT '0',
  PRIMARY KEY (`IDRas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ras`
--

LOCK TABLES `ras` WRITE;
/*!40000 ALTER TABLE `ras` DISABLE KEYS */;
INSERT INTO `ras` VALUES ('DB','Dragonborn',10,7,8,11,13,14,7),('DW','Dwarf',8,9,8,14,8,13,10),('EL','Elf',7,12,13,8,12,7,11),('HD','Half-Demon',12,12,8,10,14,6,8),('HO','Half-Orc',14,12,12,10,6,7,9),('HU','Human',10,10,10,10,10,10,10),('ME','Elemental',6,13,12,6,14,11,8);
/*!40000 ALTER TABLE `ras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tanda`
--

DROP TABLE IF EXISTS `tanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tanda` (
  `IDTanda` char(2) NOT NULL,
  `namaTanda` varchar(10) DEFAULT NULL,
  `detilTanda` varchar(120) DEFAULT NULL,
  `buffHP` smallint DEFAULT '0',
  `buffMP` smallint DEFAULT '0',
  `buffPAtk` smallint DEFAULT '0',
  `buffPDef` smallint DEFAULT '0',
  `buffMAtk` smallint DEFAULT '0',
  `buffMDef` smallint DEFAULT '0',
  `buffAtkS` smallint DEFAULT '0',
  `buffSta` smallint DEFAULT '0',
  `buffStaR` smallint DEFAULT '0',
  `buffMPR` smallint DEFAULT '0',
  `buffCrit` smallint DEFAULT '0',
  PRIMARY KEY (`IDTanda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tanda`
--

LOCK TABLES `tanda` WRITE;
/*!40000 ALTER TABLE `tanda` DISABLE KEYS */;
INSERT INTO `tanda` VALUES ('AP','Apprentice','Grant 10% buff to your MP',0,10,0,0,0,0,0,0,0,0,0),('AT','Atronach','Grant 20% buff to your MP, in exchange of 10% of your Attack Speed',0,20,0,0,0,0,-10,0,0,0,0),('LA','Lady','Confers 10% bonus to your Attack Speed, but your MP Regeneration will fall 10%',0,0,0,0,0,0,20,0,0,-10,0),('LO','Lord','Confers 10% bonus to your Attack Speed, but your MP Regeneration will fall 10%',20,0,0,0,0,-10,0,0,0,0,0),('SH','Shadow','Provides 10% additional Critical Chance, with a 10% decrease of Pyhsical Defence',0,0,0,-10,0,0,0,0,0,0,10),('ST','Steed','Provides 10% additional Stamina',0,0,0,0,0,0,0,10,0,0,0);
/*!40000 ALTER TABLE `tanda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-08 16:07:29
