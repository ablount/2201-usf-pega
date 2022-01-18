package com.revature.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.accounts.BankAccount;

public class UserAccountDAO {

	public boolean isUsernameTaken(String username) {
			
			try {
				// checks we're connected to the db
				Connection connection = ConnectionManager.getConnection();
				
				// runs a query on the db with the username plugged in as the 1st ?
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM userAccounts WHERE username = ?");
				preparedStatement.setString(1, username);
				
				// gives us a result set and executes the following query
				ResultSet results = preparedStatement.executeQuery();
	
				// always need to tell it to go to the next to get to the first row after the column headers
				if (results.next()) {
					return true;
				} else {
				return false;
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return true;
		}
	
	public void signUp(String username, String password, int accountType) {

		try {
			
			// checks that we're in the db
			Connection connection = ConnectionManager.getConnection();
			
			// asks to return the key that was generated while adding a 0 to the balance in a new row of the bank account table
			PreparedStatement otherPreparedStatement = connection.prepareStatement("INSERT INTO bankAccounts(balance) VALUES ('0')", Statement.RETURN_GENERATED_KEYS);
			
			//runs the update and names the returned int is the accountID
			int accountID = otherPreparedStatement.executeUpdate();
			
			// makes the above work 
			ResultSet generatedKeys = otherPreparedStatement.getGeneratedKeys();
			if (generatedKeys.next())
			    accountID = generatedKeys.getInt(1);
			
			// inserts the user data into the userAccount table
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userAccounts(username, password, accountType, accountID) VALUES (?, ?, ?, ?)");
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, accountType);
			preparedStatement.setInt(4, accountID);
			
			// I think this should be different???????????????????????
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean doUsernamePasswordExist(String username, String password, int accountType) {
		
		try {
			
			// checks that we're in the db
			Connection connection = ConnectionManager.getConnection();
			
			// asks to select the row based on a username, password, and account type
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM userAccounts WHERE username = ? AND password = ? AND accountType = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, accountType);
			
			// calls that resultset results
			ResultSet results = preparedStatement.executeQuery();

			//always need to tell it to go to the next to get to the first row after the column headers
			// tests to make sure that set of info appears in the table in one row
			if (results.next()) {
				return true;
			} else {
			return false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
	
}
