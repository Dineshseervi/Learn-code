package main.java.thread.example.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LearnLockExample {

    private static Integer counter=0;
    private static Lock lock=new ReentrantLock();



    private static void increment()
    {

        lock.lock();
        try {
            for (int i=0;i<10000;i++)
            {
                counter++;
                // System.out.println("--");
            }
        }
        finally {
            lock.unlock();
        }


    }
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread threadTwo=new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
        System.out.println("value :"+LearnLockExample.counter);
    }
}
