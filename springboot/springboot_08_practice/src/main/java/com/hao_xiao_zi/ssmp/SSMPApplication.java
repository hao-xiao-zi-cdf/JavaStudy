package com.hao_xiao_zi.ssmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@MapperScan("com.hao_xiao_zi.ssmp.mapper")
public class SSMPApplication {

    public static void main(String[] args) {
        //打印命令行参数
        //System.out.println(Arrays.toString(args));
        //String[] arg = new String[]{"--server.port=8083"};
        //SpringBoot程序会将.run方法的参数将命名行输入的临时属性配置传入
//        SpringApplication.run(SSMPApplication.class, arg);
        SpringApplication.run(SSMPApplication.class);
    }

}
