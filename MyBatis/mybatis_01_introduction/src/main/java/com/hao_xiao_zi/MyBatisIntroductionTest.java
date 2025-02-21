package com.hao_xiao_zi;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-21
 * Time: 17:04
 */
public class MyBatisIntroductionTest {
    //MyBatis核心库中的几个重要对象
    //1.SqlSessionFactoryBuilder
    //2.SqlSessionFactory
    //3.SqlSession --> MyBatis中执行sql语句的对象，代表java程序与数据库之间的一次会话
    public static void main(String[] args) throws IOException {
        //1.首先通过SqlSessionFactoryBuilder对象构建出SqlSessionFactory对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2.创建SqlSessionFactory对象
        //使用MyBatis中的Resources对象创建输入流对象,自动从类的根路径下查找文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(is);

        //3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //4.执行sql语句
        int count = sqlSession.insert("insertCar");
        if(count == 1){
            System.out.println("插入记录成功！");
        }else{
            System.out.println("插入记录不成功");
        }

        //5.用于提交当前 SqlSession 中的所有更改,MyBatis 默认不会自动提交事务
        sqlSession.commit();
    }
}
