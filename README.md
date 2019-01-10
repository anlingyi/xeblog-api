# 小毅博客-API端

> 分享的不只是代码更是生活！

## 环境

* JDK1.8
* SpringBoot
* Maven
* Mysql

## 编译运行

```
mvn clean install -Dmaven.test.skip=true
java -jar xeblog-api.jar
```

## 功能实现
- [x] 登陆登出
- 文章管理
   - [x] 文章发布
   - [x] 文章修改
   - [x] 文章删除
   - [ ] 定时发布
   - [ ] 定时爬虫
- 菜单管理
    - [x] 菜单添加
    - [x] 菜单修改
    - [x] 菜单删除
- 标签管理
    - [x] 标签删除
- 分类管理
    - [x] 分类添加
    - [x] 分类修改
    - [x] 分类删除
- 网站管理
    - [x] 网站信息修改
    - [x] 博主信息修改
    - [x] 密码修改



## 接口文档

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

##  前端UI

[小毅博客UI](https://github.com/anlingyi/xeblog-ui)

[小毅博客CMS端UI](https://github.com/anlingyi/xeblog-cms-ui)

