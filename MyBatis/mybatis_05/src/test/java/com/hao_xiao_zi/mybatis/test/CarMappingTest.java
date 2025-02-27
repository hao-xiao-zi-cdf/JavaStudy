package com.hao_xiao_zi.mybatis.test;

import com.hao_xiao_zi.mybatis.mapper.CarMapping;
import com.hao_xiao_zi.mybatis.pojo.Car;
import com.hao_xiao_zi.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-27
 * Time: 20:41
 */
public class CarMappingTest {
    @Test
    public void testSelectCarByCarType(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        List<Car> list = mapper.selectCarByCarType("燃油车");
        for(Car car : list){
            System.out.println(car);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectCarByDescOrAsc(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        List<Car> list = mapper.selectCarByDescOrAsc("desc");
        for(Car car : list){
            System.out.println(car);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectCarByDim(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        List<Car> list = mapper.selectCarByDim("奔驰");
        for(Car car : list){
            System.out.println(car);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
