package com.cdf.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-19
 * Time: 17:31
 */
public class ConfigServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        //获取ServletConfig对象
//        ServletConfig config  = getServletConfig();

        Enumeration<String> names = getInitParameterNames();
        while(names.hasMoreElements()){//还有更多元素
            String name = names.nextElement();
            out.println(name + "=" + getInitParameter(name) + "<br>");
        }

//        String name = getServletName();
//
//        out.print(name);
//
//        System.out.println("Hello ConfigServlet!");
    }
}
