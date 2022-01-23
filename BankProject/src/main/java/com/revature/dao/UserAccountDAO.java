package com.revature.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.accounts.BankAccount;
import com.revature.accounts.UserAccount;

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
			
			switch (accountType) {
			
			case 1 :
				// asks to return the key that was generated while adding a 0 to the balance in a new row of the bank account table
				PreparedStatement otherPreparedStatement = connection.prepareStatement("INSERT INTO bankAccounts(balance, isApproved) VALUES ('0', 'false')", Statement.RETURN_GENERATED_KEYS);
				
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
				
				preparedStatement.executeUpdate();
				
				break;
			
			case 2 :
			
				// inserts the user data into the userAccount table
				PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO userAccounts(username, password, accountType) VALUES (?, ?, ?)");
				
				preparedStatement2.setString(1, username);
				preparedStatement2.setString(2, password);
				preparedStatement2.setInt(3, accountType);
				
				preparedStatement2.executeUpdate();
				
				break;

			case 3 :
				
				// inserts the user data into the userAccount table
				PreparedStatement preparedStatement3 = connection.prepareStatement("INSERT INTO userAccounts(username, password, accountType) VALUES (?, ?, ?)");
				
				preparedStatement3.setString(1, username);
				preparedStatement3.setString(2, password);
				preparedStatement3.setInt(3, accountType);
				
				preparedStatement3.executeUpdate();
				
				break;
			
			default:
				
				System.out.println("There was an error creating your account. Please try again, thanks!");
				
				break;

			}
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void joinSignUp(String username, String password) {

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
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userAccounts(username, password, accountType) VALUES (?, ?, ?)");
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, 1);
			
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
	
	public boolean createUserAccount(UserAccount userAccount) {
		
		try {
			
			Connection connection = ConnectionManager.getConnection();
			
			PreparedStatement otherPreparedStatement = connection.prepareStatement("INSERT INTO bankAccounts(balance, isApproved) VALUES ('0', 'false')", Statement.RETURN_GENERATED_KEYS);
			
			int accountID = otherPreparedStatement.executeUpdate();
			
			ResultSet generatedKeys = otherPreparedStatement.getGeneratedKeys();
			if (generatedKeys.next())
			    accountID = generatedKeys.getInt(1);
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userAccounts(username, password, accountType, accountID) VALUES (?, ?, ?, ?)");
			
			preparedStatement.setString(1, userAccount.username);
			preparedStatement.setString(2, userAccount.getPassword());
			preparedStatement.setString(3, userAccount.accountType);
			preparedStatement.setInt(4, accountID);
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public UserAccount getUserByUsername(String username) {

		try {
			
			Connection connection = ConnectionManager.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM userAccounts WHERE username = ?");
			
			preparedStatement.setString(1, username);
			
			ResultSet userList = preparedStatement.executeQuery();
			
			while (userList.next()) {
				
				String username1 = userList.getString("username");
				String password = userList.getString("password");
				String accountType = userList.getString("accountType");
				int userID = userList.getInt("userID");
				int accountID = userList.getInt("accountID");

				return new UserAccount(username1, password, accountType, userID, accountID);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean updateUserAccountType(String username, String accountType) {
		
		try{
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE userAccounts SET accountType = ? WHERE username = ?");
			
			preparedStatement.setString(1, accountType);
			preparedStatement.setString(2, username);

			preparedStatement.executeUpdate();
				
		} catch (SQLException ex) {
		
		System.err.println(ex.getMessage());
		
		}
		
		return false;
		
	}
	
	public boolean deleteUserAccount(String username) {
		
		try{
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userAccounts WHERE username = ?");
			
			preparedStatement.setString(1, username);

			preparedStatement.executeUpdate();
				
		} catch (SQLException ex) {
		
		System.err.println(ex.getMessage());
		
		}
		
		return false;
	}
	
	public int getAccountTypes(int accountType) {
		
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
}


