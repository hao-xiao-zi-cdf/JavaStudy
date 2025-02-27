package com.hao_xiao_zi.mybatis.test;

import com.hao_xiao_zi.mybatis.mapper.LogMapping;
import com.hao_xiao_zi.mybatis.pojo.Log;
import com.hao_xiao_zi.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-27
 * Time: 21:25
 */
public class LogMappingTest {
    @Test
    public void testSelectLogByDate(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        LogMapping mapper = sqlSession.getMapper(LogMapping.class);
        List<Log> logs = mapper.selectLogByDate("20220901");
        for(Log log : logs){
            System.out.println(log);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
