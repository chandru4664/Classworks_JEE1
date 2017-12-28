package com.htc.ios.filter;
import java.io.IOException;
import java.io.FileFilter;
import java.io.File;
// filters
class MyFileFilter implements FileFilter {
 String str;

 public MyFileFilter(String str) {
  this.str = str.toLowerCase();
 }
 
 @Override
 public boolean accept(File fobj) {
   System.out.println("Accept triggerd ");
   boolean boo = (fobj.getName().endsWith(str));
   return(boo);
 }

}      

public class FileFilterDemo {  

 public static void main(String[] args)throws IOException {  

  File f = new File("D:\\JEE_onsite_training\\Day3");
  File[] files = f.listFiles(new MyFileFilter(args[0]));
  for(int i=0;i<files.length;i++){
   System.out.print(files[i].getName()+"  ");
  }
  System.out.println();
 }

} 