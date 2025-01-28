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
* Date: 2025-01-28
* Time: 14:38
*/
public class RequestTestServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取客户端的ip地址
        String iP = request.getRemoteAddr();
        System.out.println("客户端的IP的地址为：" + iP);
    }
}

