package cn.xeblog.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author yanpanyi
 */
@MapperScan(basePackages = "cn.xeblog.api.dao")
@SpringBootApplication
@EnableAsync
public class XeblogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XeblogApiApplication.class, args);
    }
}
