package com.hao_xiao_zi.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//用来指定扫描该包下的mapper接口
@MapperScan("com.hao_xiao_zi.mybatisplus.mapper")
public class Mybatisplus01QuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mybatisplus01QuickstartApplication.class, args);
    }

}
