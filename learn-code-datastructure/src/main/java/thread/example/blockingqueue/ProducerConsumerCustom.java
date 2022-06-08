package main.java.thread.example.blockingqueue;

import java.util.concurrent.TimeUnit;

public class ProducerConsumerCustom {
    public static volatile  boolean producerEnd=false;
    public static void main(String[] args) {

        CustomBlockingQueue customBlockingQueue=new CustomBlockingQueue();
        Producer producer=new Producer(customBlockingQueue);
        Consumer consumer=new Consumer(customBlockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Producer implements Runnable{

    private  CustomBlockingQueue queue;

    public Producer(CustomBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i=0 ;i<10;i++) {
            try {
                System.out.println("Producer sleep start i="+i);
                Thread.sleep(1000);
                System.out.println("Producer sleep end i="+i);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            queue.add(i);

        }
    }
}


class Consumer implements Runnable{

    private  CustomBlockingQueue queue;


    public Consumer(CustomBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true)
        {
            System.out.println("Consumer get start");
            Integer val=queue.get();
            System.out.println("Consumer get complete val:"+val);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}