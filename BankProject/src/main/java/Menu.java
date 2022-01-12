import java.util.Scanner;

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
		
		switch (welcomeResult) {
			
			case "1" :
				System.out.println();
				System.out.println("Let's get you logged in.");
				System.out.println();
				
				Scanner myObj = new Scanner(System.in);
				System.out.println("Clients (1)");
				System.out.println("Bank Employee (2)");
				System.out.println("Bank Administrator (3)");
				System.out.println();
				System.out.println("Return to Previous Screen (4)");
				String logInResult = myObj.nextLine();
				
				switch (logInResult) {
					case "1" : 
						customerMenu();
						break;
					case "2" :
						employeeMenu();
						break;
					case "3" :
						adminMenu();
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
					System.out.println("Let's get you registered.");
				// call method to get registered
					break;
					
				default :
					System.out.println("Please reviw your options, and try again. Thanks!");

		}
		
		return welcomeResult;
	}
	
	public static String customerMenu() {
		
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
		System.out.println("Transfer money (5)");
		System.out.println();
		System.out.println("Return to Login Menu (6)");
	    String customerAccountResult = myObj.nextLine();
	    
	    
	    return customerAccountAccess(customerAccountResult);
	   
		
	}
	
	public static String customerAccountAccess(String customerAccountResult) {
		 
			
			switch (customerAccountResult) {
				
				case "1" : 
					
					System.out.println("This will call the account details method");
					
					break;
				
				case "2" :
					System.out.println("This will call the current balance method");
					break;
					
				case "3" :
					System.out.println("This will call the withrdaw method");
					break;
					
				case "4" : 
					System.out.println("This will call the deposit method");
					break;
					
				case "5" :
					System.out.println("This will call the transfer method");
					break;
					
				case "6" :
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
		System.out.println("Check a Client's Balance (1)");
		System.out.println("Make a Withdrawl from a Client's Account (2)");
		System.out.println("Make a Deposit from a Client's Account (3)");
		System.out.println("Transfer money from a Client's Account (4)");
		System.out.println();
		System.out.println("View new Account Requests (5)");
		System.out.println("Cancel a Client's Account (6)");
		System.out.println();
		System.out.println("Return to Login Menu (7)");
	    String adminAccountResult = myObj.nextLine();
	    
	    
	    return adminAccountAccess(adminAccountResult);
		
	}
	
	public static String adminAccountAccess(String adminAccountResult) {
		 
		
		switch (adminAccountResult) {
			
			case "1" : 
				System.out.println("The client's current balance is: ");
				break;
				
			case "2" :
				System.out.println("How much money would the client like to withdraw?");
				// take in input for a withdraw method
				break;
				
			case "3" : 
				System.out.println("How much money would the client like to deposit?");
				// take in input for a deposit method
				break;
				
			case "4" :
				System.out.println("How much money would the client like to transer?");
				// take in input for a transfer method
				break;
				
			case "5" :
				System.out.println("Here are the new account requests: ");
				// take in input for a account approve/deny method
				break;
			
			case "6" :
				System.out.println("Whose account would you like to cancel?");
				// take in input for an account cancel method
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
			System.out.println("View new Account Requests (1)");
			System.out.println("Cancel a Client's Account (2)");
			System.out.println();
			System.out.println("Return to Login Menu (3)");
		    String employeeAccountResult = myObj.nextLine();
		    
		    
		    return employeeAccountAccess(employeeAccountResult);
			
		}
	
	public static String employeeAccountAccess(String employeeAccountResult) {
		 
		
		switch (employeeAccountResult) {
			
			case "1" : 
				System.out.println("Here are the new account requests: ");
				// take in input for a account approve/deny method
				break;
			
			case "2" :
				System.out.println("Whose account would you like to cancel?");
				// take in input for an account cancel method
				break;
				
			case "3" :
				welcomeMenu();
				break;
				
			default :
				System.out.println("Please review the options, and try again.");
				break;
		}
			
		return employeeAccountResult;

	}
}
