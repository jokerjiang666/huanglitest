/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : huangli

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 11/08/2023 10:46:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'admin', '111111', '管理员', '2023-08-10 17:57:47');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `emp_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '员工姓名',
  `sex` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '性别',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `dept_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门',
  `emp_degree_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '学历',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '赵二', '男', 30, '业务部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (2, '赵三', '男', 31, '人事部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (3, '赵四', '男', 32, '后勤部', '研究生', NULL, NULL);
INSERT INTO `user` VALUES (4, '赵五', '男', 33, '后勤部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (5, '赵六', '男', 34, '人事部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (6, '赵七', '男', 35, '业务部', '本研究生', NULL, NULL);
INSERT INTO `user` VALUES (7, '赵八', '男', 36, '后勤部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (8, '赵九', '男', 37, '业务部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (9, '张二', '男', 30, '业务部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (10, '张三', '男', 31, '人事部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (11, '张四', '男', 32, '后勤部', '研究生', NULL, NULL);
INSERT INTO `user` VALUES (12, '张五', '男', 33, '后勤部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (13, '张六', '男', 34, '人事部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (14, '张七', '男', 35, '业务部', '本研究生', NULL, NULL);
INSERT INTO `user` VALUES (15, '张八', '男', 36, '后勤部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (16, '张九', '男', 37, '业务部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (17, '王二', '男', 30, '业务部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (18, '王三', '男', 31, '人事部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (19, '王四', '男', 32, '后勤部', '研究生', NULL, NULL);
INSERT INTO `user` VALUES (20, '王五', '男', 33, '后勤部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (21, '王六', '男', 34, '人事部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (22, '王七', '男', 35, '业务部', '本研究生', NULL, NULL);
INSERT INTO `user` VALUES (23, '王八', '男', 36, '后勤部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (24, '王九', '男', 37, '业务部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (25, '李二', '男', 30, '业务部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (26, '李三', '男', 31, '人事部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (27, '李四', '男', 32, '后勤部', '研究生', NULL, NULL);
INSERT INTO `user` VALUES (28, '李五', '男', 33, '后勤部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (29, '李六', '男', 34, '人事部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (30, '李七', '男', 35, '业务部', '本研究生', NULL, NULL);
INSERT INTO `user` VALUES (31, '李八', '男', 36, '后勤部', '本科', NULL, NULL);
INSERT INTO `user` VALUES (32, '李九', '男', 37, '业务部', '大专', NULL, NULL);
INSERT INTO `user` VALUES (34, '测试1111', '男', 45, '后勤部', '大专', '2023-08-11 10:36:53', '2023-08-11 10:37:02');

SET FOREIGN_KEY_CHECKS = 1;
