package com.hello.test.vo;

import com.hello.test.common.GeneralUtils;
import com.hello.test.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import java.util.Calendar;

/**
 * @author wuketao
 * @date 2019/9/15
 * @Description
 */
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private String name;

    private Calendar birthday;

    private Calendar deathday;

    private Integer age = 0;

    public User(UserEntity entity) {
        GeneralUtils.SimpleCopy(entity, this);
    }

    /**
     * 获得实体对象
     *
     * @return
     */
    public UserEntity getUserEntity() {
        UserEntity userEntity = new UserEntity();
        GeneralUtils.SimpleCopy(this, userEntity);
        return userEntity;
    }

    public Long getId() {
        return this.id;
    }

    /**
     * 设置用户姓名
     *
     * @param name
     */
    public void setName(String name) throws IllegalArgumentException {
        if ((null != name) && (name.length() <= 100)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 设置用户生日
     *
     * @param birthday
     */
    public void setBirthday(Calendar birthday) {
        if (null != birthday) {
            if (birthday.after(Calendar.getInstance())) {
                throw new IllegalArgumentException();
            } else {
                this.birthday = birthday;
            }
        }
    }

    /**
     * 设置用户死亡日期
     *
     * @param deathday
     */
    public void setDeathday(Calendar deathday) {
        if (null != deathday) {
            if (deathday.after(Calendar.getInstance())) {
                throw new IllegalArgumentException();
            } else {
                this.deathday = deathday;
            }
        }
    }

    /**
     * 获取用户姓名
     *
     * @return 用户姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 获取用户生日
     *
     * @return 用户生日
     */
    public Calendar getBirthday() {
        return birthday;
    }

    /**
     * 获取用户死亡日期
     *
     * @return 用户死亡日期
     */
    public Calendar getDeathday() {
        return deathday;
    }

    /**
     * 获取用户年龄
     *
     * @return 用户年龄
     */
    public Integer getAge() {
        // 有出生日期，才判断年龄
        if (null != birthday) {
            // 赋值临时死亡日期为当前
            Calendar tempDeathday = Calendar.getInstance();
            if (null != this.deathday) {
                tempDeathday = this.deathday;
            }
            this.age = tempDeathday.get(Calendar.YEAR) - this.birthday.get(Calendar.YEAR);
            // 比较死亡日期大于出生日期，年龄就加一。
            if (tempDeathday.get(Calendar.DAY_OF_YEAR) > birthday.get(Calendar.DAY_OF_YEAR)) {
                this.age += 1;
            }
        }
        return age;
    }
}
