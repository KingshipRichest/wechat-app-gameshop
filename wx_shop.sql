/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : wx_shop

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 26/10/2023 18:12:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advertiser_info
-- ----------------------------
DROP TABLE IF EXISTS `advertiser_info`;
CREATE TABLE `advertiser_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '公告内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advertiser_info
-- ----------------------------

-- ----------------------------
-- Table structure for cart_info
-- ----------------------------
DROP TABLE IF EXISTS `cart_info`;
CREATE TABLE `cart_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goodsId` bigint NULL DEFAULT NULL COMMENT '所属商品',
  `count` int NULL DEFAULT NULL COMMENT '数量',
  `userId` bigint NULL DEFAULT NULL COMMENT '所属用户',
  `level` int NULL DEFAULT NULL COMMENT '用户等级',
  `createTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart_info
-- ----------------------------

-- ----------------------------
-- Table structure for comment_info
-- ----------------------------
DROP TABLE IF EXISTS `comment_info`;
CREATE TABLE `comment_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '评价内容',
  `goodsId` bigint NULL DEFAULT NULL COMMENT '所属商品',
  `userId` bigint NULL DEFAULT NULL COMMENT '评价人id',
  `level` int NULL DEFAULT NULL COMMENT '用户等级',
  `createTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_info
-- ----------------------------
INSERT INTO `comment_info` VALUES (5, '好玩，爱玩', NULL, NULL, NULL, '2023-10-23 19:36:15');
INSERT INTO `comment_info` VALUES (6, '什么mod都能加，不要命啦？', 1, 5, 3, '2023-10-23 19:45:10');

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '商品描述',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `discount` double(10, 2) NULL DEFAULT NULL COMMENT '商品折扣',
  `sales` int NULL DEFAULT 0 COMMENT '商品销量',
  `hot` int NULL DEFAULT 0 COMMENT '商品点赞数',
  `recommend` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是不是推荐',
  `count` int NULL DEFAULT 0 COMMENT '库存',
  `typeId` bigint NULL DEFAULT NULL COMMENT '所属类别',
  `fields` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片id，用英文逗号隔开',
  `userId` bigint NULL DEFAULT NULL COMMENT '所属卖家',
  `level` int NULL DEFAULT NULL COMMENT '所属卖家等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES (1, '老滚5', '好玩，爱玩', 128.00, 0.50, 30, 8, '是', 80, 1, '[7, 8, 9]', NULL, NULL);
INSERT INTO `goods_info` VALUES (2, '掉色人', '褪色者再交界地的成王之路', 298.00, 0.66, 35, 18, '是', 75, 1, '[14, 1, 2]', NULL, NULL);
INSERT INTO `goods_info` VALUES (3, '奎爷', '嘎嘎砍', 349.00, 0.50, 2, 0, '是', 98, 2, '[15]', NULL, NULL);
INSERT INTO `goods_info` VALUES (4, 'F1® 23', '想成为下一个周冠宇就来吧', 298.00, 0.60, 1, 0, '是', 119, 2, '[2, 3]', NULL, NULL);

