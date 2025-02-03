package com.cdf.dept;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-18
 * Time: 18:52
 */
public class AServlet implements Servlet {

    public AServlet(){
        System.out.println("AServlet()无参构造方法执行");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("AServlet's init method execute!");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("AServlet's service method execute!");
    }

    @Override
    public void destroy() {
        System.out.println("AServlet's destroy method execute!");
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
