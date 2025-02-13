package com.cdf.servlet;

import com.cdf.bean.User1;
import com.cdf.bean.User2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-13
 * Time: 21:47
 */
@WebServlet("/sss")
public class SessionAttributeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        //绑定数据
        session.setAttribute("user1",new User1("zhangsan",11));
        session.setAttribute("user2",new User2("zhangsan",11));

        //替换数据
//        session.setAttribute("user",new User1("lisi",12));

        //移除数据
        session.removeAttribute("user1");
        session.removeAttribute("user2");
    }
}
