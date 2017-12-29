package com.htc.nios;
import java.io.BufferedInputStream;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.StandardOpenOption.READ;

public class PathReadDemo {

  public static void main(String[] args) 
    throws java.io.IOException {

    String sep = FileSystems.getDefault().getSeparator();
    String fileName = "C:"+sep+"pras"+sep+"nio2"+sep+"sample.txt";
    Path path = FileSystems.getDefault().getPath(fileName);
    System.out.println("absolute :"+path.isAbsolute());
    
    BasicFileAttributes attrs = 
     Files.readAttributes(path, BasicFileAttributes.class);
    // returns FileTime
    System.out.println("creation time:"+attrs.creationTime());
    System.out.println("Directory:"+attrs.isDirectory());
    System.out.println("Normal file:"+attrs.isRegularFile());
    int size = (int)attrs.size();
    System.out.println("Size"+size);
    
    Path otherPath = path.getParent().resolve("sample2.txt");
    System.out.println("absolute :"+otherPath.isAbsolute());
    byte[] bytes = new byte[size]; 
    try(BufferedInputStream in = 
            new BufferedInputStream(Files.newInputStream(path,READ))){
        in.read(bytes);
        System.out.println(new String(bytes));  
    }
    
            
  }

}
