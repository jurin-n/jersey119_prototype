package com.herokuapp.jersey119;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

public abstract class AbstractResouce {
	@Context
	ServletContext context;
	
}
