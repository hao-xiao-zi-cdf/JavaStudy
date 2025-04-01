package com.hao_xiao_zi.mybatisplus;

import com.hao_xiao_zi.mybatisplus.bean.User;
import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Mybatisplus04MybatisxApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
//        List<User> list = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            User user = new User();
//            user.setAge(20 + i);
//            user.setSex(1);
//            user.setUserName("cdf" + i);
//            list.add(user);
//        }
//        int count = mapper.insertBatch(list);
//        System.out.println("成功插入记录条数为：" + count);

        mapper.deleteByUid(1L);
    }
}
