package com.hello.consumer.impl;

import com.hello.consumer.remote.UAMRemote;
import org.springframework.stereotype.Component;

/**
 * @author wuketao
 * @date 2019/10/26
 * @Description
 */
@Component
public class UAMRemoteImpl implements UAMRemote {
    @Override
    public String users() {
        return "feign user";
    }
}
