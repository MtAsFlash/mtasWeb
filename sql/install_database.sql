/*
 Navicat Premium Data Transfer

 Source Server         : mtasServer
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : mtass.cn:3306
 Source Schema         : mtas-web

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 16/05/2022 21:42:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for core_menu
-- ----------------------------
DROP TABLE IF EXISTS `core_menu`;
CREATE TABLE `core_menu`
(
    `id`         int                                                                 NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci        NOT NULL COMMENT '菜单名称',
    `url`        varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci       NULL DEFAULT NULL COMMENT '网址',
    `icon`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci        NULL DEFAULT NULL COMMENT '显示的图标',
    `menutype`   enum ('0','1','2') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '类型，0 菜单，1 连接网址,2 隐藏连接',
    `display`    int                                                                 NULL DEFAULT 1 COMMENT '显示排序',
    `parentid`   int                                                                 NULL DEFAULT 0 COMMENT '父级的id，引用本表id字段',
    `creator`    int                                                                 NULL DEFAULT 0 COMMENT '创建者id，0为超级管理员',
    `createtime` timestamp                                                           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateuser` int                                                                 NULL DEFAULT NULL COMMENT '更新者id',
    `updatetime` timestamp                                                           NULL DEFAULT NULL COMMENT '更新时间',
    `flag`       enum ('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NULL DEFAULT '1' COMMENT '是否启用，0 禁用，1启用',
    `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci       NULL DEFAULT NULL COMMENT '权限代码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 115
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for server_info
-- ----------------------------
DROP TABLE IF EXISTS `server_info`;
CREATE TABLE `server_info`
(
    `id`          int                                                           NOT NULL AUTO_INCREMENT COMMENT '主键',
    `server_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         NULL COMMENT '服务名称',
    `server_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         NULL COMMENT '服务描述',
    `host`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服务ip',
    `port`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服务端口',
    `create_time` datetime                                                      NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime                                                      NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int                                                           NOT NULL COMMENT '主键',
    `username`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
    `create_time` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
