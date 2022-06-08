package main.java.thread.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private Semaphore  semaphore=new Semaphore(2,true);

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
        System.out.println("download Data from web and sending ..."+Thread.currentThread().getName());
        Thread.sleep(9000);
    }


    public static void main(String[] args) {
        //System.out.println("int min : "+Integer.MIN_VALUE);
        SemaphoreExample semaphoreExample=new SemaphoreExample();
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for(int i=0;i<12;i++)
        {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    semaphoreExample.downloadData();
                }
            });
        }
        executorService.shutdown();
    }
}
