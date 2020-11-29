DROP TABLE IF EXISTS `footprint`;
CREATE TABLE `footprint` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(128) NOT NULL COMMENT '内容',
  `image` varchar(256) NOT NULL DEFAULT '' COMMENT '图片',
  `tag` varchar(8) NOT NULL DEFAULT '' COMMENT '标签',
  `address` varchar(128) NOT NULL COMMENT '地址',
  `nickname` varchar(10) NOT NULL DEFAULT '' COMMENT '昵称',
  `longitude` decimal(9,6) NOT NULL COMMENT '经度',
  `latitude` decimal(8,6) NOT NULL COMMENT '纬度',
  `geohash` varchar(12) NOT NULL COMMENT 'geohash',
  `ip` varchar(128) NOT NULL DEFAULT '' COMMENT 'ip',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  INDEX `idx_geohash` (`geohash`),
  INDEX `idx_create_time` (`create_time`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='足迹';

ALTER DATABASE xeblog  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE admin_user CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE website_info CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE category CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE menu CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE link CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE article CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE tag CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE subscriber CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
ALTER TABLE email_send_status CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;