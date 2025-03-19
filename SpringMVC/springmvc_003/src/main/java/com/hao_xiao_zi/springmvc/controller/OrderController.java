package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-19
 * Time: 10:54
 */
@Controller
@RequestMapping("/order")//把路径提到类上，相当于把类中所有方法的路径前面都加上/order
public class OrderController {

    @RequestMapping("/detail")
    public String orderDetail(){
        //业务处理...
        return "order";
    }
}
