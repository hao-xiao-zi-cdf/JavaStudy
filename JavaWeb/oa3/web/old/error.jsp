<%@page contentType="text/html;charset=utf-8"%>
<%
    //获取应用根目录
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>操作失败</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .error-container {
            text-align: center;
            padding: 20px;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
            background-color: #f8d7da;
            color: #721c24;
        }
        .error-container h1 {
            margin-bottom: 20px;
        }
        .error-container a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }
        .error-container a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <%--从session中获取用户信息--%>
        <h1><%=session.getAttribute("username")%></h1>
        <h1>操作失败</h1>
        <p>很抱歉，您的操作未能成功完成。</p>
        <a href="<%=path%>/index.jsp">返回登录页面</a>
    </div>
</body>
</html>
