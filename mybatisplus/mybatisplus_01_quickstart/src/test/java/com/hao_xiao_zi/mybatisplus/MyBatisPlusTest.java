package com.hao_xiao_zi.mybatisplus;

import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-27
 * Time: 21:02
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void testSelectList(){
        List<User> users = mapper.selectList(null);
        for(User user : users){
            System.out.println(user);
        }
    }
}
