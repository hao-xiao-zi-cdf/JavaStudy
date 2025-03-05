package com.hao_xiao_zi.spring.test;

import com.hao_xiao_zi.spring.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 15:16
 */
public class SpringScopeTest {
    @Test
    public void testSpringScope(){
        //1.SpringBean对象实际是在Spring上下文对象创建的时候跟着创建的
        //2.又因为Spring上下文对象创建只执行一次，所以Spring容器中的Bean对象只会创建一次，属于单例

        //设置scope="prototype"发现：1.Spring上下文对象创建的时候不会创建bean对象
        //2.可以创建多个Bean对象，每调用一次getBean()都会创建一个Bean对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        //多次调用getBean()方法获取到的是同一个Bean对象
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);

        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);

        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb2);
    }
}
