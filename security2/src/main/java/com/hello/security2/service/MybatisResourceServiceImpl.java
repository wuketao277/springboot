package com.hello.security2.service;

import com.hello.security2.bean.Resource;
import com.hello.security2.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统资源服务类
 *
 * @author wuketao
 * @date 2019/11/1
 * @Description
 */
@Service("MybatisResourceServiceImpl")
public class MybatisResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    private Map<String, String[]> resourceMap = new ConcurrentHashMap<>();

    /**
     * 获取资源映射表
     *
     * @return
     */
    @Override
    public Map<String, String[]> getResourceMap() {
        if (resourceMap.isEmpty()) {
            updateResourceMap();
        }
        return resourceMap;
    }

    /**
     * 更新资源映射表
     */
    @Override
    public synchronized void updateResourceMap() {
        if (resourceMap.isEmpty()) {
            List<Resource> resourceList = resourceMapper.findAll();
            Map<String, String[]> map = new ConcurrentHashMap<>();
            resourceList.forEach(resource -> {
                map.put(resource.getUrl(), resource.getRoles().isEmpty() ? new String[]{} : resource.getRoles().split(";"));
            });

            resourceMap = map;
        }
    }

}
