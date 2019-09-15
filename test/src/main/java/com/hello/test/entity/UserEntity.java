package com.hello.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

/**
 * @author wuketao
 * @date 2019/9/15
 * @Description
 */
@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    public Long id;

    @Column(length = 100)
    public String name;

    public Calendar birthday;

    public Calendar deathday;
}
