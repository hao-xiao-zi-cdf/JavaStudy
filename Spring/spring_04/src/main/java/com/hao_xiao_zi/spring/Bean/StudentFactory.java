package com.hao_xiao_zi.spring.Bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 19:25
 */
public class StudentFactory implements FactoryBean<Student> {

    public StudentFactory(){
        System.out.println("StudentFactory无参构造执行中");
    }

    @Override
    public Student getObject() throws Exception {
        //...
        return new Student();
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
