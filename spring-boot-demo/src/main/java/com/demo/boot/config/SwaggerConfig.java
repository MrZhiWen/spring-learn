package com.demo.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName : SwaggerConfig.java
 * @Description : Swagger2 api 文档生成工具配置
 * @Author : lizhiwen
 * @Date: 2020-08-21 08:27
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 各环境之间开启 禁用api文档
     */
    @Value("${spring.swagger.enabled}")
    private Boolean swaggerEnabled;

    /**
     * 创建 Docket
     * 用于配置swagger2，包含文档基本信息
     * 指定swagger2的作用域（这里指定包路径下的所有API）
     * @return
     */
    @Bean
    public Docket createResApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.boot"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("spring-boot-demo")
//                //团队地址
//                .termsOfServiceUrl("")
                // 设置联系方式
                .contact(new Contact("lizhiwen", "", "719272090@qq.com"))
                .version("1.0")
                .build();
    }
}
