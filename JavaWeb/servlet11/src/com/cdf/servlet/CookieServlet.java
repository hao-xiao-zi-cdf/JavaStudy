package com.cdf.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-10
 * Time: 19:20
 */
@WebServlet(urlPatterns = {"/cookie/generate","/cookie/accept"})
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取请求路径
        String path = request.getServletPath();
        if(path.equals("/cookie/generate")){
            //服务器创建一个cookie
            Cookie cookie1 = new Cookie("userName1","hao_xiao_zi");
            //服务器创建一个cookie
            Cookie cookie2 = new Cookie("userName2","听雨轩");

            //设置cookie的有效时间
            //cookie对象的expiry时间值>0,cookie数据会被存储到硬盘文件中
//        cookie.setMaxAge(60 * 60);

            //cookie对象的expiry时间值=0,删除当前的cookie对象
//        cookie.setMaxAge(0);

            //cookie对象的expiry时间值<0,cookie数据存储到浏览器内存中
//        cookie.setMaxAge(-1);

            //设置cookie对象的关联路径,/oa路径及其子目录下的请求都会自动携带该cookie数据到服务器
//            cookie1.setPath("/oa");

            //将创建的cookie发送到浏览器
            response.addCookie(cookie1);
            response.addCookie(cookie2);
        } else if ("/cookie/accept".equals(path)) {
            //获取request对象中获取cookie数据
            Cookie[] cookies = request.getCookies();
            for(Cookie c : cookies){
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name + " " + value);
            }
        }
    }
}
