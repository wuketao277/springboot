package com.hello.security2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuketao
 * @date 2019/11/2
 * @Description
 */
@RestController
@RequestMapping("api")
public class APIController {

    @RequestMapping("getList")
    public String getList() {
        return "getList";
    }

    @RequestMapping("getInfo")
    public String getInfo() {
        return "getInfo";
    }
}
