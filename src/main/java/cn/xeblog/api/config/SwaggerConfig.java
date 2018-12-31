package cn.xeblog.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置
 *
 * @author yanpanyi
 */
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig {

    /**
     * 是否开启swagger
     */
    private boolean enable;

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * 创建api
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                // 详细定制
                .apiInfo(apiInfo())
                .select()
                // 指定当前包路径
                .apis(RequestHandlerSelectors.basePackage("cn.xeblog.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(setParameter());
    }

    /**
     * 添加摘要信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("小毅博客-接口文档")
                .description("分享的不只是代码更是生活！")
                .contact(new Contact("小毅", "http://www.xeblog.cn", "1090172196@qq.com"))
                .version("1.0.0")
                .build();
    }

    /**
     * 设置参数
     *
     * @return
     */
    private List<Parameter> setParameter() {
        List<Parameter> parameterList = new ArrayList<>(2);

        ParameterBuilder parameterBuilder1 = new ParameterBuilder();
        ParameterBuilder parameterBuilder2 = new ParameterBuilder();

        parameterBuilder1.name("userId").description("用户id").modelRef(new ModelRef("int"))
                .parameterType("header").required(false).build();
        parameterBuilder2.name("token").description("令牌").modelRef(new ModelRef("string"))
                .parameterType("header").required(false).build();

        parameterList.add(parameterBuilder1.build());
        parameterList.add(parameterBuilder2.build());

        return parameterList;
    }
}
