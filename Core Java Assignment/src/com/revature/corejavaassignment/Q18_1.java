package com.revature.corejavaassignment;

/*Write a program having a concrete ;subclass that inherits three abstract methods from a superclass. 
 * Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2. Convert all of the lower case characters to uppercase in the input string, and return the result.
3. Convert the input string to integer and add 10, output the result to the console. 
Create an appropriate class having a main method to test the above setup.
 */

public class Q18_1 extends CaseStuff{
		
		public boolean testUpperCase(String testString){
			 
			 for (char testChar : testString.toCharArray()) {
				 
				 if (Character.isUpperCase(testChar)) {
					 
					 return true;
				 }
				
			 }
			
			 return false;
			 
		 }
		 
		 public String convertToUpper(String testString) {
			 
			 testString.toUpperCase();
			 
			 return testString;
		 }
		 
		 
		 public int convertToInteger(String testString) {
			
			 int stringAsInt = Integer.parseInt(testString);
			
			 return stringAsInt + 10; 
			  
		 }
		 
		 
		
	}

