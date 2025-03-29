package com.hao_xiao_zi.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-28
 * Time: 10:55
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据主键id值查询数据封装到map集合
     * @param id 主键id
     * @return map集合
     */
    Map<String,Object> selectMapById(Long id);

    User selectByName(String name);
}
