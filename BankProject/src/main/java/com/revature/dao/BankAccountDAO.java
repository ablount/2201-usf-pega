package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.accounts.BankAccount;
import com.revature.accounts.UserAccount;

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
				if (results2.next() == false) {
					
					return null;
					
				} else {

					int accountID = results2.getInt("account");
					int balance = results2.getInt("balance");
					boolean isApproved = results2.getBoolean("isApproved");
					
					// creates a bank account object that holds that info
					BankAccount myBankAccount = new BankAccount(accountID, balance, isApproved);
					
					// returns that bank account object
					return myBankAccount;
				
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		
		}
	
	
	public static void updateBalance(String username, int balance){
			
		try {
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bankAccounts SET balance = ? WHERE account = ?");
			preparedStatement.setInt(1, balance);
			preparedStatement.setInt(2, accessAccount(username).accountID);

			preparedStatement.executeUpdate();
				
		} catch (SQLException ex) {
		
		System.err.println(ex.getMessage());
		
		}
		
	}
	
	
	public static void updateAccountID(String joinUsername, int accountID){
		
		try{
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE userAccounts SET accountID = ? WHERE username = ?");
			
			preparedStatement.setInt(1, accountID);
			preparedStatement.setString(2, joinUsername);

			preparedStatement.executeUpdate();
				
		} catch (SQLException ex) {
		
		System.err.println(ex.getMessage());
		
		}
		
	}
	
	public static ArrayList<BankAccount> getPendingAccounts() {
		
		try {
			
			ArrayList<BankAccount> pendingAccounts = new ArrayList<BankAccount>();
			Connection connection = ConnectionManager.getConnection();
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM bankAccounts WHERE isApproved IS NOT NULL");
			
			while (rs.next()) {
				
				int accountID = rs.getInt("account");
				int balance = rs.getInt("balance");
				boolean isApproved = rs.getBoolean("isApproved");
				
				pendingAccounts.add(new BankAccount(accountID, balance, isApproved));
			}
			
			return pendingAccounts;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void approveAccount(int accountID) {
		
		try {
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE bankAccounts SET isApproved = ? WHERE account = ?");
			preparedStatement.setBoolean(1, true);
			preparedStatement.setInt(2, accountID);

			preparedStatement.executeUpdate();
			
			System.out.println();
			System.out.println("The account has been approved.");
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
				
		} catch (SQLException ex) {
		
		System.err.println(ex.getMessage());
		
		}
	}
	
	public static void denyAccount(int accountID) {
		
		try {
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userAccounts WHERE accountID = ?");
			preparedStatement.setInt(1, accountID);
			preparedStatement.executeUpdate();
			
			PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM bankAccounts WHERE account = ?");
			preparedStatement2.setInt(1, accountID);
			preparedStatement2.executeUpdate();
			
			System.out.println();
			System.out.println("The account has been denied.");
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
				
		} catch (SQLException ex) {
		
		System.err.println(ex.getMessage());
		
		}
	}
	public static void removeAccount(int accountID) {
		
		try {
			
			Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userAccounts WHERE accountID = ?");
			preparedStatement.setInt(1, accountID);
			preparedStatement.executeUpdate();
			
			PreparedStatement preparedStatement2 = connection.prepareStatement("DELETE FROM bankAccounts WHERE account = ?");
			preparedStatement2.setInt(1, accountID);
			preparedStatement2.executeUpdate();
			
			System.out.println();
			System.out.println("The account has been deleted.");
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
				
		} catch (SQLException ex) {
		
		System.err.println(ex.getMessage());
		
		}
	}
	
	public BankAccount getBankAccountDetails(int account) {
		
		try {
			
			
			Connection connection = ConnectionManager.getConnection();
					
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bankAccounts WHERE account = ?");
			preparedStatement.setInt(1, account);
			
			ResultSet results = preparedStatement.executeQuery();
			
			while (results.next()) {

				int balance = results.getInt("balance");
				boolean isApproved = results.getBoolean("isApproved");
				
				return new BankAccount(account, balance, isApproved);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		
		return null;
	}

	
	public BankAccount getAccountDetails(String username) {
		// I want to return a bankaccount object so I have all the details from the bank account (I told my controller it
		// was getting a BankAcount), same name of the method (getAccountDetails) I told my controller to call, 
		// and that  username parameter that I'll get from the last bit URL that's typed in
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
			while (results2.next()) {
				
				// pulls info from my database based on the column names, and makes them java variables
				int accountID = results2.getInt("account");
				int balance = results2.getInt("balance");
				boolean isApproved = results2.getBoolean("isApproved");
				
				// creates a bank account object that holds that info
				return new BankAccount(accountID, balance, isApproved);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	
	}
}
