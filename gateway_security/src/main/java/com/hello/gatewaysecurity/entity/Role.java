package com.hello.gatewaysecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 角色类
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    /**
     * 角色id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 角色名称
     */
    @Column(length = 50)
    private String roleName;
    /**
     * 角色描述
     */
    @Column(length = 100)
    private String roleDesc;
}
