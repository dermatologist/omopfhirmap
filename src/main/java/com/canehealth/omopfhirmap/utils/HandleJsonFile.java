package com.canehealth.omopfhirmap.utils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class HandleJsonFile {

//    public static void write(String jsonStr, String fileName)throws IOException {
//        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
//        writer.write(jsonStr);
//
//        writer.close();
//    }

    // https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
    public static void write(String jsonStr, String fileName)throws IOException {
        Path path = Path.of(fileName);
        Files.writeString(path, jsonStr);
    }

    public static String read(String fileName)throws IOException {
        Path path = Path.of(fileName);
        return Files.readString(path);
    }
    
}