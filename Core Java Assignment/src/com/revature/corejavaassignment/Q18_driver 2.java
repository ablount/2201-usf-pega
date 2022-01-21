package com.revature.corejavaassignment;

public class Q18_driver {
	
	public static void main(String[] args) {
		
		Q18_1 myQ18 = new Q18_1();
		
		System.out.println(myQ18.testUpperCase("What is happening here?"));
		
		
		System.out.println(myQ18.convertToUpper("What is happening here?"));
				
		try {
		
		System.out.println(myQ18.convertToInteger("823289"));
		 
		} catch (NumberFormatException e) {
			 
			 System.out.println("A String of numbers was not entered.");
		 }
	}

}
