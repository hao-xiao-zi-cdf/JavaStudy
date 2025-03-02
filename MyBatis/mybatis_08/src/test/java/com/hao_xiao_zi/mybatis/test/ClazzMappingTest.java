package com.hao_xiao_zi.mybatis.test;

import com.hao_xiao_zi.mybatis.mapper.ClazzMapping;
import com.hao_xiao_zi.mybatis.mapper.StudentMapping;
import com.hao_xiao_zi.mybatis.pojo.Clazz;
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
        Clazz clazz = mapper.selectSameClazzStudentsByName("高三一班");
        System.out.println(clazz);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectSameClazzStus(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClazzMapping mapper = sqlSession.getMapper(ClazzMapping.class);
        Clazz clazz = mapper.selectSameClazzStudentsByNameAndStep1("高三一班");
        System.out.println(clazz);
        sqlSession.commit();
        sqlSession.close();
    }
}
