DROP TABLE IF EXISTS `footprint`;
CREATE TABLE `footprint` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(32) NOT NULL COMMENT '内容',
  `image` varchar(256) NOT NULL DEFAULT '' COMMENT '图片',
  `tag` varchar(8) NOT NULL DEFAULT '' COMMENT '标签',
  `address` varchar(128) NOT NULL COMMENT '地址',
  `longitude` decimal(9,6) NOT NULL COMMENT '经度',
  `latitude` decimal(8,6) NOT NULL COMMENT '纬度',
  `geohash` varchar(12) NOT NULL COMMENT 'geohash',
  `ip` varchar(128) NOT NULL DEFAULT '' COMMENT 'ip',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='足迹';