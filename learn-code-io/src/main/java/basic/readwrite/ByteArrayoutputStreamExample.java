package main.java.basic.readwrite;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayoutputStreamExample {

    public void write()
    {
        try {
            FileOutputStream fileOutputStream1=new FileOutputStream("text2.txt");
            FileOutputStream fileOutputStream2=new FileOutputStream("text3.txt");
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            String text="New file data to be passed";
            byteArrayOutputStream.write(text.getBytes());
            byteArrayOutputStream.writeTo(fileOutputStream1);
            byteArrayOutputStream.writeTo(fileOutputStream2);
            byteArrayOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read()
    {

    }
}
