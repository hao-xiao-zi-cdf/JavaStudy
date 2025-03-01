package com.hao_xiao_zi.mybatis.test;

import com.hao_xiao_zi.mybatis.mapper.StudentMapping;
import com.hao_xiao_zi.mybatis.pojo.Student;
import com.hao_xiao_zi.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-01
 * Time: 14:53
 */
public class StudentMappingTest {
    @Test
    public void testSelectStuInfoById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        Student stu = mapper.selectStuInfoById(1);
        System.out.println(stu);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectStuInfoById1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        Student stu = mapper.selectStuInfoById1(1);
        System.out.println(stu);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectStuInfoByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        Student stu = mapper.selectStuByStep1(1);
        System.out.println(stu);
        sqlSession.commit();
        sqlSession.close();
    }
}
