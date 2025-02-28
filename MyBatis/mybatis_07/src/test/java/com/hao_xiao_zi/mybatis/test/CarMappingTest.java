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
}
