package com.hao_xiao_zi.spring.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 18:10
 */
@Component
@Aspect
public class TransactionAOP {

    //切面 = 切点 + 通知

    @Around("execution(* com.hao_xiao_zi.spring.service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint){
        try {
            //开启事务
            System.out.println("开启事务");
            //执行目标方法
            joinPoint.proceed();
            //提交事务
            System.out.println("提交事务");
        } catch (Throwable e) {
            //回滚事务
            System.out.println("回滚事务");
        }
    }
}
