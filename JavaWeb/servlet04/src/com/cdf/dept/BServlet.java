package com.cdf.dept;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-19
 * Time: 19:35
 */
public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        //获取ServletContext对象
        //第一种方法：先获取ServletConfig对象，再通过getServletContext()方法获取
        ServletConfig config = getServletConfig();
        ServletContext application = config.getServletContext();

        out.print(application);
    }
}
