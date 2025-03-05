package com.hao_xiao_zi.spring.test;

import com.hao_xiao_zi.spring.Bean.Dog;
import com.hao_xiao_zi.spring.Bean.Student;
import com.hao_xiao_zi.spring.Bean.Teacher;
import com.hao_xiao_zi.spring.Bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 18:51
 */
public class beanInstantiationTest {
    @Test
    public void testInstantiationBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testInstantiationBean1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Teacher teacherBean = applicationContext.getBean("teacherBean", Teacher.class);
        System.out.println(teacherBean);
    }

    @Test
    public void testInstantiationBean2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);

        Student studentBean1 = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean1);
    }

    @Test
    public void testInstantiationBean3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }
}
