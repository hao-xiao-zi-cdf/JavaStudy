package com.hao_xiao_zi.springboot.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hao_xiao_zi.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-31
 * Time: 17:38
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
