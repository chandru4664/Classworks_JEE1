package com.htc.ioss;
 
// how to create directories 
import java.io.IOException;
import java.io.File;
public class CreateDirFiles {
 
  public static void main(String[] args)
     throws IOException   {
    char fChar = File.separatorChar;
    System.out.println("Windows separator "+fChar);
    File  f1 = new File("d:" + fChar +
                        "aaa");
    f1.mkdir();
    System.out.println(f1.exists());
    String path = f1.getAbsolutePath();
    System.out.println(path);

    String s1  =  path + fChar + "samp.txt";
    f1 = new File(s1);
    System.out.println("File created is:" + 
                       f1.createNewFile());
    f1 = new File(path + fChar +
                   "bbb" + fChar + "ccc");   
    boolean boo = f1.mkdirs();
    System.out.println("Statement that directories" +
                       " are created is:" + boo);
   }     

}