package com.hao_xiao_zi.order.controller;

import com.hao_xiao_zi.bean.Order;
import com.hao_xiao_zi.order.service.OrderIService;
import com.hao_xiao_zi.order.service.impl.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 14:49
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderIService orderService;

    @GetMapping
    public Order createOrder(@RequestParam Long productId,@RequestParam Long userId) {
        return orderService.createOrderById(productId,userId);
    }
}
