package com.hao_xiao_zi.controller;

import com.hao_xiao_zi.bean.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-26
 * Time: 21:03
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private MyDataSource source;

    @GetMapping
    public String getById(){
        System.out.println("SpringBoot is Running...");
        System.out.println(source);
        return "springboot is running";
    }
}
