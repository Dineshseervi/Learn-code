package main.java.thread.example.blockingqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CustomBlockingQueue {

    private Queue<Integer> queue = new ArrayDeque<>();
    private Object getLock = new Object();
    private Object setLock = new Object();

    private int MAX_LIMIT = 5;

    public Integer get() {
        synchronized (getLock) {
            /*while (queue.size() <= 0) {
                try {
                    Thread.sleep(7000);
                    System.out.println("--waiting--");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }*/
            if(queue.size() <= 0)
            {
                try {
                    getLock.wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }else {
                getLock.notifyAll();
            }
        }
        return queue.poll();
    }

    public void add(Integer val) {
        synchronized (getLock) {
            /*while (queue.size() >= MAX_LIMIT) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }*/
            if(queue.size() >= MAX_LIMIT)
            {
                try {
                    getLock.wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }else {
                getLock.notifyAll();
            }

        }
        queue.add(val);
    }

    public int size()
    {
        return queue.size();
    }

}


