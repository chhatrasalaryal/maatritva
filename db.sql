/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - db_matritva
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `db_matritva`;

USE `db_matritva`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`id`,`name`,`password`) values (1,'admin','1234');

/*Table structure for table `m_finaltemp` */

DROP TABLE IF EXISTS `m_finaltemp`;

CREATE TABLE `m_finaltemp` (
  `q_no` int(10) default NULL,
  `user_id` varchar(20) default NULL,
  `user_question` varchar(1000) default NULL,
  `user_type` varchar(100) default NULL,
  `expert_id` varchar(100) default NULL,
  `expert_answer` varchar(1000) default NULL,
  `key_word` varchar(40000) default NULL,
  `total` int(20) default NULL,
  `key_rank` int(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_finaltemp` */

insert into `m_finaltemp` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (10,'shalini','cannot walk during mine months','gyano','1','null','months-during-mine-walk-',4,25);

/*Table structure for table `m_gyano` */

DROP TABLE IF EXISTS `m_gyano`;

CREATE TABLE `m_gyano` (
  `g_code` int(10) NOT NULL auto_increment,
  `g_name` varchar(40) default NULL,
  `g_age` varchar(30) default NULL,
  `g_city` varchar(50) default NULL,
  `g_state` varchar(40) default NULL,
  `g_sex` varchar(20) default NULL,
  `g_spec` varchar(200) default NULL,
  `g_mail` varchar(50) default NULL,
  `g_cell` varchar(50) default NULL,
  `g_star` varchar(50) default NULL,
  `g_image` varchar(50) default NULL,
  `g_id` varchar(50) default NULL,
  `g_pass` varchar(50) default NULL,
  PRIMARY KEY  (`g_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_gyano` */

insert into `m_gyano` (`g_code`,`g_name`,`g_age`,`g_city`,`g_state`,`g_sex`,`g_spec`,`g_mail`,`g_cell`,`g_star`,`g_image`,`g_id`,`g_pass`) values (1,'vnu','40','hassan','karnataka','male','MBBS  female','vini@gmail.com','9080779999','1','Chrysanthemum.jpg','vnu','vnu');
insert into `m_gyano` (`g_code`,`g_name`,`g_age`,`g_city`,`g_state`,`g_sex`,`g_spec`,`g_mail`,`g_cell`,`g_star`,`g_image`,`g_id`,`g_pass`) values (2,'hh','hh','hh','hh','female','888','ss@gmail.com','9898989898','3','1.jpg','shanuhh','fgh');

/*Table structure for table `m_gyanoratings` */

DROP TABLE IF EXISTS `m_gyanoratings`;

CREATE TABLE `m_gyanoratings` (
  `t_no` int(10) NOT NULL auto_increment,
  `u_id` varchar(100) default NULL,
  `g_id` varchar(100) default NULL,
  `ratings` varchar(100) default NULL,
  PRIMARY KEY  (`t_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_gyanoratings` */

insert into `m_gyanoratings` (`t_no`,`u_id`,`g_id`,`ratings`) values (1,'shalini','1','2');
insert into `m_gyanoratings` (`t_no`,`u_id`,`g_id`,`ratings`) values (2,'shalini','1','3');

/*Table structure for table `m_questions` */

DROP TABLE IF EXISTS `m_questions`;

CREATE TABLE `m_questions` (
  `q_no` int(10) NOT NULL auto_increment,
  `user_id` varchar(20) default NULL,
  `user_question` varchar(1000) default NULL,
  `user_type` varchar(100) default NULL,
  `expert_id` varchar(100) default NULL,
  `expert_answer` varchar(1000) default NULL,
  `key_word` varchar(40000) default NULL,
  `total` int(20) default NULL,
  `key_rank` int(100) default NULL,
  PRIMARY KEY  (`q_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_questions` */

insert into `m_questions` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (1,'shalini','what is the reason behind abortion during three months of pregnancy','users','1','shanu because of excess of heat','months-during-reason-what-pregnancy-abortion-three-behind-',8,50);
insert into `m_questions` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (2,'shalini','what is reason for walk back during pregnant','users','1','because if baby weight','during-reason-what-pregnant-pain-back-',6,16);
insert into `m_questions` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (3,'shalini','what is the reason behind giddyness','users','1','shanu because of excess of heat heat','giddyness-reason-what-behind-',4,25);
insert into `m_questions` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (4,'shalini','what is the reason behind giddyness','gyano','1','stomach ache head pain','giddyness-reason-what-behind-',4,25);
insert into `m_questions` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (5,'shalini','what is the reason behind giddynes','gyano','1','eat more fruits','giddyness-reason-what-behind-',4,25);
insert into `m_questions` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (7,'shalini','what is the reason behind giddyness','gyano','1','shanu vinith','giddyness-reason-what-behind-',4,25);
insert into `m_questions` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (8,'shalini','what is the reason behing leg swallowing','users','1','walk daily','swallowing-leg-reason-what-behing-',5,NULL);
insert into `m_questions` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (9,'shalini','reason behind excess of heat','users','1','sddd','reason-excess-behind-heat-',4,NULL);
insert into `m_questions` (`q_no`,`user_id`,`user_question`,`user_type`,`expert_id`,`expert_answer`,`key_word`,`total`,`key_rank`) values (10,'shalini','cannot walk during mine months','gyano','1','am','months-during-mine-walk-',4,25);

/*Table structure for table `m_temp` */

DROP TABLE IF EXISTS `m_temp`;

CREATE TABLE `m_temp` (
  `q_no` int(10) default NULL,
  `u_id` varchar(100) default NULL,
  `keyrank` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_temp` */

insert into `m_temp` (`q_no`,`u_id`,`keyrank`) values (10,'shalini','25');

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_code` int(11) NOT NULL auto_increment,
  `user_id` varchar(30) default NULL,
  `user_pass` varchar(30) default NULL,
  `user_name` varchar(30) default NULL,
  `user_age` varchar(10) default NULL,
  `user_city` varchar(30) default NULL,
  `user_state` varchar(30) default NULL,
  `user_gyna` varchar(30) default NULL,
  `user_sex` varchar(10) default NULL,
  `user_pstatus` varchar(20) default NULL,
  `user_problem` varchar(500) default NULL,
  `user_email` varchar(50) default NULL,
  `user_cell` varchar(20) default NULL,
  PRIMARY KEY  (`u_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_code`,`user_id`,`user_pass`,`user_name`,`user_age`,`user_city`,`user_state`,`user_gyna`,`user_sex`,`user_pstatus`,`user_problem`,`user_email`,`user_cell`) values (1,'shalini','shalini123','shalini gowda','26','bangalore','karnataka','1','male','yes','vomitting sesation everyday,severe head ache','shanu@gmail.com','9878668866');

/*Table structure for table `t_count` */

DROP TABLE IF EXISTS `t_count`;

CREATE TABLE `t_count` (
  `t_no` int(20) default NULL,
  `u_id` varchar(50) default NULL,
  `key_word` varchar(50) default NULL,
  `weightage` int(10) default NULL,
  `key_rank` varchar(200) default NULL,
  KEY `FK_t_count` (`t_no`),
  CONSTRAINT `t_count_ibfk_1` FOREIGN KEY (`t_no`) REFERENCES `m_questions` (`q_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_count` */

insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (1,'shalini','months',1,'12.5');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (1,'shalini','during',1,'12.5');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (1,'shalini','reason',1,'12.5');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (1,'shalini','what',1,'12.5');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (1,'shalini','pregnancy',1,'12.5');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (1,'shalini','abortion',1,'12.5');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (1,'shalini','three',1,'12.5');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (1,'shalini','behind',1,'12.5');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (2,'shalini','during',1,'16.67');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (2,'shalini','reason',1,'16.67');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (2,'shalini','what',1,'16.67');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (2,'shalini','pregnant',1,'16.67');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (2,'shalini','pain',1,'16.67');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (2,'shalini','back',1,'16.67');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (3,'shalini','giddyness',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (3,'shalini','reason',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (3,'shalini','what',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (3,'shalini','behind',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (4,'shalini','giddyness',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (4,'shalini','reason',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (4,'shalini','what',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (4,'shalini','behind',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (5,'shalini','giddyness',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (5,'shalini','reason',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (5,'shalini','what',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (5,'shalini','behind',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (7,'shalini','giddyness',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (7,'shalini','reason',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (7,'shalini','what',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (7,'shalini','behind',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (8,'null','swallowing',1,'20');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (8,'null','leg',1,'20');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (8,'null','reason',1,'20');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (8,'null','what',1,'20');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (8,'null','behing',1,'20');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (9,'shalini','reason',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (9,'shalini','excess',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (9,'shalini','behind',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (9,'shalini','heat',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (10,'shalini','months',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (10,'shalini','during',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (10,'shalini','mine',1,'25');
insert into `t_count` (`t_no`,`u_id`,`key_word`,`weightage`,`key_rank`) values (10,'shalini','walk',1,'25');

/*Table structure for table `t_word` */

DROP TABLE IF EXISTS `t_word`;

CREATE TABLE `t_word` (
  `f_code` int(10) NOT NULL auto_increment,
  `f_word` varchar(30) default NULL,
  PRIMARY KEY  (`f_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_word` */

insert into `t_word` (`f_code`,`f_word`) values (1,'is');
insert into `t_word` (`f_code`,`f_word`) values (2,'was');
insert into `t_word` (`f_code`,`f_word`) values (3,'that');
insert into `t_word` (`f_code`,`f_word`) values (4,'this');
insert into `t_word` (`f_code`,`f_word`) values (5,'where');
insert into `t_word` (`f_code`,`f_word`) values (6,'the');
insert into `t_word` (`f_code`,`f_word`) values (7,'am');
insert into `t_word` (`f_code`,`f_word`) values (8,'he');
insert into `t_word` (`f_code`,`f_word`) values (9,'she');
insert into `t_word` (`f_code`,`f_word`) values (10,'it');
insert into `t_word` (`f_code`,`f_word`) values (11,'they');
insert into `t_word` (`f_code`,`f_word`) values (12,'hello');
insert into `t_word` (`f_code`,`f_word`) values (13,'are');
insert into `t_word` (`f_code`,`f_word`) values (14,'how');
insert into `t_word` (`f_code`,`f_word`) values (15,'you');
insert into `t_word` (`f_code`,`f_word`) values (17,'where');
insert into `t_word` (`f_code`,`f_word`) values (18,'short');
insert into `t_word` (`f_code`,`f_word`) values (19,'tall');
insert into `t_word` (`f_code`,`f_word`) values (20,'big');
insert into `t_word` (`f_code`,`f_word`) values (21,'with');
insert into `t_word` (`f_code`,`f_word`) values (22,'all');
insert into `t_word` (`f_code`,`f_word`) values (23,'etc');
insert into `t_word` (`f_code`,`f_word`) values (24,'see');
insert into `t_word` (`f_code`,`f_word`) values (25,'saw');
insert into `t_word` (`f_code`,`f_word`) values (26,'my');
insert into `t_word` (`f_code`,`f_word`) values (27,'am');
insert into `t_word` (`f_code`,`f_word`) values (28,'i');
insert into `t_word` (`f_code`,`f_word`) values (29,'do');
insert into `t_word` (`f_code`,`f_word`) values (30,'was');
insert into `t_word` (`f_code`,`f_word`) values (31,'is');
insert into `t_word` (`f_code`,`f_word`) values (32,'not');
insert into `t_word` (`f_code`,`f_word`) values (33,'nor');
insert into `t_word` (`f_code`,`f_word`) values (34,'either');
insert into `t_word` (`f_code`,`f_word`) values (35,'neither');
insert into `t_word` (`f_code`,`f_word`) values (36,'that');
insert into `t_word` (`f_code`,`f_word`) values (37,'over');
insert into `t_word` (`f_code`,`f_word`) values (38,'out');
insert into `t_word` (`f_code`,`f_word`) values (39,'keep');
insert into `t_word` (`f_code`,`f_word`) values (40,'and');
insert into `t_word` (`f_code`,`f_word`) values (41,'from');
insert into `t_word` (`f_code`,`f_word`) values (42,'form');
insert into `t_word` (`f_code`,`f_word`) values (43,'full');
insert into `t_word` (`f_code`,`f_word`) values (44,'the');
insert into `t_word` (`f_code`,`f_word`) values (45,'off');
insert into `t_word` (`f_code`,`f_word`) values (46,'an');
insert into `t_word` (`f_code`,`f_word`) values (47,'or');
insert into `t_word` (`f_code`,`f_word`) values (48,'had');
insert into `t_word` (`f_code`,`f_word`) values (49,'as');
insert into `t_word` (`f_code`,`f_word`) values (50,'to');
insert into `t_word` (`f_code`,`f_word`) values (51,'him');
insert into `t_word` (`f_code`,`f_word`) values (52,'self');
insert into `t_word` (`f_code`,`f_word`) values (53,'data');
insert into `t_word` (`f_code`,`f_word`) values (54,'bad');
insert into `t_word` (`f_code`,`f_word`) values (55,'free');
insert into `t_word` (`f_code`,`f_word`) values (56,'could');
insert into `t_word` (`f_code`,`f_word`) values (57,'can');
insert into `t_word` (`f_code`,`f_word`) values (58,'shall');
insert into `t_word` (`f_code`,`f_word`) values (59,'should');
insert into `t_word` (`f_code`,`f_word`) values (60,'kept');
insert into `t_word` (`f_code`,`f_word`) values (61,'also');
insert into `t_word` (`f_code`,`f_word`) values (62,'on');
insert into `t_word` (`f_code`,`f_word`) values (63,'down');
insert into `t_word` (`f_code`,`f_word`) values (64,'have');
insert into `t_word` (`f_code`,`f_word`) values (65,'has');
insert into `t_word` (`f_code`,`f_word`) values (66,'one');
insert into `t_word` (`f_code`,`f_word`) values (67,'only');
insert into `t_word` (`f_code`,`f_word`) values (68,'in');
insert into `t_word` (`f_code`,`f_word`) values (69,'therefore');
insert into `t_word` (`f_code`,`f_word`) values (70,'then');
insert into `t_word` (`f_code`,`f_word`) values (71,'take');
insert into `t_word` (`f_code`,`f_word`) values (72,'took');
insert into `t_word` (`f_code`,`f_word`) values (73,'need');
insert into `t_word` (`f_code`,`f_word`) values (74,'we');
insert into `t_word` (`f_code`,`f_word`) values (75,'you');
insert into `t_word` (`f_code`,`f_word`) values (76,'yours');
insert into `t_word` (`f_code`,`f_word`) values (77,'one');
insert into `t_word` (`f_code`,`f_word`) values (78,'your');
insert into `t_word` (`f_code`,`f_word`) values (79,'a');
insert into `t_word` (`f_code`,`f_word`) values (80,'be');
insert into `t_word` (`f_code`,`f_word`) values (81,'being');
insert into `t_word` (`f_code`,`f_word`) values (82,'because');
insert into `t_word` (`f_code`,`f_word`) values (83,'cannot');
insert into `t_word` (`f_code`,`f_word`) values (84,'would');
insert into `t_word` (`f_code`,`f_word`) values (85,'not');
insert into `t_word` (`f_code`,`f_word`) values (86,'for');
insert into `t_word` (`f_code`,`f_word`) values (87,'off');
insert into `t_word` (`f_code`,`f_word`) values (88,'of');
insert into `t_word` (`f_code`,`f_word`) values (89,'soon');
insert into `t_word` (`f_code`,`f_word`) values (90,'nothing');
insert into `t_word` (`f_code`,`f_word`) values (91,'top');
insert into `t_word` (`f_code`,`f_word`) values (92,'bottom');
insert into `t_word` (`f_code`,`f_word`) values (93,'down');
insert into `t_word` (`f_code`,`f_word`) values (94,'up');
insert into `t_word` (`f_code`,`f_word`) values (95,'list');
insert into `t_word` (`f_code`,`f_word`) values (96,'start');
insert into `t_word` (`f_code`,`f_word`) values (97,'stop');
insert into `t_word` (`f_code`,`f_word`) values (98,'how');
insert into `t_word` (`f_code`,`f_word`) values (99,'see');
insert into `t_word` (`f_code`,`f_word`) values (100,'sea');
insert into `t_word` (`f_code`,`f_word`) values (101,'these');
insert into `t_word` (`f_code`,`f_word`) values (102,'this');
insert into `t_word` (`f_code`,`f_word`) values (103,'if');
insert into `t_word` (`f_code`,`f_word`) values (104,'else');
insert into `t_word` (`f_code`,`f_word`) values (105,'much');
insert into `t_word` (`f_code`,`f_word`) values (106,'more');
insert into `t_word` (`f_code`,`f_word`) values (107,'most');
insert into `t_word` (`f_code`,`f_word`) values (108,'give');
insert into `t_word` (`f_code`,`f_word`) values (109,'gave');
insert into `t_word` (`f_code`,`f_word`) values (110,'given');
insert into `t_word` (`f_code`,`f_word`) values (111,'bangalore');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
