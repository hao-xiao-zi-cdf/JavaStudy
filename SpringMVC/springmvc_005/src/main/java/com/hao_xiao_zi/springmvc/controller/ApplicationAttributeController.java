package com.hao_xiao_zi.springmvc.controller;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-20
 * Time: 19:42
 */
@Controller
public class ApplicationAttributeController {

    @RequestMapping("/testApplicationAttributes")
    public String testApplicationAttributes(HttpServletRequest request){
        //往application域中存储数据，首先要获取application对象
        //获取application对象其实就是获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        //存储数据
        servletContext.setAttribute("applicationAttribute","使用servlet的API共享数据");
        return "ok";
    }
}
