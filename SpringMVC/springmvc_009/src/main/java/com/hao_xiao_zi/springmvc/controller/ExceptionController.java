package com.hao_xiao_zi.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-23
 * Time: 14:34
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public String test(Exception e, Model model){//只要发生异常，都跳转到该视图
        //往请求域中存储异常信息
        model.addAttribute("yiChang",e);
        //返回逻辑视图名称
        return "exception";
    }
}
