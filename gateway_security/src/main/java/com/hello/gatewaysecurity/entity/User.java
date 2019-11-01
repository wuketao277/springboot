package com.hello.gatewaysecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 用户信息表
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 登录名
     */
    @Column(length = 50)
    private String userName;
    /**
     * 真实姓名
     */
    @Column(length = 50)
    private String realName;
    /**
     * 密码
     */
    @Column(length = 50)
    private String password;
    /**
     * 创建日期
     */
    @Column
    private Date createDate;
    /**
     * 最后登录时间
     */
    @Column
    private Date lastLoginTime;
    /**
     * 是否可用
     */
    @Column
    private boolean enabled;
    /**
     * 是否过期
     */
    @Column
    private boolean accountNonExpired;
    /**
     * 是否锁定
     */
    @Column
    private boolean accountNonLocked;
    /**
     * 证书是否过期
     */
    @Column
    private boolean credentialsNonExpired;
//    /**
//     * 用户所有权限
//     */
//    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
}