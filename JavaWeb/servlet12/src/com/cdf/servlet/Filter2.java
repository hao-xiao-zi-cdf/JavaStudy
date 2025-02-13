package com.cdf.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
* Created with IntelliJ IDEA.
* Description:
* User: 34255
* Date: 2025-02-13
* Time: 18:58
*/
public class Filter2 implements Filter {

    //init()方法只会在Filter对象创建之后执行调用，且只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter2的init()方法执行...");
    }

    //核心方法：doFilter()方法用来执行过滤代码
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //在servlet程序执行前，对请求进行过滤
        System.out.println("Filter2对servlet程序执行前进行过滤...");
        //跳转到下一个过滤器，没有过滤器则执行servlet程序
        chain.doFilter(request,response);
        //在servlet程序执行后，对响应进行过滤
        System.out.println("Filter2对servlet程序执行后进行过滤...");
    }

    //destroy()方法会在Filter对象释放前执行
    @Override
    public void destroy() {
        System.out.println("Filter2的destroy()方法执行...");
    }
}

