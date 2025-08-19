package com.hao_xiao_zi.order.feign;

import com.hao_xiao_zi.bean.Product;
import com.hao_xiao_zi.order.feign.fallback.ProductFeignClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 19:56
 */
// 配置feign远程调用客户端
@FeignClient(name = "service-product",fallback = ProductFeignClientFallBack.class)
public interface ProductFeignClient {

    //mvc注解的两套使用逻辑
    //1、标注在Controller上，是接受这样的请求
    //2、标注在FeignClient上，是发送这样的请求
    @GetMapping("/api/product/{id}")
    Product getProductById(@PathVariable Long id);
}
