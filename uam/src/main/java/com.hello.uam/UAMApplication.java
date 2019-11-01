package com.hello.uam;

import com.hello.uam.utils.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wuketao
 * @date 2019/9/17
 * @Description
 */
@EnableSwagger2
@SpringBootApplication
@EnableAsync
public class UAMApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UAMApplication.class, args);
        ApplicationContextUtil.setApplicationContext(context);
    }
}
