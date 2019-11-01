package com.hello.gatewaysecurity.repository;

import com.hello.gatewaysecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 角色对象数据访问接口
 *
 * @author wuketao
 * @date 2019/10/24
 * @Description
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
