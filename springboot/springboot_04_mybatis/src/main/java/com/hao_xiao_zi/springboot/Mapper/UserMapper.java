package com.hao_xiao_zi.springboot.Mapper;

import com.hao_xiao_zi.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-31
 * Time: 16:50
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User selectUserById(Long id);
}
