package com.hello.security2.controller;

import com.hello.security2.service.ResourceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统控制器
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@RestController
@RequestMapping("sys")
public class SystemController {

    @Resource(name = "MybatisResourceServiceImpl")
    private ResourceService resourceService;

    @RequestMapping("updateResource")
    public String updateResource() {
        resourceService.updateResourceMap();
        return "ok";
    }
}
