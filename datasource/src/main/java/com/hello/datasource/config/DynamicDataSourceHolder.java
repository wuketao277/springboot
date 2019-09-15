package com.hello.datasource.config;

/**
 * @author wuketao
 * @date 2019/9/14
 * 动态数据源处理器
 */
public class DynamicDataSourceHolder {
    /**
     * 使用ThreadLocal把数据源与当前线程绑定
     */
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

    public static void setDataSource(String dataSourceName) {
        dataSources.set(dataSourceName);
    }

    public static String getDataSource() {
        return dataSources.get();
    }

    public static void clearDataSource() {
        dataSources.remove();
    }
}
