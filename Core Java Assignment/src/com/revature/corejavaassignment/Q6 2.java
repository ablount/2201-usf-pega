package com.revature.corejavaassignment;

public class Q6 {
	
	public static void findEvens(int userNumber) {
		
		/* here we're taking the userNumber and converting it to a string, 
		 so we can then isolate the last character of the string */
		String magicString = Integer.toString(userNumber);
		char lastChar = magicString.charAt( magicString.length() - 1 );
		
		/* tested to see if you could use the userNumber, but can't use length() on a primitive
		char lastChar = userNumber.charAt( userNumber.length() - 1 );*/
		
		
		// this switch determines if the last character is even or odd
		switch(lastChar) {
		  case '0': System.out.println("It's even!");
		    break;
		  case '2': System.out.println("It's even!");
		    break;
		  case '4': System.out.println("It's even!");
		  	break;
		  case '6': System.out.println("It's even!");
		  	break;
		  case '8': System.out.println("It's even!");
		  	break;
		  default: System.out.println("It's odd, baby!");
		  	break;
		}
	}
	/*Was testing functionality before adding to Driver.java
	public static void main(String[] args) {
		
		findEvens(27);

	}*/
}
