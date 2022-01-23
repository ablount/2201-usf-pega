package com.revature.accounts;

public class UserAccount {
	
	public String username;
	private String password;
	public String accountType;
	int userID;
	public int accountID;
	
	public UserAccount(String username, String password, String accountType, int userID, int accountID){
		
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.userID = userID;
		this.accountID = accountID;

	}
	
	
	public String getPassword() {
		
		return password;

	}

	public UserAccount() {
		
	}

}


