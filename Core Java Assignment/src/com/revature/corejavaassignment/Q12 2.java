package com.revature.corejavaassignment;

import java.util.ArrayList;

/* Write a program to store numbers from 1 to 100 in an array. 
 * Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers.
 */

public class Q12 {
	
	public static boolean isEvenNumber(int testNum) {
		
		return (testNum % 2 == 0);
		
	}

	public static void pullingEvens() {
		
	ArrayList<Integer> fullList = new ArrayList<Integer>(100);
	
	// this fills the list with the numbers 1-100
	for (int i = 1; i <= 100; i++){
	   
		fullList.add(i);
	 
		}

	System.out.println("Here are the Even Numbers:");
	
	for (int evenNum : fullList) {
		
		if (isEvenNumber(evenNum)) {
		
			System.out.println(evenNum);
			
			}
		
		}

	}
}
	
