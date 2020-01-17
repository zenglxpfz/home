package com.zyq.movehome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/1/17 - 10:55
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //// swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                //当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.zyq.movehome.controller")).build();
    }

    //构建 api文档的详细信息函数，注意这里是注解引用那个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("home项目测试使用swagger2构建restFul API")
                .termsOfServiceUrl("http://localhost:8010/swagger-ui.html")
               //创建人信息
                .contact(new Contact("曾运棋","ABC","1404125815@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("lxp").build();
    }
}
