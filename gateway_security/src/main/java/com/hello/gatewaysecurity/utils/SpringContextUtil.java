package com.hello.gatewaysecurity.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * spring 上下文工具类
 *
 * @author wuketao
 * @date 2019/10/27
 * @Description
 */
public class SpringContextUtil {
    /**
     * 私有静态上下文
     */
    private static ConfigurableApplicationContext context = null;

    /**
     * 设置上下文
     *
     * @param c
     */
    public static void setContext(ConfigurableApplicationContext c) {
        if (null == SpringContextUtil.context) {
            SpringContextUtil.context = c;
        }
    }

    /**
     * 获取上下文
     *
     * @return
     */
    public static ApplicationContext getContext() {
        return SpringContextUtil.context;
    }
}
