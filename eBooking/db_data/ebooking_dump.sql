# MySQL-Front 3.2  (Build 4.15)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET CHARACTER SET 'latin1' */;

# Host: localhost    Database: ebooking
# ------------------------------------------------------
# Server version 4.1.11-nt

USE `ebooking`;

#
# Table Objects for table base_address
#

DROP TABLE IF EXISTS `base_address`;

CREATE TABLE `base_address` (
  `ID` bigint(20) NOT NULL default '0',
  `STREET` varchar(100) default NULL,
  `ZIPCODE` varchar(25) default NULL,
  `CITY` varchar(100) default NULL,
  `COUNTY_KEY` varchar(100) default NULL,
  `COUNTRY_KEY` varchar(100) default NULL,
  `POSTAL_NAME` varchar(100) default NULL,
  `DEPARTMENT` varchar(150) default NULL,
  `PHONE1` varchar(100) default NULL,
  `PHONE2` varchar(100) default NULL,
  `FAX` varchar(100) default NULL,
  `MOBILE_PHONE` varchar(100) default NULL,
  `EMAIL` varchar(100) default NULL,
  `WWW` varchar(150) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table base_address
#

INSERT INTO `base_address` VALUES (2,'Wiesengrund','78462','Illerkirchberg','bw','de','','','','','','','','http://www.pension-dorfstuben.de');
INSERT INTO `base_address` VALUES (3,'Schauberthalde 6','88512','Mengen-Rulfingen','bw','de','','','07576/901064','','','0179/9433206','tom@raedle.info','http://www.raedle.info');
INSERT INTO `base_address` VALUES (4,'Quellenweg 8','88512','Mengen','bw','de','','','','','','','','');
INSERT INTO `base_address` VALUES (5,'Kastellstraße 4','78462','Konstanz','bw','de','','','07531/382227','','','0179/9159298','','http://www.pension-dorfstuben.de');
INSERT INTO `base_address` VALUES (7,'Kastellstraße 4','88512','Mengen-Ennetach','tg','ch','','','07572/3170','','07572/6561','','markus@raedle.info','http://www.fliesen-raedle.de');
INSERT INTO `base_address` VALUES (9,'Fürstenbergstraße 11','78467','Konstanz','bw','de','','','','','','','keim@inf.uni-konstanz.de','');
INSERT INTO `base_address` VALUES (10,'Kastellstraße 4','88512','Mengen-Ennetach','bw','de','','','','','','','','');
INSERT INTO `base_address` VALUES (11,'Kastellstraße 4','88512','Mengen-Ennetach','bw','de','Anton Rädle GmbH','Fliesenfachgeschäft','07572/3170','','07572/6561','','info@fliesen-raedle.de','http://www.fliesen-raedle.de');
INSERT INTO `base_address` VALUES (13,'','','Herbertingen','bw','de','','','','','','','','');
INSERT INTO `base_address` VALUES (14,'Schauberthalde 6','88512','Mengen-Rulfingen','bw','de','','','','','','','','');
INSERT INTO `base_address` VALUES (15,'Breslauer Str. 53','88512','Mengen','bw','de','','','07572/94498','','','','tupac99@gmx.net','');
INSERT INTO `base_address` VALUES (16,'','78462','Konstanz','bw','de','','','','','','','','');
INSERT INTO `base_address` VALUES (17,'','','Konstanz','bw','de','','','','','','','','');
INSERT INTO `base_address` VALUES (18,'','','Konstanz','bw','de','','','','','','','','');
INSERT INTO `base_address` VALUES (19,'Hörvelsinger Weg 27','','Ulm','bw','de','','','0731/9650 - 459','','','','','');
INSERT INTO `base_address` VALUES (20,'asdfasdf','','','empty','de','','','','','','','','');

#
# Table Objects for table base_person
#

DROP TABLE IF EXISTS `base_person`;

CREATE TABLE `base_person` (
  `ID` bigint(20) NOT NULL default '0',
  `TITLE` bigint(20) default NULL,
  `ACADEMIC_TITLE` bigint(20) default NULL,
  `FIRSTNAME` varchar(255) default NULL,
  `LASTNAME` varchar(255) default NULL,
  `IDENTIFICATION_NUMBER` varchar(255) default NULL,
  `ADDRESS_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKA963708382CB5F37` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table base_person
#

INSERT INTO `base_person` VALUES (2,3,1,'Stefanie','Rädle','0000-0000-0000-0000',2);
INSERT INTO `base_person` VALUES (3,2,1,'Thomas','Rädle',NULL,3);
INSERT INTO `base_person` VALUES (4,1,1,'Kathrin','Rochow',NULL,4);
INSERT INTO `base_person` VALUES (5,2,1,'Roman','Rädle','XXXX-XXXX-XXXX-XXXX',5);
INSERT INTO `base_person` VALUES (7,2,1,'Markus','Rädle',NULL,7);
INSERT INTO `base_person` VALUES (8,2,2,'Daniel A.','Keim','XXXX-XXXX-XXXX-XXXX',9);
INSERT INTO `base_person` VALUES (9,2,1,'Anton','Rädle',NULL,10);
INSERT INTO `base_person` VALUES (10,6,1,'Anton','Rädle',NULL,11);
INSERT INTO `base_person` VALUES (12,2,1,'Paul','Jakuszczonek',NULL,13);
INSERT INTO `base_person` VALUES (13,3,1,'Susanne','Rauh',NULL,14);
INSERT INTO `base_person` VALUES (14,2,1,'Andreas','Weiler','',15);
INSERT INTO `base_person` VALUES (15,2,1,'Domenic','Winkler',NULL,16);
INSERT INTO `base_person` VALUES (16,3,1,'Cordula','Bauer',NULL,17);
INSERT INTO `base_person` VALUES (17,3,1,'Andrea','Söter',NULL,18);
INSERT INTO `base_person` VALUES (18,2,1,'Jürgen','Denzel',NULL,19);
INSERT INTO `base_person` VALUES (19,1,1,'asdf','asdf','',20);

#
# Table Objects for table base_system_academic_title
#

DROP TABLE IF EXISTS `base_system_academic_title`;

CREATE TABLE `base_system_academic_title` (
  `ID` bigint(20) NOT NULL default '0',
  `ACADEMIC_TITLE` varchar(100) NOT NULL default '',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table base_system_academic_title
#

INSERT INTO `base_system_academic_title` VALUES (1,'');
INSERT INTO `base_system_academic_title` VALUES (2,'Prof. Dr.');

#
# Table Objects for table base_system_country
#

DROP TABLE IF EXISTS `base_system_country`;

CREATE TABLE `base_system_country` (
  `ID` bigint(20) NOT NULL default '0',
  `COUNTRY_KEY` varchar(100) NOT NULL default '',
  `NAME` varchar(100) NOT NULL default '',
  `SYSTEM_LOCALE_KEY` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table base_system_country
#

INSERT INTO `base_system_country` VALUES (1,'de','Deutschland','de');
INSERT INTO `base_system_country` VALUES (2,'at','Österreich','de');
INSERT INTO `base_system_country` VALUES (3,'ch','Schweiz','de');
INSERT INTO `base_system_country` VALUES (4,'en','England','en');
INSERT INTO `base_system_country` VALUES (5,'at','Austria','en');
INSERT INTO `base_system_country` VALUES (6,'ch','Swiss','en');
INSERT INTO `base_system_country` VALUES (7,'de','Germany','en');
INSERT INTO `base_system_country` VALUES (8,'nl','Netherland','en');
INSERT INTO `base_system_country` VALUES (9,'de','Niederlande','de');

#
# Table Objects for table base_system_county
#

DROP TABLE IF EXISTS `base_system_county`;

CREATE TABLE `base_system_county` (
  `ID` bigint(20) NOT NULL default '0',
  `COUNTY_KEY` varchar(100) NOT NULL default '',
  `NAME` varchar(100) NOT NULL default '',
  `COUNTRY_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK1168E86C6CEDCC24` (`COUNTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table base_system_county
#

INSERT INTO `base_system_county` VALUES (1,'bw','Baden-Württemberg',1);
INSERT INTO `base_system_county` VALUES (2,'b','Bayern',1);
INSERT INTO `base_system_county` VALUES (3,'th','Thüringen',1);
INSERT INTO `base_system_county` VALUES (4,'tg','Thurgau',3);
INSERT INTO `base_system_county` VALUES (5,'db','Dornbirn',2);
INSERT INTO `base_system_county` VALUES (6,'bw','Baden-Württemberg',4);
INSERT INTO `base_system_county` VALUES (7,'b','Bavaria',4);

#
# Table Objects for table base_system_locale
#

DROP TABLE IF EXISTS `base_system_locale`;

CREATE TABLE `base_system_locale` (
  `ID` bigint(20) NOT NULL default '0',
  `LOCALE_KEY` varchar(255) NOT NULL default '',
  `LANGUAGE` varchar(255) NOT NULL default '',
  `COUNTRY_NAME` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table base_system_locale
#

INSERT INTO `base_system_locale` VALUES (1,'de','Deutsch','Deutschland');
INSERT INTO `base_system_locale` VALUES (2,'en','English','England');

#
# Table Objects for table base_system_title
#

DROP TABLE IF EXISTS `base_system_title`;

CREATE TABLE `base_system_title` (
  `ID` bigint(20) NOT NULL default '0',
  `TITLE` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table base_system_title
#

INSERT INTO `base_system_title` VALUES (1,'');
INSERT INTO `base_system_title` VALUES (2,'Herrn');
INSERT INTO `base_system_title` VALUES (3,'Frau');
INSERT INTO `base_system_title` VALUES (4,'Herr');
INSERT INTO `base_system_title` VALUES (5,'Fräulein');
INSERT INTO `base_system_title` VALUES (6,'Firma');

#
#  Foreign keys for table base_person
#

ALTER TABLE `base_person`
  ADD FOREIGN KEY (`ADDRESS_ID`) REFERENCES `base_address` (`ID`);


#
#  Foreign keys for table base_system_county
#

ALTER TABLE `base_system_county`
  ADD FOREIGN KEY (`COUNTRY_ID`) REFERENCES `base_system_country` (`ID`);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
