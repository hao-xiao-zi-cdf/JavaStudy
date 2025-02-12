package dept;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-10
 * Time: 20:57
 */
@WebServlet(value = "/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie数据
        Cookie[] cookies = request.getCookies();

        String username = null;
        String password = null;

        //判断cookie数据是否为null
        if(cookies != null){
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                if(name.equals("username")){
                    username = cookie.getValue();
                }else if (name.equals("password")) {
                    password = cookie.getValue();
                }
            }
        }

        //验证cookie数据是否存在于数据库
        if(username != null && password != null){

            Connection conn = null;
            PreparedStatement stat = null;
            ResultSet set = null;

            boolean flag = false;

            try {
                //获取数据库连接
                conn = JDBCUnit.getConnection();
                String sql = "select * from user where username = ? and password = ?;";
                stat = conn.prepareStatement(sql);
                stat.setString(1,username);
                stat.setString(2,password);
                set = stat.executeQuery();
                if(set.next()) {
                    flag = true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                JDBCUnit.close(conn,stat,set);
            }

            if(flag){
                //向session域中绑定数据
                HttpSession session = request.getSession();
                session.setAttribute("username",username);

                //重定向到/dept/list
                response.sendRedirect(request.getContextPath() + "/dept/list");
            }else{
                //重新回到登录页面
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }else{
            //重新回到登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
