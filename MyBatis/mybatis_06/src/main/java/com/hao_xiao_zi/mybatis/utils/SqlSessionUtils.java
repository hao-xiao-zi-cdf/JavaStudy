package com.hao_xiao_zi.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-22
 * Time: 16:10
 */
public class SqlSessionUtils {

    private static SqlSessionFactory factory = null;

    private SqlSessionUtils(){
    }

    static {
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            factory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //创建ThreadLocal对象将线程对象和SqlSession对象绑定，确保同个线程的SqlSession是同一个
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    //获取SqlSession对象
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = local.get();
        if(sqlSession == null){
            sqlSession = factory.openSession();
            //进行绑定
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
        local.remove();
    }
}
