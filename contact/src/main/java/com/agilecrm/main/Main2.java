package com.agilecrm.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.agilecrm.util.JdbcConnection;

public class Main2 {

	public static void main(String[] args) throws SQLException {
		
		Connection con=JdbcConnection.getConnection();
		Statement stmt=con.createStatement();
		boolean status=stmt.execute("select *from contact");
		
		if(!status)
		{
			System.out.println("Ok");
		}
		else
		{
			System.out.println("Fail");
		}
	}

}
