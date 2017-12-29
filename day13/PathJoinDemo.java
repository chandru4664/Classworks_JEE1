/*
  i am running from c:\pras\newios directory
  i am having under C:\pras
  two directories nio2 and nios
  and under nio2 ,am having samp.doc
  you may make this little more simple
*/

package com.htc.nios;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathJoinDemo {

 public static void main(String[] args) throws java.io.IOException {         String sep = File.separator;
 //demonstrating resolve method
  Path path = Paths.get("c:"+sep+"pras");
  System.out.format("%s%n", path.resolve("nio2"));
  Path path2 = Paths.get("/nio2").resolve("c:"+sep+"pras");
  System.out.println(path2);
 //demonstrating relativize()  method
 
  Path path3 = Paths.get("c:"+sep+"pras");
  Path sible1 = path3.resolve("nio2");
  Path sible2 = path3.resolve("nios");
  Path sible1_to_sible2 = sible1.relativize(sible2);
  System.out.println(sible1_to_sible2.toAbsolutePath());
  for(Path p :  sible1) {
    System.out.println(p);
  }        
  // isSameFile method
  Path file1 = Paths.get("c:"+sep+"pras"+sep+"nio2"+sep+"samp.doc");  
  Path sible1_file = sible1.resolve("samp.doc");                  System.out.println("Both files are "+Files.isSameFile(file1,sible1_file));
 }     
}