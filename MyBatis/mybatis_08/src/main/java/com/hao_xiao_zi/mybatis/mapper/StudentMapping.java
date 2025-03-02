package com.hao_xiao_zi.mybatis.mapper;

import com.hao_xiao_zi.mybatis.pojo.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-01
 * Time: 14:43
 */
public interface StudentMapping {

    /**
     * 使用级联属性映射并根据学生ID查询信息
     * @param id 学生id
     * @return 学生信息
     */
    Student selectStuInfoById(Integer id);

    Student selectStuInfoById1(Integer id);

    /**
     * 分布查询：1.先根据id查询学生信息 2.再根据查询到的cid查询相关班级信息
     * @param id
     * @return
     */
    Student selectStuByStep1(Integer id);

    List<Student> selectStuByStep2(Integer id);
}
