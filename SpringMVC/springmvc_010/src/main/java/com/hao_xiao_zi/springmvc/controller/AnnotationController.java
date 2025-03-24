package com.hao_xiao_zi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-23
 * Time: 17:11
 */
@Controller
public class AnnotationController {

    @RequestMapping(value = "/")
    public String toIndex(){
        System.out.println("AnnotationController#toIndex");
        return "index";
    }

    @RequestMapping(value = "/ok")
    public String toOk(){
        System.out.println("AnnotationController#toOk");
        return "ok";
    }
}
