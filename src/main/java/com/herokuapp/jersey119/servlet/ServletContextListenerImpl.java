package com.herokuapp.jersey119.servlet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized start");
		ServletContext context = arg0.getServletContext();
		try {
			System.out.println("doLookup to " + context.getInitParameter("db-name"));
			context.setAttribute("db-source"
					, (DataSource) InitialContext.doLookup(
							context.getInitParameter("db-name"))
					);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("contextInitialized end");
	}
}
