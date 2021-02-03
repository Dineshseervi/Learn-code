package main.java.thread.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private Semaphore  semaphore=new Semaphore(4,true);

    private void downloadData() {

        try {
            semaphore.acquire();
            download();
        }
        catch (InterruptedException interruptedException)
        {
            System.out.println("error"+interruptedException.getMessage());
        }
            finally
        {
            semaphore.release();
        }
    }

    private void download() throws InterruptedException {
        System.out.println("download Data from web and sending ...");
        Thread.sleep(9000);
    }


    public static void main(String[] args) {
        SemaphoreExample semaphoreExample=new SemaphoreExample();
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<12;i++)
        {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    semaphoreExample.downloadData();
                }
            });
        }
    }
}
