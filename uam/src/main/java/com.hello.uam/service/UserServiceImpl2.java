package com.hello.uam.service;

import org.springframework.stereotype.Service;

/**
 * @author wuketao
 * @date 2019/10/26
 * @Description
 */
@Service("userServiceImpl2")
public class UserServiceImpl2 implements UserService {
    @Override
    public String getUser() {
        return "user lisi";
    }
}
