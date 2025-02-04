package com.cdf.servlet;

import jakarta.servlet.annotation.WebServlet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-04
 * Time: 22:07
 */
//通过反射机制获取注解信息
public class test {
    public static void main(String[] args) throws ClassNotFoundException {
        //反射机制获取HelloServlet类
        Class<?> cl = Class.forName("com.cdf.servlet.HelloServlet");

        //判断HelloServlet类上面是否有注解对象，有注解对象则获取该对象
        boolean annotation = cl.isAnnotationPresent(WebServlet.class);
        if(annotation){
            //获取注解对象
            WebServlet obj = cl.getAnnotation(WebServlet.class);
            System.out.println(obj.name());
            String[] s = obj.urlPatterns();
            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
        }
    }
}
