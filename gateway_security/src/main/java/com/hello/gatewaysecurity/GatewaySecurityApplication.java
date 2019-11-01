package com.hello.gatewaysecurity;

import com.hello.gatewaysecurity.utils.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * gateway+securtiy 项目启动类
 *
 * @author wuketao
 * @date 2019/10/24
 * @Description
 */
@SpringBootApplication
public class GatewaySecurityApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GatewaySecurityApplication.class, args);
        SpringContextUtil.setContext(context);
    }
}
