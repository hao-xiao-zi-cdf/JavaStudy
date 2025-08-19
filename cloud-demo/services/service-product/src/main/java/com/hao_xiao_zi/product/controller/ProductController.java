package com.hao_xiao_zi.product.controller;

import com.hao_xiao_zi.bean.Product;
import com.hao_xiao_zi.product.service.ProductIService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 14:55
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Resource
    private ProductIService productIService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
//        // 睡眠70s
//        try {
//            Thread.sleep(70000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return productIService.getProductById(id);
    }
}
