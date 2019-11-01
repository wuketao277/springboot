package com.hello.uam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuketao
 * @date 2019/10/24
 * @Description
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("")
    public String login() {
        return "login";
    }
}
