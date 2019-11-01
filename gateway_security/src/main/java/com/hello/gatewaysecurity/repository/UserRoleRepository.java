package com.hello.gatewaysecurity.repository;

import com.hello.gatewaysecurity.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户角色对象数据访问接口
 *
 * @author wuketao
 * @date 2019/10/24
 * @Description
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    /**
     * 通过登录名获得角色集合
     *
     * @param userName 登录名
     * @return 角色集合
     */
    List<UserRole> findByUserName(String userName);
}
