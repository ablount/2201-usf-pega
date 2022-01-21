package com.revature.corejavaassignment;

import com.revature.corejavaassignment.Q15_1.mathHelper;

public class Q15_2 implements mathHelper {
	
	public int addition(int userA, int userB) {
		
		System.out.print(userA + " + " + userB + " = " );
		 
		return userA + userB;
		
	}
	
	public int subtraction(int userA, int userB) {
		
		System.out.print(userA + " - " + userB + " = " );
		
		return userA - userB;
		
	}
	
	public int multiplication(int userA, int userB) {
		
		System.out.print(userA + " * " + userB + " = " );

		return userA * userB;
	}
	
	public int division(int userA, int userB) {
		
		System.out.print(userA + " / " + userB + " = " );
		
		return userA / userB;
	}	

}
