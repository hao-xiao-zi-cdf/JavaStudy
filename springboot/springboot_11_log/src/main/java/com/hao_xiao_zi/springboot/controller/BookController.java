package com.hao_xiao_zi.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    //创建日志记录器对象
    //private Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String getById(){
        System.out.println("SpringBoot is Running...");
        //记录不同的日志级别信息
        log.info("info...");
        log.error("error...");
        log.debug("debug...");
        log.warn("warn...");
        return "springboot is running";
    }
}
