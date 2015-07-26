package com.herokuapp.jersey119.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAccess {
		
	public int runSQL(Connection conn,String sql){
		PreparedStatement pStmt;
		try {
			pStmt = conn.prepareStatement(sql);
			boolean b = pStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
