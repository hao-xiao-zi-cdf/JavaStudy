<%--设置响应内容类型,同时也可以设置响应时的字符集--%>
<%@page contentType="text/html;charset=utf-8"%>
<%--禁用jsp的内置对象session,默认情况下为true,即启用session对象，如果没有则创建session对象--%>
<%@page session="false"%>
<%--导入指定类或接口--%>
<%@page import="jakarta.servlet.http.Cookie"%>
<%--设置响应时采用的字符集--%>
<%@page pageEncoding="UTF-8"%>
<%--设置发生错误或异常后，跳转后的错误页面--%>
<%@page errorPage="error.jsp"%>
<%
    System.out.println(1/0);
%>


