package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.accounts.BankAccount;

public class BankAccountDAO {
	
	public static BankAccount accessAccount(String username) {
			
			try {
				
				// checks that we're in the db
				Connection connection = ConnectionManager.getConnection();
			
				// asks to select a row based on the username
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM userAccounts WHERE username = ?");
				preparedStatement.setString(1, username);
				
				// calls that resultset results
				ResultSet results = preparedStatement.executeQuery();
				
				//always need to tell it to go to the next to get to the first row after the column headers
				results.next();
				
				// calls that int in the db named accountID accountIDDB
				int accountIDDB = results.getInt("accountID");
	            
				// asks to select a row in the bankAccounts table based on the accountIDDB pulled above
				PreparedStatement otherPreparedStatement = connection.prepareStatement("SELECT * FROM bankAccounts WHERE account = ?");
				otherPreparedStatement.setInt(1, accountIDDB);
				
				// calls that resultset results2 
				ResultSet results2 = otherPreparedStatement.executeQuery();
				
				//always need to tell it to go to the next to get to the first row after the column headers
				results2.next();
				
				// pulls out and names these two pieces of info from the table
				int accountID = results2.getInt("account");
				int balance = results2.getInt("balance");
				
				// creates a bank account object that holds that info
				BankAccount myBankAccount = new BankAccount(accountID, balance);
				
				// returns that bank account object
				return myBankAccount;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		
		}
	
	public static int updateBalance(String username, int balance){
		
		
		String SQLupdate = "UPDATE bankAccounts SET balance = ? WHERE account = ?";
			
		int rowsAffected = 0;
		
			try (Connection connection = ConnectionManager.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(SQLupdate)){
				
					prepareStatement.setInt(1, balance);
					prepareStatement.setInt(2, accessAccount(username).accountID);

					rowsAffected = prepareStatement.executeUpdate();
					
			} catch (SQLException ex) {
			
		System.err.println(ex.getMessage());
		
		}

		return rowsAffected;
		
	}
}
