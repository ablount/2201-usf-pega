package com.revature.corejavaassignment;

/*Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division. 
 * Create a class that implements this interface and provides appropriate functionality 
 * to carry out the required operations. 
 * Hard code two operands in a test class having a main method that calls the implementing class.
 * */

public class Q15_1 {
	
	public interface mathHelper{
		
		public int addition(int A, int B);
	
		public int subtraction(int A, int B);
		
		public int multiplication(int A, int B);
		
		public int division(int A, int B);
	}

}
