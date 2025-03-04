package com.hao_xiao_zi.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-04
 * Time: 15:24
 */
public class UserImpl {

    //获取该类的日志记录器
    private Logger logger = LoggerFactory.getLogger(UserImpl.class);

    public void deleteById(){
//        System.out.println("根据id删除用户数据");
        logger.info("根据id删除用户信息...");
    }
}
