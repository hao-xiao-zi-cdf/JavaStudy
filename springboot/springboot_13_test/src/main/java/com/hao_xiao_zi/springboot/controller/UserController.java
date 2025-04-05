package com.hao_xiao_zi.springboot.controller;

import com.hao_xiao_zi.springboot.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-05
 * Time: 20:06
 */
@RestController
@RequestMapping("/books")
public class UserController {

    @GetMapping
    public User getById(){
        System.out.println("spring boot is running...");

        User user = new User();
        user.setUsername("zhansan");
        user.setPassword("123456");
        user.setAge(20);
        return user;
    }
}
