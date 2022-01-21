package com.revature.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection connection;
	
	static String connectionString = "jdbc:postgresql://hansken.db.elephantsql.com:5432/frpqpeiz";
	static String username = "frpqpeiz";
	static String password = "Ii2bMjRIFAeJnLWYWU1o_vuuZ5YM7GOG";
	
	public static Connection getConnection() {
		
		try {
			
			if (connection == null || connection.isClosed()) {
			
				Class.forName("org.postgresql.Driver");
			
				connection = DriverManager.getConnection(connectionString, username, password);
				
				}
			
			return connection;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}

