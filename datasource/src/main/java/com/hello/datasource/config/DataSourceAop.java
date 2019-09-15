package com.hello.datasource.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wuketao
 * @date 2019/9/14
 * 数据源切片
 */
@Aspect
@Component
@Slf4j
public class DataSourceAop {

    /**
     * 环绕切片，在实际方法执行前设置数据源
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(public * com.hello.datasource.service..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 通过方法名的前缀来判断是否使用从库
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.getName().startsWith("find") || targetMethod.getName().startsWith("select")
                || targetMethod.getName().startsWith("get")) {
            // 只读方法设置使用从库
            DynamicDataSourceHolder.setDataSource(DataSourceConstant.READ_DATASOURCE);
        }
        // 执行实际方法
        Object result = pjp.proceed();
        DynamicDataSourceHolder.clearDataSource();

        return result;
    }
}
