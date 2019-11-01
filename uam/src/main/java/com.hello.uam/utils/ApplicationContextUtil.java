package com.hello.uam.utils;

import org.springframework.context.ApplicationContext;

/**
 * 应用程序上下文工具类
 *
 * @author wuketao
 * @date 2019/10/26
 * @Description
 */
public class ApplicationContextUtil {
    /**
     * 私有静态 上下文实例
     */
    private static ApplicationContext ac;

    /**
     * 应用程序上下文设置方法
     * 只允许设置一次
     *
     * @param context
     */
    public static void setApplicationContext(ApplicationContext context) {
        if (null == ac) {
            ac = context;
        }
    }

    /**
     * 应用程序上下文获取方法
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return ac;
    }
}
