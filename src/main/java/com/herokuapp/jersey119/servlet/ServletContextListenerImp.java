package com.herokuapp.jersey119.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ServletContextListenerImp implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListenerImp contextInitialized start");
		ServletContext context = arg0.getServletContext();
		context.setAttribute("db-resource", "I've got " + context.getInitParameter("db-name") + "!!!");
		System.out.println("ServletContextListenerImp contextInitialized end");
	}

}
