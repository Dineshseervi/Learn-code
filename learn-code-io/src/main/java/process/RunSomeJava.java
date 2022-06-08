package main.java.process;

import java.io.IOException;

public class RunSomeJava {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process pro = Runtime.getRuntime().exec("javac -cp /Users/dineshseervi/Desktop/Doc/workDoc/learn-code/learn-code-io/src/main/java/process/LearnProcess.java");

        Process pro2 = Runtime.getRuntime().exec("java -cp /Users/dineshseervi/Desktop/Doc/workDoc/learn-code/learn-code-io/src/main/java/process/LearnProcess");

        pro2.waitFor();
        System.out.println(  " exitValue() " + pro2.exitValue());
        System.out.println("end");
    }

}
