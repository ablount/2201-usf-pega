package com.revature.corejavaassignment;

import java.util.ArrayList;
import java.util.Collections;


public class Q8 {
	
	public static boolean isPalindrome(String listWords) {
	    String testWord = listWords.replaceAll("\\s+", "").toLowerCase();
	    int length = testWord.length();
	    int forward = 0;
	    int backward = length - 1;
	    while (backward > forward) {
	        char forwardChar = testWord.charAt(forward++);
	        char backwardChar = testWord.charAt(backward--);
	    if (forwardChar != backwardChar) {
            return false;
	    	} 
        }
	    return true;
	}
	
	
	public static ArrayList<String> onlyPalindromes(ArrayList<String> listOfWords){
		
		ArrayList<String> onlyPalindromes = new ArrayList<String>();
		
			for ( String testWord : listOfWords ) {
					
				if (isPalindrome(testWord)) {
						
						onlyPalindromes.add(testWord);
				}
				
			}
			
		return onlyPalindromes;
		
	}
	
	
	public static void letsDoIt() {
		

	    ArrayList<String> listOfWords = new ArrayList<>();
	    Collections.addAll(listOfWords, "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
	    
	    System.out.println(listOfWords);
	    System.out.println(onlyPalindromes(listOfWords));
	    
	    
	    
	}
}
