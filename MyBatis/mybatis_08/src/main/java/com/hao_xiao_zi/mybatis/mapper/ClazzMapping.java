package com.hao_xiao_zi.mybatis.mapper;

import com.hao_xiao_zi.mybatis.pojo.Clazz;
import com.hao_xiao_zi.mybatis.pojo.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-01
 * Time: 14:44
 */
public interface ClazzMapping {
    /**
     * 根据分部1查询到的cid进行查询相关班级信息
     * @param id
     * @return
     */
    Clazz selectClazzById(Integer id);

    Clazz selectSameClazzStudentsByName(String cname);

    /**
     * 使用分部查询找出相同班级的学生信息1.根据班级名称查找出班级编号 2.根据班级编号查找所在班级学生信息
     * @param cname
     * @return
     */
    Clazz selectSameClazzStudentsByNameAndStep1(String cname);
}
