package com.hello.consumer.controller;

import com.hello.consumer.remote.UAMRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuketao
 * @date 2019/10/26
 * @Description
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UAMRemote uamRemote;

    @GetMapping("test")
    public String test() {
        return "test " + uamRemote.users();
    }
}
