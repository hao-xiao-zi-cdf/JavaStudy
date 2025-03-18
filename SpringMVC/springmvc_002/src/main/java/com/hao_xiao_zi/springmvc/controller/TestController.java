package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-18
 * Time: 19:31
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
