package com.cdf.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-18
 * Time: 18:52
 */
public class CServlet implements Servlet {

    public CServlet(){
        System.out.println("CServlet()无参构造方法执行");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("CServlet's init method execute!");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("CServlet's service method execute!");
    }

    @Override
    public void destroy() {
        System.out.println("CServlet's destroy method execute!");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return "";
    }
}
