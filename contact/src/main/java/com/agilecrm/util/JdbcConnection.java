package com.agilecrm.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {

	static public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root123");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
