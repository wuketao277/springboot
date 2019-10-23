package com.hello.security2.service;

import com.hello.security2.bean.Permission;
import com.hello.security2.bean.User;
import com.hello.security2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 自定义UserDetailsService类
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    /**
     * 注入用户映射工具类
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 重写方法，通过登录名获取用户信息
     *
     * @param username 登录名
     * @return 用户信息
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 通过登录名获取用户信息
        User user = userMapper.findByUsername(username);
        if (!Objects.isNull(user)) {
            List<Permission> permissionList = userMapper.findPermissionByUsername(username);
            if (permissionList != null && permissionList.size() > 0) {
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                permissionList.stream().forEach(e -> {
                    authorities.add(new SimpleGrantedAuthority(e.getPermTag()));
                });
                user.setAuthorities(authorities);
            }
        }
        return user;
    }
}