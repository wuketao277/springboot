package com.hello.datasource.service;

import com.hello.datasource.bean.User;
import com.hello.datasource.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveList(List<User> userList) {
        addOne();
        for (User user : userList) {
            userRepository.save(user);
        }
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addOne() {
        User user = new User("李四");
        userRepository.save(user);
    }
}
