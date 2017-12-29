package com.htc.ioss;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;

public class StudentSaver {
    static String sep = File.separator; 
    public static final String fileName1 = "sesestud.ser";
    
    
    private FileOutputStream fout;
    private FileInputStream  fin; 
    private ObjectOutputStream out;
    private ObjectInputStream in; 
    
    public StudentSaver() {
      try {
          fout = new FileOutputStream(fileName1);
          out = new ObjectOutputStream(fout);     
      }catch(IOException ioe) {
          ioe.printStackTrace();
      }
    }
   // serialization 
    public boolean saveStudent(StudentTO student) {
        boolean ret = false;
        try {                  
          out.writeObject(student); // serialize 
          out.flush();
          ret = true;
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return ret;
    }
    
    //deserailize  
    public void readStudents() {
        try{
            fin = new FileInputStream(fileName1);    
            in =  new ObjectInputStream(fin);
          while(fin.available()>0) {                
               StudentTO stu = (StudentTO)in.readObject();// de serialize
               System.out.println(stu);            
            }
         
        }catch(Exception ioe){
            ioe.printStackTrace();
        } 
         finally{
            try {
             in.close();  
            }catch(IOException ioe) {}
         }
    }
    
    
    public void closeOut(){
        try {
            out.close();            
           }catch(IOException ioe) {} 
    }
}
