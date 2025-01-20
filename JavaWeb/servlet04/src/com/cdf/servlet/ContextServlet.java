package com.cdf.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-20
 * Time: 14:53
 */
public class ContextServlet extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        //获取ServletContext对象
        ServletContext application = getServletContext();

        out.print("ServletContext:" + application + "<br>");

        //获取存放上下文参数配置信息的name集合
        Enumeration<String> set = application.getInitParameterNames();

        //遍历集合，取出元素
        while(set.hasMoreElements()){//是否还有下一个
            String name = set.nextElement();//取出元素
            String value = application.getInitParameter(name);
            out.print(name + "=" + value + "<br>");
        }

        //获取应用的根路径
        String path = application.getContextPath();
        out.print(path + "<br>");

        //获取webapp目录下某个文件的绝对路径
//        String realPath = application.getRealPath("/Index.html");
//        String realPath = application.getRealPath("Index.html"); 一样的效果

        String realPath = application.getRealPath("/flie/Index.html");
        out.print(realPath + "<br>");

        application.log("你好！我的用户名是hao_xiao_zi，现在我在学习JavaWEB，测试ServletContext" +
                "的log()方法");

        int age = 17;
        if(age < 18){
            application.log("很抱歉！您还不是未成年人，不能浏览该网站，等您18岁再来吧！",new RuntimeException());
        }

        //对ServletContext应用域存放数据，获取数据，移除数据操作
        User user = new User("hao_xiao_zi",18);
        application.setAttribute("user1",user);
        application.removeAttribute("user1");
        Object obj = application.getAttribute("user1");
        out.print(obj);
    }
}
