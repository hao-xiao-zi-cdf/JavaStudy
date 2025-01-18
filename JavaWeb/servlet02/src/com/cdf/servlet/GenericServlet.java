package com.cdf.servlet;

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

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
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
