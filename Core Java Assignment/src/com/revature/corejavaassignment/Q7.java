package com.revature.corejavaassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q7 {
	
	public static class Employee{
		
		// instance field
		String name;
		String department;
		int age;
		
		// constructor method
		public Employee(String empName, String empDepartment, int empAge) {
			name = empName;
			department = empDepartment;
			age = empAge;
			
		}
		// this method tells the employeeList what specific information from the list array to print for each emp
		public String toString(){
            String visibleInfo = name + " (" + age + ")";
            return visibleInfo;
        }
	}

	//this class implements the comparator interface, says we're going to compare & return employee's int ages
	public static class ageComparator implements Comparator<Employee>{
		 
		public int compare(Employee firstEmployee, Employee secondEmployee) {
		       
			return Integer.compare(firstEmployee.age, secondEmployee.age);
		    
		}	
		
	}
	
	
	//this method is what we call in the driver
	public static void employeeSort() {
			
			//this creates a list while instantiating some employees
			List<Employee> employeeList = new ArrayList<>();
			Employee firstEmployee = new Employee("Franklin", "Accounting", 56);
			Employee secondEmployee = new Employee("Marta", "HR", 24);
		    employeeList.add(firstEmployee);
		    employeeList.add(secondEmployee);
		    
		    //this instantiates our ageComparator
		    ageComparator ageRank = new ageComparator();
		  
		    //this prints out our unsorted list, sorts the list, then prints out our sorted list
		    System.out.println("Before Sorting by Age: " + employeeList);
		    Collections.sort(employeeList, ageRank);
		    System.out.println("After Sorting by Age: " + employeeList);
		    
		}
	
}