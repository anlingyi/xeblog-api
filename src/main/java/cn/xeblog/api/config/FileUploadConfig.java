package cn.xeblog.api.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * 文件上传配置
 *
 * @author yanpanyi
 * @date 2018/11/12
 */
@Configuration
public class FileUploadConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 文件上传大小
        factory.setMaxFileSize("1024MB");
        // 总文件大小
        factory.setMaxRequestSize("2048MB");

        return factory.createMultipartConfig();
    }
}
