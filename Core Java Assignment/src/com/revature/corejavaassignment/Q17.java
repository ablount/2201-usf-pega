package com.revature.corejavaassignment;

import java.util.Scanner;

/*Write a program that calculates the simple interest on the principal, 
 * rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time*/

public class Q17 {
	
	public static void main(String[] args) {
	while (true) {
		try {
		System.out.println("Welcome! Let's calculate how much total interest you will pay on your loan.");
		System.out.println();
		System.out.println("How much money have you borrowed?");
		Scanner acctInfo = new Scanner(System.in);
		double principalAmt = acctInfo.nextDouble();
		System.out.println("Next, what is your interest rate?");
		double interestAmt = acctInfo.nextDouble();
		System.out.println("Finally, for how many years will you make payments?");
		double yearsForLoan = acctInfo.nextDouble();
		acctInfo.close();
		
		System.out.println("Your total interest will be: " + (principalAmt*interestAmt*yearsForLoan));
		
		break;
		
	}
		catch (Exception e){
			
			System.out.println();
			System.out.println("Please only include numerical values in your answers, thanks!");
			System.out.println();
			System.out.println("Let's try again...");
			}
		}
	}

}
