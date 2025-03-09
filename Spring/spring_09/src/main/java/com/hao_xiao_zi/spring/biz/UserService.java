package com.hao_xiao_zi.spring.biz;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 19:08
 */
@Service
public class UserService {//目标对象

    //目标方法
    public void addUserInfo(){
        System.out.println("新增用户信息");
    }

    //目标方法
    public void delUserInfo(){
        System.out.println("删除用户信息");
    }

    //目标方法
    public void selectUserInfo(){
        System.out.println("查询用户信息");
    }

    //目标方法
    public void modifyUserInfo(){
        System.out.println("修改用户信息");
    }
}
