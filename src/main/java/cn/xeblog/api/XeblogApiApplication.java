package cn.xeblog.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yanpanyi
 */
@MapperScan(basePackages = "cn.xeblog.api.dao")
@SpringBootApplication
public class XeblogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XeblogApiApplication.class, args);
    }
}
