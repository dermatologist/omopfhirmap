package com.canehealth.omopfhirmap.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HandleJsonFile {

    public static void write(String jsonStr, String fileName)throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(jsonStr);
        
        writer.close();
    }
    
}