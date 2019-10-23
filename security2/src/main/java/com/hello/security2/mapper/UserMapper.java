package com.hello.security2.mapper;

import com.hello.security2.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户信息映射接口
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
public interface UserMapper {
    /**
     * 查询用户信息
     */
    @Select(" select * from sys_user where username = #{userName}")
    User findByUsername(@Param("userName") String userName);

    /**
     * 通过用户登录名，获取所有授权资源标识
     *
     * @param userName 登录名
     * @return 授权资源标识集合
     */
    @Select("SELECT resource_mark FROM sys_role_resource WHERE role_name IN ( " +
            " SELECT role_name FROM sys_user_role WHERE user_name = #{userName} )")
    List<String> findResourcemarkByUsername(@Param("userName") String userName);
}