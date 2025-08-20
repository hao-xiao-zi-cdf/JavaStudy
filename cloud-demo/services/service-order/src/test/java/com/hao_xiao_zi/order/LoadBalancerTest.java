package com.hao_xiao_zi.order;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 15:43
 */
@SpringBootTest
public class LoadBalancerTest {

    // 引入LoadBalancerClient=负载均衡客户端
    @Resource
    public LoadBalancerClient loadBalancerClient;

    @Test
    public void testLoadBalancer() {
        ServiceInstance choose1 = loadBalancerClient.choose("service-product");
        System.out.println(choose1.getHost() + ":" + choose1.getPort());
        ServiceInstance choose2 = loadBalancerClient.choose("service-product");
        System.out.println(choose2.getHost() + ":" + choose2.getPort());
        ServiceInstance choose3 = loadBalancerClient.choose("service-product");
        System.out.println(choose3.getHost() + ":" + choose3.getPort());
    }
}
