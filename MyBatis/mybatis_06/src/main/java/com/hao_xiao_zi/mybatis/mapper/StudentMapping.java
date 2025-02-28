package com.hao_xiao_zi.mybatis.mapper;

import com.hao_xiao_zi.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-28
 * Time: 9:55
 */
public interface StudentMapping {

    /**
     * 参数的传递
     * 当接口中的方法为单个参数，且为简单类型的参数时
     * 通过id,name,birth,sex字段进行查询
     * @return 查询到的学生列表
     */
    List<Student> selectStuById(Long id);

    List<Student> selectStuByName(String name);

    List<Student> selectStuByBirth(Date date);

    List<Student> selectStuBySex(Character sex);

    /**
     * 根据名字和生日查询学生信息
     * @param name 名字
     * @param date 信息
     * @return 返回对应的学生信息
     */
    List<Student> selectStuByNameAndBirth(String name,Date date);

    List<Student> selectStuByNameAndBirth1(@Param("name") String name, @Param("date") Date date);

    /**
     * 当查询的数据没有合适的pojo类进行描述，可以使用map集合进行接收
     * key为查询到的数据在数据库中对应的字段，value为查询的字段值
     * @param id 查询的学生id
     * @return 返回存储学生相关信息的map集合
     */
    Map<String,Object> selectByIdGetStuMap(Long id);

    /**
     * 使用map集合接收所有学生的信息
     * @return 所有学生的信息
     */
    List<Map<String,Object>> selectByIdGetStuMapList();
}
