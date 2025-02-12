<%@ page import="bean.Dept" %>
<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改部门</title>
	</head>
	<body>
		<%--从session中获取用户信息--%>
		<h1>${sessionScope.username}</h1>
		<h1>修改部门</h1>
		<hr >
		<form action="${pageContext.request.contextPath}/dept/change" method="post">
			部门编号<input type="text" name="deptno" value="${requestScope.dept.deptno}" readonly /><br>
			部门名称<input type="text" name="deptname" value="${requestScope.dept.deptname}"/><br>
			部门位置<input type="text" name="loc" value="${requestScope.dept.loc}"/><br>
			<input type="submit" value="修改"/><br>
		</form>
	</body>
</html>
