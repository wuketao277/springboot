package com.hello.gatewaysecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 系统资源
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resource {
    /**
     * 资源id
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 资源中文名称
     */
    @Column(length = 100)
    private String name;
    /**
     * 角色集合
     */
    @Column(length = 500)
    private String roles;
    /**
     * 是否要求认证
     */
    @Column
    private Boolean authentication;
    /**
     * 请求url
     */
    @Column(length = 500)
    private String url;
}
