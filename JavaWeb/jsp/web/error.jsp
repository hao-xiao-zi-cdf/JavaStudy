<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--启用jsp九大内置对象之一：exception，默认为false，调用exception.printStackTrace()可以在后台打印出发生的异常--%>
<%@ page isErrorPage="true"%>
<%
    exception.printStackTrace();
%>
<html>
<head>
    <title>error</title>
</head>
<body>
<h1>网络繁忙，稍后再试</h1>
</body>
</html>
