package com.cdf.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-24
 * Time: 12:19
 */
public class RequestTestServlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取请求协议数据中所有的name值
        Enumeration<String> set = request.getParameterNames();

        while(set.hasMoreElements()){
            String key = set.nextElement();
            //获取每个name值所对应的一维数组第一个元素
            String s = request.getParameter(key);
            System.out.println(key + "=" + s);
        }

        //获取请求协议中hobbies值的value值
        String[] str = request.getParameterValues("hobbies");
        System.out.println(str);
        for(String s : str){
            System.out.println("hobbies=" + s);
        }
    }
}
