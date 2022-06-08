package main.java.thread.example.notify;

import java.util.concurrent.Semaphore;

public class ProcessWaitNotify {

    private Semaphore semaphore=new Semaphore(1,true);
    public String value;
    public void produce() throws InterruptedException {
        semaphore.acquire();
        synchronized (this)
        {
            System.out.println("produce Before wait() ");
            for (int i=0;i<3;i++)
            {
                //notify();
                System.out.println("  -"+i+" : loop produce : " +Thread.currentThread().getName());
                wait();
                //Thread.sleep(9000);
            }
            System.out.println("produce after wait()....");
            //notifyAll();
        }
        semaphore.release();
    }

    public void consume()
    {
        try {
        Thread.sleep(10000);
        synchronized(this)
        {
            System.out.println("before notify consume .... ");
            for (int i=0;i<3;i++)
            {
                notify();
                System.out.println("loop consume");
                wait();
            }
            System.out.println("after notify consume ....");
            notifyAll();
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consumer2()
    {
        try {
            for(int i =0;i<9;i++) {
                Thread.sleep(5000);
                synchronized (this) {
                    System.out.println("i will free you ");
                    notify();
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProcessWaitNotify processWaitNotify=new ProcessWaitNotify();
        processWaitNotify.value="value1";
        Thread produceThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processWaitNotify.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumeThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processWaitNotify.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumeThread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processWaitNotify.consumer2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        produceThread.start();
        consumeThread.start();
        consumeThread2.start();
        String localVal=processWaitNotify.value;
        processWaitNotify.value=null;
        System.out.println("localVal:"+localVal);
        System.out.println("value:"+processWaitNotify.value);

    }
}
