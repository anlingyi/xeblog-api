DROP TABLE IF EXISTS `stat`;
CREATE TABLE `stat`
(
    `id`          int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `address`     varchar(500) NOT NULL DEFAULT '' COMMENT '访问地址',
    `access_ip`   varchar(255) NOT NULL DEFAULT '' COMMENT '访问IP',
    `username`    varchar(255) NOT NULL DEFAULT '' COMMENT '用户名称',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='统计';