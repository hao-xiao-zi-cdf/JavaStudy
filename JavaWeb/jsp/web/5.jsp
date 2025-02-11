<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%--从数组和列表中取数据--%>
<%
    int[] array = new int[]{1,2,3};
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    request.setAttribute("arr",array);
    request.setAttribute("list",list);
%>
${arr} <br>
\${list} <br>
${arr[0]} ${arr[1]} ${arr[2]} <br>
${list[0]} ${list[1]} ${list[2]}  <br>