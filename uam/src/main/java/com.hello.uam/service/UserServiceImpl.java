package com.hello.uam.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author wuketao
 * @date 2019/10/26
 * @Description
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Override
    public String getUser() {
        return "user zhangsan";
    }
}
