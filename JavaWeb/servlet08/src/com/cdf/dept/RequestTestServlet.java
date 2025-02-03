package com.cdf.dept;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RequestTestServlet extends HttpServlet {
//    获取请求协议中的数据name值
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //获取map集合
//        Map<String,String[]> requestMap = request.getParameterMap();
//
//        //获取请求协议中的数据name值
//        Set<String> nameSet = requestMap.keySet();
//
//        //遍历集合nameSet，取出每个name属性值
//        Iterator<String> it = nameSet.iterator();
//
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取map集合
        Map<String,String[]> requestMap = request.getParameterMap();

        //获取请求协议中的数据name值
        Set<String> nameSet = requestMap.keySet();

        //遍历集合nameSet，取出每个name属性值
        Iterator<String> it = nameSet.iterator();

        //获取请求协议数据中的name值及所对应的value值
        while(it.hasNext()){
            String value = it.next();
            String[] str = requestMap.get(value);
            for(String s:str){
                System.out.println(value + "=" + s);
            }
        }
    }
}
