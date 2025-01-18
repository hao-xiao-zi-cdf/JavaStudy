package com.cdf.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-01-18
 * Time: 15:19
 */

public class StudentServlet implements Servlet{

    @Override
    public void init(ServletConfig config) throws ServletException{

    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException , IOException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 编写JDBC代码，连接数据库，查询所有学生信息。
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            // 注册驱动 （com.mysql.jdbc.Driver，这个已过时。）
            // 新版本中建议使用：com.mysql.cj.jdbc.Driver驱动。
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url,user,password);
            // 获取预编译的数据库操作对象
            String sql = "select no,name from student";
            ps = conn.prepareStatement(sql);
            // 执行SQL
            rs = ps.executeQuery();
            // 处理查询结果集
            while(rs.next()){
                String no = rs.getString("no");
                String name = rs.getString("name");
                //System.out.println(no + "," + name);
                out.print(no + "," + name + "<br>");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            // 释放资源
            if(rs != null){
                try{
                    rs.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ps != null){
                try{
                    ps.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void destroy(){

    }

    @Override
    public String getServletInfo(){
        return "";
    }

    @Override
    public ServletConfig getServletConfig(){
        return null;
    }
}