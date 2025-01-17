package org.apache;

import javax.servlet.Servlet;
import java.util.Scanner;
import java.util.Properties;
import java.io.FileReader;


public class Tomcat{
	public static void main(String args[]) throws Exception{
		System.out.print("Tomcat服务器启动成功!");

		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入请求地址：");
		String key = scanner.nextLine();

		//根据请求地址在配置文件中找到匹配的Servlet类
		FileReader read = new FileReader("web.properties");
		Properties pro = new Properties();
		pro.load(read);
		read.close();

		String className = pro.getProperty(key);

		//根据放射机制创建对象的Servlet类
		//因为不知道通过放射机制创建出来的类类型，所以用Object类进行接收
		//因为反射出来的类都实现了Servlet接口，所以可以将创建出来的对象转换成Servlet类，调用service()方法
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		Servlet servlet = (Servlet)obj;

		//调用Servlet.service()方法实现webapp服务
		servlet.service();
	}
}