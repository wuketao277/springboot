package com.hello.security2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 错误处理controller
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@RestController
public class ErrorController {
    @RequestMapping("/error/400")
    public String error400() {
        return "/error/400";
    }

    @RequestMapping("/error/401")
    public String error401() {
        return "/error/401";
    }

    @RequestMapping("/error/402")
    public String error402() {
        return "/error/402";
    }

    @RequestMapping("/error/403")
    public String error403() {
        return "/error/403";
    }

    @RequestMapping("/error/404")
    public String error404() {
        return "/error/404";
    }

    @RequestMapping("/error/415")
    public String error415() {
        return "/error/415";
    }

    @RequestMapping("/error/500")
    public String error500() {
        return "/error/500";
    }
}
