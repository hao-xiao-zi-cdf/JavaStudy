package com.hao_xiao_zi.mybatisplus.test;

import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus02ApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Test
    public void testSelectList(){
        List<User> users = mapper.selectList(null);
        for(User user: users){
            System.out.println(user);
        }
    }

}
