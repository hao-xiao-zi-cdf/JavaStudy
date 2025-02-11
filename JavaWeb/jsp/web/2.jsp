<%@ page import="com.cdf.bean.User" %>
<%@page contentType="text/html;charset=utf-8"%>
<%
    User user1 = new User("张三",20,"1234");
    request.setAttribute("username",user1);
%>

${username} <br>
<%--常量或常量表达式计算后直接输出到浏览器--%>
${"username"} <br>
${1 + 1} <br>

<%--如何获取对象中的属性值--%>
${username.age} <br>
${username.password} <br>
${username.userName} <br>
${username.email} <br>
${username.city} <br>
<%--获取user对象的city属性的cityName,addR属性--%>
${username.city.cityName} <br>
${username.city.addR} <br>
<%--底层调用的是getXXX方法来获取属性值，与有什么属性无关--%>

<%--
pageContext
request
session
application

response
out

page
exception
config
--%>