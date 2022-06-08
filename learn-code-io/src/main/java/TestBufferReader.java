package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;

public class TestBufferReader {
    public static void main(String[] args) {
        BufferedReader bufferedReader=null;
        FileReader file= null;
        try {
            file = new FileReader("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader=new BufferedReader(file);
        //Files.newBufferedReader("");

    }
}
