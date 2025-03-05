package com.hao_xiao_zi.spring.Bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 19:15
 */
public class TeacherFactory {

    public TeacherFactory(){
        System.out.println("TeacherFactory无参构造执行中");
    }

    //实例方法
    public Teacher get(){
        return new Teacher();
    }
}
