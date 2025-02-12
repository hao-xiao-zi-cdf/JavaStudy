<%@ page contentType="text/html;charset=utf-8"%>
<%--EL表达式里面隐含的隐式对象之一pageContext,这个pageContext对象和jsp九大内置对象之一的pageContext是同一个--%>
<%--通过EL表达式获取请求的根目录--%>
${pageContext.request.contextPath} <br>
<%--EL表达式隐含的隐式对象之一param,通过该对象可以获取请求里面的字符串参数值--%>
<%--注意：获取的参数值为name的第一个属性值--%>
<%--通过EL表达式获取请求发送的数据--%>
${param.username} <br>
<%=request.getParameter("username")%> <br>
<%--EL表达式隐含的隐式对象之一paramValues--%>
<%--该对象用来获取字符串参数的所有value值--%>
${paramValues.aihao[0]} <br>
${paramValues.aihao[1]} <br>
${paramValues.aihao[2]} <br>
<%=request.getParameterValues("aihao")%> <br>
<%--EL表达式隐含的隐式对象之一initParam--%>
<%--该对象用来获取web.xml中的servlet初始化参数，初始化参数会被封装到servletContext对象中--%>
使用Java代码获取初始化参数页数：<%=application.getInitParameter("page")%> <br>
使用EL表达式获取初始化参数页数：${initParam.page} <br>