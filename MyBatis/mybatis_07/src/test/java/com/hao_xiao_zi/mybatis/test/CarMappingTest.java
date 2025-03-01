package com.hao_xiao_zi.mybatis.test;

import com.hao_xiao_zi.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-28
 * Time: 21:49
 */
public class CarMappingTest {
    @Test
    public void testSelectCarByDynamicCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        List<Car> cars = mapper.selectCarByDynamicCondition("奔驰",null,"");
        for(Car car : cars){
            System.out.println(car);
        }
//        为什么编写查询语句的时候可以不写sqlSession.commit()?
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectCarWithWhere(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        List<Car> cars = mapper.selectCarWithWhere("奔驰",null,"");
        for(Car car : cars){
            System.out.println(car);
        }
//        为什么编写查询语句的时候可以不写sqlSession.commit()?
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectCarWithTrim(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        List<Car> cars = mapper.selectCarWithTrim("奔驰",1.00,"燃油车");
        for(Car car : cars){
            System.out.println(car);
        }
//        为什么编写查询语句的时候可以不写sqlSession.commit()?
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateCarWithSet(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        int count = mapper.updateCarWithSet(new Car(166L,"","奥迪A6",50.00,"",""));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectCarWithChooseWhenOtherwise(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        List<Car> cars = mapper.selectCarWithChooseWhenOtherwise("",null,"新能源");
        for(Car car : cars){
            System.out.println(car);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteCarWithForEach(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        int count = mapper.deleteCarWithForEach(new Long[]{255L,256L});
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteCarWithForEach1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        int count = mapper.deleteCarWithForEach1(new Long[]{255L,256L});
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarWithForEach(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        List<Car> list = new LinkedList<>();
        Car car1 = new Car(null,"34","奥迪A8",90.00,"2020-10-10","燃油车");
        Car car2 = new Car(null,"44","红旗H6",100.00,"2022-10-10","燃油车");
        list.add(car1);
        list.add(car2);
        int count = mapper.insertCarWithForEach(list);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
