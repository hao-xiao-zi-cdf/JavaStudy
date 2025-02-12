<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新增部门</title>
	</head>
	<body>
		<%--从session中获取用户信息--%>
		<h1>${sessionScope.username}</h1>
		<h1>新增部门</h1>
		<hr >
		<form action="${pageContext.request.contextPath}/dept/add" method="post">
			部门编号<input type="text" name="deptno"/><br>
			部门名称<input type="text" name="deptname"/><br>
			部门位置<input type="text" name="loc"/><br>
			<input type="submit" value="保存"/><br>
		</form>
	</body>
</html>
