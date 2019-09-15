package com.hello.datasource.controller;

import com.hello.datasource.bean.User;
import com.hello.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("getList")
    public List<User> getList() {
        return userService.findAll();
    }

    @PostMapping("save")
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        return userService.save(user);
    }
}
