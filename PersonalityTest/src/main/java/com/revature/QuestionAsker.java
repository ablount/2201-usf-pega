package com.revature;


import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class QuestionAsker{
	
	private static final Logger logger = LogManager.getLogger(QuestionAsker.class);
	
	public static String getInput() {

		System.out.println("Let's find out if you're a human.");
		Scanner animalInput = new Scanner(System.in); // creates the scanner
		System.out.println("Do you celebrate any holidays - 1 for yes, 2 for no."); // asks for the input
	    String celebrates = animalInput.nextLine();  // reads user input
	    System.out.println("Do you get regular haircuts - 1 for yes, 2 for no.");
	    String isFurry = animalInput.nextLine();  // reads user input
	    System.out.println("Do you have spoken language - 1 for yes, 2 for no.");
	    String doesSpeak = animalInput.nextLine();  // reads user input
	    System.out.println("Could you have a job that pays you money - 1 for yes, 2 for no.");
	    String doesWork = animalInput.nextLine();  // reads user input
	    
	    return askQuestions(celebrates, isFurry, doesSpeak, doesWork);
	}

	public static String askQuestions(String celebrates, String isFurry, String doesSpeak, String doesWork) {
 

	    
	    if (celebrates.equals("1") && isFurry.equals("1") && doesSpeak.equals("1") && doesWork.equals("1")) {
	    		
	    		System.out.println("Result: Safe to say you're a human.");
	    		
	    		return "Human.";
	    	
	   		} else if (celebrates.equals("1") && isFurry.equals("1") || doesSpeak.equals("1") && doesWork.equals("1")) {
	   			
	   			System.out.println("Result: You're looking most likely human.");
	   			
	   			return "Likely human.";
	   			
	   		} else if (celebrates.equals("1") && doesSpeak.equals("1") || isFurry.equals("1") && doesWork.equals("1")) {
	   			
	   			System.out.println("Result: You sure do seem like a human.");
	   			
	   			return "Seemingly human.";
	   		
	   		} else if (isFurry.equals("1") && doesSpeak.equals("1") || celebrates.equals("1") && doesWork.equals("1")) {
	   			
	   			System.out.println("Result: I'd guess you're a human.");
	   			
	   			return "Guess human.";
	   		
	   		} else if (celebrates.equals("1") || doesSpeak.equals("1") || isFurry.equals("1") || doesWork.equals("1")) {
	   			
	   			System.out.println("Result: There's a slight chance you're human.");
	   			
	   			return "Slight human.";
	   		
	   		} else {
	   			
	   			System.out.println("Result: You're most likely not a human.");
	   			
	   			return "Not human.";
	   		}
	    
	}

	
    public static void main(String[] arg) throws Exception {
    	
    	while (true) {
	    		
	    	try {		
	    		getInput();
	    		System.out.println();
	
	    	}
	 
	    	catch (Exception e){
	    		System.out.println("Unfortunately, that is not a valid number. Please review the available options, and try again.");
	    		logger.error("The user did not input a valid response.");
	
	    	}
    	
    	}
    }

}
