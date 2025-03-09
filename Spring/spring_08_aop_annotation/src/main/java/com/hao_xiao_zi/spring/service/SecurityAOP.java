package com.hao_xiao_zi.spring.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 17:18
 */
@Component("securityAOP")
@Aspect
@Order(-1)//数字越小,切面的执行顺序越靠前
public class SecurityAOP {

    //切面 = 切点 + 通知
    @Before("com.hao_xiao_zi.spring.service.UserServiceAOP.universalCutPoint()")
    public void beforeAdvice(){
        System.out.println("前置通知:安全...");
    }
}
