package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnalysisDAO {
	
	public int countAccountTypes(int accountType) {
		
		try {
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(accountType) FROM userAccounts WHERE accountType = ?");
			
			preparedStatement.setInt(1, accountType);
			
			ResultSet results = preparedStatement.executeQuery();
			
			while (results.next()) {
	
				int count = results.getInt("count");
				
				return count;
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	
	return -1;
	
	}
	
	public int countOpenAccounts(){
		
		try {
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(isApproved) FROM bankAccounts WHERE isApproved = true");
			
			ResultSet results = preparedStatement.executeQuery();
			
			while (results.next()) {
	
				int count = results.getInt("count");
				
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	
		return -1;
	}
	
	public int countPendingAccounts(){
		
		try {
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(isApproved) FROM bankAccounts WHERE isApproved = false");
			
			ResultSet results = preparedStatement.executeQuery();
			
			while (results.next()) {
	
				int count = results.getInt("count");
				
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	
		return -1;
	}

}
