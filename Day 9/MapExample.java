package com.htc.map;

import java.util.*;  
public class MapExample {  
   public static void main(String args[]) {  
   // create and populate hash map  
     HashMap<Integer, String> citymap = new HashMap<Integer, String>();
     citymap.put(101,"Chennnai");
     citymap.put(102,"Hyd");
     citymap.put(103, "Mumbai");
     citymap.put(104, "delhi");
     System.out.println("The details are "+citymap);
     System.out.println("Random search "+citymap.get(103));
     citymap.remove(102);
     System.out.println("The details afetr deletion "+citymap);
 
     
     
     
     
      
   }      
} 