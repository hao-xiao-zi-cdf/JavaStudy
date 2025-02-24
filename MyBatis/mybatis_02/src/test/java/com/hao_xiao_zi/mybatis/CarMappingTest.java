package com.hao_xiao_zi.mybatis;

import com.hao_xiao_zi.pojo.Car;
import com.hao_xiao_zi.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-24
 * Time: 17:14
 */
public class CarMappingTest {

    @Test
    public void testSelectAllCar(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        List<Object> list = sqlSession.selectList("selectAll");
        for(Object car:list){
            System.out.println(car);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectOneCar(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Object car = sqlSession.selectOne("selectOne", 201);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateCar(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Car car = new Car(185L,"8888","奔驰",88.0,"2020-10-10","燃油车");
        int count = sqlSession.insert("updateCar", car);
        System.out.println("成功跟新" + count + " 记录!");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteCar(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        int count = sqlSession.insert("deleteCar", 165);
        System.out.println("成功删除" + count + " 记录!");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Car car = new Car(null,"8888","奔驰",88.0,"2020-10-10","燃油车");
        int count = sqlSession.insert("insertCar1", car);
        System.out.println("成功插入" + count + " 记录!");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //业务处理
        Map<String,Object> map = new HashMap<>();
        map.put("car_num",444);
        map.put("brand","奥迪A8");
        map.put("guide_price",55.0);
        map.put("produce_time","2023-10-10");
        map.put("car_type","燃油车");
        int count = sqlSession.insert("car.insertCar", map);
        System.out.println("插入" + count + " 条记录");

        //提交事务并关闭执行对象
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testEnvironment() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        Car car = new Car(null,"8888","奔驰C",88.0,"2020-10-10","燃油车");
        int count = sqlSession.insert("car.insertCar", car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testEnvironment1() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"),"development1");
        SqlSession sqlSession = factory.openSession();
        Car car = new Car(null,"8888","奔驰C",88.0,"2020-10-10","燃油车");
        int count = sqlSession.insert("car.insertCar", car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDateSource() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        //第一次打开会话
        SqlSession sqlSession = factory.openSession();
        Car car = new Car(null,"8888","奔驰C",88.0,"2020-10-10","燃油车");
        int count = sqlSession.insert("car.insertCar", car);
        sqlSession.commit();
        sqlSession.close();
        //第二次打开会话
        SqlSession sqlSession1 = factory.openSession();
        car = new Car(null,"8888","奔驰C",88.0,"2020-10-10","燃油车");
        count = sqlSession1.insert("car.insertCar", car);
        sqlSession1.commit();
        sqlSession1.close();
    }

    @Test
    public void testDateSource1() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        for (int i = 0; i < 4; i++) {
            SqlSession sqlSession1 = factory.openSession();
            Car car = new Car(null,"8888","奔驰C",88.0,"2020-10-10","燃油车");
            sqlSession1.insert("car.insertCar", car);
        }
    }
}
