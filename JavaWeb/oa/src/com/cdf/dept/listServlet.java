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
 * Date: 2025-02-03
 * Time: 16:15
 */
//获取数据库部门列表数据
public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //设置响应内容类型
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        //1.准备参数
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        try {
            //2.获取连接执行sql语句并处理结果集
            conn = JDBCUnit.getConnection();
            String sql = "select * from dept";
            stat = conn.prepareStatement(sql);
            set = stat.executeQuery();
            //将响应内容输出到前端页面
            out.print("<!DOCTYPE html>");
            out.print("<html lang='zh-CN'>");
            out.print("<head>");
            out.print("    <meta charset='UTF-8'>");
            out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("    <title>部门列表</title>");
            out.print("    <style>");
            out.print("                body {");
            out.print("            font-family: Arial, sans-serif;");
            out.print("            margin: 0;");
            out.print("            padding: 20px;");
            out.print("        }");
            out.print("        h1 {");
            out.print("            text-align: center;");
            out.print("        }");
            out.print("        table {");
            out.print("            width: 100%;");
            out.print("            border-collapse: collapse;");
            out.print("            margin-top: 20px;");
            out.print("        }");
            out.print("        th, td {");
            out.print("            border: 1px solid #ddd;");
            out.print("            padding: 8px;");
            out.print("            text-align: left;");
            out.print("        }");
            out.print("        th {");
            out.print("            background-color: #f2f2f2;");
            out.print("            font-weight: bold;");
            out.print("        }");
            out.print("        tr:nth-child(even) {");
            out.print("            background-color: #f9f9f9;");
            out.print("        }");
            out.print("        .operation {");
            out.print("            text-align: center;");
            out.print("        }");
            out.print("        .operation a {");
            out.print("            margin: 0 5px;");
            out.print("        }");
            out.print("    </style>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>部门列表</h1>");
            out.print("<table>");
            out.print("    <thead>");
            out.print("    <tr>");
            out.print("        <th>序号</th>");
            out.print("        <th>部门编号</th>");
            out.print("        <th>部门名称</th>");
            out.print("        <th>操作</th>");
            out.print("    </tr>");
            out.print("    </thead>");
            out.print("    <tbody>");
            int i = 0;
            while(set.next()){
                String deptno = set.getString("deptno");
                String deptname = set.getString("deptname");
                System.out.println(deptname);
                out.print(" <tr>");
                out.print(" <td>" + (++i) + "</td>");
                out.print(" <td>" + deptno + "</td>");
                out.print(" <td>" + deptname + "</td>");
                out.print(" <td class='operation'>");
                out.print(" <a href='#' onclick='confirmDelete(3)'>删除</a>");
                out.print(" <a href='revise.html'>修改</a>");
                out.print(" <a href='#' onclick='showDetails(3)'>详情</a>");
                out.print(" </td>");
                out.print(" </tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            JDBCUnit.close(conn,stat,set);
        }

        out.print("    </tbody>");
        out.print("</table>");
        out.print("<div style='text-align: center; margin-top: 20px;'>");
        out.print("    <a href='add.html'>新增部门</a>");
        out.print("</div>");
        out.print("");
        out.print("<script>");
        out.print("                function confirmDelete(id) {");
        out.print("            if (confirm('确定要删除该部门吗？')) {");
        out.print("                // 这里可以添加删除逻辑，例如发送 AJAX 请求");
        out.print("                alert('部门 ' + id + ' 已被删除');");
        out.print("            }");
        out.print("        }");
        out.print("");
        out.print("        function showDetails(id) {");
        out.print("                window.location.href = 'select.html?id=' + id;");
        out.print("    }");
        out.print("</script>");
        out.print("</body>");
        out.print("</html>");
    }
}
