package com.hello.uam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuketao
 * @date 2019/9/23
 * @Description
 */
@Slf4j
@RequestMapping("test")
@RestController
public class Test {

    @GetMapping("test")
    public String test() {
        log.info("test");
        return "test";
    }
}
