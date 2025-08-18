package com.hao_xiao_zi.order.service.impl;

import com.hao_xiao_zi.bean.Order;
import com.hao_xiao_zi.bean.Product;
import com.hao_xiao_zi.order.feign.ProductFeignClient;
import com.hao_xiao_zi.order.service.OrderIService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 15:03
 */
@Service
@Slf4j
public class OrderService implements OrderIService {

    @Resource
    public DiscoveryClient discoveryClient;

    @Resource
    public RestTemplate restTemplate;

    @Resource
    public LoadBalancerClient loadBalancerClient;

    @Resource
    public ProductFeignClient productFeignClient;

    @Override
    public Order createOrderById(Long productId, Long userId) {
        Order order = new Order();
        // 调用远程服务获取商品信息
//        Product product = procedureCallProduct(productId);
//        Product product = procedureCallProductWithLoadBalancer(productId);
//        Product product = procedureCallProductWithLoadBalancer1(productId);
        Product product = productFeignClient.getProductById(productId);
        order.setId(productId);
        order.setTotalAmount(product.getPrice());
        order.setUserId(userId);
        order.setNickName("xxx");
        order.setAddress("aaa");
        order.setProductList(Collections.singletonList(product));
        return order;
    }

    /**
     * 远程调用商品服务
     * @param productId 商品id
     */
    private Product procedureCallProduct(Long productId) {
        // 获取商品服务所有的服务地址
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        // 随机选择一个并获取服务地址
        ServiceInstance instance = instances.get(0);
        String url = "http://" + instance.getHost() + ":" +instance.getPort() + "/product/" + productId;
        log.info("OrderService 调用远程服务：url: {}", url);

        // 调用商品服务
        return restTemplate.getForObject(url, Product.class);
    }

    /**
     * 完成负载均衡发送请求
     * @param productId 商品id
     */
    private Product procedureCallProductWithLoadBalancer(Long productId) {
        ServiceInstance instance = loadBalancerClient.choose("service-product");
        String url = "http://" + instance.getHost() + ":" +instance.getPort() + "/product/" + productId;
        log.info("OrderService 负载均衡远程服务：url: {}", url);

        // 调用商品服务
        return restTemplate.getForObject(url, Product.class);
    }

    /**
     * 使用注解方式完成负载均衡发送请求
     * @param productId 商品id
     */
    private Product procedureCallProductWithLoadBalancer1(Long productId) {
        String url = "http://service-product/product/" + productId;
        log.info("OrderService 使用注解方式完成负载均衡远程服务：url: {}", url);

        // 调用商品服务
        return restTemplate.getForObject(url, Product.class);
    }
}
