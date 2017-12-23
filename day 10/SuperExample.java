package com.htc.pendingtopics;

class Animal{
	String color= "White";
	Animal(){
		System.out.println("Parent Animal construtor is fired ");
	}
	
	Animal(int x){
		System.out.println("Overloaded parent class constructor ");
	}
	void eat() {
		System.out.println("Eat something in parent class");
	}
}

class Cow extends Animal{
	void eat() {
		
		System.out.println("eat grass ");
	}
}

class Dog extends Animal{
	Dog(){
		super(5);
		System.out.println("Dog child constructor is fired ");
	}
	void eat() { 
		System.out.println("Invoking parent attribute "+super.color);
		System.out.println(" eat biscuit ");
	}
}
public class SuperExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal animal=new Dog();
		animal.eat();

	}

}
