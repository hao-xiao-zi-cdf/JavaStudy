<%@page contentType="text/html;charset=utf-8"%>
<%
	//获取应用根目录
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>欢迎使用OA系统</title>
	</head>
	<body>
		<a href="<%=path%>/dept/list">查看部门列表</a>
	</body>
</html>
