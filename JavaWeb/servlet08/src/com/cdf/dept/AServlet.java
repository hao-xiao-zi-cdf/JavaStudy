package com.cdf.dept;

import jakarta.servlet.RequestDispatcher;
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
 * Time: 14:08
 */
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //多个Servlet对象如何共享数据？使用Servlet的转发机制

//        Date nowTime = new Date();
//
//        //请求域中绑定数据
//        request.setAttribute("time",nowTime);

        //1.获取请求转发器，将资源路径封装到转发器对象中，即告诉TomCat下一个跳转资源的路径
//        RequestDispatcher dis = request.getRequestDispatcher("/b");

        //1.跳转到静态资源如html
        RequestDispatcher dis = request.getRequestDispatcher("/index.html");


        //2.调用请求转发器RequestDispatcher的forWord()方法将request和response传给DoGet方法作为参数
        dis.forward(request,response);


    }
}
