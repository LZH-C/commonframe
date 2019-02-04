package com.lzh.commonframe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
//@Profile({"dev", "sit", "pre"})
public class SwaggerConfig {

    // 分组名称
    @Value("${swagger.apiGroupName}")
    private String apiGroupName;

    // 文档标题
    @Value("${swagger.title}")
    private String title;

    // 文档描述
    @Value("${swagger.description}")
    private String description;

    // api版本
    @Value("${swagger.version}")
    private String version;

    // service url
    @Value("${swagger.serviceUrl}")
    private String serviceUrl;

    // controller 包路径
    @Value("${swagger.packAge}")
    private String packAge;

    /**
     * ServiceApi 可以定义多个API组
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage(packAge))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(serviceUrl)
                .version(version)
                //.contact(new Contact("帅呆了", "url", "email"))
                .build();
    }


}
