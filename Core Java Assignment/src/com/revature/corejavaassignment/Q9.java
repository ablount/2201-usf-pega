package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q9 {
	
	//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	
	public static void main(String[] args) {
		
		//this sets the size of the array to 100
		ArrayList<Integer> primeList = new ArrayList<Integer>(100);
		
		// this fills the list with the numbers 1-100
		for (int i = 1; i <= 100; i++){
		   
			primeList.add(i);
		 
		}
		
		// not sure how to pull only prime numbers out of the list
		
		
		
		System.out.println(onlyPrimeNumbers);
		
	}
}
