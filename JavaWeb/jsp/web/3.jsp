<%@ page contentType="text/html;charset=UTF-8"%>
<%--如果四个域都存在相同的name，那么取出来的name值会是什么--%>
<%--    往四个域中绑定了相同的数据    --%>
<%
    pageContext.setAttribute("date","pageContext");
//    request.setAttribute("date","request");
    session.setAttribute("date","session");
    application.setAttribute("date","application");
%>
${date} <br>
<%--结论：域中绑定了相同的数据，会优先从范围小的域中查找，有直接拿--%>

<%--如果四个域中都绑定了相同的数据，就是想要拿范围大的域的值呢？--%>
${applicationScope.date} <br>
${sessionScope.date} <br>
${requestScope.date} <br>
${date} <br>

<%--EL表达式对null值进行了处理，只要结果为null，会想浏览器输出一个空字符串--%>
request域中：${requestScope.date} <br>