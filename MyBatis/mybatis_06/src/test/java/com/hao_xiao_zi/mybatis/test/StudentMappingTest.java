package com.hao_xiao_zi.mybatis.test;

import com.hao_xiao_zi.mybatis.mapper.StudentMapping;
import com.hao_xiao_zi.mybatis.pojo.Student;
import com.hao_xiao_zi.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-28
 * Time: 9:56
 */
public class StudentMappingTest {
    @Test
    public void testSelectStuById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        List<Student> students = mapper.selectStuById(1L);
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectStuByName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        List<Student> students = mapper.selectStuByName("张三");
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectStuBySex(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        Character c = Character.valueOf('男');
        List<Student> students = mapper.selectStuBySex(c);
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectStuByBirth() throws ParseException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2022-09-01");
        List<Student> students = mapper.selectStuByBirth(date);
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectStuByNameAndBirth() throws ParseException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2022-09-01");
        List<Student> students = mapper.selectStuByNameAndBirth("赵六",date);
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectStuByNameAndBirth1() throws ParseException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2022-09-01");
        List<Student> students = mapper.selectStuByNameAndBirth1("赵六",date);
        for (Student stu:students){
            System.out.println(stu);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByIdGetStuMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        Map<String,Object> map = mapper.selectByIdGetStuMap(1L);
        System.out.println(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByIdGetStuMapList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapping mapper = sqlSession.getMapper(StudentMapping.class);
        List<Map<String,Object>> list = mapper.selectByIdGetStuMapList();
        for (Map<String,Object> map:list){
            System.out.println(map);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
