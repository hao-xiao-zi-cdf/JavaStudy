package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-19
 * Time: 11:15
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String indexPage(){
        return "index";
    }

    @RequestMapping({"/testValue1","/testValue2"})
//    @RequestMapping(path = {"/testValue1","/testValue2"})
    public String testValue(){
        return "testValue";
    }

//    @RequestMapping("/x?y/testAnt")
    @RequestMapping("/testAnt/**")
    public String testAntValue(){
        return "ok";
    }

    //使用占位符
    //使用PathVariable就可以将路径中的占位符变量和方法参数进行绑定，
    //前端发送请求过来后，会自动占位符接收到的值赋给方法参数
    @RequestMapping("/login/{username}/{password}")
    public String testRESTFul(@PathVariable("username") String username,
                              @PathVariable("password") String password){
        System.out.println("用户名：" + username + "密码：" + password);
        return "ok";
    }
}
