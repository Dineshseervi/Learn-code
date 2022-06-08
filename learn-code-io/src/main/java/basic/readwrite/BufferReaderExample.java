package main.java.basic.readwrite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderExample  implements InputOutputOperations{
    @Override
    public void write() {

    }

    @Override
    public void read() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("text2.txt"));
            String vale;

            while( (vale=bufferedReader.readLine())!=null)
            {
                System.out.println(vale);
            }
        }
        catch (FileNotFoundException fileNoteFoundException)
        {
            fileNoteFoundException.printStackTrace();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }
}
