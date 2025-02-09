package user;

import dept.JDBCUnit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

        //跳转回登录页面
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean flag = false;

        //获取应用根目录
        String path = request.getContextPath();

        //获取用户输入value值
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        //准备参数
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet set = null;

        //获取连接
        try {
            conn = JDBCUnit.getConnection();
            String sql = "select * from users where user_id = ? and password = ?";
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
            //进行资源跳转，重定向到列表页面
            //使用session机制将用户信息存入会话域，以便在后续操作中可以快捷的判断是否为本人操作
            HttpSession session = request.getSession();
            session.setAttribute("username",userId);
            response.sendRedirect(path + "/dept/list");
        }else{
            //进行资源跳转，重定向到列表页面
            response.sendRedirect(path + "/error.jsp");
        }
    }
}
