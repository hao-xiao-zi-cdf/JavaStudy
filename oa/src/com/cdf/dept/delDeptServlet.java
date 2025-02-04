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
 * Time: 13:48
 */
//链接数据库删除指定部门数据
public class delDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取应用根路径
        String path = request.getContextPath();

        //获取要删除的部门具体编号
        String deptno = request.getParameter("deptno");

        //连接数据库
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            conn = JDBCUnit.getConnection();
            String sql = "DELETE FROM dept WHERE deptno = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1, deptno);
            int count = stat.executeUpdate();
            //判断是否删除成功
            if (count == 1) {
                response.sendRedirect(path + "/dept/list");
            } else {
                response.sendRedirect(path + "/error.html");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn, stat, set);
        }
    }
}
