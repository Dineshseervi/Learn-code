package main.java.thread.example.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * count down latch will come handy when at end task require few other task result or to be completed .
 * Like stock market .
 * search result
 * Or let say cloud application come up require prerequisite as database ,cache service and s3 bucket to be present
 */
public class CountDownApp {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        Integer task=6;
        CountDownLatch countDownLatch=new CountDownLatch(task);
        for(int i=1;i<=task;i++)
        {
            executorService.execute(new WorkerRunnableLatch(i,countDownLatch));
        }
        executorService.shutdown();
        System.out.println("post loop waiting");
        countDownLatch.await();
        System.out.println("All task are completed");



    }
}
