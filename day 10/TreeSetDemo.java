package com.htc.treesetsample;
 

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		
		TreeSet<Integer> numbers = new TreeSet<Integer>();
		numbers.add(new Integer(399));
		numbers.add(new Integer(199));
		numbers.add(new Integer(299));
		numbers.add(new Integer(99));
		
		for(Integer number : numbers) {
			System.out.println(number);
		}
		
		System.out.println("=============================");
	  
		TreeSet<Employee> employees = new TreeSet<Employee>();
		employees.add(new Employee(104, "Rahul", 15000.0));
		employees.add(new Employee(102, "Ramesh", 35000.0));
		employees.add(new Employee(101, "Arun", 25000.0));
		employees.add(new Employee(103, "Ajay", 14000.0));
		
		for(Employee emp : employees) {
			System.out.println(emp);
		}
	 
	}
}
