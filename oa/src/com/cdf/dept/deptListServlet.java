package com.cdf.dept;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-04
 * Time: 11:19
 */
//连接数据库动态展示部门列表
public class deptListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取应用根路径
        String path = request.getContextPath();

        //获取数据库连接
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //将响应内容输出到前端
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("	<head>");
        out.print("		<meta charset='utf-8'>");
        out.print("		<title>部门列表页面</title>");
        out.print("<script type='text/javascript'>");
        out.print("            function del(dno){");
        out.print("            var ok = window.confirm('亲，删了不可恢复哦！');");
        out.print("            if(ok){");
        out.print("                document.location.href = '/oa/dept/del?deptno=' + dno;");
        out.print("            }");
        out.print("        }");
        out.print("</script>");
        out.print("");
        out.print("	</head>");
        out.print("	<body>");
        out.print("		<h1 align='center'>部门列表</h1>");
        out.print("		<hr >");
        out.print("		<table border='1px' align='center' width='50%'>");
        out.print("			<tr>");
        out.print("				<th>序号</th>");
        out.print("				<th>部门编号</th>");
        out.print("				<th>部门名称</th>");
        out.print("				<th>操作</th>");
        out.print("			</tr>");

        try {
            conn = JDBCUnit.getConnection();
            String sql = "select * from dept";
            stat = conn.prepareStatement(sql);
            set = stat.executeQuery();
            int i = 0;
            while(set.next()){
                String deptno = set.getString("deptno");
                String deptname = set.getString("deptname");
                out.print("			<tr>");
                out.print("				<td>" + (++i) + "</td>");
                out.print("				<td>" + deptno + "</td>");
                out.print("				<td>" + deptname + "</td>");
                out.print("				<td>");
                out.print("					<!--href后面设置为 javascript:void(0) 表示：仍然保留住超链接的样子-->");
                out.print("					<!--点击此超链接之后，不进行页面的跳转。-->");
                out.print("					<!--我只是希望用户点击该超链接的时候执行一段JS代码，不进行页面的跳转。-->");
                out.print("					<a href='javascript:void(0)' onclick='del(" + deptno + ")' >删除</a>");
                out.print("					<a href='" + path + "/dept/edit?deptno=" + deptno + "'>修改</a>");
                out.print("					<a href='" + path + "/dept/detail?deptno="+ deptno +"'>详情</a>");
                out.print("				</td>");
                out.print("			</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUnit.close(conn,stat,set);
        }

        out.print("		</table>");
        out.print("		");
        out.print("		<hr >");
        out.print("		<a href='" + path + "/add.html'>新增部门</a>");
        out.print("		");
        out.print("	</body>");
        out.print("</html>");
    }
}
