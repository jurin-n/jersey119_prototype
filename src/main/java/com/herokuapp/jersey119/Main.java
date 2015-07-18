package com.herokuapp.jersey119;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {
	/*
	 * This class launches the web application in an embedded Jetty container.
	 * This is the entry point to your application.
	 * The Java command that is used for launching should fire this main method.
	 * */
	public static void main(String[] args) throws Exception{
		// The port that we should run on can be set into an environment variable.
		// Look for that variable and default to 8080 if it isn't there.
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()){
			webPort = "8080";
		}
		
		final Server server = new Server(Integer.valueOf(webPort));
		final WebAppContext root = new WebAppContext();
		
		root.setContextPath("/");
		root.setWar("target/jersey119_prototype.war");
		server.setHandler(root);
		
		server.start();
		server.join();
	}
}