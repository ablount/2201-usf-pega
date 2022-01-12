package com.revature.corejavaassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
 * Add all the even numbers up and display the result. Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 * */

public class Q19 {
	
	public static boolean isPrimeNumber(int testNum) {
		
		if (testNum == 1) {
			
			return false;
			
		}

		for (int testNumb2 = 2; testNumb2 <= testNum / 2; testNumb2++) {
		    
		     if (testNum % testNumb2 == 0) {
		        
		    	return false;
		      
		      }
		    }
		
		return true;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> numStuff = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		
		int evenNum = 0;
		int oddNum =0;
		
		for (int testNum : numStuff) {
			
			if (testNum % 2 == 0) {
				
				evenNum += testNum;
				 //add the even numbers together and print result
				 
			
			} else {
				
				oddNum += testNum;
				// add the false numbers together and print result
				
			}
		}
			
		
		for (int i = 0; i < numStuff.size(); i++) {
			
			if (isPrimeNumber(numStuff.get(i))) {
				
				numStuff.remove(i);
			}
		}
		
		/*Iterator<Integer> primeIterator = numStuff.iterator();
		
			while (primeIterator.hasNext()) {
				int testNum = primeIterator.next();
				
				if (isPrimeNumber(testNum)) {
					
					numStuff.remove(testNum);
				}
			}*/
		
		
		System.out.println(evenNum);
		System.out.println(oddNum);
		System.out.println(Arrays.toString(numStuff.toArray()));
	}
}



