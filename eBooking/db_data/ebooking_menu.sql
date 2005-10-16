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
# Dumping data for table base_address
#

INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (2,'Wiesengrund 6','89171','Illerkirchberg','de-bw','de','','','','','','','','http://www.pension-dorfstuben.de');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (3,'Schauberthalde 6','88512','Mengen-Rulfingen','bw','de','','','07576/901064','','','0179/9433206','tom@raedle.info','http://www.raedle.info');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (4,'Quellenweg 8','88512','Mengen','bw','de','','','','','','','','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (5,'Kastellstraße 4','78462','Konstanz','bw','de','','','07531/382227','','','0179/9159298','','http://www.pension-dorfstuben.de');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (7,'Kastellstraße 4','88512','Mengen-Ennetach','tg','ch','','','07572/3170','','07572/6561','','markus@raedle.info','http://www.fliesen-raedle.de');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (9,'Fürstenbergstraße 11','78467','Konstanz','bw','de','Universität Konstanz','Databases, Data Mining & Visualization','','','','','keim@inf.uni-konstanz.de','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (10,'Kastellstraße 4','88512','Mengen-Ennetach','bw','de','','','','','','','','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (11,'Kastellstraße 4','88512','Mengen-Ennetach','bw','de','Anton Rädle GmbH','Fliesenfachgeschäft','07572/3170','','07572/6561','','info@fliesen-raedle.de','http://www.fliesen-raedle.de');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (13,'','','Herbertingen','bw','de','','','','','','','','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (14,'Schauberthalde 6','88512','Mengen-Rulfingen','bw','de','','','','','','','','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (15,'Breslauer Str. 53','88512','Mengen','bw','de','','','07572/94498','','','','tupac99@gmx.net','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (16,'','78462','Konstanz','bw','de','','','','','','','','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (17,'','','Konstanz','bw','de','','','','','','','','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (18,'','','Konstanz','bw','de','','','','','','','','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (19,'Hörvelsinger Weg 27','','Ulm','bw','de','','','0731/9650 - 459','','','','','');
INSERT INTO `base_address` (`ID`,`STREET`,`ZIPCODE`,`CITY`,`COUNTY_KEY`,`COUNTRY_KEY`,`POSTAL_NAME`,`DEPARTMENT`,`PHONE1`,`PHONE2`,`FAX`,`MOBILE_PHONE`,`EMAIL`,`WWW`) VALUES (20,'asdfasdf','','','empty','de','','','','','','','','');

#
# Dumping data for table base_person
#

INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (2,'mrs','empty','Stefanie','Rädle','0000-0000-0000-0000',2);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (3,'mr','empty','Thomas','Rädle',NULL,3);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (4,'miss','empty','Kathrin','Rochow',NULL,4);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (5,'mr','empty','Roman','Rädle','XXXX-XXXX-XXXX-XXXX',5);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (7,'mr','empty','Markus','Rädle',NULL,7);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (8,'mr','prof. dr.','Daniel A.','Keim','XXXX-XXXX-XXXX-XXXX',9);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (9,'mr','empty','Anton','Rädle',NULL,10);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (10,'firm','empty','Anton','Rädle',NULL,11);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (12,'mr','empty','Paul','Jakuszczonek',NULL,13);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (13,'mrs','empty','Susanne','Rauh',NULL,14);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (14,'mr','empty','Andreas','Weiler','',15);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (15,'mr','empty','Domenic','Winkler',NULL,16);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (16,'mrs','empty','Cordula','Bauer',NULL,17);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (17,'mrs','empty','Andrea','Söter',NULL,18);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (18,'mr','empty','Jürgen','Denzel',NULL,19);
INSERT INTO `base_person` (`ID`,`TITLE_KEY`,`ACADEMIC_TITLE_KEY`,`FIRSTNAME`,`LASTNAME`,`IDENTIFICATION_NUMBER`,`ADDRESS_ID`) VALUES (19,'empty','empty','asdf','asdf','',20);

#
# Dumping data for table base_system_academic_title
#

INSERT INTO `base_system_academic_title` (`ID`,`ACADEMIC_TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (1,'prof. dr.','Prof. Dr.','de');
INSERT INTO `base_system_academic_title` (`ID`,`ACADEMIC_TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (2,'dr.','Dr.','de');
INSERT INTO `base_system_academic_title` (`ID`,`ACADEMIC_TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (3,'prof. dr.','Prof. Dr.','en');

#
# Dumping data for table base_system_article
#

INSERT INTO `base_system_article` (`ID`,`ARTICLE_KEY`,`PRICE`,`VAT_INCLUDED`) VALUES (1,'single_room',38,1);
INSERT INTO `base_system_article` (`ID`,`ARTICLE_KEY`,`PRICE`,`VAT_INCLUDED`) VALUES (2,'twin_room',56,1);

#
# Dumping data for table base_system_article_description
#

INSERT INTO `base_system_article_description` (`ID`,`DESCRIPTION`,`LOCALE_KEY`,`ARTICLE_KEY`) VALUES (1,'Einzelzimmer','de','single_room');
INSERT INTO `base_system_article_description` (`ID`,`DESCRIPTION`,`LOCALE_KEY`,`ARTICLE_KEY`) VALUES (2,'Doppelzimmer','de','twin_room');
INSERT INTO `base_system_article_description` (`ID`,`DESCRIPTION`,`LOCALE_KEY`,`ARTICLE_KEY`) VALUES (3,'Single Room','en','single_room');
INSERT INTO `base_system_article_description` (`ID`,`DESCRIPTION`,`LOCALE_KEY`,`ARTICLE_KEY`) VALUES (4,'Twin Room','en','twin_room');

#
# Dumping data for table base_system_article_to_unit_plural
#

INSERT INTO `base_system_article_to_unit_plural` (`ARTICLE_KEY`,`UNIT_ID`) VALUES ('single_room',1002);
INSERT INTO `base_system_article_to_unit_plural` (`ARTICLE_KEY`,`UNIT_ID`) VALUES ('single_room',2002);
INSERT INTO `base_system_article_to_unit_plural` (`ARTICLE_KEY`,`UNIT_ID`) VALUES ('twin_room',1002);

#
# Dumping data for table base_system_article_to_unit_singular
#

INSERT INTO `base_system_article_to_unit_singular` (`ARTICLE_KEY`,`UNIT_ID`) VALUES ('single_room',1001);
INSERT INTO `base_system_article_to_unit_singular` (`ARTICLE_KEY`,`UNIT_ID`) VALUES ('single_room',2001);
INSERT INTO `base_system_article_to_unit_singular` (`ARTICLE_KEY`,`UNIT_ID`) VALUES ('twin_room',1001);

#
# Dumping data for table base_system_country
#

INSERT INTO `base_system_country` (`ID`,`COUNTRY_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (1,'de','Deutschland','de');
INSERT INTO `base_system_country` (`ID`,`COUNTRY_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (2,'at','Österreich','de');
INSERT INTO `base_system_country` (`ID`,`COUNTRY_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (3,'ch','Schweiz','de');
INSERT INTO `base_system_country` (`ID`,`COUNTRY_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (4,'en','England','en');
INSERT INTO `base_system_country` (`ID`,`COUNTRY_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (5,'at','Austria','en');
INSERT INTO `base_system_country` (`ID`,`COUNTRY_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (6,'ch','Swiss','en');
INSERT INTO `base_system_country` (`ID`,`COUNTRY_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (7,'de','Germany','en');
INSERT INTO `base_system_country` (`ID`,`COUNTRY_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (8,'nl','Netherland','en');

#
# Dumping data for table base_system_county
#

INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10001,'de-bw','Baden-Württemberg',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10002,'de-by','Bayern',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10003,'de-be','Berlin',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10004,'de-br','Brandenburg',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10005,'de-hb','Bremen',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10006,'de-hh','Hamburg',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10007,'de-he','Hessen',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10008,'de-mv','Mecklenburg-Vorpommern',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10009,'de-ni','Niedersachsen',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10010,'de-nw','Nordrhein-Westfalen',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10011,'de-rp','Rheinland-Pfalz',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10012,'de-sl','Saarland',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10013,'de-sn','Sachsen',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10014,'de-st','Sachsen-Anhalt',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10015,'de-sh','Schleswig-Holstein',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10016,'de-th','Thüringen',1);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10101,'at-1','Burgenland',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10102,'at-2','Kärnten',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10103,'at-3','Niederösterreich',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10104,'at-4','Oberösterreich',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10105,'at-5','Salzburg',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10106,'at-6','Steiermark',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10107,'at-7','Tirol',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10108,'at-8','Vorarlberg',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10109,'at-9','Wien',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10201,'ch-zh','Zürich',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10202,'ch-be','Bern',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10203,'ch-lu','Luzern',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10204,'ch-ur','Uri',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10205,'ch-sz','Schwyz',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10206,'ch-ow','Obwalden',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10207,'ch-nw','Nidwalden',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10208,'ch-gl','Glarus',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10209,'ch-zg','Zug',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10210,'ch-fr','Freiburg',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10211,'ch-so','Solothurn',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10212,'ch-bs','Basel-Stadt',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10213,'ch-bl','Basel-Landschaft',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10214,'ch-sh','Schaffhausen',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10215,'ch-ar','Appenzell Ausserrhoden',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10216,'ch-ai','Appenzell Innerrhoden',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10217,'ch-sg','St. Gallen',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10218,'ch-gr','Graubünden',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10219,'ch-ag','Aargau',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10220,'ch-tg','Thurgau',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10221,'ch-ti','Tessin',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10222,'ch-vd','Waadt',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10223,'ch-vs','Wallis',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10224,'ch-ne','Neuenburg',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10225,'ch-ge','Genf',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (10226,'ch-ju','Jura',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (100000,'tg','Thurgau',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (100001,'db','Dornbirn',2);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (100002,'bw','Baden-Württemberg',7);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (100004,'z','Zürich',3);
INSERT INTO `base_system_county` (`ID`,`COUNTY_KEY`,`NAME`,`COUNTRY_ID`) VALUES (100300,'th','Thueringen',7);

#
# Dumping data for table base_system_locale
#

INSERT INTO `base_system_locale` (`ID`,`LOCALE_KEY`,`LANGUAGE`,`COUNTRY_NAME`) VALUES (1,'de','Deutsch','Deutschland');
INSERT INTO `base_system_locale` (`ID`,`LOCALE_KEY`,`LANGUAGE`,`COUNTRY_NAME`) VALUES (2,'en','English','England');

#
# Dumping data for table base_system_title
#

INSERT INTO `base_system_title` (`ID`,`TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (1,'mr','Herr','de');
INSERT INTO `base_system_title` (`ID`,`TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (2,'mrs','Frau','de');
INSERT INTO `base_system_title` (`ID`,`TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (3,'miss','Fräulein','de');
INSERT INTO `base_system_title` (`ID`,`TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (4,'firm','Firma','de');
INSERT INTO `base_system_title` (`ID`,`TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (5,'firm','Firm','en');
INSERT INTO `base_system_title` (`ID`,`TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (6,'mr','Mr.','en');
INSERT INTO `base_system_title` (`ID`,`TITLE_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (7,'mrs','Mrs.','en');

#
# Dumping data for table base_system_unit
#

INSERT INTO `base_system_unit` (`ID`,`UNIT_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (1001,'day','Tag','de');
INSERT INTO `base_system_unit` (`ID`,`UNIT_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (1002,'days','Tage','de');
INSERT INTO `base_system_unit` (`ID`,`UNIT_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (1003,'piece','Stück','de');
INSERT INTO `base_system_unit` (`ID`,`UNIT_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (1004,'kg','kg','de');
INSERT INTO `base_system_unit` (`ID`,`UNIT_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (1005,'cm','cm','de');
INSERT INTO `base_system_unit` (`ID`,`UNIT_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (2001,'day','Day','en');
INSERT INTO `base_system_unit` (`ID`,`UNIT_KEY`,`NAME`,`SYSTEM_LOCALE_KEY`) VALUES (2002,'days','Days','en');

#
# Dumping data for table base_system_user
#

INSERT INTO `base_system_user` (`ID`,`LOGIN_ID`,`PASSWORD`,`LOCKED`,`PASSWORD_FAILED`) VALUES (1,'ADMIN','BFpBV?',0,0);

#
# Dumping data for table booking
#

INSERT INTO `booking` (`ID`,`PERSON_ID`) VALUES (1,5);

#
# Dumping data for table booking_item
#

INSERT INTO `booking_item` (`ID`,`FROM_DATE`,`TO_DATE`,`AMOUNT`,`UNIT_ID`,`DESCRIPTION`,`PRICE`,`BOOKING_ID`) VALUES (1,'2005-05-17','2005-05-18',1,1003,NULL,35,1);
INSERT INTO `booking_item` (`ID`,`FROM_DATE`,`TO_DATE`,`AMOUNT`,`UNIT_ID`,`DESCRIPTION`,`PRICE`,`BOOKING_ID`) VALUES (2,'2005-05-17','2005-05-18',1,1001,NULL,35,1);
INSERT INTO `booking_item` (`ID`,`FROM_DATE`,`TO_DATE`,`AMOUNT`,`UNIT_ID`,`DESCRIPTION`,`PRICE`,`BOOKING_ID`) VALUES (3,'2005-05-18','2005-05-20',2,1002,NULL,56,1);

#
# Dumping data for table booking_system_room
#

INSERT INTO `booking_system_room` (`ID`,`ROOM_KEY`,`DESCRIPTION`,`PRICE`,`BED_AMOUNT`) VALUES (1,'first','Ich bin so gut!',56,2);

#
# Dumping data for table booking_system_room_to_room_type
#


#
# Dumping data for table booking_system_room_type
#

INSERT INTO `booking_system_room_type` (`ID`,`ROOM_TYPE_KEY`,`LOCALE_KEY`) VALUES (1,'single_room','de');

#
# Dumping data for table core_menu
#

INSERT INTO `core_menu` (`ID`,`MENU_KEY`) VALUES (1,'system_admin');
INSERT INTO `core_menu` (`ID`,`MENU_KEY`) VALUES (2,'default_user');

#
# Dumping data for table core_menu_item
#

INSERT INTO `core_menu_item` (`ID`,`MENU_ITEM_INDEX`,`MENU_ITEM_KEY`,`IMAGE_PATH`,`LINK`,`TARGET`,`TOOLTIP`,`PARENT`) VALUES (1,1,'menu_home',NULL,'/base/home.jspa','_top','tooltip.home',NULL);
INSERT INTO `core_menu_item` (`ID`,`MENU_ITEM_INDEX`,`MENU_ITEM_KEY`,`IMAGE_PATH`,`LINK`,`TARGET`,`TOOLTIP`,`PARENT`) VALUES (2,2,'menu_customer',NULL,'/base/client.jspa',NULL,'tooltip.client',NULL);
INSERT INTO `core_menu_item` (`ID`,`MENU_ITEM_INDEX`,`MENU_ITEM_KEY`,`IMAGE_PATH`,`LINK`,`TARGET`,`TOOLTIP`,`PARENT`) VALUES (3,1,'menu_customer_add','/ebooking/images/ThemeOffice/users_add.png','/ebooking/base/add_customer.jspa','main','tooltip.add_client','menu_customer');
INSERT INTO `core_menu_item` (`ID`,`MENU_ITEM_INDEX`,`MENU_ITEM_KEY`,`IMAGE_PATH`,`LINK`,`TARGET`,`TOOLTIP`,`PARENT`) VALUES (4,3,'menu_customer_list','/ebooking/images/ThemeOffice/users.png','/ebooking/base/list_customer.jspa','main','tooltip.list_client','menu_customer');
INSERT INTO `core_menu_item` (`ID`,`MENU_ITEM_INDEX`,`MENU_ITEM_KEY`,`IMAGE_PATH`,`LINK`,`TARGET`,`TOOLTIP`,`PARENT`) VALUES (5,2,'_cmSplit','','','','','menu_customer');
INSERT INTO `core_menu_item` (`ID`,`MENU_ITEM_INDEX`,`MENU_ITEM_KEY`,`IMAGE_PATH`,`LINK`,`TARGET`,`TOOLTIP`,`PARENT`) VALUES (6,1,'menu_all_customer_list','/ebooking/images/ThemeOffice/users.png','/ebooking/base/list_customer.jspa','main','tooltip.list_customers','menu_customer_add');
INSERT INTO `core_menu_item` (`ID`,`MENU_ITEM_INDEX`,`MENU_ITEM_KEY`,`IMAGE_PATH`,`LINK`,`TARGET`,`TOOLTIP`,`PARENT`) VALUES (7,2,'menu_some_customer_list','/ebooking/images/ThemeOffice/users.png','/ebooking/base/list_customer.jspa','main','tooltip.list_customers','menu_customer_add');
INSERT INTO `core_menu_item` (`ID`,`MENU_ITEM_INDEX`,`MENU_ITEM_KEY`,`IMAGE_PATH`,`LINK`,`TARGET`,`TOOLTIP`,`PARENT`) VALUES (8,1,'menu_test',NULL,NULL,NULL,NULL,'menu_all_customer_list');

#
# Dumping data for table core_menu_to_menu_item
#

INSERT INTO `core_menu_to_menu_item` (`MENU_KEY`,`MENU_ITEM_ID`) VALUES ('default_user',2);
INSERT INTO `core_menu_to_menu_item` (`MENU_KEY`,`MENU_ITEM_ID`) VALUES ('system_admin',1);
INSERT INTO `core_menu_to_menu_item` (`MENU_KEY`,`MENU_ITEM_ID`) VALUES ('system_admin',2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
