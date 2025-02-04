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
 * Time: 13:09
 */
//连接数据库将新增部门信息添加入库
public class addDeptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取应用根路径
        String path = request.getContextPath();

        //获取前端用户输入的部门信息
        String deptno = request.getParameter("deptno");
        String deptname = request.getParameter("deptname");
        String loc = request.getParameter("loc");

        //连接数据库
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            conn= JDBCUnit.getConnection();
            String sql = "INSERT INTO dept (deptno, deptname, loc) VALUES (?, ?, ?);";
            stat = conn.prepareStatement(sql);
            stat.setString(1,deptno);
            stat.setString(2,deptname);
            stat.setString(3,loc);
            int count = stat.executeUpdate();

            //判断信息是否插入成功
            if (count != 1) {
                //新增失败跳转到错误页面
                response.sendRedirect(path + "/error.html");
            }else{
                //进行资源跳转，跳转回部门列表页面
                response.sendRedirect(path + "/dept/list");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn,stat,set);
        }
    }
}
