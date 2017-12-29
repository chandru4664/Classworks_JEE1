package com.htc.nios;

import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
public class PathCopy {
    public static void main(String[] args)throws IOException {
        String sep = File.separator;
        Path source = Paths.get("c:"+sep+"pras"+sep+"nio2"+sep+"forCopy.doc");
        Path target = Paths.get("c:"+sep+"pras"+sep+"nios"+sep+"forCopy.doc");
        Files.copy(source, target,StandardCopyOption.REPLACE_EXISTING);
        Path target2 = Paths.get("c:"+sep+"pras"+sep+"nios"+sep+"sameCopy.doc");                 OutputStream out =            Files.newOutputStream(target2,StandardOpenOption.CREATE_NEW); 
         long ln = Files.copy(target, out);
         System.out.println(ln+" bytes copied");
    }
}