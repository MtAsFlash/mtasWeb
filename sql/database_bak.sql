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

 Date: 16/05/2022 21:41:14
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
-- Records of core_menu
-- ----------------------------
INSERT INTO `core_menu`
VALUES (1, '首页', '/home.html', 'fa-home', '0', 1, 43, 0, '2018-08-21 08:07:46', NULL, '2020-09-27 05:52:39', '1',
        'null');
INSERT INTO `core_menu`
VALUES (2, '系统模块', '', 'fa-cog', '0', 1, 0, 0, '2017-03-31 20:16:43', 0, '2018-09-14 15:23:54', '1', 'null');
INSERT INTO `core_menu`
VALUES (3, '用户管理', '/coreUser/index.html', 'fa-user', '1', 2, 2, 0, '2017-03-31 20:16:54', 0, '2018-08-26 22:25:58',
        '1', 'auth:user:view');
INSERT INTO `core_menu`
VALUES (4, '角色管理', '/coreRole/index.html', 'fa-user-circle', '0', 2, 2, 0, '2017-03-31 20:16:48', 0,
        '2018-09-14 15:23:29', '1', 'auth:role:view');
INSERT INTO `core_menu`
VALUES (5, '菜单管理', '/coreMenu/index.html', 'fa-list', '0', 1, 2, 0, '2017-03-31 20:16:45', 0, '2018-09-14 15:23:43',
        '1', 'auth:menu:view');
INSERT INTO `core_menu`
VALUES (6, 'Druid监控', '/druid/index.html', 'fa-line-chart', '0', 1, 2, 0, '2018-08-25 15:05:34', NULL,
        '2018-10-01 00:23:08', '1', 'null');
INSERT INTO `core_menu`
VALUES (7, 'API管理', '/swagger-ui.html', 'layui-icon-read', '0', 1, 2, 0, '2018-09-28 10:36:22', NULL,
        '2018-09-28 10:53:14', '1', 'null');
INSERT INTO `core_menu`
VALUES (8, '系统日志', '/coreLogger/index.html', 'layui-icon-form', '0', 1, 2, 0, '2018-10-01 00:05:28', NULL,
        '2020-07-10 18:28:23', '1', 'null');
INSERT INTO `core_menu`
VALUES (9, '服务器管理', '/system/index.html', 'layui-icon-login-wechat', '0', 1, 2, 0, '2018-11-05 10:30:18', NULL,
        '2019-11-18 18:24:39', '1', 'auth:system:view');
INSERT INTO `core_menu`
VALUES (10, '文件上传', '/upload/index.html', 'fa-cloud-upload', '0', 1, 54, 0, '2018-08-23 13:09:37', NULL,
        '2018-11-05 16:39:19', '1', 'auth:upload:view');
INSERT INTO `core_menu`
VALUES (63, '玩家管理', '/user/account', 'layui-icon-user', '0', 1, 0, 0, '2019-11-04 19:52:51', NULL,
        '2019-11-04 19:55:16', '1', 'auth:player:view');
INSERT INTO `core_menu`
VALUES (64, '账户列表', '/user/account/index.html', 'layui-icon-friends', '0', 1, 63, 0, '2019-11-04 19:55:10', NULL,
        '2019-11-04 19:55:31', '1', 'null');
INSERT INTO `core_menu`
VALUES (65, '领主信息', '/game/user/profile/index.html', 'layui-icon-release', '0', 1, 63, 0, '2019-11-04 20:28:51', NULL,
        '2019-11-06 10:41:03', '1', 'auth:general:view');
INSERT INTO `core_menu`
VALUES (67, '游戏服务器密钥管理', '/serverkey/index.html', 'layui-icon-password', '0', 1, 2, 0, '2019-11-06 21:00:01', NULL,
        '2019-11-06 21:16:44', '1', 'null');
INSERT INTO `core_menu`
VALUES (69, '邮件', '', 'layui-icon-release', '0', 1, 2, 0, '2019-11-15 21:30:24', NULL, '2019-11-16 10:37:32', '1',
        'null');
INSERT INTO `core_menu`
VALUES (70, '语言管理', '/language/index.html', 'layui-icon-voice', '0', 1, 74, 0, '2019-11-18 18:00:19', NULL,
        '2019-11-21 11:44:42', '1', 'null');
INSERT INTO `core_menu`
VALUES (72, '方案管理', '/language-plan/index.html', 'layui-icon-template-1', '0', 1, 74, 0, '2019-11-21 11:37:46', NULL,
        '2019-11-21 15:22:51', '1', 'null');
INSERT INTO `core_menu`
VALUES (74, '多语言', '', 'layui-icon-dialogue', '0', 1, 2, 0, '2019-11-21 11:43:58', NULL, '2019-11-21 15:22:20', '1',
        'null');
