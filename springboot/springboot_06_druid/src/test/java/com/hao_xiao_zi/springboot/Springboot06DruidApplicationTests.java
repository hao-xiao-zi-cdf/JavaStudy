package com.hao_xiao_zi.springboot;

import com.hao_xiao_zi.springboot.mapper.UserMapper;
import com.hao_xiao_zi.springboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot06DruidApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Test
    public void test() {
        User user = mapper.selectById(2L);
        System.out.println(user);
    }

}
