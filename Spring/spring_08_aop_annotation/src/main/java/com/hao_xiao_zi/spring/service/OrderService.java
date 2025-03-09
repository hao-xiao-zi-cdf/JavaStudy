package com.hao_xiao_zi.spring.service;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 16:28
 */
@Service("orderService")
public class OrderService {//目标类

    //目标方法
    public void generate(){
        System.out.println("订单正在生成中...");
//        if(true){
//            try {
//                throw new Exception("运行异常");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
