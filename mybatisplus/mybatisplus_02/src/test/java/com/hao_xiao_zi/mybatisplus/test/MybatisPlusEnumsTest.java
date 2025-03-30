package com.hao_xiao_zi.mybatisplus.test;

import com.hao_xiao_zi.mybatisplus.mapper.UserMapper;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.hao_xiao_zi.mybatisplus.enums.SexEnum.MAN;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-30
 * Time: 11:27
 */
@SpringBootTest
public class MybatisPlusEnumsTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void test01(){
        User user = new User();
        user.setName("渣男");
        user.setAge(22);
        user.setSex(MAN);
        int count = mapper.insert(user);
        System.out.println("插入记录条数：" + count);
    }
}
