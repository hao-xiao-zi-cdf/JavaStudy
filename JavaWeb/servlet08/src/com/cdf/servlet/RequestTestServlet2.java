package com.cdf.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-24
 * Time: 12:59
 */
public class RequestTestServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //往请求域中添加数据
        request.setAttribute("url","http://127.0.0.1:8080/xxx");

        //从请求域中取出数据
        Object obj = request.getAttribute("url");
        System.out.println(obj);
    }
}
