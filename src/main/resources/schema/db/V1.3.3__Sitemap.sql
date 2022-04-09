DROP TABLE IF EXISTS `sitemap`;
CREATE TABLE `sitemap`
(
    `id`          int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `domain`      varchar(64)  NOT NULL DEFAULT '' COMMENT '访问域名',
    `out_path`    varchar(255) NOT NULL DEFAULT '' COMMENT '站点地图文件输出路径',
    `last_update` datetime              DEFAULT NULL COMMENT '最近更新时间',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='站点地图';