package com.htc.ioss;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// how to do write operation 

public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		byte[] data="Learn by mistakes".getBytes();
		FileOutputStream fos=new FileOutputStream("D:/study10.txt");
		
		for(int i=0;i<data.length;i++){
			fos.write(data[i]);
		}
		
		
		
		
		FileOutputStream fos2=new FileOutputStream("D:/FileJ.txt");
		fos2.write(data);
		
		FileOutputStream fos3=new FileOutputStream("D:/FileJJ.txt");
		fos3.write(data,2,10);
		
		fos.close();
		fos2.close();
		fos3.close();
		
		
	}
}
