package com.hao_xiao_zi.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 19:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")//自动加载类路径下的spring配置文件，并创建spring容器
public class SpringJunit4Test {

    @Autowired//自动注入该bean对象
    private User user;

    @Test
    public void testJunit(){
        System.out.println(user);
    }

    @Test
    public void testJunit1(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testJunit2(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }
}
