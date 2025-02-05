<%@page contentType = "text/html;charset=utf-8"%>

Hello JSP

<h1>Hello JSP</h1>

<%
    int a = 10;
    System.out.println("a = " + a);
    out.write("a = " + a);
    out.write(userName);
%>

<%!
    private String userName = "张三";
%>

<%= 100%>

