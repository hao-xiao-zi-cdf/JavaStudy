package com.hao_xiao_zi.order.service;

import com.hao_xiao_zi.bean.Order;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 15:02
 */
public interface OrderIService {

    Order createOrderById(Long productId, Long userId);
}
