package main.java.process;

import java.io.IOException;
import java.io.InputStream;

public class LearnProcess {

    public static void main(String[] args) throws IOException {
        String homeDirectory = System.getProperty("user.home");
        System.out.println("homeDirectory:"+homeDirectory);
        Process process=Runtime.getRuntime()
                .exec(String.format("sh -c ls %s", homeDirectory));

        InputStream inputStream=process.getInputStream();
        int i=0;
        while ((i=inputStream.read())>-1)
        {
            System.out.print((char) i);
        }
    }
}
