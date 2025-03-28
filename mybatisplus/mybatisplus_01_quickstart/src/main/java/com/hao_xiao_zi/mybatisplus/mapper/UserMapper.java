package com.hao_xiao_zi.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-27
 * Time: 20:43
 */
//之前编写mapper接口，需要编写各种方法，但是使用mybatis-plus后
//它为我们提供了许多通用的方法，以便我们进行开发,只需要继承BaseMapper类
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
