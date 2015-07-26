package com.herokuapp.jersey119;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import javax.ws.rs.core.Context;
import javax.annotation.PreDestroy;
import javax.annotation.PostConstruct;

public abstract class AbstractDataAccess {
	private DataSource ds;

	@Context
	private void setDataSource(ServletContext context){
		this.ds = (DataSource)context.getAttribute("db-source");
	}
	
	public DataSource getDs() {
		return ds;
	}
	
	
	@PostConstruct
	public void init(){
		System.out.println("*** AbstractDataAccess init ***");
	}

	@PreDestroy
	public void destory(){
		System.out.println("*** AbstractDataAccess destory ***");
	}

	
}
