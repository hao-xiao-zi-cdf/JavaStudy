package com.cdf.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-13
 * Time: 21:36
 */
//@WebListener
//该监听器用来监听session域中所有绑定的数据的变化，监听的对象还是session
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    //往session域中绑定数据服务器自动调用该方法
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("绑定数据");
    }

    //往session域中移除数据服务器自动调用该方法
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("移除数据");
    }

    //往session域中替换数据服务器自动调用该方法
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("替换数据");
    }
}
