package com.cscrb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname StartApplication
 * @Description 项目启动类
 * @Date 2020/3/4 16:35
 */
@SpringBootApplication
@MapperScan("com.cscrb.mapper")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class ,args);
    }
}
