package com.hao_xiao_zi.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-05
 * Time: 19:14
 */
//在test目录下，就不会影响到源代码，只对测试类有效，避免了同配置的冲突
public class MsgConfig {

    @Bean
    public String msg(){
        return "test mag";
    }
}
