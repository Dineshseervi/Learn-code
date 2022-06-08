package main.java.appender;

import java.io.*;

public class LearnFileAppender {

    private static void addendDataToFile(File file,String data)
    {
        System.out.println(file.getPath());
        if(file.exists())
        {
            System.out.println("SIZE :"+file.length());
        }
        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(data);
            //more code
            out.println("\n");
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        if(file.exists())
        {
            System.out.println("SIZE :"+file.length());
        }
    }

    public static void main(String[] args) {
        String val="test data";

        for (int i=0;i<10;i++) {
            LearnFileAppender.addendDataToFile(new File("MyFileAppenderLEarn.txt"), val + " ->"+System.currentTimeMillis());
        }
    }
}
