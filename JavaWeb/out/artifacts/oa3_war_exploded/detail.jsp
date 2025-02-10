<%@ page import="bean.Dept" %>
<%@page contentType="text/html;charset=utf-8"%>
<%
	Dept dept = (Dept)request.getAttribute("dept");
	String deptno = dept.getDeptno();
	String deptname = dept.getDeptname();
	String loc = dept.getLoc();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门详情</title>
	</head>
	<body>
		<%--从session中获取用户信息--%>
		<h1><%=session.getAttribute("username")%></h1>
		<h1>部门详情</h1>
		<hr >
		部门编号：<%=deptno%> <br>
		部门名称：<%=deptname%><br>
		部门位置：<%=loc%><br>
		
		<input type="button" value="后退" onclick="window.history.back()"/>
	</body>
</html>
