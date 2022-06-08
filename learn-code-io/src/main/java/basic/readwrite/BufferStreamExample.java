package main.java.basic.readwrite;

import java.io.*;

public class BufferStreamExample {

    public void write()
    {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("text2.txt");
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            String text="My name is dinesh";
            bufferedOutputStream.write(text.getBytes());
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public  void read()
    {
        try {
            BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("text2.txt"));

            int i;
            while((i=bufferedInputStream.read())!=-1){
                System.out.print((char)i);
            }
            System.out.println( "\n"+bufferedInputStream.markSupported());
            bufferedInputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
