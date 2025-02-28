package com.hao_xiao_zi.mybatis.test;

import com.hao_xiao_zi.mybatis.mapper.CarMapping;
import com.hao_xiao_zi.mybatis.pojo.Car;
import com.hao_xiao_zi.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-28
 * Time: 9:42
 */
public class CarMappingTest {
    @Test
    public void testInsertCarAndGetId(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        Car car = new Car(null,"8888","奔驰C",88.0,"2020-10-10","燃油车");
        System.out.println("插入前：" + car);
        mapper.insertCarAndGetId(car);
        System.out.println("插入后：" + car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectCarCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        Integer count = mapper.selectCarCount();
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAllCarByResultMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        List<Car> list = mapper.selectAllCarByResultMap();
        for(Car car : list){
            System.out.println(car);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAllCarByRetMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        Map<Long,Map<String,Object>> maps = mapper.selectAllCarByRetMap();
        System.out.println(maps);
        sqlSession.commit();
        sqlSession.close();
    }
}
