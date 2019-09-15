package com.hello.test.repository;

import com.hello.test.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wuketao
 * @date 2019/9/15
 * @Description
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
