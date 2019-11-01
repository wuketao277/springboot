package com.hello.gatewaysecurity.service;

import com.hello.gatewaysecurity.bean.MyUserDetail;
import com.hello.gatewaysecurity.entity.User;
import com.hello.gatewaysecurity.entity.UserRole;
import com.hello.gatewaysecurity.repository.UserRepository;
import com.hello.gatewaysecurity.repository.UserRoleRepository;
import com.hello.gatewaysecurity.utils.UserAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuketao
 * @date 2019/10/31
 * @Description
 */
@Service
public class MysqlReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

    /**
     * 用户仓库
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * 用户角色关联表仓库
     */
    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * 通过用户名获得用户权限信息
     *
     * @param username
     * @return
     */
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        // 通过用户名查询用户实体对象
        User user = userRepository.findByUserName(username);
        // 将实体对象转换为用户权限对象
        MyUserDetail myUserDetail = UserAdapter.getInstance().fromUser(user);
        // 通过用户名查询用户角色信息，并将角色保持到用户权限对象中
        List<UserRole> userRoleList = userRoleRepository.findByUserName(user.getUserName());
        if (null != userRoleList) {
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            userRoleList.forEach(ur -> grantedAuthorityList.add(new SimpleGrantedAuthority(ur.getRoleName())));
            myUserDetail.setAuthorities(grantedAuthorityList);
        }

        Mono<UserDetails> userDetailMono = Mono.defer(() -> Mono.justOrEmpty(myUserDetail));
        return userDetailMono;
    }
}
