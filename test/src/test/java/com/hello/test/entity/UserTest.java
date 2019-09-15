package com.hello.test.entity;

import com.hello.test.vo.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;


/**
 * @author wuketao
 * @date 2019/9/15
 */
public class UserTest {

    private User user = new User();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 测试名称设置不能超过100个字符，产生非法参数异常
     */
    @Test(expected = IllegalArgumentException.class)
    public void setName_Length100() {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 101; i++) {
            name.append("a");
        }

        user.setName(name.toString());
    }

    /**
     * 测试名称设置可以等于100个字符
     */
    @Test
    public void setName_OK() {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            name.append("a");
        }

        user.setName(name.toString());
        Assert.assertTrue(name.toString().equals(user.getName()));
    }

    /**
     * 测试生日大于当前时间，产生非法参数异常
     */
    @Test(expected = IllegalArgumentException.class)
    public void setBirthday_AfterToday() {
        Calendar birthday = Calendar.getInstance();
        birthday.add(Calendar.DAY_OF_YEAR, 1);
        user.setBirthday(birthday);
    }

    /**
     * 测试生日小于 等于 当前时间
     */
    @Test
    public void setBirthday_BeforeToday() {
        Calendar birthday = Calendar.getInstance();
        birthday.add(Calendar.DAY_OF_YEAR, -2);
        user.setBirthday(birthday);
        Assert.assertTrue(birthday.equals(user.getBirthday()));

        birthday = Calendar.getInstance();
        user.setBirthday(birthday);
        Assert.assertTrue(birthday.equals(user.getBirthday()));
    }

    /**
     * 测试死亡日期大于当前时间，产生非法参数异常
     */
    @Test(expected = IllegalArgumentException.class)
    public void setDeathday_AfterToday() {
        Calendar birthday = Calendar.getInstance();
        birthday.add(Calendar.DAY_OF_YEAR, 1);
        user.setDeathday(birthday);
    }

    /**
     * 测试死亡日期小于 等于 当前时间
     */
    @Test
    public void setDeathday_BeforeToday() {
        Calendar deathday = Calendar.getInstance();
        deathday.add(Calendar.DAY_OF_YEAR, -2);
        user.setDeathday(deathday);
        Assert.assertTrue(deathday.equals(user.getDeathday()));

        deathday = Calendar.getInstance();
        user.setDeathday(deathday);
        Assert.assertTrue(deathday.equals(user.getDeathday()));
    }

    @Test
    public void getAge() {
        // 1年前出生，到现在是1岁
        Calendar birthday = Calendar.getInstance();
        birthday.add(Calendar.YEAR, -1);
        user.setBirthday(birthday);
        Assert.assertTrue(1 == user.getAge());
        // 1年零1天前出生，到现在是2岁
        birthday.add(Calendar.DAY_OF_YEAR, -1);
        user.setBirthday(birthday);
        Assert.assertTrue(2 == user.getAge());
        // 2010-1-1出生，2015-5-5死亡，年龄是6岁
        birthday.set(2010, 1, 1);
        user.setBirthday(birthday);
        Calendar deathDay = Calendar.getInstance();
        deathDay.set(2015, 5, 5);
        user.setDeathday(deathDay);
        Assert.assertTrue(6 == user.getAge());
    }
}