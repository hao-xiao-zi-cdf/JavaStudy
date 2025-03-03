package com.hao_xiao_zi.spring.bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-03
 * Time: 20:56
 */
public class User {

    //Spring底层是通过反射机制创建的bean对象
    //获取Spring容器的时候回去读取配置文件，根据bean标签中类路径
    //Class clazz = class.forName("类路径");
    //Object bean = clazz.newInstance();//调用的无参构造

    public User() {
        System.out.println("使用反射机制创建的bean对象");
    }

    public User(String name) {
        System.out.println("使用反射机制创建的bean对象");
    }
}
