package com.hao_xiao_zi.ssm.controller;

import com.hao_xiao_zi.ssm.bean.User;
import com.hao_xiao_zi.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-24
 * Time: 18:15
 */
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public User toIndex(
            @PathVariable("id")
            Integer id){
        User user = userService.selectUserById(id);
        return user;
    }
}
