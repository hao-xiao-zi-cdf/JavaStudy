package com.hao_xiao_zi.product.service.impl;

import com.hao_xiao_zi.bean.Product;
import com.hao_xiao_zi.product.service.ProductIService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 14:57
 */
@Service
public class ProductService implements ProductIService {
    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setProductName("测试商品");
        product.setPrice(new BigDecimal(10));
        product.setNum(10);
        return product;
    }
}
