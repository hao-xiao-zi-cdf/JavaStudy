package com.hao_xiao_zi.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 在自己定义的sql语句中通过分页插件的分页功能进行数据查询
     * @param page 在sql语句中不需要用到page参数，但是如果想要使用分页插件的分页功能就要求有page参数且为第一个参数
     * @param age 年龄
     * @return 分页对象
     */
    Page<User> selectPageByAge(@Param("page") Page<User> page, @Param("age") Integer age);
}
