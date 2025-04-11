package com.hao_xiao_zi.springdataredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringdataredisDemo1ApplicationTests {

    //注入核心API：RedisTempLate
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test01() {
        redisTemplate.opsForValue().set("name","hao_xiao_zi");
        //取出数据
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println("name=" + name);
    }

}
