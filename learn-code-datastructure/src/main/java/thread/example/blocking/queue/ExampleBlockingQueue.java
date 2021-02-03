package main.java.thread.example.blocking.queue;

import java.util.Random;
import java.util.concurrent.*;

public class ExampleBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(5);
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new Producer(blockingQueue));
        executorService.execute(new Consumer(blockingQueue));
        executorService.shutdown();
    }
}

class Producer implements Runnable
{

    Random random=new Random();
    private BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                blockingQueue.put(random.nextInt());
                System.out.println("added value");
                Thread.sleep(4000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable
{

    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer value = blockingQueue.take();
                System.out.println(" consume value: " + value);
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}