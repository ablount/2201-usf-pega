package com.revature.accounts;

public class UserAccount {
	
	private String username;
	private String password;
	String accountType;
	int userID;
	int accountID;
	
	UserAccount(String username, String password, String accountType, int userID, int accountID){
		
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.userID = userID;
		this.accountID = accountID;

	}
	
	public String getUsername() {
		
		return username;
	
	}

	
}


