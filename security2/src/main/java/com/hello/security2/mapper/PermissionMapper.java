package com.hello.security2.mapper;

import com.hello.security2.bean.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限配置接口
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
public interface PermissionMapper {
    /**
     * 查询所有权限
     */
    @Select(" select * from sys_permission ")
    List<Permission> findAllPermission();
}
