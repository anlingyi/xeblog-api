ALTER TABLE article
    ADD COLUMN `is_rcmd` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否推荐，0否|1是';