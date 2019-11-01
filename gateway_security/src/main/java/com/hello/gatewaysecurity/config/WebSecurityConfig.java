package com.hello.gatewaysecurity.config;

import com.hello.gatewaysecurity.repository.ResourceRepository;
import com.hello.gatewaysecurity.service.MysqlReactiveUserDetailsServiceImpl;
import com.hello.gatewaysecurity.utils.MD5Util;
import com.hello.gatewaysecurity.utils.SecurityWebFilterChainUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author wuketao
 * @date 2019/10/27
 * @Description
 */
@Slf4j
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {
    /**
     * 权限获取映射
     */
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private MysqlReactiveUserDetailsServiceImpl mysqlReactiveUserDetailsService;

    /**
     * 定义reactive 认证管理器
     *
     * @return
     */
    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager() {
        // 将自定义 ReactiveUserDetailService注入到bean中
        UserDetailsRepositoryReactiveAuthenticationManager userDetailsRepositoryReactiveAuthenticationManager = new UserDetailsRepositoryReactiveAuthenticationManager(mysqlReactiveUserDetailsService);
        // 自定义用户密码验证
        userDetailsRepositoryReactiveAuthenticationManager.setPasswordEncoder(new PasswordEncoder() {
            /**
             * 对表单密码进行加密
             */
            @Override
            public String encode(CharSequence rawPassword) {
                // 调用自定义MD5工具类对用户输入的密码进行加密
                return MD5Util.encode((String) rawPassword);
            }

            /**
             * 加密的密码与数据库密码进行比对
             * rawPassword 表单密码     encodedPassword数据库密码
             */
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                // 返回true代表认证成功，false失败
                return MD5Util.encode((String) rawPassword).equals(encodedPassword);
            }
        });
        return userDetailsRepositoryReactiveAuthenticationManager;
    }

    /**
     * 自定义web安全过滤器
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        return SecurityWebFilterChainUtil.webFluxSecurityFilterChain(resourceRepository, http);
    }
}
