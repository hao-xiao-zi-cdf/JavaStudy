package com.cdf.dept;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
* Created with IntelliJ IDEA.
* Description:
* User: 34255
* Date: 2025-01-20
* Time: 19:56
*/public class GetServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Simple Web Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to the Web Server!</h1>");
        out.println("<p>This is a simple HTML page sent from the server.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
