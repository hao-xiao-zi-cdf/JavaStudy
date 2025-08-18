package com.hao_xiao_zi.order.controller;

import com.hao_xiao_zi.bean.Order;
import com.hao_xiao_zi.order.properties.OrderProperties;
import com.hao_xiao_zi.order.service.OrderIService;
import com.hao_xiao_zi.order.service.impl.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 14:49
 */
//@RefreshScope
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderIService orderService;

//    @Value("${order.timeout}")
//    String orderTimeout;
//
//    @Value("${order-auto-confirm}")
//    String orderAutoConfirm;

    @Resource
    private OrderProperties orderProperties;

    @GetMapping
    public Order createOrder(@RequestParam Long productId,@RequestParam Long userId) {
        return orderService.createOrderById(productId,userId);
    }

    @GetMapping("/config")
    public String getConfig() {
        return "order-timeout:" + orderProperties.getTimeout() + " order-auto-confirm:" + orderProperties.getAutoConfirm();
    }
}
