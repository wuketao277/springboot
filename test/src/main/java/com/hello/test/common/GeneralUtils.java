package com.hello.test.common;

import com.alibaba.fastjson.JSON;
import com.hello.test.entity.UserEntity;
import com.hello.test.vo.User;

import java.lang.reflect.Field;
import java.util.Calendar;

/**
 * @author wuketao
 * @date 2019/9/15
 * @Description
 */
public class GeneralUtils {

    /**
     * 浅拷贝方法
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void SimpleCopy(Object source, Object target) {
        Field[] sourceDeclaredFields = source.getClass().getDeclaredFields();
        Field[] targetDeclaredFields = target.getClass().getDeclaredFields();
        for (Field tField : targetDeclaredFields) {
            for (Field sField : sourceDeclaredFields) {
                if (tField.getName().equals(sField.getName()) && tField.getType().equals(sField.getType())) {
                    // 目标对象属性名称、类型与源对象属性名称、类型相同的情况下，就进行赋值
                    try {
                        // 首先设置变量的accessible的属性为true，然后获取值并赋给目标对象属性。
                        sField.setAccessible(true);
                        tField.set(target, sField.get(source));
                        break;
                    } catch (Exception ex) {
                    }
                }
            }
        }
    }
}
