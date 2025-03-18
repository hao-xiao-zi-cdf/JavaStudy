package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-18
 * Time: 17:05
 */
@Controller//Controller是Component注解类的别名，使用Controller注解将该类纳入IOC容器进行管理
public class FirstController {

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping(value = "/test")//请求映射
    public String hello(){
//        返回逻辑视图名称，模板引擎会根据前后缀拼接出物理逻辑视图名称，就能过找到该模板文件位置
        return "first";
    }

    @RequestMapping("hei")
    public String heiHei(){
        return "heiHei";
    }
}
