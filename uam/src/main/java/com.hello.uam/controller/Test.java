package com.hello.uam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuketao
 * @date 2019/9/23
 * @Description
 */
@RequestMapping("test")
@RestController
public class Test {

    @GetMapping("test")
    public String test() {
        return "test";
    }
}
