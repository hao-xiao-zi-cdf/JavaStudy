package com.hao_xiao_zi.mybatis.test;

import com.hao_xiao_zi.mybatis.mapper.ClazzMapping;
import com.hao_xiao_zi.mybatis.mapper.StudentMapping;
import com.hao_xiao_zi.mybatis.pojo.Student;
import com.hao_xiao_zi.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-01
 * Time: 14:53
 */
public class ClazzMappingTest {
    @Test
    public void testSelectStudents(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClazzMapping mapper = sqlSession.getMapper(ClazzMapping.class);
        List<Student> students = mapper.selectSameClazzStudentsById(1000);
        for(Student stu : students){
            System.out.println(stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
