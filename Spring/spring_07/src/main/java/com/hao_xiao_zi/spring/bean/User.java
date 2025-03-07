package com.hao_xiao_zi.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-07
 * Time: 9:25
 */
@Component
public class User {


    private String name;

    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    将set方法注释掉，bean对象的属性仍然可以完成初始化，说明该方式底层可不依赖于set注入
//    @Value("张三")
//    public void setName(String name) {
//        this.name = name;
//    }
//
////    @Value("19")
//    public void setAge(int age) {
//        this.age = age;
//    }

    public User(@Value("张三11") String name, @Value("11") int age) {
        this.name = name;
        this.age = age;
    }
}
