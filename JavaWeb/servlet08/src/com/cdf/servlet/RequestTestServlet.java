package com.cdf.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RequestTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.print("request：" + request);
//      request：org.apache.catalina.connector.RequestFacade@3e9b7c8
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        //获取浏览器往服务器发送的请求协议中的数据集合
        Map<String,String[]> map = request.getParameterMap();

        Set<String> set = map.keySet();

        Iterator iterator = set.iterator();

        //遍历map集合，获取请求协议中的name属性
        while(iterator.hasNext()){
            System.out.println(iterator.next() + "=");
            for(String str:map.get(iterator.next())){
                System.out.println(str + ",");
            }
        }
    }
}
