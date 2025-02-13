package com.cdf.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-13
 * Time: 21:17
 */
@WebListener
//该监听器监听request对象，监听request对象的创建和销毁
//注意：监听范围是该项目下的所有请求，非该项目的请求不会被监听
public class MyServletRequestListener implements ServletRequestListener {

    //request对象创建时该方法被服务器调用
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request对象被创建...");
    }

    //request对象销毁时该方法会被服务器调用
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request对象被销毁...");
    }
}
