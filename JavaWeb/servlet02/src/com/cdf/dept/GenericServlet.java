package com.cdf.dept;

import jakarta.servlet.*;

import java.io.IOException;

/**
* Created with IntelliJ IDEA.
* Description:
* User: 34255
* Date: 2025-01-18
* Time: 21:07
*/
public abstract class GenericServlet implements Servlet {

    //因为ServletConfig对象属于局部变量，并且也只创建一次
    //一旦init()方法执行结束，内存回收，变量就会销毁
    //其他方法如果需要用到ServletConfig变量就会找不到
    //所以创建成员变量在init()方法执行时赋值，这样就保证不会消失
    private ServletConfig servletConfig = null;

    //添加final保证子类不能重写代码，也就不会破坏父类代码结构
    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("Tomcat服务器调用init()方法传入参数ServletConfig:" + servletConfig);
        //母版设计模式保证了子类不能重写该方法，也就不会破坏父类代码结构，但是能够类似重写代码
        init();
    }

    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return " ";
    }

    @Override
    public void destroy() {

    }
}
