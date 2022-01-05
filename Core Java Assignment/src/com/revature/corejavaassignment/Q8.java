package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q8 {
	
	public static String isPalindrome(String listWords) {
	    String testWord = listWords.replaceAll("\\s+", "").toLowerCase();
	    int length = testWord.length();
	    int forward = 0;
	    int backward = length - 1;
	    while (backward > forward) {
	        char forwardChar = testWord.charAt(forward++);
	        char backwardChar = testWord.charAt(backward--);
	        if (forwardChar != backwardChar) {
	            return a set of words I can add to one array; //how do I get the true into one group
	        } else {
	        	return a set of words I can add to the other array; //how do I get the false into one group
	        }
	    }
	}

	public static void main(String[] args) {
		
	    ArrayList<String> listOfWordsPal = new ArrayList<String>();
	    listOfWordsPal.add(words that returned as palindrones);
	    
	    ArrayList<String> listOfWordsNotPal = new ArrayList<String>();
	    listOfWordsNotPal.add(words that returned not as palindrones);
	   
	  
		
	}
}
