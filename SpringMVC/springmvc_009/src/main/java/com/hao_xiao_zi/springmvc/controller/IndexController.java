package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-23
 * Time: 14:12
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String toIndex(){
        System.out.println("IndexController#toIndex()...");
        return "ok";
    }

    @RequestMapping(value = "/ok")
    public String toOk(){
        System.out.println("IndexController#toOk()...");
        return "ok";
    }
}
