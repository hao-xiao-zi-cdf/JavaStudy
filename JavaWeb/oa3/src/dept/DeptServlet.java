package dept;

import Unit.JDBCUnit;
import bean.Dept;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-06
 * Time: 21:48
 */
@WebServlet(value = {"/dept/list","/dept/add","/dept/del","/dept/detail","/dept/edit","/dept/change"})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取请求路径
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

    private void doDel(HttpServletRequest request, HttpServletResponse response) {
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

    private void doAdd(HttpServletRequest request, HttpServletResponse response) {
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

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //准备参数
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        //获取地址栏上的deptno值
        String deptno = request.getParameter("deptno");

        Dept dept = new Dept();

        try {
            conn = JDBCUnit.getConnection();
            String sql = "select deptname,loc from dept where deptno = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,deptno);
            set = stat.executeQuery();
            if(set.next()){
                String deptname = set.getString("deptname");
                String loc = set.getString("loc");
                dept.setDeptno(deptno);
                dept.setDeptname(deptname);
                dept.setLoc(loc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn,stat,set);
        }

        request.setAttribute("dept",dept);

        //进行判断要跳转的资源是哪一个
        if(request.getParameter("f").equals("d")){
            request.getRequestDispatcher("/detail.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/edit.jsp").forward(request,response);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //准备参数
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        List<Dept> list = new ArrayList<>();

        //获取数据库连接
        try {
            conn = JDBCUnit.getConnection();
            String sql = "select * from dept";
            stat = conn.prepareStatement(sql);
            set = stat.executeQuery();
            while(set.next()){
                String deptno = set.getString("deptno");
                String deptname = set.getString("deptname");
                String loc = set.getString("loc");
                Dept dept = new Dept();
                dept.setDeptno(deptno);
                dept.setDeptname(deptname);
                dept.setLoc(loc);
                list.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn,stat,set);
        }

        //将封装好的数据绑定到request请求域中
        request.setAttribute("list",list);

        //通过转发机制进行转发，跳转到下一个资源
        request.getRequestDispatcher( "/list.jsp").forward(request,response);
    }
}
