package com.hello.gatewaysecurity.repository;

import com.hello.gatewaysecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户对象数据访问接口
 *
 * @author wuketao
 * @date 2019/10/24
 * @Description
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 通过登录名获取对象
     *
     * @param userName 登录名
     * @return
     */
    User findByUserName(String userName);
}
