/*
 Navicat Premium Data Transfer

 Source Server         : LUOSHIJIE
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : contact

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 16/05/2022 18:56:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_contact
-- ----------------------------
DROP TABLE IF EXISTS `t_contact`;
CREATE TABLE `t_contact`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contact_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `contact_sex` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别:男/女',
  `contact_type` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关系',
  `contact_phone` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `contact_address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `contact_text` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '联系人' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_contact
-- ----------------------------
INSERT INTO `t_contact` VALUES (1, '张三', '男', '舍友', '234332', '惠州', '一号床');
INSERT INTO `t_contact` VALUES (2, '李四', '男', '舍友', '12', '惠州', '二号床');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `notice_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `notice_text` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `notice_type` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `create_date` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (1, '测试', '测试通过', '测试', '2022');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `real_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `user_sex` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别:男/女',
  `user_phone` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `user_text` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `user_type` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型:管理员/普通用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'root', 'root', 'root', '男', '122121', '', '管理员');
INSERT INTO `t_user` VALUES (2, 'a', '123456', '甲', '男', '32332', '', '普通用户');

SET FOREIGN_KEY_CHECKS = 1;
