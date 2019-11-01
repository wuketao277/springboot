package com.hello.uam.controller;

import com.alibaba.fastjson.JSONObject;
import com.hello.uam.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuketao
 * @date 2019/10/25
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("info")
    public String info() {
        return "user info";
    }

    @RequestMapping("users")
    public JSONObject users() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "users");
        return jsonObject;
    }

    @RequestMapping("person")
    public Person person() {
        Person person = new Person();
        person.name = "吴克涛";
        return person;
    }


}
