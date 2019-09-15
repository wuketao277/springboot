package com.hello.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuketao
 * @date 2019/9/13
 */
@Configuration
public class DataSourceConfig {

    /**
     * 配置Druid数据源，写数据库
     *
     * @return
     */
    @Primary
    @Bean(name = DataSourceConstant.WRITE_DATASOURCE)
    @ConfigurationProperties("spring.write")
    public DruidDataSource writeDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid数据源，读数据库
     *
     * @return
     */
    @Bean(name = DataSourceConstant.READ_DATASOURCE)
    @ConfigurationProperties("spring.read")
    public DruidDataSource readDataSource() {
        return new DruidDataSource();
    }

    /**
     * 注入AbstractRoutingDataSource
     *
     * @param readDruidDataSource
     * @param writeDruidDataSource
     * @return
     * @throws Exception
     */
    @Bean
    public AbstractRoutingDataSource routingDataSource(
            @Qualifier(DataSourceConstant.READ_DATASOURCE) DataSource readDruidDataSource,
            @Qualifier(DataSourceConstant.WRITE_DATASOURCE) DataSource writeDruidDataSource
    ) throws Exception {
        // 配置数据源，设置写数据库为默认数据源。
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap();
        targetDataSources.put(DataSourceConstant.WRITE_DATASOURCE, writeDruidDataSource);
        targetDataSources.put(DataSourceConstant.READ_DATASOURCE, readDruidDataSource);
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(writeDruidDataSource);
        return dataSource;
    }
}
