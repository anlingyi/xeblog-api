DROP DATABASE IF EXISTS `xeblog`;
CREATE DATABASE xeblog;

USE xeblog;

-- 管理员用户表
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(256) NOT NULL DEFAULT '' COMMENT '密码',
  `token` varchar(256) NOT NULL DEFAULT '' COMMENT 'token',
  `avatar` varchar(256) DEFAULT NULL COMMENT '头像',
  `name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `signature` varchar(50) DEFAULT NULL COMMENT '个性签名',
  `github_url` varchar(256) DEFAULT NULL COMMENT 'github地址',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB CHARSET=utf8;

-- 网站信息表
DROP TABLE IF EXISTS `website_info`;
CREATE TABLE `website_info` (
  `title` varchar(256) DEFAULT NULL COMMENT '网站标题',
  `subtitle` varchar(256) DEFAULT NULL COMMENT '网站副标题',
  `copyright` text DEFAULT NULL COMMENT '网站版权',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间'
) ENGINE=InnoDB CHARSET=utf8;

-- 文章类目表
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '类目名称',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB CHARSET=utf8;

-- 菜单表
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '名称',
  `url` varchar(256) NOT NULL COMMENT '链接地址',
  `order_id` int(10) DEFAULT 0 COMMENT '排序',
  `icon` varchar(256) DEFAULT NULL COMMENT '图标css',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8;

-- 链接表
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '名称',
  `url` varchar(256) NOT NULL COMMENT '链接地址',
  `order_id` int(10) DEFAULT 0 COMMENT '排序',
  `brief` varchar(50) DEFAULT NULL COMMENT '简述',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8;

-- 文章表
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '文章标题',
  `content` text NOT NULL COMMENT '文章内容',
  `cover` varchar(256) DEFAULT NULL COMMENT '文章封面',
  `is_top` int(1) DEFAULT 0 COMMENT '是否置顶,0否|1是',
  `is_private` int(1) DEFAULT 0 COMMENT '是否私有,0否|1是',
  `is_draft` int(1) DEFAULT 0 COMMENT '是否草稿,0否|1是',
  `category_id` int(11) NOT NULL COMMENT '类目id',
  `tag` varchar(50) DEFAULT NULL COMMENT '标签',
  `pageviews` int(11) NOT NULL DEFAULT 0 COMMENT '浏览量',
  `author` varchar(50) NOT NULL COMMENT '作者',
  `brief` varchar(256) DEFAULT NULL COMMENT '简述',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8;

-- 标签表
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '标签名称',
  `create_time` datetime NOT NULL DEFAULT now() COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB CHARSET=utf8;


