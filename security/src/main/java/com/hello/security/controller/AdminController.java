package com.hello.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuketao
 * @date 2019/10/15
 * @Description
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("")
    public String home() {
        return "admin home";
    }
}
