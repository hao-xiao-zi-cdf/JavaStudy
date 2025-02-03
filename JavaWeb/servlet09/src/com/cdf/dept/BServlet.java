package com.cdf.dept;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-28
 * Time: 16:08
 */
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.print("我是一名Java工程师！" + "<br>");

        //获取应用的根路径
        out.print(request.getContextPath() + "<br>");

        //获取请求方式
        out.print(request.getMethod() + "<br>");

        //获取URI
        out.print(request.getRequestURI());

        //获取ServletPath路径
        out.print(request.getServletPath());
    }
}

