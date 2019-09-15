package com.hello.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wuketao
 * @date 2019/9/14
 * datasource应用启动程序
 */
@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
public class DataSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataSourceApplication.class, args);
    }
}
