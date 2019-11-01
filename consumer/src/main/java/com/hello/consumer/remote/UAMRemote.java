package com.hello.consumer.remote;

import com.hello.consumer.impl.UAMRemoteImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wuketao
 * @date 2019/10/26
 * @Description
 */
@FeignClient(name = "uam",fallback = UAMRemoteImpl.class)
public interface UAMRemote {
    @GetMapping("/user/users")
    String users();
}
