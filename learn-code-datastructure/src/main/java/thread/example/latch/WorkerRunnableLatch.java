package main.java.thread.example.latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class WorkerRunnableLatch implements Runnable{

    private Integer id;
    private CountDownLatch countDownLatch;
    private Random random=new Random();

    public WorkerRunnableLatch(Integer id ,CountDownLatch countDownLatch)
    {
        this.countDownLatch=countDownLatch;
        this.id=id;
    }

    @Override
    public void run() {
        try {

            Thread.sleep(random.nextInt(9000));
            System.out.println("task "+id+" ,is completed");

        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }
}
