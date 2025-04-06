package com.hao_xiao_zi.frontend.controller;

import com.hao_xiao_zi.frontend.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
* Created with IntelliJ IDEA.
* Description:
* User: 34255
* Date: 2025-04-06
* Time: 16:53
*/
@Controller
@ResponseBody
public class TestController {

    //http://localhost:8080/test?username=zhangsan
//    @GetMapping("/test")
//    public String test01(@RequestParam("username") String username){
//        return "用户名为：" + username;
//    }

    @PostMapping("/test")
    public User getUserInfo(User user){
        return user;
    }
}
