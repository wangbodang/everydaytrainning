/*
SQLyog Ultimate v11.42 (64 bit)
MySQL - 5.7.23-log : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `hiredatePeriod` varchar(6) DEFAULT NULL,
  `remark` varchar(150) DEFAULT NULL,
  `summary` varchar(150) DEFAULT NULL,
  `decimalNumber` decimal(20,6) DEFAULT NULL,
  `idcard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `birthday` varchar(10) DEFAULT NULL,
  `gendercn` varchar(1) DEFAULT NULL COMMENT '性别',
  `officedate` varchar(10) DEFAULT NULL COMMENT '入职日期',
  `testdate` varchar(10) DEFAULT NULL COMMENT '测试数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11023 DEFAULT CHARSET=utf8 COMMENT='Emp 测试表';

/*Data for the table `employee` */

insert  into `employee`(`id`,`name`,`age`,`gender`,`salary`,`hiredate`,`hiredatePeriod`,`remark`,`summary`,`decimalNumber`,`idcard`,`birthday`,`gendercn`,`officedate`,`testdate`) values (11001,'wangbodang',37,'M',54455.89,NULL,NULL,NULL,'0',NULL,'411082198104272413','1981-04-27','男',NULL,'2015-01-12'),(11002,'xieyingdeng',36,'M',234243.23,'2018-07-04','201807','TonyStarkOper03','0',NULL,'',NULL,'男',NULL,'2014-2-9'),(11003,'qiguoyuan',35,'M',989898.23,'2017-03-25','201703','TonyStark02Oper03','',NULL,'411082198104272473','1981-04-27','男',NULL,'2013-2-05'),(11004,'lirugui',23,'M',2324234.34,NULL,NULL,NULL,NULL,NULL,'411082198104272423','1981-04-27','女',NULL,'2013-05-2'),(11005,'李白',22,'M',213.23,NULL,NULL,NULL,NULL,'100.230000','411082198104272483','1981-04-27','女',NULL,NULL),(11006,'柳如是',18,'F',239842.34,NULL,NULL,NULL,NULL,NULL,'',NULL,'女',NULL,NULL),(11007,'李师师',21,'X',9893.34,NULL,NULL,NULL,NULL,NULL,'',NULL,'男',NULL,NULL),(11009,'杜十娘',31,'F',32323.23,NULL,NULL,NULL,NULL,NULL,'',NULL,'女',NULL,NULL),(11010,'李清照',23,'F',893233.34,NULL,NULL,'11',NULL,NULL,'',NULL,'男',NULL,NULL),(11011,'梁红玉',35,'F',8989.34,NULL,NULL,NULL,NULL,NULL,'',NULL,'男',NULL,NULL),(11021,'孙承宗',39,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
