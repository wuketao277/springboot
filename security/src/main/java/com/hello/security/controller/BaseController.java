package com.hello.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wuketao
 * @date 2019/10/15
 * @Description
 */
@Controller
@RequestMapping("/")
public class BaseController {

    @GetMapping("home")
    public ModelAndView home(ModelAndView mav) {
        mav.setViewName("home");
        return mav;
    }

    @GetMapping("hello")
    public ModelAndView hello(ModelAndView mav) {
        mav.setViewName("hello");
        return mav;
    }

    @GetMapping("login")
    public ModelAndView login(ModelAndView mav) {
        mav.setViewName("login");
        return mav;
    }
}
