package com.hao_xiao_zi.spring.test;

import com.hao_xiao_zi.spring.Student;
import com.hao_xiao_zi.spring.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 21:04
 */
public class SpringLifeCycleTest {
    @Test
    public void testBeanLifeCycle(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println("第六步：使用bean对象");
        //销毁bean对象需要先销毁spring上下文对象，之后spring会自动调用bean对象里面的销毁方法
        applicationContext = (ClassPathXmlApplicationContext) applicationContext;
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @Test
    public void testRegisterBean(){
        Student stu = new Student();
        System.out.println(stu);

        //获取工厂
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //将该对象注册入工厂
        factory.registerSingleton("stuBean",stu);

        //从工厂中获取该bean对象
        Student stuBean = factory.getBean("stuBean", Student.class);
        System.out.println(stuBean);
    }
}
