package com.hao_xiao_zi.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-04
 * Time: 15:50
 */
public class StudentImpl {

    private Logger logger = LoggerFactory.getLogger("StudentImpl");

    public void deleteById(){
        logger.info("根据id删除学生信息...");
    }
}
