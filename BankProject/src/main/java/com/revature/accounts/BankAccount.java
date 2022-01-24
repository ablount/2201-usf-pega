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
		
		logger.debug(whoChecked(accountType) + " checked the account status for " + username + "'s Account #" + accountID + ".");
		System.out.println("__________________________________");
		System.out.println();
		
		menuSwitch(accountType, username);
		
		return accountID;
	}
		
	
	public int checkBalance(String username, int accountType) {
		
		if (isApproved == true) {
		
			System.out.println();
			System.out.println("The current balance is: " + balance);
			System.out.println();
			logger.debug(whoChecked(accountType) + " checked " + username + "'s balance.");
			System.out.println("__________________________________");
			System.out.println();
			
			menuSwitch(accountType, username);
		
		} else {
			
			System.out.println();
			System.out.print("This account has not yet been approved.");
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
			menuSwitch(accountType, username);
			
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
			
			if (amountToWithdraw <= balance && amountToWithdraw > 0) {
				balance -= amountToWithdraw;
				System.out.println("The new balance is: " + balance);
				BankAccountDAO.updateBalance(username, balance);
				
				System.out.println();
				logger.debug(whoChecked(accountType) + " made a withdrawal from " + username + "'s account.");
				System.out.println("__________________________________");
				System.out.println();
				
			} else {
				
				System.out.println();
				System.out.println("Account does not have sufficient funds or the withdrawal amount was entered as a negative.");
				System.out.println("Please check your current balance, and/or try again without entering a negative amount. Thanks!");
				System.out.println();	
				logger.debug(whoChecked(accountType) + " unsuccessfully tried to make a withdrawal from " + username + "'s account.");
				System.out.println("__________________________________");
				System.out.println();
			}
			
			menuSwitch(accountType, username);
			
		} else {
		
		System.out.println();
		System.out.print("This account has not yet been approved.");
		System.out.println();
		logger.debug(whoChecked(accountType) + " tried to make a withdrawal from " + username + "'s account, but the account is not yet approved.");
		System.out.println("__________________________________");
		System.out.println();
		menuSwitch(accountType, username);
		
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
			
			if (amountToDeposit > 0) {
				
				balance += amountToDeposit;
				
				System.out.println();
				System.out.println("The new balance is: " + balance);
				
				BankAccountDAO.updateBalance(username, balance);
				
				System.out.println();
				logger.debug(whoChecked(accountType) + " made a deposit of $" + amountToDeposit + " into " + username + "'s account.");
				System.out.println("__________________________________");
				System.out.println();
				
				menuSwitch(accountType, username);
				
			} else {
				
				System.out.println();
				System.out.print("The amount cannot be negavite, please try again.");
				System.out.println();
				logger.debug(whoChecked(accountType) + " tried to make a deposit to " + username + "'s account, but the amount was negative.");
				System.out.println("__________________________________");
				System.out.println();
				menuSwitch(accountType, username);
			}
			
		} else {
		
		System.out.println();
		System.out.print("This account has not yet been approved.");			
		System.out.println();
		logger.debug(whoChecked(accountType) + " tried to make a deposit into " + username + "'s account, but the account is not yet approved.");
		System.out.println("__________________________________");
		System.out.println();
		
		menuSwitch(accountType, username);
		
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
			
			if (amountToTransfer <= balance && amountToTransfer > 0) {
				
				System.out.println("What is the username on the account to which you'd like to transfer $" + amountToTransfer + "?");
				String accountToTransfer = myObj.nextLine();
				
				if (BankAccountDAO.accessAccount(accountToTransfer).isApproved == true) {
					
					balance -= amountToTransfer;
					BankAccountDAO.updateBalance(username, balance);
				
					BankAccountDAO.updateBalance(accountToTransfer, BankAccountDAO.accessAccount(accountToTransfer).balance + amountToTransfer);
				
					System.out.println();
					System.out.println("$" + amountToTransfer + " from " + username + " has been transferred to " + accountToTransfer);
					System.out.println();
					System.out.println(username + "'s new balance is: " + balance);
					System.out.println(accountToTransfer + "'s new balance is: " + BankAccountDAO.accessAccount(accountToTransfer).balance);
					System.out.println();
					logger.debug(whoChecked(accountType) + " made a transfer of $" + amountToTransfer + " from " + username + "'s account to " + accountToTransfer + "'s account.");
					System.out.println("__________________________________");
					System.out.println();
					
					menuSwitch(accountType, username);
				
				} else {
					
					System.out.println();
					System.out.print("This account has not yet been approved.");
					System.out.println();
					logger.debug(whoChecked(accountType) + " tried to make a transfer from " + username + "'s account to " + accountToTransfer + "'s account, but " + accountToTransfer + "'s account is not yet approved.");
					System.out.println("__________________________________");
					System.out.println();
					menuSwitch(accountType, username);
					
				}
				
			} else {
					
				System.out.println();
				System.out.print("The account does not have sufficient funds, or the amount entered was negative, please try again.");
				System.out.println();
				logger.debug(whoChecked(accountType) + " tried to make a transfer from " + username + "'s account, but the amount was negative or more than the current balance.");
				System.out.println("__________________________________");
				System.out.println();
				menuSwitch(accountType, username);
					
				}
				
			} else {
			
				System.out.println();
				System.out.print("This account has not yet been approved.");
				System.out.println();
				logger.debug(whoChecked(accountType) + " tried to make a transfer from " + username + "'s account, but the account is not yet approved.");
				System.out.println("__________________________________");
				System.out.println();
				
				menuSwitch(accountType, username);
			
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
		System.out.println("Return to Portal (0)");
		Scanner s = new Scanner(System.in);
		int accountID = s.nextInt();
		
		if (accountID == 0) {
		
			menuSwitch2(accountType);
			
		} else {
		 	
			approveDenyAccount(accountID, accountType);
		
		}
	
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
		System.out.println("Return to Portal (0)");
		String approveDeny = s.nextLine();
		
		if (approveDeny == "0") {
			
			menuSwitch2(accountType);
			
		} else {
			
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
			
		}
		
		menuSwitch2(accountType);
		
	}
	
	public static void deleteAccount(int accountType) {
		
		String employeeType = "";
		
		if (accountType == 2) {
			
			employeeType = "Bank Admin";
			
		} else if (accountType == 3) {
			
			employeeType = "Employee";
		
		}
		
		System.out.println();
		System.out.println("Here are the current accounts: ");
		System.out.println();
		ArrayList<BankAccount> pendingAccounts = BankAccountDAO.getPendingAccounts();

		for (BankAccount account : pendingAccounts){
			
			System.out.println(account.toString());
		}
		
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Which account number would you like to delete?");
		System.out.println("Return to Portal (0)");
		int accountToDelete = s.nextInt();
		
		if (accountToDelete == 0) {
			
			menuSwitch2(accountType);
			
		} else {
		
			BankAccountDAO.removeAccount(accountToDelete);
		
			logger.debug("A(n) " + employeeType + " deleted Account #" + accountToDelete + ".");

		}
		
		menuSwitch2(accountType);
		
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

	public String whoChecked(int accountType) {
		
		String whoChecked = "";
		
		if (accountType == 1) {
			whoChecked = "The Client";
		} else if (accountType == 2) {
			whoChecked = "A Bank Admin";
		} else if (accountType == 3) {
			whoChecked = "An Employee";
		}
		
		return whoChecked;
	}
	
	public void menuSwitch(int accountType, String username) {
		
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
	}
	
	public static void menuSwitch2(int accountType) {
		
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
	
	
	public BankAccount() {
			
		}
	
	}



