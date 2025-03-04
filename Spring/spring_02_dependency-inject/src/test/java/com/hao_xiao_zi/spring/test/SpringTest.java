package com.hao_xiao_zi.spring.test;

import com.hao_xiao_zi.spring.dao.*;
import com.hao_xiao_zi.spring.service.StudentServiceImpl;
import com.hao_xiao_zi.spring.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-04
 * Time: 15:24
 */
public class SpringTest {
    @Test
    public void testSetInject(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        //获取bean对象
        UserServiceImpl userServiceBean = applicationContext.getBean("userServiceBean", UserServiceImpl.class);
        userServiceBean.deleteUserService();
    }

    @Test
    public void testConstructorInject(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        //获取bean对象
        StudentServiceImpl studentServiceBean = applicationContext.getBean("studentServiceBean", StudentServiceImpl.class);
        studentServiceBean.deleteStuService();
    }

    @Test
    public void testSet1(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //获取bean对象
        UserServiceImpl userServiceBean = applicationContext.getBean("userServiceBean", UserServiceImpl.class);
        userServiceBean.deleteUserService();
    }

    @Test
    public void testSet2(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //获取bean对象
        StudentServiceImpl studentServiceBean = applicationContext.getBean("studentServiceBean", StudentServiceImpl.class);
        studentServiceBean.deleteStuService();
    }

    @Test
    public void testSet3(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //获取bean对象
        VipImpl vipImplBean = applicationContext.getBean("vipImplBean", VipImpl.class);
        System.out.println(vipImplBean.getStr().toLowerCase());
    }

    @Test
    public void testSet4(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("array.xml");
        //获取bean对象
        Array arrayBean = applicationContext.getBean("arrayBean", Array.class);
        System.out.println(arrayBean);
    }

    @Test
    public void testNull(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("null.xml");
        Stu nullBean = applicationContext.getBean("nullBean", Stu.class);
        System.out.println(nullBean);
    }

    @Test
    public void testP(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        //获取bean对象
        Teacher teacherBean = applicationContext.getBean("teacherBean", Teacher.class);
        System.out.println(teacherBean);
    }

    @Test
    public void testC(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testUtils(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-utils.xml");
        MyDataSource1 source1 = applicationContext.getBean("source1", MyDataSource1.class);
        MyDataSource2 source2 = applicationContext.getBean("source2", MyDataSource2.class);
        System.out.println(source1.getProperties());
        System.out.println(source2.getProperties());
    }

    @Test
    public void test(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-auto.xml");
        UserServiceImpl userServiceBean = applicationContext.getBean("userServiceBean", UserServiceImpl.class);
        userServiceBean.deleteUserService();
    }

    @Test
    public void test1(){
        //获取Spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-a.xml");
        MyDataSource sourceBean = applicationContext.getBean("sourceBean", MyDataSource.class);
        System.out.println(sourceBean);
    }
}
