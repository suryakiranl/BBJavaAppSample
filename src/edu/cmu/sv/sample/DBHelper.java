package edu.cmu.sv.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static final String DB_CONN_URL = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection(DB_CONN_URL, USERNAME,
				PASSWORD);

		return conn;
	}
	
	public User saveUser(User user) {
		return user;
	}
}
