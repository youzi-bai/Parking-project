/*
 Navicat Premium Data Transfer

 Source Server         : bai
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : bai-parking

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 08/04/2022 15:19:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车牌号',
  `car_state` int(1) NULL DEFAULT NULL COMMENT '停车状态 1停车中 2缴费已出',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `image_url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片地址',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆类型',
  `user_id` int(1) NULL DEFAULT NULL COMMENT '车辆所属人id',
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆所属人姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_info
-- ----------------------------
INSERT INTO `car_info` VALUES (2, '冀F66666', 1, '2022-04-03 13:19:35.000000', '', '跑车1', 2, '张三');
INSERT INTO `car_info` VALUES (3, '冀F88888', 2, '2022-04-03 13:20:10.000000', '', '轿车2', 3, '李四');
INSERT INTO `car_info` VALUES (4, '冀F11111', 1, '2022-04-05 19:42:28.503000', NULL, '轿车', 8, 'ceshi');

-- ----------------------------
-- Table structure for car_info_copy1
-- ----------------------------
DROP TABLE IF EXISTS `car_info_copy1`;
CREATE TABLE `car_info_copy1`  (
  `car_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `car_state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆状态（1-停车中；2-已缴费并驶出）',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆类型',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所有人的姓名',
  `user_id` int(20) NOT NULL COMMENT '所有人的ID',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆图片的地址',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user_id` int(20) NOT NULL COMMENT '创建人id',
  `updata_time` datetime(0) NULL DEFAULT NULL COMMENT '更改时间',
  `updata_user_id` int(20) NULL DEFAULT NULL COMMENT '更改人id',
  PRIMARY KEY (`car_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_info_copy1
-- ----------------------------
INSERT INTO `car_info_copy1` VALUES ('冀F66666', '2', '跑车', '李四', 2, 'C:\\Users\\GW00284346\\Downloads\\冀F66666.jpg', '2022-03-16 13:58:07', 2, NULL, NULL);
INSERT INTO `car_info_copy1` VALUES ('冀F88888', '1', '轿车', '李四', 2, 'C:\\Users\\GW00284346\\Downloads\\冀F88888.jpg', '2022-03-16 13:58:10', 2, NULL, NULL);

-- ----------------------------
-- Table structure for function_info
-- ----------------------------
DROP TABLE IF EXISTS `function_info`;
CREATE TABLE `function_info`  (
  `id-function` int(20) NOT NULL COMMENT '功能的编号',
  `name-function` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '功能名称',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user_id` int(20) NOT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_people_id` int(20) NULL DEFAULT NULL COMMENT '更新人',
  `father-id` int(20) NULL DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`id-function`) USING BTREE,
  INDEX `name-fiction`(`name-function`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of function_info
-- ----------------------------
INSERT INTO `function_info` VALUES (5, '1', '1', '2022-03-16 14:00:24', 1, '2022-03-16 14:00:24', 0, NULL);

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `create_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `sub_time` datetime(6) NULL DEFAULT NULL,
  `path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES (2, '', '权限管理', NULL, '2022-03-30 20:53:11.644000', '/perManage');
INSERT INTO `menu_info` VALUES (3, NULL, '角色管理', NULL, '2022-03-30 20:55:40.071000', '/roleManage');
INSERT INTO `menu_info` VALUES (4, NULL, '菜单管理', NULL, '2022-03-30 20:55:51.906000', '/menuManage');
INSERT INTO `menu_info` VALUES (5, NULL, '用户管理', NULL, '2022-03-30 21:02:08.620000', '/userManage');
INSERT INTO `menu_info` VALUES (7, NULL, '停车场管理', NULL, '2022-04-03 13:21:09.456000', '/parkingManage');
INSERT INTO `menu_info` VALUES (8, NULL, '车辆管理', NULL, '2022-04-03 13:21:24.945000', '/carManage');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `account_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `car_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `user_id` int(20) NOT NULL COMMENT '车辆所有人的id',
  `cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '花费',
  `come_time` datetime(0) NOT NULL COMMENT '驶入时间',
  `go_time` datetime(0) NULL DEFAULT NULL COMMENT '驶出时间',
  `state` int(10) NOT NULL COMMENT '订单状态（1：已缴费；2：已创建但还未付费）',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `create_user_id` int(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更改时间',
  `update_user_id` int(20) NULL DEFAULT NULL COMMENT '更改人id',
  PRIMARY KEY (`account_id`) USING BTREE,
  INDEX `car-num`(`car_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, '冀F66666', 2, 36.00, '2022-03-16 14:00:24', '2022-03-16 14:00:24', 0, '2022-03-16 14:00:24', 0, NULL, NULL);

-- ----------------------------
-- Table structure for parking_info
-- ----------------------------
DROP TABLE IF EXISTS `parking_info`;
CREATE TABLE `parking_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '车位描述',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `create_user_id` int(1) NULL DEFAULT NULL COMMENT '创建人id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '停车场管理',
  `rest_position` int(1) NULL DEFAULT NULL COMMENT '剩余停车位数',
  `state` int(1) NOT NULL DEFAULT 1 COMMENT '停车场状态',
  `sum_position` int(1) NULL DEFAULT NULL COMMENT '停车位总数',
  `update_time` datetime(6) NULL DEFAULT NULL,
  `update_user_id` int(1) NULL DEFAULT NULL COMMENT '修改人id',
  `is_remove` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of parking_info
-- ----------------------------
INSERT INTO `parking_info` VALUES (1, '5555', '2022-04-02 13:27:49.174000', 0, '测试停车场', 9, 0, 196, NULL, 0, 0);
INSERT INTO `parking_info` VALUES (4, 'caccaxcasc', '2022-04-02 13:48:47.562000', 0, '测1212', 22, 0, 22, NULL, NULL, 0);
INSERT INTO `parking_info` VALUES (5, 'caccaxcasc', '2022-04-02 13:48:59.781000', 0, '测11111', 13, 0, 13, NULL, NULL, 0);
INSERT INTO `parking_info` VALUES (6, 'caccaxcasc', '2022-04-02 13:49:04.168000', 0, 'cscsac', 13, 0, 13, NULL, NULL, 0);
INSERT INTO `parking_info` VALUES (7, 'ccc', '2022-04-02 13:49:46.454000', 0, '1dqcsc', 111, 0, 111, NULL, NULL, 0);
INSERT INTO `parking_info` VALUES (9, '23213', '2022-04-02 14:20:18.572000', 0, '889', 122, 0, 122, NULL, NULL, 0);
INSERT INTO `parking_info` VALUES (10, 'edqwsqw', '2022-04-08 08:49:08.085000', 0, 'ade', 2, 0, 2, NULL, NULL, 0);

-- ----------------------------
-- Table structure for permission_info
-- ----------------------------
DROP TABLE IF EXISTS `permission_info`;
CREATE TABLE `permission_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `create_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `sub_time` datetime(6) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission_info
-- ----------------------------
INSERT INTO `permission_info` VALUES (4, '新增', NULL, '2022-03-30 21:13:48.522000', '新增功能44');
INSERT INTO `permission_info` VALUES (5, '修改', NULL, '2022-03-30 21:13:53.267000', '修改11112321');
INSERT INTO `permission_info` VALUES (6, '查询', NULL, '2022-03-30 21:14:01.511000', 'select');
INSERT INTO `permission_info` VALUES (7, '删除', NULL, '2022-03-30 21:14:07.087000', 'delete');

-- ----------------------------
-- Table structure for role_function
-- ----------------------------
DROP TABLE IF EXISTS `role_function`;
CREATE TABLE `role_function`  (
  `role_id` int(20) NOT NULL COMMENT '角色的编号',
  `function_id` int(20) NOT NULL COMMENT '功能的编号',
  PRIMARY KEY (`role_id`, `function_id`) USING BTREE,
  INDEX `fid`(`function_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_function
-- ----------------------------
INSERT INTO `role_function` VALUES (1, 5);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `state` int(1) NOT NULL DEFAULT 0 COMMENT '角色状态 0启用 1禁用',
  `sub_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `level` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色级别',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (8, '系统管理员', 0, '2022-04-01 01:06:26.781000', NULL, '一级', '测试哈哈哈哈');
INSERT INTO `role_info` VALUES (9, '普通用户', 0, '2022-04-01 01:54:45.248000', NULL, '四级', '这是个普通的');
INSERT INTO `role_info` VALUES (10, '高级管理员', 0, '2022-04-01 11:19:23.042000', NULL, '二级', '测试测试');
INSERT INTO `role_info` VALUES (11, '测试用户', 0, '2022-04-08 08:23:51.675000', NULL, '五级', '额实打实的');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(1) NULL DEFAULT NULL COMMENT '菜单id',
  `menu_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `role_id` int(1) NULL DEFAULT NULL COMMENT '角色id',
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `sub_time` datetime(6) NULL DEFAULT NULL,
  `per_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `per_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (7, 2, '权限管理', 8, '系统管理员', '2022-04-01 01:43:15.029000', '新增,修改,查询,删除', '4,5,6,7');
INSERT INTO `role_menu` VALUES (8, 3, '角色管理', 8, '系统管理员', '2022-04-01 01:46:32.223000', '新增,修改,查询,删除', '4,5,6,7');
INSERT INTO `role_menu` VALUES (9, 4, '菜单管理', 8, '系统管理员', '2022-04-01 01:52:57.298000', '新增,修改,查询,删除', '4,5,6,7');
INSERT INTO `role_menu` VALUES (10, 5, '用户管理', 8, '系统管理员', '2022-04-01 01:53:03.096000', '新增,修改,查询,删除', '4,5,6,7');
INSERT INTO `role_menu` VALUES (11, 5, '用户管理', 9, '普通用户', '2022-04-01 01:54:57.744000', '查询,修改123', '6,5');
INSERT INTO `role_menu` VALUES (12, 2, '权限管理', 10, '高级管理员', '2022-04-01 11:19:44.805000', '新增,修改,查询', '4,5,6');
INSERT INTO `role_menu` VALUES (13, 3, '角色管理', 10, '高级管理员', '2022-04-01 11:19:51.617000', '新增,修改,查询', '4,5,6');
INSERT INTO `role_menu` VALUES (14, 5, '用户管理', 10, '高级管理员', '2022-04-01 11:19:55.549000', '新增,修改,查询', '4,5,6');
INSERT INTO `role_menu` VALUES (15, 7, '停车场管理', 8, '系统管理员', '2022-04-03 13:21:57.506000', '新增,修改,查询,删除', '4,5,6,7');
INSERT INTO `role_menu` VALUES (16, 8, '车辆管理', 9, '普通用户', '2022-04-03 13:22:14.763000', '新增,修改,查询,删除', '4,5,6,7');
INSERT INTO `role_menu` VALUES (17, 8, '车辆管理', 8, '系统管理员', '2022-04-03 13:24:47.413000', '新增,修改', '4,5');
INSERT INTO `role_menu` VALUES (18, 7, '停车场管理', 11, '测试用户', '2022-04-08 08:24:47.956000', '查询', '6');
INSERT INTO `role_menu` VALUES (19, 8, '车辆管理', 11, '测试用户', '2022-04-08 08:25:09.394000', '新增', '4');

-- ----------------------------
-- Table structure for user-role
-- ----------------------------
DROP TABLE IF EXISTS `user-role`;
CREATE TABLE `user-role`  (
  `user-id` int(20) NOT NULL COMMENT '用户的编号',
  `role-id` int(20) NOT NULL COMMENT '角色的编号',
  PRIMARY KEY (`user-id`, `role-id`) USING BTREE,
  INDEX `role-id1`(`role-id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user-role
-- ----------------------------
INSERT INTO `user-role` VALUES (1, 1);
INSERT INTO `user-role` VALUES (2, 3);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address_user` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '地址',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '个人简介',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `create_user_id` int(11) NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `gender_user` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `ipone_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `name_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `state_user` int(1) NOT NULL DEFAULT 1 COMMENT '用户状态',
  `update_time` datetime(6) NULL DEFAULT NULL,
  `update_user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (2, '北京', '山羊放了个绵阳屁，既洋气又骚气。', '2022-04-01 01:55:28.693000', NULL, '123@qq.com', '男', '133123123', '张三', '111111', '', 1, NULL, NULL);
INSERT INTO `user_info` VALUES (3, '泰国', '萨瓦迪卡欢迎大家', '2022-04-01 02:48:22.896000', NULL, '阿斯顿撒的', '女', '15555', '李四', '123456', NULL, 1, NULL, NULL);
INSERT INTO `user_info` VALUES (8, '火星', '叽里咕噜叽里咕噜', '2022-04-01 12:15:31.759000', NULL, '栋栋幺', '未知', '0000000000', 'ceshi', '123456', NULL, 1, NULL, NULL);
INSERT INTO `user_info` VALUES (9, '上海市浦东', '隔离中。。。', '2022-04-05 19:44:57.977000', NULL, '1234567@qq.com', '男', '12345678910', '王五', '123456', '', 1, NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(1) NULL DEFAULT NULL,
  `user_id` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (4, 8, 2);
INSERT INTO `user_role` VALUES (5, 9, 3);
INSERT INTO `user_role` VALUES (6, 10, 8);
INSERT INTO `user_role` VALUES (7, 11, 9);

SET FOREIGN_KEY_CHECKS = 1;
