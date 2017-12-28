package com.htc.ioss;
import java.io.File;

// getting meta data of a file 
public class FileClassDemo {
	public static void main(String[] args) {
		File file1=new File("D:\\ios\\notes.txt");
		
		System.out.println("File: "+file1.getName() +(file1.isFile()? " -- is a file " : "is a named pipe or directory"));
		
		System.out.println("Size: "+file1.length());
		
		System.out.println("Path: " +file1.getPath());
		
		System.out.println("File was last modified: "+file1.lastModified());
		
		System.out.println(file1.exists()? "File exists" : "File does not exist");
		
		System.out.println(file1.canRead()? "File can be read from" : "File cannot be read");
		
		System.out.println(file1.canWrite()? "File can be written to" : "File cannot be written to");
		
		System.out.println(file1.isDirectory()? "is a directory" : " is not a directory");
				
	}

}
