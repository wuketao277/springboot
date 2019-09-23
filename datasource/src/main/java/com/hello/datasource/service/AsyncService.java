package com.hello.datasource.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author wuketao
 * @date 2019/9/18
 * @Description
 */
@Slf4j
@Service
public class AsyncService {
    @Async
    public Future<String> testAsync(String name) {
        return new AsyncResult<>("hello " + name);

    }

    @Async
    public void testThread() {
        while (true) {
            try {
                log.info(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
        }
    }
}
