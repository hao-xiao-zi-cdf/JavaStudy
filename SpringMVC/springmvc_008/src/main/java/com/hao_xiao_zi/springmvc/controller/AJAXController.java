package com.hao_xiao_zi.springmvc.controller;

import com.hao_xiao_zi.springmvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: AJAXController
 * Description:
 * Datetime: 2024/3/28 15:42
 * Author: 老杜@动力节点
 * Version: 1.0
 */
//@Controller
@RestController//添加了@RestController注解后，就相当于再类上添加@Controller注解同时，有再该类的所有方法上加上了@ResponseBody注解
public class AJAXController {

    //@RequestMapping(value = "/ajax", method = RequestMethod.GET)
    /*@GetMapping("/ajax")
    public String ajax(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("hello ajax, my name is Spring MVC!");
        return null;
    }*/

//    @ResponseBody
//    @RequestMapping("/ajax")
//    public String toAjax(){
//        //使用ResponseBody注解后，不在返回逻辑视图名称，最终以字符串的形式直接响应到浏览器客户端
//        return "hello ajax,my name is springmvc";
//    }

//    @ResponseBody
    @RequestMapping("/ajax")
    public User toAjax(){
        //模拟底层调用获取数据库user数据
        User user = new User(1L,"张三","2237817963cdf");
        //现在要将bean对象转化成json格式字符串返还给客户端
        //添加@ReponseBody注解，并再pom.xml文件中添加依赖，直接返回获取的user对象
        //spring底层会自动将java对象转化为json格式字符串返回给客户端，底层会调用MappingJackson2HttpMessageConverter
        return user;
    }

    //获取请求体当中的数据,并再方法使用String类型的形参接收
    @RequestMapping("/save1")
    public String toSave(
            @RequestBody
            String requestBody){
        System.out.println("requestBody:" + requestBody);
        return "ok";
    }

    //现在前端以ajax post方式向服务器发送一个请求，请求体当中存有json数据，需要将json数据转化方法形参的java对象
    //方法：通过@RequestBody注解进行转化

//    @RequestMapping("/save")
//    public String saveUser(
//            @RequestBody
//            User user){
//        //这里返回的不是逻辑视图名称，因为使用了@RestController注解
//        System.out.println("requestBody: " + user);
//        return "ok";
//    }

    //使用RequestEntity获取整个请求协议内容
    //使用方法：只需要再控制器的方法参数上添加RequestEntity类型的形参
    //前端发送请求过来，springmvc自动获取请求协议的内容，并封装到该对象中
    //请求体中的泛型参数代表要将请求体中的内容封装成什么java对象
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveUser(RequestEntity<User> request){
        System.out.println(request.getMethod());
        System.out.println(request.getType());
        System.out.println(request.getUrl());
        System.out.println(request.getBody());
        return "ok";
    }
}
