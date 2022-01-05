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
		
		// why does this one not need Q2 q2 = new Q2(); to run?
		int N = 25;
		Q2.Fibonacci(N);
		//gave an error until I added Q2. in front of Fibonacci
		
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
        /*finally figured out I needed to add q4. in front of factorial - 
        not quiet grasping when that's necessary, and why the one I added in Q2
        was caps and this one was lower case*/
        
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
		
		System.out.println("Need help turning psuedocode into \"code\" code.");
		
		// Begin Q9
		System.out.println("Q9 Result:");
		
		System.out.println("Need help turning psuedocode into \"code\" code.");
		
		// Begin Q10
		System.out.println("Q10 Result:");
		
		Q10.whoseOlder();
	}


}
