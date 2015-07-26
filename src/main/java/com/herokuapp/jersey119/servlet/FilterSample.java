package com.herokuapp.jersey119.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.herokuapp.jersey119.dao.DataAccess;

@WebFilter("/*")
public class FilterSample implements Filter {

	private DataSource ds;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/* In ログ */
		
		
		/* 認証 */
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String authorization = httpRequest.getHeader("Authorization");
		if(authorization==null){
			PrintWriter out = response.getWriter();
			response.setContentType("application/json; charset=UTF-8");
			out.println("{\"message\":\"authorizationは必須！\"}");	
		}else if(authorization.equals("test")){
			chain.doFilter(request, response);
		}else{
			PrintWriter out = response.getWriter();
			response.setContentType("application/json; charset=UTF-8");
			out.println("{\"message\":\"認証エラー\"}");	
		}

		/* Out ログ */
		System.out.println("Output Log start");
		Connection conn = null;
		try {
			System.out.println("Output Log Get Connection");
			conn = ds.getConnection();
			
			System.out.println("Output Log Run SQL");
			DataAccess da = new DataAccess();
			da.runSQL(conn
					, "insert into ACCESS_LOG(url,start_time,end_time) "
							+ "value('url-test','201507251600','201507251601')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				System.out.println("Output Log Close Connection");
				conn.close();
			} catch (SQLException e) {
				conn = null;
			}
		}
		System.out.println("Output Log end");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		ds = (DataSource)config.getServletContext().getAttribute("db-source");
	}
}
