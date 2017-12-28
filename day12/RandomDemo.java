package com.htc.ioss;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
// random access
class Student  {
 private int    rollNum;
 private String name;
 private String course;
   
 public static final int SFIELD_SIZE = 30;
 public static final int RECORD_SIZE
                         = 4 + (2 * SFIELD_SIZE * 2);
   
 public Student(int r, String n, String c){
  rollNum = r;
  name = n;
  course = c;
 }
   
 public Student(){}
   
 public void show() {
  System.out.println("RollNum:"+rollNum+" Name: "+
                     name+" Course:"+course);
 }
   
 public void writeData(DataOutput out) throws IOException {
  out.writeInt(rollNum);   
  DatIO.writeString(name,SFIELD_SIZE,out);
  DatIO.writeString(course,SFIELD_SIZE,out);
 }
   
 public void readData(DataInput in)throws IOException { 
  rollNum = in.readInt();
  name = DatIO.readString(SFIELD_SIZE,in);
  course = DatIO.readString(SFIELD_SIZE,in);
 }
   
}
class DatIO {

 static void writeString(String str, int size, DataOutput out) 
    throws IOException  {
  int i; 
  for(i=0;i<size;i++) {
   char ch = 0;
   if(i<str.length()) {
      ch= str.charAt(i);
   }
   out.writeChar(ch); 
  }  
 }

 static String readString(int size, DataInput in)throws IOException {         
  StringBuffer temp = new StringBuffer(size);   
  int i = 0;              
   while(i<size) {
    char ch = in.readChar();  
    i++;                 
    temp.append(ch);
   }       
   return temp.toString().trim();
  }
 
}
public class RandomDemo {

 public static void main(String[] args)throws IOException {
  Student stu[] = new Student[3];
  stu[0] = new Student(100,"Radhe Shyam","mpc");
  stu[1] = new Student(101,"Revati Kumari","bpc");
  stu[2] = new Student(102,"Karuna Raj","mec"); 
  int i;
  try  {
   DataOutputStream out =
     new DataOutputStream(new FileOutputStream("output.dat"));
 
   for(i=0;i<stu.length;i++) {
    stu[i].writeData(out);
   }
   out.close();
  }
  catch(Exception e) {
   System.out.println("error:"+e);
   System.exit(1);
  }
  try {
   RandomAccessFile in =
      new RandomAccessFile("output.dat","r");
    
   int n = (int)in.length()/Student.RECORD_SIZE;
   Student newstu[] = new Student[n];
   for(i=n-1;i>=0;i--) {
    newstu[i] = new Student();
    in.seek(i*Student.RECORD_SIZE); 
    newstu[i].readData(in);
    newstu[i].show();
   }  
  }
  catch(Exception e) {
   System.out.println("error:"+e);
   System.exit(1);
  }
 }

}