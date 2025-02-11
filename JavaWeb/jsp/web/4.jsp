<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.cdf.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--取数据的两种方式--%>
<%
    User user1 = new User("cdf",20,"1234");

    request.setAttribute("user1.ddd",user1);
%>
${requestScope.ddd.userName} <br>
${requestScope["user1.ddd"]} <br>


<%--从map集合中取数据--%>
<%
    Map<String,String> map = new HashMap<>();
    map.put("date1","数据1");
    map.put("date2","数据2");
    map.put("date3","数据3");
    request.setAttribute("map",map);
%>
${map} <br>
${map.date1} <br>
${map.date2} <br>
${map.date3} <br>