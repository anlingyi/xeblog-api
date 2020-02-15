DROP TABLE IF EXISTS `subscriber`;
CREATE TABLE `subscriber` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `email` varchar(50) NOT NULL COMMENT '电子邮箱',
  `uid` varchar(64) NOT NULL COMMENT 'uid',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '订阅状态，0未验证 1已订阅 2.未订阅/取消订阅',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  UNIQUE KEY `uk_email` (`email`),
  UNIQUE KEY `uk_uid` (`uid`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订阅者';

DROP TABLE IF EXISTS `email_send_status`;
CREATE TABLE `email_send_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sub_id` int(11) NOT NULL COMMENT '订阅者id',
  `article_id` int(11) NOT NULL COMMENT '文章id',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '发送状态，0未发送 1发送成功 2发送失败',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='邮件发送状态';