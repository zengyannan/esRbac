/*
Navicat MySQL Data Transfer

Source Server         : emp
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : es_rbac

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-04-10 16:43:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(36) NOT NULL COMMENT '唯一id标识 uuid或者拼音标识',
  `admin_name` varchar(36) NOT NULL COMMENT '用户名',
  `admin_nickname` varchar(36) DEFAULT NULL COMMENT '昵称',
  `admin_password` varchar(36) DEFAULT NULL COMMENT '密码',
  `admin_createtime` bigint(4) NOT NULL COMMENT '创建日期',
  `admin_modifytime` bigint(4) NOT NULL COMMENT '修改时间',
  `admin_email` varchar(100) DEFAULT NULL COMMENT '用户电子邮件',
  `admin_tel` varchar(13) DEFAULT NULL COMMENT '手机号码',
  `admin_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `admin_role_id` varchar(36) DEFAULT NULL COMMENT '用户角色id标识',
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_unique` (`admin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('0', 'admin', '管理员', 'admin', '1458372647', '1458372647', null, null, '1', '1');
INSERT INTO `admin` VALUES ('1', 'fk1', '访客1', '123', '1458372647', '1458372647', null, null, '1', '2');
INSERT INTO `admin` VALUES ('12F26129-DC5F-55F9-4068-E7862BF88D47', 'maomao1', '毛毛', '123456', '1460431161', '1460431161', null, null, '1', '3');
INSERT INTO `admin` VALUES ('13254DBD-5A09-699B-B182-D6460B9D3837', 'AD22', '222', '111111', '1461020457', '1461020457', null, null, '1', '3');
INSERT INTO `admin` VALUES ('2A36745C-EAAE-5E3A-A56F-2F3D9D166129', 'sssss', null, '123456', '1460431506', '1460431506', null, null, '0', '2');
INSERT INTO `admin` VALUES ('674FBA1D-C96D-0340-9418-BBBB4E70297D', 'qqqqqq', null, '123456', '1460431471', '1460431471', null, null, '0', '2');
INSERT INTO `admin` VALUES ('68E73127-BF31-DFB4-7759-1DA34EA3A695', 'laixin', '', '123456', '1460432070', '1460432070', null, null, '0', '1');
INSERT INTO `admin` VALUES ('917A68A6-DF84-951E-35B3-46C7959D6A9A', 'maomao', null, '12345', '1458379958', '1458379958', null, null, '0', '2');
INSERT INTO `admin` VALUES ('DC1500C5-E754-6151-1D64-15E3EFC11697', 'sss111', null, '123456', '1460431567', '1460431567', null, null, '0', '2');
INSERT INTO `admin` VALUES ('FD62A1A6-98F4-7B4B-7EB9-556AEA2869BC', 'x1x1', null, '123456', '1460455538', '1460455538', null, null, '0', '2');

-- ----------------------------
-- Table structure for `auth`
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth` (
  `auth_id` int(4) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(36) NOT NULL COMMENT '权限名称',
  `auth_pid` int(4) NOT NULL COMMENT '父id',
  `auth_c` varchar(36) DEFAULT '' COMMENT '模块',
  `auth_a` varchar(36) DEFAULT '' COMMENT '操作',
  `auth_path` varchar(36) DEFAULT '' COMMENT '全路径',
  `auth_url` varchar(500) DEFAULT NULL COMMENT '模块操作访问路径',
  `auth_level` tinyint(4) DEFAULT '0' COMMENT '级别',
  `auth_state` tinyint(4) DEFAULT '1' COMMENT '权限状态',
  `auth_createtime` bigint(4) unsigned NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`auth_id`),
  UNIQUE KEY `auth_name_unique` (`auth_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth
-- ----------------------------
INSERT INTO `auth` VALUES ('1', '系统目录', '0', '', '', '', '', '1', '1', '1458372647');
INSERT INTO `auth` VALUES ('2', '系统管理', '1', '', '', '', '', '2', '1', '1458372647');
INSERT INTO `auth` VALUES ('3', '用户管理', '2', 'Manage', 'manageList', '2-3', '/Manage/manageList', '3', '1', '1458372647');
INSERT INTO `auth` VALUES ('4', '角色管理', '2', 'Role', 'roleList', '2-4', '/Role/roleList', '3', '1', '1458372647');
INSERT INTO `auth` VALUES ('5', '权限管理', '2', 'Auth', 'authList', '2-5', '/Auth/authList', '3', '1', '1458372647');
INSERT INTO `auth` VALUES ('7', '商户管理', '1', '', '', '', '', '2', '1', '1458372647');
INSERT INTO `auth` VALUES ('8', '产品列表', '7', 'Product', 'productList', '7-8', '/Product/productList', '3', '1', '1458372647');
INSERT INTO `auth` VALUES ('9', '产品分类', '7', 'Product', 'sortProduct', '7-9', '/Product/sortProduct', '3', '1', '1458372647');
INSERT INTO `auth` VALUES ('10', '商户设置', '7', 'Product', '', '7-10', '', '3', '1', '1458372647');
INSERT INTO `auth` VALUES ('11', '商户页面', '7', 'Product', '', '7-11', '', '3', '1', '1458372647');
INSERT INTO `auth` VALUES ('12', '系统设置', '1', '', '', '', '', '2', '1', '1458372647');
INSERT INTO `auth` VALUES ('13', '主题设置', '12', 'User', 'theme', '12-13', '/User/theme', '3', '1', '1458372647');
INSERT INTO `auth` VALUES ('14', '个人设置', '12', 'User', 'profile', '12-14', '/User/profile', '3', '1', '1458372647');
INSERT INTO `auth` VALUES ('15', '帮助', '12', 'SYS', '', '12-15', '', '3', '1', '1458372647');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(4) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(36) NOT NULL COMMENT '角色名称',
  `role_auth_ids` text COMMENT '权限ids xtgl,yhgl',
  `role_auth_ac` text COMMENT '模块-操作',
  `role_createtime` bigint(4) DEFAULT NULL COMMENT '角色创建时间',
  `role_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '角色状态',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name_unique` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '', '', '1458375174', '1');
INSERT INTO `role` VALUES ('2', '访客', '1,12,13,14,', 'User-theme,User-profile,', '1458375175', '1');
INSERT INTO `role` VALUES ('3', '商户', '1,7,8,9,10,', 'Product-productList,Product-sortProduct,', '1461004780', '1');
