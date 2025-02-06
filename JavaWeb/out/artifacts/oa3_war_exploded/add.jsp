<%@page contentType="text/html;charset=utf-8"%>
<%
	//获取应用根目录
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新增部门</title>
	</head>
	<body>
		<h1>新增部门</h1>
		<hr >
		<form action="<%=path%>/dept/add" method="post">
			部门编号<input type="text" name="deptno"/><br>
			部门名称<input type="text" name="deptname"/><br>
			部门位置<input type="text" name="loc"/><br>
			<input type="submit" value="保存"/><br>
		</form>
	</body>
</html>
