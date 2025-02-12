package user;

import dept.JDBCUnit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-09
 * Time: 17:14
 */
@WebServlet(value = {"/user/login","/user/exit"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求路径
        String path = request.getServletPath();

        if("/user/login".equals(path)){
            doLogin(request,response);
        }else if("/user/exit".equals(path)){
            doExit(request,response);
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //删除在服务器中的会话域对象
        HttpSession session = request.getSession(false);
        session.invalidate();

        //删除cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            //有效时常设置为0表示删除该cookie对象
            cookie.setMaxAge(0);
            //设置cookie对象的关联路径，要确保关联路径和刚创建对象时设置的时候相同，
            //否则删除的对象可能不是原先的cookie对象
            cookie.setPath(request.getContextPath());
            // 将修改后的Cookie添加到响应中，以更新或删除客户端上的Cookie
            response.addCookie(cookie);
        }

        //重定向到欢迎页面
        response.sendRedirect(request.getContextPath() + "/welcome");
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean flag = false;

        //获取应用根目录
        String path = request.getContextPath();

        //获取用户输入value值
        String userId = request.getParameter("username");
        String password = request.getParameter("password");

        //准备参数
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        //获取连接
        try {
            conn = JDBCUnit.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            stat = conn.prepareStatement(sql);
            stat.setString(1,userId);
            stat.setString(2,password);
            set = stat.executeQuery();
            if(set.next()){
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUnit.close(conn,stat,set);
        }

        if(flag){
            //使用session机制将用户信息存入会话域，以便在后续操作中可以快捷的判断是否为本人操作
            HttpSession session = request.getSession();
            session.setAttribute("username",userId);

            //判断是否勾选十天免登录复选框
            if(request.getParameter("f") != null){
                //将用户数据存入cookie中
                Cookie cookie1 = new Cookie("username",userId);
                Cookie cookie2 = new Cookie("password",password);

                //设置cookie关联路径
                cookie1.setPath(path);
                cookie2.setPath(path);

                //设置cookie有效时间10天
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setMaxAge(60 * 60 * 24 * 10);

                //发送到浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }

            //进行资源跳转，重定向到列表页面
            response.sendRedirect(path + "/dept/list");
        }else{
            //进行资源跳转，重定向到列表页面
            response.sendRedirect(path + "/error.jsp");
        }
    }
}
