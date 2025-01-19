package com.cdf.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-18
 * Time: 21:08
 */
public class LoginServlet extends GenericServlet{

    //如果需要在这里重写init()方法，怎么办？
    @Override
    public void init(){
        System.out.println("hhhh");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello LoginServlet!");
        //设置响应内容类型
        servletResponse.setContentType("text/html");

        PrintWriter out = servletResponse.getWriter();
        out.print("Hello World!");
        out.print("<h1>你好呀！</h1>");

        //在这里想要使用ServletConfig
        out.println(getServletConfig());
    }
}
