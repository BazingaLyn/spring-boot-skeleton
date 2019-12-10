
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `product_id` int(11) NOT NULL DEFAULT '0',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 删除 0 未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `product_id` int(11) NOT NULL DEFAULT '0',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 删除 0 未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `t_order_2`;
CREATE TABLE `t_order_2` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `product_id` int(11) NOT NULL DEFAULT '0',
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 删除 0 未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
