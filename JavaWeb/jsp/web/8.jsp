<%@ page import="com.cdf.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--通过taglib指令将uri指定的标签库导入jsp中，prefix对引入的标签库起名--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<User> list = new ArrayList<>();
    User user1 = new User("zhangsan",20,"1234");
    User user2 = new User("lisi",19,"1234");
    User user3 = new User("wangwu",18,"1234");
    list.add(user1);
    list.add(user2);
    list.add(user3);
    request.setAttribute("list",list);
%>
<%--遍历list集合，取出里面的每一个元素--%>
<%
    List<User> users = (List<User>)request.getAttribute("list");
    for (User user : users){
%>
        用户名：<%=user.getUserName()%> 年龄：<%=user.getAge()%> <br>
<%
    }
%>
<c:forEach items="${requestScope.list}" var="s" varStatus="v">
    ${v.count} 用户名：${s.userName} 年龄：${s.age} <br>
</c:forEach>

<c:forEach var="i" begin="1" end="10" step="2">
    ${i}
</c:forEach>