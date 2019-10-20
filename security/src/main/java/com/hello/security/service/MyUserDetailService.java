package com.hello.security.service;

import com.hello.security.repository.UserModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hello.security.bean.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现用户细节服务
 * @author wuketao
 * @date 2019/10/14
 * @Description
 */
@Slf4j
@Service
public class MyUserDetailService implements UserDetailsService {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncode;

    /**
     * 数据库访问
     */
    @Autowired
    private UserModelRepository userRepository;

    /**
     * 通过用户名获得用户信息
     *
     * @param username 用户名
     * @return 用户授权信息
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户名：" + username);

        UserModel userModel = userRepository.findByUserName(username);
        if (userModel == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        User auth_user = new User(userModel.getUserName()
                , passwordEncode.encode(userModel.getPassword())
                , createAuthority(userModel.getRoles()));
        return auth_user;
    }

    /**
     * 这里是将数据库的角色分割，构造GrantedAuthority
     */
    private List<SimpleGrantedAuthority> createAuthority(String roles) {
        String[] roleArray = roles.split(",");
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (String role : roleArray) {
            authorityList.add(new SimpleGrantedAuthority(role));
        }
        return authorityList;
    }
}
