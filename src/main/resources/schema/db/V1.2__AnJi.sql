ALTER TABLE `admin_user` ADD COLUMN `uid` varchar(64) NOT NULL DEFAULT '' COMMENT 'uid';
ALTER TABLE `admin_user` ADD UNIQUE `uk_uid` (`uid`);

UPDATE `admin_user` SET `uid` = REPLACE(UUID(), '-', '');

ALTER TABLE `article` ADD COLUMN `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志，0未删除|1已删除';