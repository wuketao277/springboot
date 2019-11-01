package com.hello.gatewaysecurity.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    /**
     * 认证失败处理方法
     *
     * @param req
     * @param res
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException auth)
            throws IOException, ServletException {
        System.out.println("用户认证失败");
        res.sendRedirect("/uam/login");
    }
}
