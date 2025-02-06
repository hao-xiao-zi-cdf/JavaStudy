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
 * Time: 22:21
 */
@WebServlet(value = {"/dept/list","/dept/add","/dept/del","/dept/detail","/dept/edit","/dept/change"})
public class deptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取servlet类路径
        String path = request.getServletPath();

        //根据路劲不同执行不同的操作
        if("/dept/list".equals(path)){
            doList(request,response);
        }else if ("/dept/add".equals(path)){
            doAdd(request,response);
        }else if ("/dept/del".equals(path)){
            doDel(request,response);
        }else if ("/dept/detail".equals(path)){
            doDetail(request,response);
        }else if ("/dept/change".equals(path)){
            doChange(request,response);
        }else{
            doEdit(request,response);
        }
    }

    private void doChange(HttpServletRequest request, HttpServletResponse response) {

        //获取更新后的部门信息
        String deptno = request.getParameter("deptno");
        String deptname = request.getParameter("deptname");
        String loc = request.getParameter("loc");

        //获取应用根路径
        String path = request.getContextPath();

        //连接数据库
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        try {
            conn= JDBCUnit.getConnection();
            String sql = "UPDATE dept SET deptname = ?, loc = ? WHERE deptno = " + deptno + ";";
            stat = conn.prepareStatement(sql);
            stat.setString(1,deptname);
            stat.setString(2,loc);
            int count = stat.executeUpdate();

            //判断信息是否插入成功
            if (count != 1) {
                //新增失败跳转到错误页面
                response.sendRedirect(path + "/error.html");
            }else{
                //进行资源跳转，跳转回部门列表页面
                //新增失败跳转到错误页面
                response.sendRedirect(path + "/dept/list");
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn,stat,set);
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {

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

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //获取部门具体编号
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
        out.print("		<title>部门详情</title>");
        out.print("	</head>");
        out.print("	<body>");
        out.print("		<h1>部门详情</h1>");
        out.print("		<hr >");

        try {
            conn = JDBCUnit.getConnection();
            String sql = "select * from dept where deptno = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,deptno);
            set = stat.executeQuery();
            if(set.next()){
                String deptname = set.getString("deptname");
                String loc = set.getString("loc");
                out.print("                部门编号：" + deptno + " <br>");
                out.print("                部门名称：" + deptname + "<br>");
                out.print("        部门位置：" + loc + "<br>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn,stat,set);
        }

        out.print("		<input type='button' value='后退' onclick='window.history.back()'/>");
        out.print("	</body>");
        out.print("</html>        ");
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //获取应用根路径
        String path = request.getContextPath();

        //获取要删除的部门具体编号
        String deptno = request.getParameter("deptno");

        //连接数据库
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

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
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn, stat, set);
        }
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn,stat,set);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
        out.print("                document.location.href = '/ao/dept/del?deptno=' + dno;");
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
