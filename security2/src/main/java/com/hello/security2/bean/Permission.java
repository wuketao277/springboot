package com.hello.security2.bean;

import lombok.Data;

/**
 * 权限资源类
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Data
public class Permission {
    private Integer id;
    /**
     * 权限名称
     */
    private String permName;
    /**
     * 权限标识
     */
    private String permTag;
    /**
     * 请求url
     */
    private String url;
}