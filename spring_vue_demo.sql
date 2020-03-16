DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `passwd` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `address` varchar(255) DEFAULT NULL COMMENT '用户地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'test_user1', 'a3e5f867a100929c21ecc95525392cc4da7ba5', '江苏省苏州市');
INSERT INTO `user_info` VALUES ('2', 'test_user2', 'a3e5f867a100929c21ecc95525392cc4da7ba5', '江苏省南京市');
