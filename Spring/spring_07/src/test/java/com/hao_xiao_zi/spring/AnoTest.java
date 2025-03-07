package com.hao_xiao_zi.spring;

import cn.hao_xiao_zi.spring.SpringConfig;
import cn.hao_xiao_zi.spring.service.TeacherService;
import com.hao_xiao_zi.spring.bean.User;
import org.hao_xiao_zi.spring.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-07
 * Time: 9:26
 */
public class AnoTest {

    @Test
    public void testAno3(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        TeacherService teacherService = annotationConfigApplicationContext.getBean("teacherService", TeacherService.class);
        teacherService.deleteTeacher();
    }


    @Test
    public void testAno2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring3.xml");
        TeacherService teacherService = applicationContext.getBean("teacherService", TeacherService.class);
        teacherService.deleteTeacher();
    }

    @Test
    public void testAno1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStu();
    }

    @Test
    public void testAno(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }
}
