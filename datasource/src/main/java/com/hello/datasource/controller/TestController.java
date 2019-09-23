package com.hello.datasource.controller;

import com.hello.datasource.bean.User;
import com.hello.datasource.service.AsyncService;
import com.hello.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private AsyncService asyncService;

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

    @GetMapping("saveList")
    public void saveList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("张三"));
        userList.add(new User("李四"));
        userList.add(new User("王五"));
        userList.add(new User("赵六"));
        userService.saveList(userList);
    }

    @GetMapping("testAsync")
    public String testAsync(@RequestParam String name) throws InterruptedException, ExecutionException {
        return asyncService.testAsync(name).get();
    }

    @GetMapping("testThread")
    public void testThread() {
        asyncService.testThread();
    }
}
