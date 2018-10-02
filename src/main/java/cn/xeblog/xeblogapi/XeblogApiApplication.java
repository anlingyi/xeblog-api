package cn.xeblog.xeblogapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "cn.xeblog.xeblogapi.dao")
@SpringBootApplication
public class XeblogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XeblogApiApplication.class, args);
    }
}
