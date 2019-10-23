package com.hello.security2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用程序启动类
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@SpringBootApplication
@MapperScan("com.hello.security2.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
