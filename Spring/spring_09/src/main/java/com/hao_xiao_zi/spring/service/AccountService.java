package com.hao_xiao_zi.spring.service;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 18:06
 */
@Service
public class AccountService {//目标对象

    //目标方法
    public void transfer(){
        System.out.println("账户正在转账中...");
    }

    //目标方法
    public void withdrawal(){
        System.out.println("账户正在取款中...");
    }
}
