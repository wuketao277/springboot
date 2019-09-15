package com.hello.datasource.repository;

import com.hello.datasource.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wuketao
 * @data 2019/9/13
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
