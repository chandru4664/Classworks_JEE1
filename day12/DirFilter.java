package com.htc.ios.filter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Path;
import java.util.Iterator;

class SimpDirFilter implements 
    DirectoryStream.Filter<Path> {

 public boolean accept(Path entry) throws IOException {
	System.out.println("---"+entry);
    String str = entry.getFileName().toString();
    if(str.endsWith(".txt")){
        return true;
    }    
    return false;    
 }
  
}    

public class DirFilter {
    
    public static void main(String[] args) {
     Path path = Paths.get("D:\\JEE_onsite_training\\Day3");
     final SimpDirFilter filter = new SimpDirFilter();
     try (DirectoryStream<Path> stream = Files.newDirectoryStream(path,filter)){
       for(Path p : stream){
           System.out.println(p.getFileName());
       }
     }catch(IOException ioe){
         ioe.printStackTrace();
     }

    }

}
