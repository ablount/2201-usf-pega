package com.revature.corejavaassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Create a notepad file called Data.txt and enter the following: 

Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana

Write a program that would read from the file and print it out to the screen in the following format:
Name: Mickey Mouse
Age: 35 years
State: Arizona State*/

//why is it printing all of them?
  

public class Q20 {
	
	public static void main(String[] args) {
		
	    try {
	        File myData = new File("/Users/allison/Desktop/RevaturePractice/Data.txt");
	        
	        Scanner dataReader = new Scanner(myData);
	        
	        while (dataReader.hasNextLine()) {
		    
	        	String stringFromFile = dataReader.nextLine();
	        	
		  		String[] stringArrayFromFile = stringFromFile.split(":");
		  		
				System.out.println("Name: " + stringArrayFromFile[0] + " " + stringArrayFromFile[1]);
				System.out.println("Age: " + stringArrayFromFile[2] + " years");
				System.out.println("State: " + stringArrayFromFile[3] + " State");
				System.out.println();
				
	        }
	        
	        dataReader.close();
	        
	      } catch (FileNotFoundException e) {
	    	  
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	        
		}
		
	}
}

