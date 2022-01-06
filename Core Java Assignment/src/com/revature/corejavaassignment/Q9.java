package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q9 {
	
	public static boolean isPrimeNumber(int testNumb) {
		
		if (testNumb == 1) {
			return false;
			}

		for (int testNumb2 = 2; testNumb2 <= testNumb / 2; testNumb2++) {
		    
		     if (testNumb % testNumb2 == 0) {
		        return false;
		      
		      }
		    }
		return true;
	}

	    
	
	public static void primeTime() {
		
		//this sets the size of the array to 100
		ArrayList<Integer> primeList = new ArrayList<Integer>(100);
		
		// this fills the list with the numbers 1-100
		for (int i = 1; i <= 100; i++){
		   
			primeList.add(i);
		 
		}
		
		System.out.println("Here are the Prime Numbers:");
		
		for (int primeNum : primeList) {
			
			if (isPrimeNumber(primeNum)) {
			
				System.out.println(primeNum);
				}
			
			}

		}
		
		
	}

