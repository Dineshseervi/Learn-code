package main.java;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartProcess {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*Process process =Runtime.getRuntime().exec("/Users/dineshseervi/Desktop/wavemaker-setup/server/shortcuts/unix/t1start.sh");
        process.getInputStream();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line + "\n");
        }

        int exitVal = process.waitFor();
        if (exitVal == 0) {
            System.out.println("Success!");
            System.out.println(exitVal);
            System.exit(0);
        } else {
            //abnormal...
            System.out.println("skipped");
        }
*/
       // System.out.println("Enter value");
        String val = System.console().readLine();
        System.out.println("val is :"+val);
    }
}
