package com.htc.arraylistsample;

import java.util.*;

public class TestMethods {
	public static void main(String args[]){  
		  ArrayList<String> al=new ArrayList<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ajay");  
		  ArrayList<String> al2=new ArrayList<String>();  
		  al2.add("Sonoo");  
		  al2.add("Hanumat");  
		  al.addAll(al2);//adding second list in first list  
		 // al.removeAll(al2);
		  //al.retainAll(al2);
		  Iterator itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
		 }  
}
