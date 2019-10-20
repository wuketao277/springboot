package com.hello.security.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author wuketao
 * @date 2019/10/15
 * @Description
 */
@Data
@Entity
public class UserModel {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 30)
    private String userName;
    @Column(length = 30)
    private String password;
    @Column(length = 500)
    private String roles;
}
