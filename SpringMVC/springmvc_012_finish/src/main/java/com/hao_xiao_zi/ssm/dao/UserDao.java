package com.hao_xiao_zi.ssm.dao;

import org.apache.ibatis.annotations.Select;
import com.hao_xiao_zi.ssm.bean.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-24
 * Time: 17:15
 */
public interface UserDao {
    @Select("select * from user where id = #{id}")
    User selectById(Long id);
}
