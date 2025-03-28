package com.hao_xiao_zi.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//指定扫描该包及其子包下的所有mapper接口
@MapperScan("com.hao_xiao_zi.mybatisplus.mapper")
public class Mybatisplus02Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybatisplus02Application.class, args);
    }

}
