package com.hao_xiao_zi.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 20:17
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring.xml")//从类路径下查找该文件并创建spring容器
public class SpringJunit5Test {

    @Autowired//自动注入
    private User user;

    @Test
    public void testJunit5(){
        System.out.println(user);
    }
}
