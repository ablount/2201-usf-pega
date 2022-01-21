package com.revature.accounts;
import java.util.Scanner;

import com.revature.dao.BankAccountDAO;
import com.revature.dao.UserAccountDAO;
import com.revature.driver.Menu;

public class BankAccount {

	public int accountID;
	public int balance;
	public boolean isApproved;
	
	public BankAccount(int accountID, int balance, boolean isApproved){
		this.accountID = accountID;
		this.balance = balance;
		this.isApproved = isApproved;
	}
	

	public int viewAccountDetails(String username, int accountType, boolean isApproved) {
		
		System.out.println();
		System.out.println("Here are the account details:");
		System.out.println();
		
		System.out.println("Username: " + username);
		System.out.println("Account Number: " + accountID);
		System.out.print("Current Status: ");
		if (isApproved == true) {
			System.out.print("This account has been approved.");
		} else {
			System.out.print("This account has not yet been approved.");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("__________________________________");
		System.out.println();
		
		switch(accountType) {
			
			case 1 :
	
				Menu.customerMenu(username);
				break;
				
			case 2 :
				
				Menu.adminMenu();
				break;
				
			case 3 :
				
				Menu.employeeMenu();
				break;
				
			default :
				
				Menu.welcomeMenu();
				break;
		
		}
		
		return accountID;
	}
		
	
	public int checkBalance(String username, int accountType) {
		
		if (isApproved == true) {
		
			System.out.println();
			System.out.println("The current balance is: " + balance);
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
			
			switch(accountType) {
			
			case 1 :
	
				Menu.customerMenu(username);
				break;
				
			case 2 :
				
				Menu.adminMenu();
				break;
				
			case 3 :
				
				Menu.employeeMenu();
				break;
				
			default :
				
				Menu.welcomeMenu();
				break;
		
			}
		
		
		} else {
			
			System.out.println();
			System.out.print("This account has not yet been approved.");
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
			Menu.welcomeMenu();
		}
		
		return balance; 

	}
	
	public int withdraw(String username, int accountType) {
		
		if (isApproved == true) {
			
			System.out.println();
			Scanner myObj = new Scanner(System.in);
			System.out.println("The current balance is: " + balance);
			System.out.println("How much would you like to withdraw?");
			int amountToWithdraw = myObj.nextInt();
			
			if (amountToWithdraw <= balance) {
				balance -= amountToWithdraw;
				System.out.println("The new balance is: " + balance);
				BankAccountDAO.updateBalance(username, balance);
				
				System.out.println();
				System.out.println("__________________________________");
				System.out.println();
				
			} else {
				
				System.out.println();
				System.out.println("Account does not have sufficient funds. Please check your current balance, and try again. Thanks!");
				System.out.println();	
				System.out.println("__________________________________");
				System.out.println();
			}
			
			switch(accountType) {
			
			case 1 :
	
				Menu.customerMenu(username);
				break;
				
			case 2 :
				
				Menu.adminMenu();
				break;
				
			case 3 :
				
				Menu.employeeMenu();
				break;
				
			default :
				
				Menu.welcomeMenu();
				break;
		
			}	
			
		} else {
		
		System.out.println();
		System.out.print("This account has not yet been approved.");
		System.out.println();
		System.out.println("__________________________________");
		System.out.println();
		Menu.welcomeMenu();
		}
		
		return balance;
		
	}

	public int deposit(String username, int accountType) {
		
		if (isApproved == true) {
		
			System.out.println();	
			Scanner myObj = new Scanner(System.in);
			System.out.println("Your current balance is: " + balance);
			System.out.println("How much would you like to deposit?");
			int amountToDeposit = myObj.nextInt();
			
			balance += amountToDeposit;
			
			System.out.println();
			System.out.println("Your new balance is: " + balance);
			
			BankAccountDAO.updateBalance(username, balance);
			
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
			
			switch(accountType) {
			
			case 1 :
	
				Menu.customerMenu(username);
				break;
				
			case 2 :
				
				Menu.adminMenu();
				break;
				
			case 3 :
				
				Menu.employeeMenu();
				break;
				
			default :
				
				Menu.welcomeMenu();
				break;
		
			}
			
		} else {
		
		System.out.println();
		System.out.print("This account has not yet been approved.");			
		System.out.println();
		System.out.println("__________________________________");
		System.out.println();
		Menu.welcomeMenu();
		
		}
		
		return balance;
		
	}
	
	public int transfer(String username, int accountType) {
		
		if (isApproved == true) {
		
			System.out.println();	
			Scanner myObj = new Scanner(System.in);
			System.out.println("The current balance is: " + balance);
			System.out.println("How much would you like to transfer?");
			int amountToTransfer = myObj.nextInt();
			myObj.nextLine();
			System.out.println("What is the username on the account to which you'd like to transfer $" + amountToTransfer + "?");
			String accountToTransfer = myObj.nextLine();
			
			if (amountToTransfer <= balance) {
				balance -= amountToTransfer;
				BankAccountDAO.updateBalance(username, balance);
			}
			
			BankAccountDAO.updateBalance(accountToTransfer, BankAccountDAO.accessAccount(accountToTransfer).balance + amountToTransfer);
			
			System.out.println();
			System.out.println("$" + amountToTransfer + " from " + username + " has been transferred to " + accountToTransfer);
			System.out.println();
			System.out.println(username + "'s new balance is: " + balance);
			System.out.println(accountToTransfer + "'s new balance is: " + BankAccountDAO.accessAccount(accountToTransfer).balance);
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
			
			switch(accountType) {
			
			case 1 :
	
				Menu.customerMenu(username);
				break;
				
			case 2 :
				
				Menu.adminMenu();
				break;
				
			case 3 :
				
				Menu.employeeMenu();
				break;
				
			default :
				
				Menu.welcomeMenu();
				break;
		
			}	
			
		} else {
		
		System.out.println();
		System.out.print("This account has not yet been approved.");
		System.out.println();
		System.out.println("__________________________________");
		System.out.println();
		Menu.welcomeMenu();
		
		}
		
		return balance;
		
	}
	
	
	public void joinAccount(int accountID) {
		
		UserAccountDAO userDao = new UserAccountDAO();
		
		System.out.println();
		Scanner joinAccount = new Scanner(System.in);
		System.out.print("Please enter the username for the joint account owner: ");
		String joinUsername = joinAccount.nextLine();
		
		System.out.print("Please enter the password for the joint account owner: ");
		String joinPassword = joinAccount.nextLine();
		
		
		if (userDao.doUsernamePasswordExist(joinUsername, joinPassword, 1)) {
		
			System.out.println("That username already exists.");
			System.out.println("Please try again, or contact the bank for further assistance. Thanks!");
			System.out.println();
			
		
		} else {

			userDao.joinSignUp(joinUsername, joinPassword);
			
			BankAccountDAO.updateAccountID(joinUsername, accountID);
			
			System.out.println();
			System.out.println(joinUsername + " has been successfully added as an additional owner of Account #" + accountID + "!");
		
		}
		
	}
	

}

