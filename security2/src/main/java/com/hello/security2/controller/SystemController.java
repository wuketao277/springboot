package com.hello.security2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统控制器
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Controller
@RequestMapping("sys")
public class SystemController {
    @RequestMapping("config")
    public String config() {
        return "/sys/config";
    }
}
