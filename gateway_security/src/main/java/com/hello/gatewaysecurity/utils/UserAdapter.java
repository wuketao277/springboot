package com.hello.gatewaysecurity.utils;

import com.hello.gatewaysecurity.bean.MyUserDetail;
import com.hello.gatewaysecurity.entity.User;

/**
 * 用户适配器
 *
 * @author wuketao
 * @date 2019/10/24
 * @Description
 */
public class UserAdapter {
    /**
     * 私有构造函数
     */
    private UserAdapter() {
    }

    /**
     * 私有静态实例
     */
    private static UserAdapter instance = new UserAdapter();

    /**
     * 获取私有静态实例
     *
     * @return 对象实例
     */
    public static UserAdapter getInstance() {
        return instance;
    }

    /**
     * 从User对象转MyUserDetail对象
     *
     * @param user
     * @return
     */
    public MyUserDetail fromUser(User user) {
        MyUserDetail detail = new MyUserDetail();
        if (null != user) {
            detail.setAccountNonExpired(user.isAccountNonExpired());
            detail.setAccountNonLocked(user.isAccountNonLocked());
            detail.setCreateDate(user.getCreateDate());
            detail.setEnabled(user.isEnabled());
            detail.setCredentialsNonExpired(user.isCredentialsNonExpired());
            detail.setId(user.getId());
            detail.setLastLoginTime(user.getLastLoginTime());
            detail.setPassword(user.getPassword());
            detail.setRealname(user.getRealName());
            detail.setUsername(user.getUserName());
        }
        return detail;
    }
}
