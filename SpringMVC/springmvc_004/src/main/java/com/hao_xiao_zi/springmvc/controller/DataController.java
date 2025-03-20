package com.hao_xiao_zi.springmvc.controller;

import com.hao_xiao_zi.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-19
 * Time: 18:22
 */
@Controller
public class DataController {

    @RequestMapping("/")
    public String toIndex(){
        return "register";
    }

    //1.使用
//    @RequestParam("")属性用来将请求参数和方法形参进行映射，一旦前端发送请求，就会将请求参数值赋给形参
    @RequestMapping("/user/reg1")
    public String userRegister1(
            @RequestParam("username")
            String username,
            @RequestParam("password")
            String password,
            @RequestParam("sex")
            Integer sex,
            @RequestParam("interest")
            String[] interest,
            @RequestParam("intro")
            String intro,
            @RequestParam(value = "age",required = true,defaultValue = "25")
            Integer age){
//        RequestParam注解中的required属性用来标记该请求参数是否为必须参数
//        前端没有传递该参数就会报400错误
//        required=false，该参数为非必须参数，前端没有传递也没事，由于没有传递，所以后端接收到的值为null
//        defaultValue="25" 该请求参数前端没有传递，默认值为25，如果前端传递，以传递的值为准
        System.out.println(username);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(Arrays.toString(interest));
        System.out.println(intro);
        System.out.println(age);
        return "ok";
    }

//    2.使用控制器中方法的形参名进行接收请求参数,要求请求参数要和形参一样
//    注意：如果请求参数获取不到，则会给形参赋null
//    spring6+以后要求在pom.xml文件中配置参数
    @RequestMapping("/user/reg2")
    public String userRegister2(String username,String password,Integer sex,String[] interest,String intro,
                               @RequestParam(defaultValue = "28")
                               Integer age){
        System.out.println(username);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(Arrays.toString(interest));
        System.out.println(intro);
        System.out.println(age);
        return "ok";
    }

    //3.使用pojo类来接收前端发送的请求参数，底层使用的时反射机制
    //通过类名并使用反射机制创建出字节码对象，使用该对象的方法创建出User对象
    //再通过请求参数获取对应的setXxx方法，调用该方法对对应的属性进行赋值
    //如果pojo属性与请求参数不匹配，则该属性不会进行赋值，默认为null
    @RequestMapping("/user/reg3")
    public String userRegister3(User user){
        System.out.println(user);
        return "ok";
    }

    //@RequestHeaders注解用来将请求协议中的请求头中的请求头参数与形参进行映射
    @RequestMapping("/user/reg4")
    public String getRequestHeaders(
            @RequestHeader(value = "Host",required = false,defaultValue = "")
            String host,
            @RequestHeader(value = "Referer",required = true,defaultValue = "")
            String referer){
        System.out.println(host);
        System.out.println(referer);
        return "ok";
    }

//    CookieValue注解的作用：将客户端发送过来的请求协议中的cookie数据与控制器方法形参进行映射
    @RequestMapping("/testCookie")
    public String getCookieValue(
            @CookieValue(value = "id",required = false,defaultValue = "")
            Integer id,
            @CookieValue(value = "expires",required = true,defaultValue = "eee")
            String data){
        System.out.println(id);
        System.out.println(data);
        return "ok";
    }

    @RequestMapping("/cookie")
    public String sendCookie(){
        return "cookie";
    }

    @RequestMapping("/user/reg")
    public String userRegister(User user){
        System.out.println(user);
        return "ok";
    }
}
