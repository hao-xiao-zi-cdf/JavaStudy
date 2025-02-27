package com.hao_xiao_zi.mybatis.mapper;

import com.hao_xiao_zi.mybatis.pojo.Log;

import java.util.List;

/**
* Created with IntelliJ IDEA.
* Description:
* User: 34255
* Date: 2025-02-27
* Time: 21:19
*/
public interface LogMapping {

    /**
     * 根据日期查询对应表信息
     * @param date 指定日期
     * @return 查询到的log表信息
     */
    List<Log> selectLogByDate(String date);
}
