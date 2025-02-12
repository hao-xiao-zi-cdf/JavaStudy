<%@ page import="com.cdf.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${10 + 20} <br>
${10 + "20"} <br>
${"10" + "20"} <br>
<%--${10 + "10abc"} <br>--%>
${10 == 10} <br>
${"abc" == "abc"} <br>
<%
  User user1 = new User("zhangsan",20,"1234");
  User user2 = new User("zhangsan",20,"1234");
  request.setAttribute("user1",user1);
  request.setAttribute("user2",user2);
%>
${user1 eq user2} <br>
<%--empty运算符，用来判断是否为null,真为true,否则false--%>
${empty param.username == null}
<%--empty优先级更高，得出来的结果为boolean类型，==后面为null--%>