insert into `xeblog`.`admin_user` (`password`, `github_url`, `signature`, `username`, `name`)
  values ('21232f297a57a5a743894a0e4a801fc3', 'https://github.com/anlingyi', '不畏将来，不念过往！', 'admin', '小毅');

insert into `xeblog`.`website_info` (`title`, `copyright`, `subtitle`) values ('小毅博客', '小毅博客',
  '分享的不只是代码更是生活！');

insert into `xeblog`.`category` (`name`) values ('记录');

insert into `xeblog`.`menu` (`order_id`, `name`, `url`, `icon`) values
(1, '首页', '/', 'fa fa-fw fa-home'),
(2, '分类', '/categories', 'fa fa-fw fa-group'),
(3, '归档', '/archives', 'fa fa-fw fa-archive'),
(4, '标签', '/tags', 'fa fa-fw fa-tags');

insert into `xeblog`.`article` (`author`, `category_id`, `title`, `content`, `brief`) values ('小毅', 1, 'Hello World!',
  '你好，世界！', '记录，从此刻开始！');