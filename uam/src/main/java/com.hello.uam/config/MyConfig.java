package com.hello.uam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author wuketao
 * @date 2019/10/26
 * @Description
 */
@Configuration
public class MyConfig {

    @Bean
    public AsyncTaskExecutor getAsyncTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("My-Executor");
        executor.setMaxPoolSize(2);
        return executor;
    }
}
