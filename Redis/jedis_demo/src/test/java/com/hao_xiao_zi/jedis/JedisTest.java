package com.hao_xiao_zi.jedis;

import com.hao_xiao_zi.jedis.utils.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-08
 * Time: 17:18
 */
public class JedisTest {

    private Jedis jedis;

    @BeforeEach
    void setUp() {
        //建立连接
        jedis = JedisConnectionFactory.getJedis();
        //设置redis访问密码
        jedis.auth("123321");
        //设置访问的库
        jedis.select(0);
    }

    @Test
    void test() {
        //设置key-value
        String set = jedis.set("age", "12");
        System.out.println("result = " + set);
        System.out.println(jedis.get("name"));
    }

    @AfterEach
    void afterEach() {
        //关闭连接
        if(jedis != null){
            jedis.close();
        }
    }
}
