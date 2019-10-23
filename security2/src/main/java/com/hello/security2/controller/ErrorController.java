package com.hello.security2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误处理controller
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Controller
public class ErrorController {
    @RequestMapping("/error/403")
    public String error() {
        return "/error/403";
    }
}
