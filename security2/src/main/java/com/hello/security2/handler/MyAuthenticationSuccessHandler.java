package com.hello.security2.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证成功处理器
 *
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * 用户认证成功
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
            throws IOException, ServletException {
        System.out.println("用户登陆成功");
        res.sendRedirect("/");
    }
}