package com.hello.uam.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author wuketao
 * @date 2019/10/26
 * @Description
 */
@Scope("prototype")
@Component
public class Person {
    public String name;
}
