package com.hao_xiao_zi.springdataredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hao_xiao_zi.springdataredis.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-11
 * Time: 20:30
 */
@SpringBootTest
public class StringRedisTemplateTest {

    //使用Spring提供的StringRedisTemplateAPI,要求键值对都必须为String类型,底层键值对
    //都是使用字符串序列化器，值传递对象需要手动转化为json字符串
    @Autowired
    private StringRedisTemplate redisTemplate;

    //json工具
    private ObjectMapper mapper;

    @Test
    public void test01() throws JsonProcessingException {

        mapper = new ObjectMapper();

        //创建User对象
        User user = new User("张三",19);

        //将对象转化为Json字符串
        String jsonUser = mapper.writeValueAsString(user);

        //存入数据
        redisTemplate.opsForValue().set("user:3",jsonUser);

        //出去json字符串
        String userJson = redisTemplate.opsForValue().get("user:3");

        //将json字符串转化为User对象
        User user1 = mapper.readValue(userJson, User.class);
        System.out.println(user1);
    }
}
