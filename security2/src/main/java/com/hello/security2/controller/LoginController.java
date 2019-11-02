package com.hello.security2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author wuketao
 * @date 2019/11/2
 * @Description
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session = null;
        return "login";
    }
}
