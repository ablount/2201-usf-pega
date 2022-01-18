package com.revature.accounts;
import java.util.Scanner;

import com.revature.dao.BankAccountDAO;
import com.revature.dao.UserAccountDAO;
import com.revature.driver.Menu;

public class BankAccount {

	public int accountID;
	public int balance;
	
	public BankAccount(int accountID, int balance){
		this.accountID = accountID;
		this.balance = balance;
	}
	

	public int viewAccountDetails(String username) {
		
		System.out.println();
		System.out.println("Here are your account details:");
		System.out.println();
		
		System.out.println("Username: " + username);
		System.out.println("Account Number: " + accountID);
		
		System.out.println();
		System.out.println("__________________________________");
		System.out.println();
		Menu.customerMenu(username);
		
		return accountID;
	}
	
	public int checkBalance(String username) {
		
		System.out.println();
		System.out.println("The current balance is: " + balance);
		System.out.println();
		System.out.println("__________________________________");
		System.out.println();
		Menu.customerMenu(username);
		
		
		return balance;
		
	}
	
	public int withdraw(String username) {
		
		System.out.println();
		Scanner myObj = new Scanner(System.in);
		System.out.println("Your current balance is: " + balance);
		System.out.println("How much would you like to withdraw?");
		int amountToWithdraw = myObj.nextInt();
		
		if (amountToWithdraw <= balance) {
			balance -= amountToWithdraw;
			System.out.println("Your new balance is: " + balance);
			BankAccountDAO.updateBalance(username, balance);
			
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
			Menu.customerMenu(username);
			
		} else {
			
			System.out.println();
			System.out.println("You do not have sufficient funds. Please check your current balance, and try again. Thanks!");
			System.out.println();	
			System.out.println("__________________________________");
			System.out.println();
			Menu.customerMenu(username);
		}
		
		return balance;
		
	}

	public int deposit(String username) {
		
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
		Menu.customerMenu(username);
		
		return balance;
		
	}
	
	// I need to make this transfer money from account to account
	public int transfer(String username) {
		
		System.out.println();	
		Scanner myObj = new Scanner(System.in);
		System.out.println("Your current balance is: " + balance);
		System.out.println("How much would you like to transfer?");
		int amountToTransfer = myObj.nextInt();
		System.out.println("What is the username on the account to which you'd like to transfer $" + amountToTransfer + "?");
		String accountToTransfer = myObj.nextLine();
		
		if (amountToTransfer <= balance) {
			balance -= amountToTransfer;
			BankAccountDAO.updateBalance(username, balance);
		}
		
		BankAccountDAO.accessAccount(accountToTransfer).balance += amountToTransfer;
		BankAccountDAO.updateBalance(accountToTransfer, BankAccountDAO.accessAccount(accountToTransfer).balance);
		
		System.out.println("$" + amountToTransfer + "has been transferred to " + accountToTransfer);
		System.out.println("Your new balance is: " + balance);
		System.out.println();
		System.out.println("__________________________________");
		System.out.println();
		Menu.customerMenu(username);
		
		return balance;
		
	}
	

}