INSERT INTO `core_menu`
VALUES (75, '地区语言管理', '/language-area/index.html', 'layui-icon-reply-fill', '0', 1, 74, 0, '2019-11-23 12:00:43', NULL,
        NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (76, 'BUFF列表', 'game/user/buff/index.html', 'layui-icon-vercode', '0', 1, 63, 0, '2019-11-28 11:23:26', NULL,
        '2019-11-28 11:38:52', '1', 'null');
INSERT INTO `core_menu`
VALUES (77, '建筑列表', 'game/user/building/index.html', 'layui-icon-vercode', '0', 1, 63, 0, '2019-11-28 11:24:59', NULL,
        '2019-11-28 11:36:23', '1', 'null');
INSERT INTO `core_menu`
VALUES (78, '行军列表', 'game/user/march/index.html', 'layui-icon-vercode', '0', 1, 63, 0, '2019-11-28 11:40:08', NULL,
        '2019-11-28 11:41:48', '1', 'null');
INSERT INTO `core_menu`
VALUES (79, '兵种列表', 'game/user/army/index.html', 'layui-icon-vercode', '0', 1, 63, 0, '2019-11-28 11:41:26', NULL, NULL,
        '1', 'null');
INSERT INTO `core_menu`
VALUES (80, '科技列表', 'game/user/science/index.html', 'layui-icon-vercode', '0', 1, 63, 0, '2019-11-28 11:42:31', NULL,
        NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (81, '版本管理', '/app-version/index.html', 'layui-icon-cellphone', '0', 1, 97, 0, '2019-12-02 12:04:52', NULL,
        '2020-02-26 12:25:34', '1', 'null');
INSERT INTO `core_menu`
VALUES (82, '公告管理', 'notice/index.html', 'layui-icon-speaker', '0', 1, 2, 0, '2019-12-12 12:35:02', NULL, NULL, '1',
        'null');
INSERT INTO `core_menu`
VALUES (83, '联盟', 'game/gm/alliance/index.html', 'layui-icon-flag', '0', 1, 86, 0, '2020-01-14 15:08:46', NULL,
        '2020-01-16 14:24:22', '1', 'null');
INSERT INTO `core_menu`
VALUES (84, '联盟宝库', 'game/gm/alliance/box/boxInfo/index.html', 'layui-icon-vercode', '0', 1, 86, 0,
        '2020-01-14 18:32:25', NULL, '2020-01-15 17:28:10', '1', 'null');
INSERT INTO `core_menu`
VALUES (85, '联盟宝库宝箱信息', 'game/gm/alliance/box/boxs/index.html', 'layui-icon-vercode', '0', 1, 86, 0,
        '2020-01-14 18:33:04', NULL, '2020-01-15 17:28:18', '1', 'null');
INSERT INTO `core_menu`
VALUES (86, '联盟管理', '', 'layui-icon-vercode', '0', 1, 0, 0, '2020-01-15 17:27:29', NULL, NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (87, '联盟成员', 'game/gm/alliance/indexMember.html', 'layui-icon-vercode', '0', 1, 86, 0, '2020-01-16 10:55:37',
        NULL, '2020-01-16 10:57:14', '1', 'null');
INSERT INTO `core_menu`
VALUES (88, '静态数据管理', '/game/spec/index.html', 'layui-icon-template-1', '0', 1, 0, 0, '2020-01-16 14:25:44', NULL, NULL,
        '1', 'null');
INSERT INTO `core_menu`
VALUES (89, '道具管理', 'template/item/index.html', 'layui-icon-cart', '0', 1, 88, 0, '2020-02-20 15:18:34', NULL,
        '2020-02-21 13:14:10', '1', 'null');
INSERT INTO `core_menu`
VALUES (90, '导量语言组', '', 'layui-icon-fonts-strong', '0', 1, 2, 0, '2020-02-21 11:32:30', NULL, NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (91, '子集设置', 'game/gm/loginLanguage/child/index.html', 'layui-icon-form', '0', 1, 90, 0, '2020-02-21 11:33:28',
        NULL, '2020-03-30 10:43:56', '1', 'null');
INSERT INTO `core_menu`
VALUES (92, '士兵模板', 'template/army/index.html', 'layui-icon-group', '0', 1, 88, 0, '2020-02-21 13:14:41', NULL,
        '2020-02-21 13:14:28', '1', 'null');
INSERT INTO `core_menu`
VALUES (93, '策略组设置', 'game/gm/loginLanguage/group/index.html', 'layui-icon-senior', '0', 1, 90, 0,
        '2020-02-21 14:42:17', NULL, '2020-03-30 10:44:30', '1', 'null');
INSERT INTO `core_menu`
VALUES (94, '多语言', 'template/language/index.html', 'layui-icon-voice', '0', 1, 88, 0, '2020-02-21 18:16:17', NULL, NULL,
        '1', 'null');
INSERT INTO `core_menu`
VALUES (95, '方案管理', 'template/server/index.html', 'layui-icon-read', '0', 1, 69, 0, '2020-02-24 14:11:49', NULL,
        '2020-04-07 09:01:29', '1', 'null');
INSERT INTO `core_menu`
VALUES (96, '后台管理', '', 'layui-icon-vercode', '0', 1, 2, 0, '2020-02-26 12:00:57', NULL, '2020-02-26 12:26:21', '1',
        'null');
INSERT INTO `core_menu`
VALUES (97, '版本号管理', 'app-version/index.html', 'layui-icon-cellphone-fine', '0', 1, 96, 0, '2020-02-26 12:02:31', NULL,
        '2020-02-26 12:29:02', '1', 'null');
INSERT INTO `core_menu`
VALUES (98, '渠道管理', 'client-channel/index.html', 'layui-icon-spread-left', '0', 1, 96, 0, '2020-02-26 18:46:10', NULL,
        '2020-02-26 19:11:13', '1', 'null');
INSERT INTO `core_menu`
VALUES (99, '群体邮件', 'new-multiple-mail/index.html', 'layui-icon-group', '0', 1, 69, 0, '2020-02-28 02:49:33', NULL,
        NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (100, '单人邮件', 'new-single-mail/index.html', 'layui-icon-friends', '0', 1, 69, 0, '2020-02-28 02:50:41', NULL,
        NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (101, '联盟邮件', 'new-alliance-mail/index.html', 'layui-icon-dialogue', '0', 1, 69, 0, '2020-02-28 02:52:22', NULL,
        NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (102, '维护公告', 'new-repair-mail/index.html', 'layui-icon-set', '0', 1, 69, 0, '2020-02-28 02:55:44', NULL, NULL,
        '1', 'null');
INSERT INTO `core_menu`
VALUES (103, '礼包邮件', 'new-purchase-mail/index.html', 'layui-icon-friends', '0', 1, 69, 0, '2020-04-26 11:00:31', NULL,
        NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (104, '礼包模板', 'template/purchase/index.html', 'layui-icon-cart-simple', '0', 1, 88, 0, '2020-04-26 11:02:45',
        NULL, '2020-04-26 11:51:33', '1', 'null');
INSERT INTO `core_menu`
VALUES (105, '举报受理', '/game/user/report/index.html', 'layui-icon-auz', '0', 1, 63, 0, '2020-05-08 16:56:04', NULL,
        '2020-05-08 16:59:56', '1', 'null');
INSERT INTO `core_menu`
VALUES (106, 'GM命令工具', '/api/cmd/cmd.html', 'layui-icon-rate-solid', '0', 1, 2, 0, '2020-05-13 18:50:26', NULL, NULL,
        '1', 'null');
INSERT INTO `core_menu`
VALUES (107, '玩家日志', '', 'layui-icon-list', '0', 1, 63, 0, '2020-05-27 11:25:46', NULL, NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (108, '全部日志', '/gamelog/normalLogIndex.html', 'layui-icon-form', '0', 1, 107, 0, '2020-05-27 11:27:13', NULL,
        '2020-06-11 16:15:40', '1', 'null');
INSERT INTO `core_menu`
VALUES (109, '支付日志', '/gamelog/payLogIndex.html', 'layui-icon-rmb', '0', 1, 107, 0, '2020-05-27 11:28:26', NULL,
        '2020-06-04 17:03:00', '1', 'null');
INSERT INTO `core_menu`
VALUES (110, '支付统计', '/gamelog/echart.html', 'layui-icon-chart', '0', 1, 107, 0, '2020-05-29 13:02:39', NULL,
        '2020-06-11 16:14:51', '1', 'null');
INSERT INTO `core_menu`
VALUES (111, '支付订单', '/gamelog/payOrderIndex.html', 'layui-icon-form', '0', 1, 107, 0, '2020-06-04 17:02:40', NULL,
        NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (112, 'GM后台日志', '/coreLogger/index.html', 'layui-icon-rate', '0', 1, 8, 0, '2020-07-10 18:26:54', NULL, NULL,
        '1', 'null');
INSERT INTO `core_menu`
VALUES (113, '服务器infoLog', '/gamelog/infoLogIndex.html', 'layui-icon-rate-half', '0', 1, 8, 0, '2020-07-10 18:27:32',
        NULL, NULL, '1', 'null');
INSERT INTO `core_menu`
VALUES (114, '服务器SlowLog', '/gamelog/slowLogIndex.html', 'layui-icon-rate-solid', '0', 1, 8, 0, '2020-07-10 18:28:11',
        NULL, '2020-12-09 14:20:55', '1', 'null');

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
-- Records of server_info
-- ----------------------------
INSERT INTO `server_info`
VALUES (1, 'nextCloud', 'nextCloud', 'mtass.cn', '88', '2022-05-06 16:48:36', '2022-05-06 16:48:36');
INSERT INTO `server_info`
VALUES (3, 'kyd1', '<p>可道云1</p>', 'mtass.cn', '88', '2022-05-16 01:33:30', '2022-05-16 01:41:32');
INSERT INTO `server_info`
VALUES (4, 'emby', '<p>emby服务器</p>', 'mtass.cn', '8096', '2022-05-16 02:43:30', '2022-05-16 16:31:12');

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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, 'mtasflash', 'B73BD1879B805B2E5D3FC5EEB4A06F11', '2022-04-29 17:08:02', '2022-04-29 17:08:15');

SET FOREIGN_KEY_CHECKS = 1;
