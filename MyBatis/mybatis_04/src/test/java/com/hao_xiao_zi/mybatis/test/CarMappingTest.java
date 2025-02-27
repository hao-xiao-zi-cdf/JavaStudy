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
 * Time: 20:03
 */
public class CarMappingTest {
    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        Car car = new Car(null,"8888","奔驰C",88.0,"2020-10-10","燃油车");
        mapper.insertCar(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteCarById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        mapper.deleteCarById(229L);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateCarById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        Car car = new Car(253L,"8888","奔驰B",88.0,"2020-10-10","燃油车");
        mapper.updateCarById(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectOneById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        Car car = mapper.selectOneById(173L);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        Car car = new Car(null,"8888","奔驰C",88.0,"2020-10-10","燃油车");
        List<Car> list =  mapper.selectAll();
        for(Car car1:list){
            System.out.println(car1);
        }
        sqlSession.commit();
        sqlSession.close();
    }








}
