package cn.xeblog.api.config;

import cn.xeblog.api.domain.config.FileConfig;
import cn.xeblog.api.interceptor.CorsInterceptor;
import cn.xeblog.api.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * mvc配置
 *
 * @author yanpanyi
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;
    @Resource
    private CorsInterceptor corsInterceptor;
    @Resource
    private FileConfig fileConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileConfig.getStaticAccessPath())
                .addResourceLocations(fileConfig.getDirectoryMapping());
    }

}
