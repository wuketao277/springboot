package com.hello.security2.bean;

import lombok.Data;

/**
 * 系统资源
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Data
public class Resource {
    /**
     * 资源id
     */
    private Integer id;
    /**
     * 资源中文名称
     */
    private String name;
    /**
     * 角色集合
     */
    private String roles;
    /**
     * 请求url
     */
    private String url;
}
