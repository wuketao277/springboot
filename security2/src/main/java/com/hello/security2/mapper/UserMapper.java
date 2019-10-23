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
     * 通过用户登录名，获取所有授权角色
     *
     * @param userName 登录名
     * @return 授权角色
     */
    @Select("select role_name from sys_user_role where user_name = #{userName} ")
    List<String> findRolesByUsername(@Param("userName") String userName);
}