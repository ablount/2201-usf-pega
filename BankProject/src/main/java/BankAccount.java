import java.util.Scanner;

public class BankAccount {
	
	String name;
	String account;
	int balance;
	
	BankAccount(String nameOnAccount, String accountName, int accountBalance){
		name = nameOnAccount;
		account = accountName;
		balance = accountBalance;
	}
	
	
	public void viewAccountDetails() {
		
		System.out.println("Here are your account details:");
		System.out.println();
		System.out.println("Name on Account: " + name);
		System.out.println("Name on Account: " + account);
		System.out.println();
		Menu.customerMenu();
	}
	
	public int checkBalance() {
		
		System.out.println("The current balance is: " + balance);
		System.out.println();
		Menu.customerMenu();
		
		return balance;
		
	}
	
	public int withdraw() {
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("How much would you like to withdraw?");
		int amountToWithdraw = myObj.nextInt();
		
		if (amountToWithdraw <= balance) {
			balance -= amountToWithdraw;
			System.out.println("Your new balance is: " + balance);
			System.out.println();
			Menu.customerMenu();
			
		} else {
			
			System.out.println("You do not have sufficient funds. Please check your current balance, and try again. Thanks!");
			Menu.customerMenu();
		}
		
		return balance;
		
	}

	public int deposit() {
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("How much would you like to deposit?");
		int amountToDeposit = myObj.nextInt();
		
		balance += amountToDeposit;
		
		System.out.println("Your new balance is: " + balance);
		System.out.println();
		Menu.customerMenu();
		
		return balance;
		
	}
	
	// I need to make this transfer money from account to account
	public int transfer() {
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("How much would you like to transfer?");
		int amountToTransfer = myObj.nextInt();
		
		if (amountToTransfer <= balance) {
			balance -= amountToTransfer;
		}
		
		System.out.println("Your new balance is: " + balance);
		System.out.println();
		Menu.customerMenu();
		
		return balance;
		
	}
}

