package com.hao_xiao_zi.springmvc.controller;

import com.hao_xiao_zi.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-22
 * Time: 10:27
 */
@Controller
public class userController {

    @RequestMapping(value = "/user",method = {RequestMethod.GET})
    public String getAllUser(){
        System.out.println("正在查询所有用户信息...");
        return "ok";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(
            @PathVariable("id")
            Integer id){
        System.out.println("根据id查询用户信息...");
        return "ok";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser(User user){
        System.out.println(user);
        return "ok";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String modifyUser(User user){
        System.out.println("正在修改用户信息" + user);
        return "ok";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUserById(
            @PathVariable("id")
            Integer id){
        System.out.println("正在根据id=" + id + "删除用户信息");
        return "ok";
    }
}
