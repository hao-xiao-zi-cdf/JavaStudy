<%@ page import="bean.Dept" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>部门列表页面</title>
		<%--设置基础路径--%>
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
	</head>
	<body>

<script type="text/javascript">
	function del(dno){
		// 弹出确认框，用户点击确定，返回true，点击取消返回false
		var ok = window.confirm("亲，删了不可恢复哦！");
		if(ok){
			// 发送请求进行删除数据的操作。
			// 在JS代码当中如何发送请求给服务器？
			//alert("正在删除数据，请稍后...")

			//document.location.href = "请求路径"
			//document.location = "请求路径"
			//window.location.href = "请求路径"
			//window.location = "请求路径"
			document.location.href = "${pageContext.request.contextPath}/dept/del?deptno=" + dno;
		}
	}
</script>
		<%--从session中获取用户信息--%>
		<h1>${sessionScope.username}</h1>
		<%--退出登录--%>
		<a href="user/exit">安全退出</a>
		<h1 align="center">部门列表</h1>
		<hr >
		<table border="1px" align="center" width="50%">
			<tr>
				<th>序号</th>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="s" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${s.deptno}</td>
					<td>${s.deptname}</td>
					<td>
						<a href="javascript:void(0)" onclick="del(${s.deptno})" >删除</a>
						<a href="dept/detail?f=e&deptno=${s.deptno}">修改</a>
						<a href="dept/detail?f=d&deptno=${s.deptno}">详情</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<hr >
		<a href="add.jsp">新增部门</a>
		
	</body>
</html>
