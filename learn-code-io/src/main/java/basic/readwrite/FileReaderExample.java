package main.java.basic.readwrite;

import java.io.*;

public class FileReaderExample implements InputOutputOperations
{

    @Override
    public void write() {

    }

    @Override
    public void read() {
        try {
            FileReader fileReader=new FileReader("text2.txt");
            int i;
            while ((i=fileReader.read())!=-1)
            {
                System.out.print((char)i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readWrite()
    {
        char [] filechar=null;
        try {
            File file=new File("image1.jpg");
            FileReader fileReader=new FileReader(file);
            filechar=new char[(int)(file.length())];
            int i;
            fileReader.read(filechar);
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileWriter fileWriter=new FileWriter("image3_create.jpg");
            fileWriter.write(filechar);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FileReaderExample fileReaderExample=new FileReaderExample();
        fileReaderExample.readWrite();
    }
}
