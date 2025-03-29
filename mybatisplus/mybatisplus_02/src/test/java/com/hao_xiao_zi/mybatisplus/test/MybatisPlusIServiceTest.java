package com.hao_xiao_zi.mybatisplus.test;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hao_xiao_zi.mybatisplus.pojo.User;
import com.hao_xiao_zi.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-29
 * Time: 11:31
 */
@SpringBootTest
public class MybatisPlusIServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void testGetCount(){
//        查询总记录条数
        long count = service.count();
        System.out.println("总记录条数：" + count);
    }

    @Test
    public void insertMore(){
//        批量添加数据
//        NSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
//        批量添加底层实际是通过多次循环使用单条记录插入的sql实现的
        List userList = new ArrayList();
        for (int i = 0; i < 7; i++) {
            User user = new User();
            user.setAge(20 + i);
            user.setName("cdf" + i);
            user.setEmail("342558871" + i + "@qq.com");
            userList.add(user);
        }
        boolean flag = service.saveBatch(userList);
        System.out.println(flag);
    }
}
