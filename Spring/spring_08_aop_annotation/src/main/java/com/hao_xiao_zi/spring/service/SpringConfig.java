package com.hao_xiao_zi.spring.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 17:43
 */
@Configuration//代替spring.xml配置文件
@ComponentScan({"com.hao_xiao_zi.spring.service"})//组件扫描
@EnableAspectJAutoProxy//开启Aspect的自动代理模式
public class SpringConfig {
}
