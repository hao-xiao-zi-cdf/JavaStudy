package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-24
 * Time: 15:50
 */
@Controller
public class TestController {

    @RequestMapping(value = "/hello")
    public String toHello(){
        System.out.println("TestController#toHello()...");
//        String str = null;
//        str.toLowerCase(Locale.ROOT);
        return "hello";
    }
}
