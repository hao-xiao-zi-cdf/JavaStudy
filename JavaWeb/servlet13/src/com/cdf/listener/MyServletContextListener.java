package com.cdf.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-13
 * Time: 21:07
 */
//@WebListener
//该监听器用来监听ServletContext对象，监听该对象的创建和销毁
public class MyServletContextListener implements ServletContextListener {

    //服务器会在servletContext对象创建时调用该方法
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象创建...");
    }

    //服务器会在ServletContext对象销毁时调用该方法
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象销毁...");
    }
}
