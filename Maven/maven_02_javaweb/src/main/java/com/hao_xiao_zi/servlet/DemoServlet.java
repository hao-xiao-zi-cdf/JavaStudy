package com.hao_xiao_zi.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-18
 * Time: 22:05
 */
@WebServlet(value = {"/demo"})
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取应用根目录
        String path = request.getContextPath();

        //重定向到main.jsp页面
        response.sendRedirect(path + "/main.jsp");
    }
}
