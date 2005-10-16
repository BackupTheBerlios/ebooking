alter table BASE_PERSON drop foreign key FKA963708382CB5F37;
alter table BASE_SYSTEM_COUNTY drop foreign key FK1168E86C6CEDCC24;
alter table BOOKING drop foreign key FK2EA6943991E91E4A;
alter table BOOKING_ITEM drop foreign key FKFCF753595029D9;
alter table BOOKING_ITEM drop foreign key FKFCF753599D2D8950;
alter table BOOKING_SYSTEM_ROOM_TO_ROOM_TYPE drop foreign key FK3796AF743D85E06F;
alter table BOOKING_SYSTEM_ROOM_TO_ROOM_TYPE drop foreign key FK3796AF74A20963B8;
drop table if exists BASE_ADDRESS;
drop table if exists BASE_PERSON;
drop table if exists BASE_SYSTEM_ACADEMIC_TITLE;
drop table if exists BASE_SYSTEM_ARTICLE;
drop table if exists BASE_SYSTEM_ARTICLE_DESCRIPTION;
drop table if exists BASE_SYSTEM_ARTICLE_TO_UNIT_PLURAL;
drop table if exists BASE_SYSTEM_ARTICLE_TO_UNIT_SINGULAR;
drop table if exists BASE_SYSTEM_COUNTRY;
drop table if exists BASE_SYSTEM_COUNTY;
drop table if exists BASE_SYSTEM_LOCALE;
drop table if exists BASE_SYSTEM_TITLE;
drop table if exists BASE_SYSTEM_UNIT;
drop table if exists BASE_SYSTEM_USER;
drop table if exists BOOKING;
drop table if exists BOOKING_ITEM;
drop table if exists BOOKING_SYSTEM_ROOM;
drop table if exists BOOKING_SYSTEM_ROOM_TO_ROOM_TYPE;
drop table if exists BOOKING_SYSTEM_ROOM_TYPE;
drop table if exists CORE_MENU;
drop table if exists CORE_MENU_ITEM;
drop table if exists CORE_MENU_ITEM_AUTHORIZATION;
drop table if exists CORE_MENU_TO_MENU_ITEM;
create table BASE_ADDRESS (
   ID bigint not null,
   STREET varchar(100),
   ZIPCODE varchar(25),
   CITY varchar(100),
   COUNTY_KEY varchar(100),
   COUNTRY_KEY varchar(100),
   POSTAL_NAME varchar(100),
   DEPARTMENT varchar(150),
   PHONE1 varchar(100),
   PHONE2 varchar(100),
   FAX varchar(100),
   MOBILE_PHONE varchar(100),
   EMAIL varchar(100),
   WWW varchar(150),
   primary key (ID)
) type=InnoDB;
create table BASE_PERSON (
   ID bigint not null,
   TITLE_KEY varchar(255),
   ACADEMIC_TITLE_KEY varchar(255),
   FIRSTNAME varchar(255),
   LASTNAME varchar(255),
   IDENTIFICATION_NUMBER varchar(255),
   ADDRESS_ID bigint,
   primary key (ID)
) type=InnoDB;
create table BASE_SYSTEM_ACADEMIC_TITLE (
   ID bigint not null,
   ACADEMIC_TITLE_KEY varchar(100) not null,
   NAME varchar(100) not null,
   SYSTEM_LOCALE_KEY varchar(255) not null,
   primary key (ID)
) type=InnoDB;
create table BASE_SYSTEM_ARTICLE (
   ID bigint not null,
   ARTICLE_KEY varchar(100) not null,
   PRICE float,
   VAT_INCLUDED bit not null,
   primary key (ID)
) type=InnoDB;
create table BASE_SYSTEM_ARTICLE_DESCRIPTION (
   ID bigint not null,
   DESCRIPTION text,
   LOCALE_KEY varchar(255),
   ARTICLE_KEY varchar(255),
   primary key (ID)
) type=InnoDB;
create table BASE_SYSTEM_ARTICLE_TO_UNIT_PLURAL (
   ARTICLE_KEY varchar(255) not null,
   UNIT_ID bigint not null,
   primary key (ARTICLE_KEY, UNIT_ID)
) type=InnoDB;
create table BASE_SYSTEM_ARTICLE_TO_UNIT_SINGULAR (
   ARTICLE_KEY varchar(255) not null,
   UNIT_ID bigint not null,
   primary key (ARTICLE_KEY, UNIT_ID)
) type=InnoDB;
create table BASE_SYSTEM_COUNTRY (
   ID bigint not null,
   COUNTRY_KEY varchar(100) not null,
   NAME varchar(100) not null,
   SYSTEM_LOCALE_KEY varchar(255) not null,
   primary key (ID)
) type=InnoDB;
create table BASE_SYSTEM_COUNTY (
   ID bigint not null,
   COUNTY_KEY varchar(100) not null,
   NAME varchar(100) not null,
   COUNTRY_ID bigint,
   primary key (ID)
) type=InnoDB;
create table BASE_SYSTEM_LOCALE (
   ID bigint not null,
   LOCALE_KEY varchar(255) not null,
   LANGUAGE varchar(255) not null,
   COUNTRY_NAME varchar(255) not null,
   primary key (ID)
) type=InnoDB;
create table BASE_SYSTEM_TITLE (
   ID bigint not null,
   TITLE_KEY varchar(100) not null,
   NAME varchar(100) not null,
   SYSTEM_LOCALE_KEY varchar(255) not null,
   primary key (ID)
) type=InnoDB;
create table BASE_SYSTEM_UNIT (
   ID bigint not null,
   UNIT_KEY varchar(100) not null,
   NAME varchar(100) not null,
   SYSTEM_LOCALE_KEY varchar(255) not null,
   primary key (ID)
) type=InnoDB;
create table BASE_SYSTEM_USER (
   ID bigint not null,
   LOGIN_ID varchar(25) not null unique,
   PASSWORD varchar(255) not null,
   LOCKED bit not null,
   PASSWORD_FAILED integer not null,
   primary key (ID)
) type=InnoDB;
create table BOOKING (
   ID bigint not null,
   PERSON_ID bigint,
   primary key (ID)
) type=InnoDB;
create table BOOKING_ITEM (
   ID bigint not null,
   FROM_DATE date not null,
   TO_DATE date not null,
   AMOUNT float not null,
   UNIT_ID bigint,
   DESCRIPTION text,
   PRICE float not null,
   BOOKING_ID bigint not null,
   primary key (ID)
) type=InnoDB;
create table BOOKING_SYSTEM_ROOM (
   ID bigint not null,
   ROOM_KEY varchar(50) not null,
   DESCRIPTION text not null,
   PRICE float not null,
   BED_AMOUNT integer not null,
   primary key (ID)
) type=InnoDB;
create table BOOKING_SYSTEM_ROOM_TO_ROOM_TYPE (
   ROOM_ID bigint not null,
   ROOM_TYPE_ID bigint not null,
   primary key (ROOM_TYPE_ID, ROOM_ID)
) type=InnoDB;
create table BOOKING_SYSTEM_ROOM_TYPE (
   ID bigint not null,
   ROOM_TYPE_KEY varchar(50) not null,
   LOCALE_KEY varchar(255),
   primary key (ID)
) type=InnoDB;
create table CORE_MENU (
   ID bigint not null,
   MENU_KEY varchar(50),
   primary key (ID)
) type=InnoDB;
create table CORE_MENU_ITEM (
   ID bigint not null,
   MENU_ITEM_INDEX integer,
   MENU_ITEM_KEY varchar(50),
   IMAGE_PATH varchar(255),
   LINK varchar(255),
   TARGET varchar(255),
   TOOLTIP varchar(255),
   PARENT varchar(255),
   primary key (ID)
) type=InnoDB;
create table CORE_MENU_ITEM_AUTHORIZATION (
   ID bigint not null,
   USER_ROLE varchar(255),
   MENU_ITEM_KEY varchar(255) not null,
   primary key (ID)
) type=InnoDB;
create table CORE_MENU_TO_MENU_ITEM (
   MENU_KEY varchar(255) not null,
   MENU_ITEM_ID bigint not null,
   primary key (MENU_KEY, MENU_ITEM_ID)
) type=InnoDB;
alter table BASE_PERSON add index FKA963708382CB5F37 (ADDRESS_ID), add constraint FKA963708382CB5F37 foreign key (ADDRESS_ID) references BASE_ADDRESS (ID);
alter table BASE_SYSTEM_COUNTY add index FK1168E86C6CEDCC24 (COUNTRY_ID), add constraint FK1168E86C6CEDCC24 foreign key (COUNTRY_ID) references BASE_SYSTEM_COUNTRY (ID);
alter table BOOKING add index FK2EA6943991E91E4A (PERSON_ID), add constraint FK2EA6943991E91E4A foreign key (PERSON_ID) references BASE_PERSON (ID);
alter table BOOKING_ITEM add index FKFCF753595029D9 (BOOKING_ID), add constraint FKFCF753595029D9 foreign key (BOOKING_ID) references BOOKING (ID);
alter table BOOKING_ITEM add index FKFCF753599D2D8950 (UNIT_ID), add constraint FKFCF753599D2D8950 foreign key (UNIT_ID) references BASE_SYSTEM_UNIT (ID);
alter table BOOKING_SYSTEM_ROOM_TO_ROOM_TYPE add index FK3796AF743D85E06F (ROOM_TYPE_ID), add constraint FK3796AF743D85E06F foreign key (ROOM_TYPE_ID) references BOOKING_SYSTEM_ROOM_TYPE (ID);
alter table BOOKING_SYSTEM_ROOM_TO_ROOM_TYPE add index FK3796AF74A20963B8 (ROOM_ID), add constraint FK3796AF74A20963B8 foreign key (ROOM_ID) references BOOKING_SYSTEM_ROOM (ID);
