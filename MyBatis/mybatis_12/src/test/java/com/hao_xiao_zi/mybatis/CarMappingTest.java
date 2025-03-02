package com.hao_xiao_zi.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        PageHelper.startPage(2,3);
        List <Car> cars = mapper.selectByExample(null);
//        for(Car car : cars){
//            System.out.println(car);
//        }
        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 3);
        System.out.println(carPageInfo);
        sqlSession.commit();
        sqlSession.close();
    }
}
