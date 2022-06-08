package main.java.thread.example.notify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenNumber implements Runnable {

    public static volatile int MAX_COUNT=20;
    public static volatile int cout = 0;
    public static Object lock = new Object();
    private Integer theadT;

    public OddEvenNumber(Integer theadT) {
        this.theadT = theadT;
    }

    @Override
    public void run() {
        while (cout<=MAX_COUNT) {
            synchronized (lock) {
                if (cout % 2 == theadT) {
                    System.out.println("val :" + cout + " threadT =" + theadT);
                    cout++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        OddEvenNumber evenNumber=new OddEvenNumber(0);
        OddEvenNumber oddNumber=new OddEvenNumber(1);
        new Thread(evenNumber).start();
        new Thread(oddNumber).start();
    }
}
