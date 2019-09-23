package com.hello.uam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wuketao
 * @date 2019/9/17
 * @Description
 */
@EnableSwagger2
@SpringBootApplication
public class UAMApplication {
    public static void main(String[] args) {
        SpringApplication.run(UAMApplication.class, args);
    }
}
