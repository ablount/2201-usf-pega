package com.revature.corejavaassignment;

import java.util.Arrays;

public class Driver {
	
	public static void main(String[] args) {
		// Begin Q1
		System.out.println("Q1 Result:");
		
		Q1 q1 = new Q1();
		
		int[] data = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		Q1.bubbleSort(data);
		System.out.println("Ascending Array: " + Arrays.toString(data));
		
		// Begin Q2
		System.out.println("Q2 Result:");
		
		int N = 25;
		Q2.Fibonacci(N);
		
		// Begin Q3
		System.out.println("Q3 Result:");
	
		
		String str = "Backwards, please.";
        str = Q3.reverse(str);
        System.out.println("The reversed string is " + str);
		
		// Begin Q4
		System.out.println("Q4 Result:");
				
		Q4 q4 = new Q4();
		
		int num = 6;
        System.out.println("Factorial of "+ num + " is " + Q4.factorial(6));
        
		// Begin Q5
		System.out.println("Q5 Result:");
				
		System.out.println(Q5.Substring("Make me shorter", 5));
		
		// Begin Q6
		System.out.println("Q6 Result:");
		
		Q6.findEvens(35);
		Q6.findEvens(24);
		
		// Begin Q7
		System.out.println("Q7 Result:");
		
		Q7.employeeSort();
		
		// Begin Q8
		System.out.println("Q8 Result:");
		
		Q8.letsDoIt();
		
		// Begin Q9
		System.out.println("Q9 Result:");
		
		Q9.primeTime();
		
		// Begin Q10
		System.out.println("Q10 Result:");
		
		Q10.whoseOlder(24, 36);
		
		// Begin Q11
		System.out.println("Q11 Result:");
		
		Q11_1.floatTogether();
		
		// Begin Q12
		System.out.println("Q12 Result:");
		
		Q12.pullingEvens();
		
		// Begin Q13
		System.out.println("Q13 Result:");
		
		Q13.patternPrinter();
		
		// Begin Q14
		System.out.println("Q14 Result:");
		
		try {		
    		Q14_1.askQuestions();}
    	catch (Exception e){
    		System.out.println("Unfortunately, that is not a valid number. Please review the available options, and try again.");
    		}
	}


}
