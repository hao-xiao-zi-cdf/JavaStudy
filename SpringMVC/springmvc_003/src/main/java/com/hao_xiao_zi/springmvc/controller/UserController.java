package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-19
 * Time: 10:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/detail")
    public String userDetail(){
        //业务处理...
        return "user";
    }
}
