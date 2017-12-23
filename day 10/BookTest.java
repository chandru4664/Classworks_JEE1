package com.htc.pendingtopics;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book dbmsbook; 		
		try {
		  dbmsbook=new Book(102,"DBMS",30);
		  Class cls= dbmsbook.getClass();
		  System.out.println(cls);
		  Constructor constructor=cls.getConstructor();
	      System.out.println("The constructor is " +
                                 constructor.getName());

          System.out.println("The public methods of class are : ");

          //  Getting methods of the class through the object
          // of the class by using getMethods
          Method[] methods = cls.getMethods();
          // Printing method names
          for (Method method:methods)
             System.out.println(method.getName());
              
          Field field = cls.getDeclaredField("bookPrice");

           // allows the object to access the field irrespective
          // of the access specifier used with the field
          field.setAccessible(true);

             // takes object and the new value to be assigned
              // to the field as arguments
            field.set(dbmsbook,50);
            System.out.println(dbmsbook);
 
          // Creates object of the desired method by providing
         //  the name of method as argument to the 
         // getDeclaredMethod method
         Method methodcall3 = cls.getDeclaredMethod("privateMethod");
         System.out.println("return type is "+methodcall3.getReturnType());
         System.out.println("Parameter count "+methodcall3.getParameterCount());

         // allows the object to access the method irrespective 
        // of the access specifier used with the method
        //methodcall3.setAccessible(false);

      // invokes the method at runtime
       // methodcall3.invoke(dbmsbook);
		     
 

	     }
		 catch(InvalidPriceException IVP) {
			 IVP.printStackTrace();
			  
		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
		 }
	  }
	}

