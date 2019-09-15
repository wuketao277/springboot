package com.hello.test.service;

import com.hello.test.entity.UserEntity;
import com.hello.test.repository.UserRepository;
import com.hello.test.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuketao
 * @date 2019/9/15
 * @Description 用户服务类
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 通过vo对象创建实例对象
     *
     * @param user
     * @return
     */
    public UserEntity saveUser(User user) {
        return userRepository.save(user.getUserEntity());
    }
}
