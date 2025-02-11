<%@page contentType="text/html;charset=utf-8"%>
<%@page session="false"%>
<%
    //获取应用根目录
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录页面</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        form {
            text-align: center;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 2px 2px 12px #aaa;
        }
        input[type="text"], input[type="password"] {
            width: 80%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="checkbox"] {
            margin: 10px 0;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <form action="<%=path%>/user/login" method="post">
        <h2>登录页面</h2>
        <input type="text" name="username" placeholder="用户ID" required>
        <input type="password" name="password" placeholder="密码" required>
        <br>
        <input type="checkbox" name="f" value="1"> 十天内免登录
        <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
