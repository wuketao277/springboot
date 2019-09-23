package com.hello.datasource.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author wuketao
 * @date 2019/9/14
 * 用户类实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long Id;

    @Column(length = 32, nullable = false)
    public String name;
}
