package com.cdf.dept;

import jakarta.servlet.ServletException;
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
 * Time: 15:37
 */
//连接数据库获取要修改的部门信息
public class editDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取应用根路径
        String path = request.getContextPath();

        //获取部门编号
        String deptno = request.getParameter("deptno");

        //连接数据库
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
        out.print("		<title>修改部门</title>");
        out.print("	</head>");
        out.print("	<body>");
        out.print("		<h1>修改部门</h1>");
        out.print("		<hr >");
        out.print("		<form action='" + path + "/dept/change' method='post'>");

        try {
            conn = JDBCUnit.getConnection();
            String sql = "select * from dept where deptno = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,deptno);
            set = stat.executeQuery();
            if (set.next()) {
                String deptname = set.getString("deptname");
                String loc = set.getString("loc");
                out.print("                部门编号<input type='text' name='deptno' value='" + deptno + "' readonly /><br>");
                out.print("                部门名称<input type='text' name='deptname' value='" + deptname + "'/><br>");
                out.print("                部门位置<input type='text' name='loc' value='" + loc + "'/><br>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn,stat,set);
        }

        out.print("			<input type='submit' value='修改'/><br>");
        out.print("		</form>");
        out.print("	</body>");
        out.print("</html>");
    }
}
