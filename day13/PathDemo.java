package com.htc.nios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;

public class PathDemo {

    public static void main(String[] args) throws java.io.IOException {
        String sep = File.separator;
        Path path = Paths.get("c:"+sep+"pras"+sep+"nio2"+"nbfile.txt");
        int dirCount = path.getNameCount();
        for(int i=0;i<dirCount;i++) {
            System.out.println(path.getName(i));
        }
        path = Paths.get("samp.txt");
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
        
        /* reading file attributes  */
        BasicFileAttributes attrs =
                Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Size of attributes:"+attrs.size());
        System.out.println("Creation Time:"+attrs.creationTime());
        System.out.println("Last Accessed Time:"+attrs.lastAccessTime());
        System.out.println("Last Modified Time:"+attrs.lastModifiedTime());
        System.out.println("Is Directory:"+attrs.isDirectory());
        System.out.println("Is Regular file:"+attrs.isRegularFile());
        
        // changing the time
        long currTime = System.currentTimeMillis();
        FileTime ft = FileTime.from(currTime, TimeUnit.MILLISECONDS);
        Files.setLastModifiedTime(path, ft);
        attrs =
                Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Last Modified Time:"+attrs.lastModifiedTime());
        
        
        
        
        
    }
     
}
