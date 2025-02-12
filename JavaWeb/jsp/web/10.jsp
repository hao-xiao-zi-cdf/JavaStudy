<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${10 > 9}" var="s" scope="request">
  10比9大 <br>
</c:if>
${requestScope.s}