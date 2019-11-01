package com.hello.gatewaysecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author wuketao
 * @date 2019/10/24
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRole {

    /**
     * 自增主键id
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 用户登录名
     */
    @Column(length = 50)
    private String userName;
    /**
     * 角色名
     */
    @Column(length = 50)
    private String roleName;
}
