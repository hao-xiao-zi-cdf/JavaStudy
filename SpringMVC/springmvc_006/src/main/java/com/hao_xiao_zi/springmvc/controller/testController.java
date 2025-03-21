package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-21
 * Time: 15:04
 */
@Controller
public class testController {

    @RequestMapping("/a")
    public String toA(){
//        return "a"会跳转到a视图,底层默认使用转发forward的方式进行跳转，底层会创建ThymeleafView对象
//        return "a";
//        return "forward:/b";
        return "redirect:https://www.bilibili.com/";
    }
    //总结：
    //1.转发："forward:/b",底层会创建InternalResourceView对象
    //2.重定向："redirect:/b",底层会创建RedirectView对象
    //3.return "b" 返回一个逻辑视图名称，需要前行前缀后缀拼接，底层创建ThymeleafView对象
}
