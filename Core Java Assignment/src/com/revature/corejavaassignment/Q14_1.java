package com.revature.corejavaassignment;

/*Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array. “I am learning Core Java”
 */

import java.util.Date;
import java.util.Scanner;

public class Q14_1 {

	public static void askQuestions() throws Exception {
			// asking the user for input 
			System.out.println("How can I help you today?");
			System.out.println("1 will find the Square Root of any given number.");
			System.out.println("2 will provide you Today's Date and Time.");
			System.out.println("3 will split \"I am learning Core Java\" into an array.");
			Scanner getNum = new Scanner(System.in); // creates the scanner
			System.out.println("Please enter 1, 2, or 3"); // asks for the input
		    int inputNum = getNum.nextInt();  // reads user input
		    System.out.println("Thanks!");
		    getNum.close();
		    

		   // want to add a while loop but need to remember how to stop it
		   switch (inputNum) {
		   		
			  case 1: // if the user inputs 1 - this case runs
				  Scanner sqrtObj = new Scanner(System.in); // creates the scanner
				  System.out.println("Please enter the integer for which you'd like the square root:"); // asks for the number
				  int sqrtNum = sqrtObj.nextInt();  // reads user input		
				  System.out.println(Math.sqrt(sqrtNum));; // prints out the number
				  getNum.close();
			    break;
			 case 2: // if the user inputs 2 - this case runs
				   Date date = new Date(); // these two lines print out the date and time
			       System.out.println(date.toString());
			    break;
			  case 3: // if 3, this case
			    Q14_2.stringBreaker(); // I coded this on a separate page
			    break;
			  default: // this prints if they don't enter 1 2 or 3
				 throw new Exception("Unfortunately, that is not a valid number. Please review the available options, and try again.");

		   		}
		 	   	
		
	}
	
		
	    public static void main(String[] arg) throws Exception {
	    	// this runs the method
	    	while (true) {
	    		
	    	try {		
	    		askQuestions();}
	    	catch (Exception e){
	    		System.out.println("Unfortunately, that is not a valid number. Please review the available options, and try again.");
	    		}
	    	}
	    }
	}

