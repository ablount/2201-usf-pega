package com.revature.corejavaassignment;

public class Q2 {
	public static void Fibonacci(int N) {
		
		int num1 = 0, num2 = 1;
		
		int counter = 0;
		
		while (counter < N) {
		
			System.out.println(num1 + "");
			
			int num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
			counter = counter + 1;
		}
	}
	

}