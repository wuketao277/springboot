package com.hello.gatewaysecurity.controller;

import com.hello.gatewaysecurity.repository.ResourceRepository;
import com.hello.gatewaysecurity.utils.SecurityWebFilterChainUtil;
import com.hello.gatewaysecurity.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuketao
 * @date 2019/10/27
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("security")
public class MySecurityController {
    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping("refreshSecurityConfig")
    public String refreshSecurityConfig(ServerHttpSecurity http) {
        SecurityWebFilterChain bean = SpringContextUtil.getContext().getBean(SecurityWebFilterChain.class);
        try {
            bean = SecurityWebFilterChainUtil.webFluxSecurityFilterChain(resourceRepository, http);
        } catch (Exception ex) {
        }
        return "ok";
    }
}
