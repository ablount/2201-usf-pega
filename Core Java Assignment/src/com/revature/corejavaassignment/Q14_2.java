package com.revature.corejavaassignment;

public class Q14_2 {
	
	public static void stringBreaker() {
		// this is called for case 3 - it takes that given string, splits it into a string array, the prints out each word
		 String str = "I am learning Core Java";		  
		 String strArray[] = str.split(" ");
		 for(int i=0; i < strArray.length; i++){
			 System.out.println(strArray[i]);
		 }
	 }
}