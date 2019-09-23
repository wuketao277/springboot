package com.hello.datasource.config.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author wuketao
 * @date 2019/9/18
 * @Description
 */
@Configuration
@EnableAsync
public class MyAsync {

    @Bean
    public AsyncTaskExecutor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("Async-Executor");
        executor.setMaxPoolSize(2);
        return executor;
    }
}
