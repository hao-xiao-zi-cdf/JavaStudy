package com.hao_xiao_zi.spring.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-08
 * Time: 14:56
 */
@Component("userServiceAOP")
@Aspect
@Order(0)
//切面类要想被spring识别,需要添加@Aspect注解,spring容器识别到后就会为其创建代理类
public class UserServiceAOP {//切面类
    //切面 = 切点 + 通知


    //编写通用切点
    @Pointcut("execution(* com.hao_xiao_zi.spring.service..*(..))")
    public static void universalCutPoint(){
    }

    //@Before注解是用来告诉spring容器这个方法是前置通知，需要在注解里面编写
    //切面表达式,告诉spring容器该前置通知织入到哪些业务方法中
    @Before("universalCutPoint()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知");

//        JoinPoint可以用来获取目标方法的方法签名
        Signature signature = joinPoint.getSignature();
//        通过方法签名可以获取目标方法的方法名称,返回值等信息
        System.out.println(signature.getName());
    }

    //后置通知
    @AfterReturning("universalCutPoint()")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }

    //环绕通知
    @Around("universalCutPoint()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //前环绕
        System.out.println("前环绕");
        //目标方法
        joinPoint.proceed();
        //后环绕
        System.out.println("后环绕");
    }

    //异常通知
    @AfterThrowing("universalCutPoint()")
    public void afterThrowing(){
        System.out.println("异常通知");
    }

    //最后通知
    @After("universalCutPoint()")
    public void afterAdvice(){
        System.out.println("最后通知");
    }
}