-- ----------------------------
-- Table structure for nx_system_file_info
-- ----------------------------
DROP TABLE IF EXISTS `nx_system_file_info`;
CREATE TABLE `nx_system_file_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `originName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '原始文件名',
  `fileName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '存储文件名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nx_system_file_info
-- ----------------------------
INSERT INTO `nx_system_file_info` VALUES (1, '3 (2).png', '3 (2)1696750230218.png');
INSERT INTO `nx_system_file_info` VALUES (2, '11.jpg', '111696750324767.jpg');
INSERT INTO `nx_system_file_info` VALUES (3, '3 (2).png', '3 (2)1696751995864.png');
INSERT INTO `nx_system_file_info` VALUES (4, 'hanabe4.png', 'hanabe41696752464766.png');
INSERT INTO `nx_system_file_info` VALUES (5, 'hanabe4.png', 'hanabe41696752700302.png');
INSERT INTO `nx_system_file_info` VALUES (6, 'akane1.jpg', 'akane11696756685164.jpg');
INSERT INTO `nx_system_file_info` VALUES (7, 'akane1.jpg', 'akane11696757123906.jpg');
INSERT INTO `nx_system_file_info` VALUES (8, 'akane.jpg', 'akane1696757123923.jpg');
INSERT INTO `nx_system_file_info` VALUES (9, '11.jpg', '111696765976797.jpg');
INSERT INTO `nx_system_file_info` VALUES (10, '21.jpg', '211696765976797.jpg');
INSERT INTO `nx_system_file_info` VALUES (11, '4.jpg', '41696765976797.jpg');
INSERT INTO `nx_system_file_info` VALUES (12, '1.jpg', '11696859602733.jpg');
INSERT INTO `nx_system_file_info` VALUES (13, '2.jpg', '21696859602733.jpg');
INSERT INTO `nx_system_file_info` VALUES (14, 'liuga.jpg', 'liuga1696940444609.jpg');
INSERT INTO `nx_system_file_info` VALUES (15, 'hanabe4-gigapixel-standard-scale-6_00x.jpg', 'hanabe4-gigapixel-standard-scale-6_00x1697260966401.jpg');

-- ----------------------------
-- Table structure for order_goods_rel
-- ----------------------------
DROP TABLE IF EXISTS `order_goods_rel`;
CREATE TABLE `order_goods_rel`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderId` bigint NULL DEFAULT NULL COMMENT '所属订单id',
  `goodsId` bigint NULL DEFAULT NULL COMMENT '所属商品id',
  `count` int NULL DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单商品关系映射表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_goods_rel
-- ----------------------------
INSERT INTO `order_goods_rel` VALUES (9, 17, 1, 3);
INSERT INTO `order_goods_rel` VALUES (10, 17, 2, 3);
INSERT INTO `order_goods_rel` VALUES (16, 20, 1, 1);
INSERT INTO `order_goods_rel` VALUES (17, 20, 2, 1);
INSERT INTO `order_goods_rel` VALUES (18, 21, 4, 1);
INSERT INTO `order_goods_rel` VALUES (19, 22, 2, 1);

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单ID',
  `totalPrice` double(10, 2) NULL DEFAULT NULL COMMENT '总价格',
  `userId` bigint NULL DEFAULT NULL COMMENT '所属用户',
  `level` int NULL DEFAULT NULL COMMENT '用户等级',
  `linkAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `linkPhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `linkMan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `createTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品订单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (20, '52023102316564109', 260.68, 5, 3, '我家', '13329264024', '就是我', '2023-10-23 16:56:46', '完成');
INSERT INTO `order_info` VALUES (21, '52023102515158959', 178.80, 5, 3, '我家', '13329264024', '就是我', '2023-10-25 15:15:18', '完成');
INSERT INTO `order_info` VALUES (22, '52023102518362082', 196.68, 5, 3, '我家', '13329264024', '就是我', '2023-10-25 18:36:16', '完成');

-- ----------------------------
-- Table structure for type_info
-- ----------------------------
DROP TABLE IF EXISTS `type_info`;
CREATE TABLE `type_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type_info
-- ----------------------------
INSERT INTO `type_info` VALUES (1, 'RPG', '角色扮演');
INSERT INTO `type_info` VALUES (2, 'ACT', '动作游戏');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生日',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮便',
  `carId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `level` int NULL DEFAULT NULL COMMENT '权限等级（1管理员 2卖家 3买家）',
  `account` double(10, 2) NULL DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员1', '男', 22, '2001-07-21', '15361744143', '佛山市东软学院', '526110', '1433698861@qq.com', '441283200107219999', 1, 99999.00);
INSERT INTO `user_info` VALUES (2, 'megumi', 'e10adc3949ba59abbe56e057f20f883e', '惠', '女', 22, NULL, '18899990001', '东京侦探坡', NULL, NULL, NULL, 3, NULL);
INSERT INTO `user_info` VALUES (4, 'chisato', 'e10adc3949ba59abbe56e057f20f883e', '千束', '女', 22, NULL, '17899998888', '花之塔咖啡店', NULL, NULL, NULL, 3, NULL);
INSERT INTO `user_info` VALUES (5, '微信用户', 'e10adc3949ba59abbe56e057f20f883e', '就是我', '男', 33, '2001-07-21', '13329264024', '我家', 'https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132', '1433698861@qq.com', '441283200107219999', 3, 88080.66);

SET FOREIGN_KEY_CHECKS = 1;