package com.hao_xiao_zi.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-05
 * Time: 18:35
 */
//场景：临时加载属性配置，只用于当前的测试类，其他类不受影响
//@SpringBootTest注解中的properties属性为当前测试类临时添加属性配置，与配置文件同名，当前属性配置的优先级更高
//@SpringBootTest(properties = {"test.prpo=testValue2"})
//args的属性值可以参数的形式传递给args形参
//@SpringBootTest(args = {"--test.prpo=testValue3"})
@SpringBootTest(properties = {"test.prpo=testValue2"},args = {"--test.prpo=testValue3"})
public class PropertiesAndArgsTest {

    @Value("${test.prpo}")
    private String value;

    @Test
    public void testProperties(){
        System.out.println(value);
    }
}
