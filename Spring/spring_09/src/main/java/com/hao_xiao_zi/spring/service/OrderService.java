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
public class OrderService {//目标对象

    //目标方法
    public void generate(){
        System.out.println("订单正在生成中...");
    }

    //目标方法
    public void cancel(){
        System.out.println("订单取消中...");
    }
}
