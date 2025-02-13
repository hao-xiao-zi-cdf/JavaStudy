package com.cdf.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-13
 * Time: 21:25
 */
@WebListener
//该监听器监听Session对象，监听Session对象的创建和销毁
//注意：监听范围是该项目下的所有会话，非该项目的会话不会被监听
public class MyHttpSessionListener implements HttpSessionListener {

    //服务器会在Session对象创建时调用该方法
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session对象创建...");
    }

    //服务器会在Session对象销毁时调用该方法
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session对象销毁...");
    }
}
