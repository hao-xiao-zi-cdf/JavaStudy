package com.hao_xiao_zi.springdataredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hao_xiao_zi.springdataredis.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringdataredisDemoApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

//    @Test
//    public void test01(){
//        redisTemplate.opsForValue().set("email","3425588768@qq.com");
//        Object email = redisTemplate.opsForValue().get("email");
//        System.out.println("email: " + email);
//    }

//    @Test
//    public void test01(){
//        redisTemplate.opsForValue().set("user:1",new User("赵六",29));
//        User o = (User)redisTemplate.opsForValue().get("user:1");
//        System.out.println(o);
//    }
    
    //json工具
    private static final ObjectMapper mapper = new ObjectMapper();
    
//    @Test
//    public void test03() throws JsonProcessingException {
//        //创建User对象
//        User user = new User("赵六",29);
//
//        //使用序列化工具将User对象转化为json字符串
//        String userJson = mapper.writeValueAsString(user);
//
//        //存入redis
//        redisTemplate.opsForValue().set("user:3",userJson);
//
//
//        //取出数据
//        String s = redisTemplate.opsForValue().get("user:3");
//
//        //使用序列化工具反序列化，将json字符串转化为User对象
//        User user1 = mapper.readValue(s, User.class);
//        System.out.println(user1);
//    }

    @Test
    public void test04(){

        redisTemplate.opsForHash().put("user:4","username","小虎");
        redisTemplate.opsForHash().put("user:4","age","20");

        Map<Object,Object> map = new HashMap<>();
        map.put("username","小刘");
        map.put("age","20");
        redisTemplate.opsForHash().putAll("user:5",map);

        String username = (String) redisTemplate.opsForHash().get("user:4", "username");
        System.out.println("username: " + username);

        Map<Object, Object> entries = redisTemplate.opsForHash().entries("user:4");
        System.out.println(entries);

        Map<Object, Object> entries1 = redisTemplate.opsForHash().entries("user:5");
        System.out.println(entries1);
    }

}
