package com.hao_xiao_zi.spring.test;

import com.hao_xiao_zi.spring.bean.Teacher;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-03
 * Time: 21:04
 */
public class FirstSpringTest {
    private static final Logger log = LoggerFactory.getLogger(FirstSpringTest.class);

    @Test
    public void testFirstSpringCode(){
        //先获取Spring容器
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml","spring-config.xml");
        //执行完上述代码后，spring容器启动，回去读取spring配置文件，并读取bean标签内容
        //创建出bean对象，和id名称进行相关联后放到容器里
        //获取bean对象,指定id
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        Teacher teacherBean = applicationContext.getBean("teacherBean", Teacher.class);
        System.out.println(teacherBean);

        Object dateBean = applicationContext.getBean("dateBean");
        System.out.println(dateBean);
    }

    @Test
    public void testFirstSpring(){
        //先获取Spring容器
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml","spring-config.xml");

        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        //获取日志记录器
        //指定为哪个类创建日志记录器，只要这个类中代码执行，就会记录日志输出到控制台
        Logger logger = LoggerFactory.getLogger("FirstSpringTest");
        logger.info("我是一条日志");
        logger.error("我是一条错误日志");
    }
}
