/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80000
Source Host           : localhost:3306
Source Database       : traval

Target Server Type    : MYSQL
Target Server Version : 80000
File Encoding         : 65001

Date: 2017-06-25 14:07:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `friend`
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `user` int(20) NOT NULL,
  `friend` int(20) NOT NULL,
  PRIMARY KEY (`user`,`friend`),
  KEY `friendslate` (`friend`),
  CONSTRAINT `friendslate` FOREIGN KEY (`friend`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userlate` FOREIGN KEY (`user`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `history`
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `userid` int(10) NOT NULL,
  `recentspot` varchar(20) DEFAULT NULL,
  `recentscene` varchar(20) DEFAULT NULL,
  `time` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `recentspot` (`recentspot`),
  KEY `recentscene` (`recentscene`),
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `history_ibfk_2` FOREIGN KEY (`recentspot`) REFERENCES `spot` (`point`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `history_ibfk_3` FOREIGN KEY (`recentscene`) REFERENCES `scene` (`sceneid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history
-- ----------------------------

-- ----------------------------
-- Table structure for `scene`
-- ----------------------------
DROP TABLE IF EXISTS `scene`;
CREATE TABLE `scene` (
  `sceneid` varchar(20) NOT NULL,
  `city` varchar(20) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`sceneid`),
  KEY `city` (`city`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scene
-- ----------------------------

-- ----------------------------
-- Table structure for `spot`
-- ----------------------------
DROP TABLE IF EXISTS `spot`;
CREATE TABLE `spot` (
  `point` varchar(20) NOT NULL,
  `sceneid` varchar(20) NOT NULL,
  `spotname` varchar(40) NOT NULL,
  `scenename` varchar(40) NOT NULL,
  `city` varchar(20) NOT NULL,
  PRIMARY KEY (`point`,`sceneid`),
  KEY `sceneid` (`sceneid`),
  KEY `city` (`city`),
  KEY `scenename` (`scenename`),
  KEY `point` (`point`),
  CONSTRAINT `spot_ibfk_1` FOREIGN KEY (`sceneid`) REFERENCES `scene` (`sceneid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `spot_ibfk_2` FOREIGN KEY (`city`) REFERENCES `scene` (`city`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `spot_ibfk_3` FOREIGN KEY (`scenename`) REFERENCES `scene` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spot
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(10) NOT NULL,
  `identyid` char(18) NOT NULL,
  `nickname` varchar(10) DEFAULT NULL,
  `realname` varchar(10) NOT NULL,
  `point` int(5) NOT NULL,
  `passwar` varchar(15) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2102811', 'a', 'A', '0', '');
INSERT INTO `user` VALUES ('2', '210281199612030817', 'b', 'B', '0', '');
