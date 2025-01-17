package com.cdf.webapp;

import javax.servlet.Servlet;

public class BankServlet implements Servlet{
	public void service(){
		System.out.print("BankServlet...");
	}
}