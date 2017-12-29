package com.htc.ioss;
import java.io.Externalizable ;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectInput;

class Book implements Externalizable  {
   int id;
    String name;
   String desc;
  
  
   public Book() {
     System.out.println("Book Constructor1");
   }
  
   public Book(int i, String n) {
     System.out.println("Book Constructor2");
     id   = i;
     name = n;
     desc = "books world";
   }

   public String toString() {
      return(id+":"+name+":"+desc);
   }
   @Override
   public void writeExternal(ObjectOutput out) {
     try {
    // customize and serialize 
       out.writeObject(name.toUpperCase());
       out.writeInt(id+1000);
     }catch(Exception e) {
        System.out.println(e.toString());
     }
   }
   
   @Override
   public void readExternal(ObjectInput in) {
    try{       
    	// reading customized serialized data 
       name = (String)in.readObject();
       id = in.readInt();
    }catch(Exception e) {
      System.out.println(e.toString());
    }
   }
}

public class ExternalizeDemo {

   public static void main(String[] args) 
      throws IOException, ClassNotFoundException {
     Book b1,b2;
     b1 = new Book(101,"Java");
     System.out.println(b1);
    
     ObjectOutputStream obOut = 
        new ObjectOutputStream(new FileOutputStream("book.dat"));
     obOut.writeObject(b1);// serialize 
     obOut.close();
        
    ObjectInputStream obIn = 
        new ObjectInputStream(new FileInputStream("book.dat"));
    b2 = (Book)obIn.readObject();       // deserialize 
    System.out.println(b2);
    obIn.close();
  }

}