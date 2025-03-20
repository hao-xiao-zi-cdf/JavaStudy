package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-20
 * Time: 19:30
 */
@Controller
@SessionAttributes(value = {"x","y"})//只要往这添加的属性，不会在被存储到请求域中，而是存储到会话域中
public class SessionAttributeController {

    @RequestMapping("testSessionAttributes")
    public String testSessionAttributes(Model model){
        //往请求域中存储数据
        model.addAttribute("x","我是x");
        model.addAttribute("y","我是y");
        return "ok";
    }
}
