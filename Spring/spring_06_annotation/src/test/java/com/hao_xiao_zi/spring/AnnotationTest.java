package com.hao_xiao_zi.spring;

import com.hao_xiao_zi.spring.bean.People;
import com.hao_xiao_zi.spring.bean.Student;
import com.hao_xiao_zi.spring.bean.Teacher;
import com.hao_xiao_zi.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-06
 * Time: 21:52
 */
public class AnnotationTest {
    @Test
    public void testAnnotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("user", User.class);
        System.out.println(userBean);

        Student studentBean = applicationContext.getBean("student", Student.class);
        System.out.println(studentBean);

        Teacher teacherBean = applicationContext.getBean("teacherBean", Teacher.class);
        System.out.println(teacherBean);

        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);

//        com.hao_xiao_zi.spring.bean2.People people = applicationContext.getBean("people", com.hao_xiao_zi.spring.bean2.People.class);
//        System.out.println(people);
    }
}
