package main.java.thread.example.executer;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);

        for (int i=0;i<=20;i++)
        {
            executorService.execute(new WorkerExample(i));

        }

        //executorService.
        try {
            Thread.sleep(9000);
            System.out.println("------------submitted------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("------------over------");
    }
}
