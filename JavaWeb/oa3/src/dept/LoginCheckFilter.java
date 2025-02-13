package dept;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-13
 * Time: 19:13
 */
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        //进行类型强转
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;

        //获取该会话session对象
        HttpSession session = request.getSession(false);

        String path = request.getServletPath();

        if(path.equals("/index.jsp") || path.equals("/user/login") || path.equals("/welcome") ||
                session != null && session.getAttribute("username") != null){
            //执行下一个过滤器，没有则执行servlet程序
            chain.doFilter(request,response);
        }else{
            //重定向会登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
