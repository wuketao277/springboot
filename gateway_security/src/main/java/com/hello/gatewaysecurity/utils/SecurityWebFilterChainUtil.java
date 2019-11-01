package com.hello.gatewaysecurity.utils;

import com.google.common.base.Strings;
import com.hello.gatewaysecurity.entity.Resource;
import com.hello.gatewaysecurity.repository.ResourceRepository;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.List;

/**
 * @author wuketao
 * @date 2019/11/1
 * @Description
 */
public class SecurityWebFilterChainUtil {
    public static SecurityWebFilterChain webFluxSecurityFilterChain(ResourceRepository resourceRepository, ServerHttpSecurity http) throws Exception {
        ServerHttpSecurity.AuthorizeExchangeSpec authorizeExchangeSpec = http.authorizeExchange();

        // 动态获取资源权限配置
        // 获取所有资源
        List<Resource> resourceList = resourceRepository.findAll();
        if (null != resourceList) {
            for (Resource r : resourceList) {
                if (!r.getAuthentication()) {
                    // 不要求认证
                    authorizeExchangeSpec.pathMatchers(r.getUrl()).permitAll();
                } else if (r.getAuthentication() && Strings.isNullOrEmpty(r.getRoles())) {
                    // 只要求认证，不要求特定角色
                    authorizeExchangeSpec.pathMatchers(r.getUrl()).authenticated();
                } else if (r.getAuthentication() && !Strings.isNullOrEmpty(r.getRoles())) {
                    // 要求认证，且要求特定角色
                    authorizeExchangeSpec.pathMatchers(r.getUrl()).hasRole(r.getRoles());
                } else {
                    authorizeExchangeSpec.pathMatchers(r.getUrl()).denyAll();
                }
            }
        }

        // 设置登录页
        authorizeExchangeSpec
                .pathMatchers("/security/**").permitAll()
                .anyExchange().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .and()
                .httpBasic().and()
                .csrf().disable();
        return http.build();
    }
}
