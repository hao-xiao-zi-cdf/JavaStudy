package com.hao_xiao_zi.jedis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-11
 * Time: 19:11
 */
public class JedisTest {

    private Jedis jedis;

    @BeforeEach//用来提前创建对象
    public void setUp(){
        jedis = new Jedis("192.168.88.130",6379);
        jedis.auth("123321");
        jedis.select(0);
    }

    @Test
    public void test(){
        //存入键值对
        jedis.hset("user:1","username","zhangsan");
        jedis.hset("user:1","age","20");
        //取出数据
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach//释放连接
    public void after(){
        if(jedis != null){
            jedis.close();
        }
    }
}
