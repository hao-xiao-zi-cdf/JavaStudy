package com.hao_xiao_zi.spring.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 15:48
 */
public class AspectJAnnotationTest {

    @Test
    public void testAspectJ1(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testAspectJ(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        userService.login();
//        userService.exit();
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }
}
