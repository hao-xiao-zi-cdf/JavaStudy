package com.hao_xiao_zi.spring.Bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 18:56
 */
public class UserFactory {

    //静态方法
    public static User get(){
        return new User();
    }
}
