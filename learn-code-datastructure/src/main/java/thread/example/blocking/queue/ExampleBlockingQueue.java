package main.java.thread.example.blocking.queue;

import java.util.Random;
import java.util.concurrent.*;

public class ExampleBlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(5);
        Producer producer = new Producer(blockingQueue);
        producer.start();
        new Consumer(blockingQueue).start();
        System.out.println("status: "+producer.status());
        Thread.sleep(29000);
        System.out.println("status: "+producer.status());


    }
}

class Producer implements Runnable
{
    Thread thread;


    public void start()
    {
        thread=new Thread(this);
        thread.start();
    }

    public boolean status()
    {
        return thread.isAlive();
    }
    Random random=new Random();
    private BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int count =0;
        while (count<11)
        {
            try {
                count++;
                blockingQueue.put(random.nextInt(400));

                System.out.println("size: "+blockingQueue.size());
                System.out.println("added value");
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable
{

    Thread thread;
    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void start()
    {
        thread=new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            int count =0;
            while (count<11) {
                count++;
                Integer value = blockingQueue.take();
                System.out.println(" consume value: " + value);
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}