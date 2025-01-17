package com.cdf.webapp;

import javax.servlet.Servlet;

public class UserServlet implements Servlet{
	public void service(){
		System.out.print("UserServlet...");
	}
}