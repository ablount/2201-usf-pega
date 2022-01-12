package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			String connectionString = "jdbc:postgresql://hansken.db.elephantsql.com:5432/frpqpeiz",
					username = "frpqpeiz",
					password = "Ii2bMjRIFAeJnLWYWU1o_vuuZ5YM7GOG";
			
				Connection connection = DriverManager.getConnection(connectionString, username, password);
				
				Statement statement = connection.createStatement();
				
				ResultSet result = statement.executeQuery("SELECT * FROM apartment1");
				
				while (result.next()) {
					System.out.println("ID: " + result.getInt("apartment_id") + ", price: $" + result.getDouble("rent") + ", beds " + result.getInt("bedroom_num") + "/baths " + result.getInt("bath_num"));
				}
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
