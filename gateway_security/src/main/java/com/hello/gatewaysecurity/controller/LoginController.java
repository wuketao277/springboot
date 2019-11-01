package com.hello.gatewaysecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuketao
 * @date 2019/10/27
 * @Description
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @GetMapping("")
    public String login() {
        return "login";
    }
}
