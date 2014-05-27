package edu.cmu.sv.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
	private static final String DB_CONN_URL = "jdbc:h2:file:~/h2db";
	private static final String USERNAME = "surya";
	private static final String PASSWORD = "kiran";
	
	static {
		createTableIfMissing();
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection(DB_CONN_URL, USERNAME,
				PASSWORD);

		return conn;
	}
	
	public static User saveUser(User user) {
		String insertQuery = "insert into users (name) values (?)";
		try(Connection conn = getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(insertQuery);) {
			stmt.setString(1, user.getUserName());
			int rows = stmt.executeUpdate();
			System.out.println( "User '" + user.getUserName() + "' saved. " + rows + " rows persisted to DB");
			
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static List<String> loadAllUserNames() {
		List<String> userNames = new ArrayList<String>();
		String selectStmt = "select name from users order by name";
		
		try(Connection conn = getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(selectStmt);
				ResultSet rs = stmt.executeQuery();) {
			while(rs.next()) {
				userNames.add(rs.getString("name"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return userNames;
	}
	
	public static void createTableIfMissing() {
		String createStatement = "create table users (name varchar(50))";
		try(Connection conn = getConnection(); Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(createStatement);
		} catch (ClassNotFoundException | SQLException e) {
			
		}
	}
}
