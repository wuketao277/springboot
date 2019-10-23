package com.hello.security2.mapper;

import com.hello.security2.bean.Resource;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wuketao
 * @date 2019/10/23
 * @Description
 */
public interface ResourceMapper {
    /**
     * 获取全部资源
     *
     * @return 资源列表
     */
    @Select(" select * from sys_resource ")
    List<Resource> findAll();
}
