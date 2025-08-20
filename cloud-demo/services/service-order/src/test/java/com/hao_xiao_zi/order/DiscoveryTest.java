package com.hao_xiao_zi.order;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 14:01
 */
@SpringBootTest
public class DiscoveryTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    public void testDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            discoveryClient.getInstances(service).forEach(instance -> {
                System.out.println(instance.getServiceId() + ":" + instance.getHost() + ":" + instance.getPort());
            });
        }
    }
}
