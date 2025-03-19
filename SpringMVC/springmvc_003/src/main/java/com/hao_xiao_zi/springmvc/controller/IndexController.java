package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    //对前端发送的请求进行约束，只有请求路径为/method，且请求方式为POST方法才能进行提交
    //不满足该条件的请求路径映射不到该方法
    @RequestMapping(value = "/method")
//    @PostMapping("method")
    public String RequestMethod(){
        //业务处理
        System.out.println("login succeed");
        return "ok";
    }

//    params属性用来规定字符串参数中可以出现什么参数，以及参数的值等
    @RequestMapping(value = "/login",params = {"username!=u","password"})
    public String testParam(){
        return "ok";
    }

//    headers属性规定了前端发送的请求协议中，请求头内容参数要有什么，参数值等于什么
    @RequestMapping(value = "/headers",headers = {"Host","Referer!=http://localhost:8080/springmvc/"})
    public String testHeaders(){
        return "ok";
    }
}
