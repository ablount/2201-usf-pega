package com.revature.datatypes;

public class Driver {
	public static void main(String[] args) {
		// Here I am instantiating a new DataTypes object - making an instance of DataTypes
		// 
		DataTypes dt = new DataTypes();
		
		System.out.println(dt.add(5, 10));
		
		int answer = dt.add(10, 12);
		System.out.println(answer);
		
		Dog felix = new Dog(), henry = new Dog(), patty = new Dog();
		
		felix.name = "Felix";
		felix.age = 2;
		felix.breed = "German Shepard";
		felix.weight = 4.9;
		
		henry.name = "Henry";
		henry.age = 10;
		henry.breed = "Malimute";
		henry.weight = 95.6;
		
		patty.name = "Patty";
		patty.age = 6;
		patty.breed = "Basset Hound";
		patty.weight = 34.5;
	
		
		dt.printDogName(felix);
		dt.printDogAge(patty);
	
	}
}
