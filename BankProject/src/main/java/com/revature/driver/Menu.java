package com.revature.driver;
import java.util.Scanner;

import com.revature.accounts.BankAccount;
import com.revature.dao.BankAccountDAO;
import com.revature.dao.UserAccountDAO;

public class Menu {
	
	
	
	public static String welcomeMenu() {
	
	System.out.println("Welcome to Bank of Allison!");
	System.out.println("How can we help you today?");
	System.out.println();
	
	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    
	System.out.println("Would you like to Login (1) or Register (2)");
    String welcomeResult = myObj.nextLine();  // Read user input
    
    return logIn(welcomeResult);
    		
 
	}
	
	
	public static String logIn(String welcomeResult) {
	
		UserAccountDAO userDao = new UserAccountDAO();
		
		switch (welcomeResult) {
			
			case "1" :
				System.out.println();
				System.out.println("Let's get you logged in.");
				System.out.println();
				Scanner welcomeScanner = new Scanner(System.in);
				System.out.println("Clients (1)");
				System.out.println("Bank Employee (2)");
				System.out.println("Bank Administrator (3)");
				System.out.println();
				System.out.println("Return to Previous Screen (4)");
				String logInResult = welcomeScanner.nextLine();
			
				
				switch (logInResult) {
				
					case "1" : 
				
						System.out.println();
						
						System.out.print("Please enter your username: ");
						String username = welcomeScanner.nextLine();
						
						System.out.print("Please enter your password: ");
						String password = welcomeScanner.nextLine();
						
						
						if (userDao.doUsernamePasswordExist(username, password, 1)) {
						
							customerMenu(username);
							
							return username;
						
						} else {
							
							System.out.println("That username does not exist, the password is incorrect, or you have not selected the correct account type.");
							System.out.println("Please try again, or contact the bank for further assistance. Thanks!");
							System.out.println();
							welcomeMenu();
						}
						
						break;
						
					case "2" :
						
						System.out.println();
						System.out.print("Please enter your username: ");
						String username2 = welcomeScanner.nextLine();
						
						System.out.print("Please enter your password: ");
						String password2 = welcomeScanner.nextLine();
												
						if (userDao.doUsernamePasswordExist(username2, password2, 2)) {
						
							employeeMenu();
							
							return username2;
							
						
						} else {
							
							System.out.println("That username does not exist, the password is incorrect, or you have not selected the correct account type.");
							System.out.println("Please try again, or contact the bank for further assistance. Thanks!");
							System.out.println();
							welcomeMenu();
						}
						break;
						
					case "3" :
						
						System.out.println();
						
						System.out.print("Please enter your username: ");
						String username3 = welcomeScanner.nextLine();
						
						System.out.print("Please enter your password: ");
						String password3 = welcomeScanner.nextLine();
												
						if (userDao.doUsernamePasswordExist(username3, password3, 3)) {
						
							adminMenu();
							
							return username3;
						
						} else {
							
							System.out.println("That username does not exist, the password is incorrect, or you have not selected the correct account type.");
							System.out.println("Please try again, or contact the bank for further assistance. Thanks!");
							System.out.println();
							welcomeMenu();
						}
						break;
						
					case "4" :
						
						welcomeMenu();
						break;
					
					default :
						System.out.println("Please review your options, and try again. Thanks!");
						break;
					
					}
				
					break;
					
				case "2" : 
					System.out.println();
					register();
					break;
					
				default :
					System.out.println("Please reviw your options, and try again. Thanks!");

		}
		
		return welcomeResult;
	}
	
	public static void register() {
		System.out.println("We're so glad you'd like to bank with us!");
		System.out.println();
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.print("Please enter the username you'd like to use: ");

		String username = myObj.nextLine();
		
		UserAccountDAO userDao = new UserAccountDAO();
		if (userDao.isUsernameTaken(username)) {
			System.out.println("Unfortunately, that username is already taken! Let's try again...");
			return;
		}
		
		System.out.print("Please enter the password you'd like to use (cover your screen): ");
		
		String password = myObj.nextLine();
		
		System.out.println("Please enter the corresponding number for the type of account you are creating:");
		System.out.println("Client (1)");
		System.out.println("Bank Employee (2)");
		System.out.println("Bank Administrator (3)");
		int accountType = myObj.nextInt();
		
		userDao.signUp(username, password, accountType);
		
		switch (accountType) {
		
			case 1 : 
				
			System.out.println("Thank you for registering for an account.");
			System.out.println("A bank employee will review your account request, and approve or deny the new account.");
			break;
			
			case 2 :
				
			System.out.println("You have registered successfully.");	
			break;
			
			case 3 :
				
			System.out.println("You have registered successfully.");	
			break;
			
			default:
				
			System.out.println("There was an error registering your account.");
			System.out.println("Please try again, or contact your local bank branch.");
			
		}
		
	}
	
	public static String customerMenu(String username) {
		
		System.out.println();
		System.out.println("Welcome to the Customer Portal.");
		System.out.println();
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Would you like to:");
		System.out.println();
		System.out.println("View your Account Details (1)");
		System.out.println("Check your Balance (2)");
		System.out.println("Make a Withdrawl (3)");
		System.out.println("Make a Deposit (4)");
		System.out.println("Make a Transfer (5)");
		System.out.println("Create an account for an additional Acccount Owner (6)");
		System.out.println();
		System.out.println("Return to Login Menu (7)");
	    String customerAccountResult = myObj.nextLine();
	    
	    
	    return customerAccountAccess(customerAccountResult, username);
	   
		
	}
	
