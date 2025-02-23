package com.hao_xiao_zi;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.SqlSessionUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-22
 * Time: 13:55
 */
public class testCarMapping {

    @Test
    public void testSqlSessionUtils(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        int count = sqlSession.insert("insertCar");
        if(count == 1){
            System.out.println("插入成功！");
        }
        sqlSession.close();
    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
            //开启会话和事务
            sqlSession = factory.openSession();
            //业务处理
            int count = sqlSession.insert("insertCar");
            System.out.println("成功插入 " + count + " 条记录");
            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            //事务回滚
            if(sqlSession != null){
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            //关闭
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
