package com.revature.accounts;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dao.BankAccountDAO;
import com.revature.dao.UserAccountDAO;
import com.revature.driver.Menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {
	

	public int accountID;
	public int balance;
	public boolean isApproved;
	
	public BankAccount(int accountID, int balance, boolean isApproved){
		this.accountID = accountID;
		this.balance = balance;
		this.isApproved = isApproved;
	}
	
	private static final Logger logger = LogManager.getLogger(BankAccount.class);
	

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
		logger.debug(username + " checked the account status for their Account #" + accountID + ".");
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
			logger.debug(username + " checked their balance.");
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
				logger.debug(username + " made a withdrawal.");
				System.out.println("__________________________________");
				System.out.println();
				
			} else {
				
				System.out.println();
				System.out.println("Account does not have sufficient funds. Please check your current balance, and try again. Thanks!");
				System.out.println();	
				logger.debug(username + " unsuccessfully tried to make a withdrawal.");
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
		logger.debug(username + " tried to make a withdrawal, but their account is not yet approved.");
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
			logger.debug(username + " made a deposit of $" + amountToDeposit + ".");
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
		logger.debug(username + " tried to make a deposit, but their account is not yet approved.");
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
			
			if (BankAccountDAO.accessAccount(accountToTransfer).isApproved == true) {
				
				if (amountToTransfer <= balance) {
					balance -= amountToTransfer;
					BankAccountDAO.updateBalance(username, balance);
				
				BankAccountDAO.updateBalance(accountToTransfer, BankAccountDAO.accessAccount(accountToTransfer).balance + amountToTransfer);
				
				System.out.println();
				System.out.println("$" + amountToTransfer + " from " + username + " has been transferred to " + accountToTransfer);
				System.out.println();
				System.out.println(username + "'s new balance is: " + balance);
				System.out.println(accountToTransfer + "'s new balance is: " + BankAccountDAO.accessAccount(accountToTransfer).balance);
				System.out.println();
				logger.debug(username + " made a transfer of $" + amountToTransfer + " to " + accountToTransfer + "'s account.");
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
					logger.debug(username + " tried to make a transfer, but the account they tried to transfer to is not yet approved.");
					System.out.println("__________________________________");
					System.out.println();
					Menu.welcomeMenu();
				}
	
				
			} else {
			
			System.out.println();
			System.out.print("This account has not yet been approved.");
			System.out.println();
			logger.debug(username + " tried to make a transfer, but their account is not yet approved.");
			System.out.println("__________________________________");
			System.out.println();
			Menu.welcomeMenu();
			
			}
		}
		
		return balance;
		
	}
	
	
	public void joinAccount(String username, int accountID) {
		
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
			logger.debug(username + " tried to make a joint account, but the second account already exists.");

		
		} else {

			userDao.joinSignUp(joinUsername, joinPassword);
			
			BankAccountDAO.updateAccountID(joinUsername, accountID);
			
			System.out.println();
			System.out.println(joinUsername + " has been successfully added as an additional owner of Account #" + accountID + "!");
			System.out.println();
			logger.debug(joinUsername + " was added to " + username + "'s account - Account #" + accountID + ".");

		}

		System.out.println();
		System.out.println("Would you like to:");
		System.out.println();
		System.out.println("Return to " + username + "'s Customer Portal (1)");
		System.out.println("View " + joinUsername + "'s Customer Portal (2)");
		String accountReturn = joinAccount.nextLine();
		
		switch(accountReturn) {
		
		case "1" :

			Menu.customerMenu(username);
			break;
			
		case "2" :
			
			Menu.customerMenu(joinUsername);
			break;
			

		default :
			
			System.out.println("Your response was not recognized, please feel free to log in again.");
			System.out.println();
			Menu.welcomeMenu();
			break;
		}

	}
	
	public static void viewPendingAccounts(int accountType){
		
		System.out.println();
		System.out.println("Here are the current accounts: ");
		System.out.println();
		ArrayList<BankAccount> pendingAccounts = BankAccountDAO.getPendingAccounts();

		for(BankAccount account : pendingAccounts){
			
			System.out.println(account.toString());
		}
		
		System.out.println();
		System.out.println("Which account number would you like to approve or deny?");
		Scanner s = new Scanner(System.in);
		int accountID = s.nextInt();
		
		approveDenyAccount(accountID, accountType);
	
	}
	
	public static void approveDenyAccount(int accountID, int accountType) {
		
		String employeeType = "";
		
		if (accountType == 2) {
			
			employeeType = "Bank Admin";
			
		} else if (accountType == 3) {
			
			employeeType = "Employee";
		
		}
		
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Would you like to Approve Account (1) or Deny/Delete Account (2)?");
		String approveDeny = s.nextLine();
		
		switch (approveDeny) {
		
			case "1": 
				
				BankAccountDAO.approveAccount(accountID);
				logger.debug("A(n) " + employeeType + " approved Account #" + accountID + ".");

				break;
				
			case "2":
				
				BankAccountDAO.denyAccount(accountID);
				logger.debug("A(n) " + employeeType + " denied Account #" + accountID + ".");

				break;
				
			default:
				
				System.out.println("Please review your options and try again.");
				break;
		}
		
		switch(accountType) {
			
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
		
		
	}
	
	public static void deleteAccount(int accountType) {
		
		String employeeType = "";
		
		if (accountType == 2) {
			
			employeeType = "Bank Admin";
			
		} else if (accountType == 3) {
			
			employeeType = "Employee";
		
		}
		
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Which account number would you like to delete?");
		int accountToDelete = s.nextInt();
		
		BankAccountDAO.removeAccount(accountToDelete);
		
		logger.debug("A(n) " + employeeType + " deleted Account #" + accountToDelete + ".");

		
		switch(accountType) {
			
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
		
	}
	
	public String toString() {
		
		String approvalStatus = "";
		
		if (isApproved == true) {
			
			approvalStatus = "Approved";
			
		} else {
			
			approvalStatus = "Pending";
		}
		
		String result = "Account #" + accountID + ", Current Balance: $" + balance + ", Approval Status: " + approvalStatus;
		
		return result;
			
		}
	
	public BankAccount() {
			
		}
	
	}



