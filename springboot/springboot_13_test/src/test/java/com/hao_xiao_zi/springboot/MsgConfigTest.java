package com.hao_xiao_zi.springboot;

import com.hao_xiao_zi.springboot.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-05
 * Time: 19:10
 */
//场景：在当前的测试类中临时加载配置，其他类不受影响
@SpringBootTest
//使用@Import注解加载当前测试类专用的配置
//专用的配置类需要把@Configuration注解去掉，否则其他的测试类运行，其spring容器也可以获取到该bean对象
@Import({MsgConfig.class})
public class MsgConfigTest {

    @Autowired
    private String msg;

    @Test
    public void testMsg(){
        System.out.println(msg);
    }
}
