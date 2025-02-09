<%@ page import="bean.Dept" %>
<%@page contentType="text/html;charset=utf-8"%>
<%
	//获取应用根目录
	String path = request.getContextPath();

	//获取查询到的数据进行展示
	Dept dept = (Dept)request.getAttribute("dept");
	String deptno = dept.getDeptno();
	String deptname = dept.getDeptname();
	String loc = dept.getLoc();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改部门</title>
	</head>
	<body>
		<%--从session中获取用户信息--%>
		<h1><%=session.getAttribute("username")%></h1>
		<h1>修改部门</h1>
		<hr >
		<form action="<%=path%>/dept/change" method="post">
			部门编号<input type="text" name="deptno" value="<%=deptno%>" readonly /><br>
			部门名称<input type="text" name="deptname" value="<%=deptname%>"/><br>
			部门位置<input type="text" name="loc" value="<%=loc%>"/><br>
			<input type="submit" value="修改"/><br>
		</form>
	</body>
</html>
