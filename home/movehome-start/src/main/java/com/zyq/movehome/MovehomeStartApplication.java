package com.zyq.movehome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@MapperScan("com.zyq.movehome.mapper")
public class MovehomeStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovehomeStartApplication.class, args);
    }

}
