package com.revature.corejavaassignment;

/* Write a program to display the number of characters for a string input. 
 * The string should be entered as a command line argument using (String [ ] args).*/

public class Q16 {
	
		public static void main(String[] args) {
			
			if (args.length == 0) {
				System.out.println("Please run the program again, including an argument.");
			} else {
				String userString = args [0];
				System.out.println("The string array is this many characters long: " + userString.length());
			}

		}
	
}
