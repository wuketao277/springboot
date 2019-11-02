package com.hello.security2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试权限controller
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Controller
public class OrderController {
    /**
     * 首页
     */
    @RequestMapping(path = {"/", "/index"})
    public String index() {
        return "index";
    }

    /**
     * 查询订单
     */
    @RequestMapping("/showOrder")
    public String showOrder() {
        return "showOrder";
    }

    /**
     * 添加订单
     */
    @RequestMapping("/addOrder")
    public String addOrder() {
        return "addOrder";
    }

    /**
     * 修改订单
     */
    @RequestMapping("/updateOrder")
    public String updateOrder() {
        return "updateOrder";
    }

    /**
     * 删除订单
     */
    @RequestMapping("/deleteOrder")
    public String deleteOrder() {
        return "deleteOrder";
    }
}
