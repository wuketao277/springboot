package com.hello.test.service;

import com.hello.test.TestApplication;
import com.hello.test.entity.UserEntity;
import com.hello.test.repository.UserRepository;
import com.hello.test.vo.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;

/**
 * @author wuketao
 * @date 2019/9/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @After
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setName("小明");
        Calendar birthday = Calendar.getInstance();
        birthday.add(Calendar.YEAR, -10);
        user.setBirthday(birthday);
        Calendar deathday = Calendar.getInstance();
        deathday.add(Calendar.YEAR, -1);
        user.setDeathday(deathday);

        UserEntity userEntity = userService.saveUser(user);
        Assert.assertTrue(user.getName().equals(userEntity.name));
        Assert.assertTrue(user.getBirthday().equals(userEntity.birthday));
        Assert.assertTrue(user.getDeathday().equals(userEntity.deathday));
        Assert.assertTrue(userEntity.id > 0);
    }
}