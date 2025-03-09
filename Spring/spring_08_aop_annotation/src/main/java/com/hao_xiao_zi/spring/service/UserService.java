package com.hao_xiao_zi.spring.service;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-08
 * Time: 14:51
 */
@Service("userService")
public class UserService {//目标类

    //目标方法
    public void login(){
        System.out.println("用户正在登陆中...");
    }

    //目标方法
    public void exit(){
        System.out.println("正在退出");
    }
}
