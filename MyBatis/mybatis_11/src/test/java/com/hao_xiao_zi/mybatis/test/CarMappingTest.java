package com.hao_xiao_zi.mybatis.test;

import com.hao_xiao_zi.mybatis.mapper.CarMapper;
import com.hao_xiao_zi.mybatis.pojo.Car;
import com.hao_xiao_zi.mybatis.pojo.CarExample;
import com.hao_xiao_zi.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-02
 * Time: 16:52
 */
public class CarMappingTest {
    @Test
    public void testSelectByPrimaryKey(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectByPrimaryKey(257L);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByExample(null);
        for(Car car : cars){
            System.out.println(car);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        //CarExample对象用来封装查询条件
        CarExample carExample = new CarExample();
        //创建查询条件
        carExample.createCriteria().andBrandLike("%奥迪%").
                andGuidePriceGreaterThan(new BigDecimal(1.00)).andCarTypeEqualTo("燃油车");
        carExample.or().andBrandLike("%红旗%");

        List<Car> cars = mapper.selectByExample(carExample);
        for(Car car : cars){
            System.out.println(car);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
