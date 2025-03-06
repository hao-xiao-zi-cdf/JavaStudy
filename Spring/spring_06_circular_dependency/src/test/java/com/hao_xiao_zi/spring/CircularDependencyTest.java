package com.hao_xiao_zi.spring;

import com.hao_xiao_zi.spring.bean.Husband;
import com.hao_xiao_zi.spring.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-06
 * Time: 19:37
 */
public class CircularDependencyTest {

    @Test
    public void testCircularDependency1(){
        //解析配置文件将bean对象都创建出来
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");

        com.hao_xiao_zi.spring.bean2.Husband husBandBean = applicationContext.getBean("husBandBean", com.hao_xiao_zi.spring.bean2.Husband.class);
        System.out.println(husBandBean);

        com.hao_xiao_zi.spring.bean2.Wife wifeBean = applicationContext.getBean("wifeBean", com.hao_xiao_zi.spring.bean2.Wife.class);
        System.out.println(wifeBean);
    }
    @Test
    public void testCircularDependency(){
        //解析配置文件将bean对象都创建出来
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        System.out.println(husbandBean);

        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(wifeBean);
    }
}
