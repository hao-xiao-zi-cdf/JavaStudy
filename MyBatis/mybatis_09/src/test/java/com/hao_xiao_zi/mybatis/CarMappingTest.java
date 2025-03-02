package com.hao_xiao_zi.mybatis;

import com.hao_xiao_zi.mybatis.mapper.CarMapping;
import com.hao_xiao_zi.mybatis.mapper.ClazzMapping;
import com.hao_xiao_zi.mybatis.pojo.Car;
import com.hao_xiao_zi.mybatis.utils.SqlSessionUtils;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-02
 * Time: 11:01
 */
public class CarMappingTest {
    @Test
    public void testSelectCarByCache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CarMapping mapper = sqlSession.getMapper(CarMapping.class);
        Car car1 = mapper.selectCarByCache(166L);
        System.out.println(car1);

//        手动清空sqlSession的一级缓存
//        sqlSession.clearCache();
        ClazzMapping mapper2 = sqlSession.getMapper(ClazzMapping.class);
        int count = mapper2.deleteClazzById(1000);
        System.out.println(count);

        CarMapping mapper1 = sqlSession.getMapper(CarMapping.class);
        Car car2 = mapper1.selectCarByCache(166L);
        System.out.println(car2);
    }

    @Test
    public void testSelectCarByCache1() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();

        CarMapping mapper1 = sqlSession1.getMapper(CarMapping.class);
        CarMapping mapper2 = sqlSession2.getMapper(CarMapping.class);

        Car car1 = mapper1.selectCarByCache(166L);
        System.out.println(car1);
        sqlSession1.close();

        Car car2 = mapper2.selectCarByCache(166L);
        System.out.println(car2);


        sqlSession2.close();

    }
}
