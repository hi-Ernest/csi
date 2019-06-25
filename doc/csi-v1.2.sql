/*
Navicat MySQL Data Transfer

Source Server         : cqut
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : csi

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-06-25 21:43:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept_inf
-- ----------------------------
DROP TABLE IF EXISTS `dept_inf`;
CREATE TABLE `dept_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'NAME部门名称',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'NAME部门名称',
  `remake` varchar(300) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'REMARK详细信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for document_inf
-- ----------------------------
DROP TABLE IF EXISTS `document_inf`;
CREATE TABLE `document_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'TITLE标题',
  `file_name` varchar(300) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Filename文件名称',
  `remake` varchar(300) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'REMARK描述',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'CREATE_DATE创建时间',
  `user_id` int(11) DEFAULT NULL COMMENT 'USER_ID创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for employee_inf
-- ----------------------------
DROP TABLE IF EXISTS `employee_inf`;
CREATE TABLE `employee_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) DEFAULT NULL COMMENT 'DEPT_ID部门主键',
  `job_id` int(11) DEFAULT NULL COMMENT 'JOB_ID职位主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'NAME名字',
  `card_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'CARD_ID身份证',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'ADDRESS住址',
  `post_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'POST_CODE邮编',
  `tel` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'TEL电话',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'PHONE手机',
  `qq_num` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'QQ_NUM qq号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'EMAIL电子邮件',
  `sex` int(11) DEFAULT NULL COMMENT 'SEX 性别 1男 2女',
  `party` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'PARTY 政治面貌',
  `birthday` timestamp NULL DEFAULT NULL COMMENT 'BIRTHDAY出生日期',
  `race` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'RACE民族',
  `education` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'EDUCATION学历',
  `speciality` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'SPECIALITY专业',
  `hobby` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'HOBBY特长',
  `remake` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'REMARK备注',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'CREATE_DATE创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for facekey_inf
-- ----------------------------
DROP TABLE IF EXISTS `facekey_inf`;
CREATE TABLE `facekey_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '百度语音合成所需要的appID',
  `api_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '百度语音合成所需要的apiKey',
  `secret_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '百度语音合成所需要的secretKey',
  `threshold` int(3) DEFAULT NULL COMMENT '人脸对比阀值 threshold',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for job_inf
-- ----------------------------
DROP TABLE IF EXISTS `job_inf`;
CREATE TABLE `job_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'NAME职位名称',
  `remake` varchar(300) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'REMARK详细信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for notice_inf
-- ----------------------------
DROP TABLE IF EXISTS `notice_inf`;
CREATE TABLE `notice_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'TITLE公告名称',
  `content` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'CONTENT公告内容',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'CREATE_DATE创建时间',
  `user_id` int(11) DEFAULT NULL COMMENT 'USER_ID公告人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for user_inf
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Loginname 登录名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'PASSWORD 密码',
  `status` int(11) DEFAULT NULL COMMENT 'STATUS权限状态 1管理员，2用户',
  `create_date` timestamp NULL DEFAULT NULL COMMENT 'Createdate 创建时间',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Username 用户名',
  `face_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Faceurl 注册人脸图片访问地址',
  `face_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Facepath 注册人脸图片存储路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
