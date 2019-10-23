package com.hello.security2.bean;

import lombok.Data;

/**
 * 角色类
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Data
public class Role {
    /**
     * 角色id
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
}
