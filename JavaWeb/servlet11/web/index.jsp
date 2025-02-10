<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<html>
  <head>
    <title>cookie</title>
  </head>
  <body>
  <a href="<%=request.getContextPath()%>/cookie/generate">
    点击链接服务器创建一个cookie,并将该cookie发送给浏览器,浏览器把该cookie保存在浏览器的运行内存中</a>
  <br>
  <a href="<%=request.getContextPath()%>/cookie/accept">
    点击链接,服务器处理请求，将其中的cookie数据打印到后台服务器</a>
  </body>
</html>