	public static String customerAccountAccess(String customerAccountResult, String username) {
			
			BankAccount myBankAccount = BankAccountDAO.accessAccount(username);
			
			switch (customerAccountResult) {
				
				case "1" : 
					
					myBankAccount.viewAccountDetails(username, 1, BankAccountDAO.accessAccount(username).isApproved);
	
					break;
				
				case "2" :
					
					myBankAccount.checkBalance(username, 1);
					
					break;
					
				case "3" :
					
					myBankAccount.withdraw(username, 1);
					
					break;
					
				case "4" : 
					
					myBankAccount.deposit(username, 1);
					
					break;
					
				case "5" :
					myBankAccount.transfer(username, 1);
					
					break;
					
				case "6" :
					myBankAccount.joinAccount(BankAccountDAO.accessAccount(username).accountID);
					
					break;
					
				case "7" :
					welcomeMenu();
					break;
					
				default :
					System.out.println("Please review the options, and try again.");
					break;
			}
				
			return customerAccountResult;

	}
	
	public static String adminMenu() {
		
		System.out.println();
		System.out.println("Welcome to the Bank Administrator Portal.");
		System.out.println();
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Would you like to:");
		System.out.println();
		System.out.println("View a Client's Account Details (1)");
		System.out.println("Make a Withdrawl from a Client's Account (2)");
		System.out.println("Make a Deposit to a Client's Account (3)");
		System.out.println("Make a Transfer between Client Accounts (4)");
		System.out.println();
		System.out.println("View Bank Accounts / Approve or Deny Pending Accounts (5)");
		System.out.println("Cancel a Client's Account (6)");
		System.out.println();
		System.out.println("Return to Login Menu (7)");
	    String adminAccountResult = myObj.nextLine();
	    
	    
	    return adminAccountAccess(adminAccountResult);
		
	}
	
	public static String adminAccountAccess(String adminAccountResult) {
		 
		
		switch (adminAccountResult) {
			
			case "1" : 
				
				Scanner myObj = new Scanner(System.in);  // Create a Scanner object
				System.out.print("Please enter the username on the account you'd like to view: ");

				String username = myObj.nextLine();
				
				BankAccount myBankAccount = BankAccountDAO.accessAccount(username);
				
				myBankAccount.viewAccountDetails(username, 2, BankAccountDAO.accessAccount(username).isApproved);
				
				break;
				
			case "2" :
				
				Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
				System.out.print("Please enter the username on the account you'd like to withdraw money from: ");
				String username2 = myObj2.nextLine();
				
				BankAccount myBankAccount2 = BankAccountDAO.accessAccount(username2);
				
				myBankAccount2.withdraw(username2, 2);	
				
				break;
				
			case "3" : 
				
				Scanner myObj3 = new Scanner(System.in);  // Create a Scanner object
				System.out.print("Please enter the username on the account you'd like to deposit money into: ");
				String username3 = myObj3.nextLine();
				
				BankAccount myBankAccount3 = BankAccountDAO.accessAccount(username3);
				
				myBankAccount3.deposit(username3, 2);	
				
				break;
				
				
			case "4" :
				Scanner myObj4 = new Scanner(System.in);  // Create a Scanner object
				System.out.print("Please enter the username on the account you'd like to transfer money from: ");
				String username4 = myObj4.nextLine();
				
				BankAccount myBankAccount4 = BankAccountDAO.accessAccount(username4);
				
				myBankAccount4.transfer(username4, 2);	
				
				break;
				
			case "5" :
				
				BankAccount.viewPendingAccounts(2);
				
				break;
			
			case "6" :
				
				BankAccount.deleteAccount(2);
				
				break;
				
			case "7" :
				welcomeMenu();
				
				break;
				
			default :
				System.out.println("Please review the options, and try again.");
				break;
		}
			
		return adminAccountResult;

	}
	
	public static String employeeMenu() {
			
			System.out.println();
			System.out.println("Welcome to the Employee Portal.");
			System.out.println();
			
			Scanner myObj = new Scanner(System.in);
			System.out.println("Would you like to:");
			System.out.println();
			System.out.println("View a Client's Account Details (1)");
			System.out.println("View Existing Bank Accounts / Approve or Deny Pending Accounts (2)");
			System.out.println("Cancel a Client's Account (3)");
			System.out.println();
			System.out.println("Return to Login Menu (4)");
		    String employeeAccountResult = myObj.nextLine();
		    
		    
		    return employeeAccountAccess(employeeAccountResult);
			
		}
	
	public static String employeeAccountAccess(String employeeAccountResult) {
		 
		
		switch (employeeAccountResult) {
		
			case "1" : 
				
				Scanner myObj = new Scanner(System.in);  // Create a Scanner object
				System.out.print("Please enter the username on the account you'd like to view: ");

				String username = myObj.nextLine();
				
				BankAccount myBankAccount = BankAccountDAO.accessAccount(username);
				
				myBankAccount.viewAccountDetails(username, 3, BankAccountDAO.accessAccount(username).isApproved);
				
				break;
				
			
			case "2" : 
				
				BankAccount.viewPendingAccounts(3);
				
				break;
			
			case "3" :
			
				BankAccount.deleteAccount(3);

				break;
				
			case "4" :
				welcomeMenu();
				break;
				
			default :
				System.out.println("Please review the options, and try again.");
				break;
		}
			
		return employeeAccountResult;

	}
}
