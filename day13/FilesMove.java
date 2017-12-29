package com.htc.nios;

import java.io.IOException;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;

public class FilesMove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String sep = File.separator;
        Path mainPath = Paths.get("D:"+sep+"nioss");
        Path  source = mainPath.resolve("source" + sep + "source.txt");
        Path  target = mainPath.resolve("tgt" + sep + "target.txt");
        Files.move(source, target, ATOMIC_MOVE, REPLACE_EXISTING);
       
    }
}
