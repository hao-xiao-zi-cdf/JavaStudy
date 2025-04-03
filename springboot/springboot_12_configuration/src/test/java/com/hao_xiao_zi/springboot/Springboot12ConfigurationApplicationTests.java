package com.hao_xiao_zi.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot12ConfigurationApplicationTests {

    //@Value注解不支持属性的宽松绑定
//    @Value("${service.config.ip_address}")
//    private String ipAddress;

    @Value("${dataSource.password}")
    private String password;

    @Test
    public void contextLoads() {
//        System.out.println(ipAddress);
        System.out.println(password);
    }

}
