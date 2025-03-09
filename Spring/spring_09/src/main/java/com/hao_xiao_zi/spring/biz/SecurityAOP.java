package com.hao_xiao_zi.spring.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-09
 * Time: 19:13
 */
@Component
@Aspect
public class SecurityAOP {

    //切面 = 切点 + 通知
    //设置通用切点
    @Pointcut("execution(* com.hao_xiao_zi.spring.biz..add*(..))")
    public void add(){}

    @Pointcut("execution(* com.hao_xiao_zi.spring.biz..del*(..))")
    public void del(){}

    @Pointcut("execution(* com.hao_xiao_zi.spring.biz..modify*(..))")
    public void modify(){}

    @Before("add() || del() || modify()")
    public void beforeAdvice(JoinPoint joinPoint){
        //获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(new Date());
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("张三: " + nowTime + " " + name);
    }
}
