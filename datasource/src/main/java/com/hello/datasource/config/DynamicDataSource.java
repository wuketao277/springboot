package com.hello.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author wuketao
 * @date 2019/9/14
 * 自定义动态数据源，继承自AbstractRoutingDataSource。
 * 通过重新AbstractRoutingDataSource方法来返回当前数据源的map值
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 决定当前线程使用哪个数据源
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        // 读取动态数据源处理类，通过ThreadLocal类获取数据源指向。
        return DynamicDataSourceHolder.getDataSource();
    }
}