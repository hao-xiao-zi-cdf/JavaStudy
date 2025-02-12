<%@ page import="com.cdf.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    User user = new User("zhangsna",20,"1234");
    request.setAttribute("user",user);
%>

   <c:choose>
       <c:when test="${param.age < 18}">
           青少年
       </c:when>
       <c:when test="${param.age >= 18 && param.age < 36}">
           少年
       </c:when>
       <c:when test="${param.age >= 36 && param.age < 60}">
           中年
       </c:when>
       <c:otherwise>
           老年
       </c:otherwise>
   </c:choose>


