package main.java.thread.example.notify;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerLearn {
    private List<Integer> list = new ArrayList<>();
    private static final Integer UPPER_LIMIT = 5;
    private static final Integer LOWER_LIMIT = 0;
    private Integer value = 0;
    private Object lock = new Object();

    private void producer() throws InterruptedException {
        synchronized (lock) {
            while (true) {

                if (list.size() == UPPER_LIMIT) {
                    System.out.println("max limit is reached");
                    lock.wait();
                    value = LOWER_LIMIT;

                } else {
                    System.out.println("adding value:" + value);
                    list.add(value);
                    value++;
                    Thread.sleep(500);
                    lock.notify();
                }
            }
        }
    }

    private void consumer() throws InterruptedException {
        synchronized (lock) {
            while (true) {

                if (list.size() == LOWER_LIMIT) {
                    System.out.println("lower limit is reached");
                    lock.wait();
                    //value=LOWER_LIMIT;

                } else {
                    System.out.println("remvoed the value:" + list.remove(list.size() - 1));
                    Thread.sleep(500);
                    lock.notify();
                   // System.out.println("notify");
                }
                System.out.println("outside");
                Thread.sleep(500);
            }


        }
    }

    public static void main(String[] args) {
        ProducerConsumerLearn producerConsumerLearn = new ProducerConsumerLearn();
        Thread produceThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumerLearn.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumerLearn.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        produceThread.start();
        consumeThread.start();
    }
}
