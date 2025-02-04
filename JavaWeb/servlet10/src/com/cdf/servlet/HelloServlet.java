package com.cdf.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-04
 * Time: 20:13
 */
@WebServlet(
        name = "HelloServlet",
        loadOnStartup = 1,
        urlPatterns = {"/d","/e"},
        initParams = {@WebInitParam(name = "url",value = "http://127.0.0.1:8080"),
                      @WebInitParam(name = "user",value = "root"),
                      @WebInitParam(name = "password",value = "root")}
)
public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("服务器启动时使用无参构造创建对象");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = getServletName();
        out.print(name);
        Enumeration<String> in = getInitParameterNames();
        while(in.hasMoreElements()){
            String value = getInitParameter(in.nextElement());
            out.print("<br>" + value);
        }

    }
}
