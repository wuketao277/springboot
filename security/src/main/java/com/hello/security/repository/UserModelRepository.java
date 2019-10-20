package com.hello.security.repository;

import com.hello.security.bean.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wuketao
 * @date 2019/10/15
 * @Description
 */
@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByUserName(String userName);
}
