package com.hao_xiao_zi.order.feign.fallback;

import com.hao_xiao_zi.bean.Product;
import com.hao_xiao_zi.order.feign.ProductFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 21:23
 */
@Slf4j
@Component
public class ProductFeignClientFallBack implements ProductFeignClient {
    @Override
    public Product getProductById(Long id) {
        log.error("调用兜底方案...");
        Product product = new Product();
        product.setId(id);
        product.setProductName("兜底商品");
        product.setPrice(new BigDecimal(0));
        product.setNum(0);
        return product;
    }
}
