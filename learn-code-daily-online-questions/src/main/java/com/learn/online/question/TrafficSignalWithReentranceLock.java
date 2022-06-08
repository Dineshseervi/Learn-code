package com.learn.online.question;

import java.util.concurrent.locks.ReentrantLock;

public class TrafficSignalWithReentranceLock implements Runnable{

    public enum Signal
    {
        GREEN,ORANGE,RED;
    }


    private static volatile Signal previous= Signal.ORANGE;
    private Signal signal;
    private static ReentrantLock lock=new ReentrantLock();

    public TrafficSignalWithReentranceLock(Signal signal)
    {
        this.signal=signal;

    }


    public void  display() throws InterruptedException {
        synchronized (lock) {
            switch (signal) {
                case RED:
                    if (previous != Signal.ORANGE) {
                        lock.wait();
                    }
                    break;
                case GREEN:
                    if (previous != Signal.RED) {
                        lock.wait();
                    }
                    break;
                case ORANGE:
                    if (previous != Signal.GREEN) {
                        lock.wait();
                    }
                    break;
            }
            System.out.println("Colour : " + this.signal);
            Thread.sleep(5000);
            previous = signal;
            lock.notify();
        }
    }

    public void run()
    {
        try {
            while (true)
            display();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new TrafficSignalWithReentranceLock(Signal.GREEN)).start();
        new Thread(new TrafficSignalWithReentranceLock(Signal.RED)).start();
        new Thread(new TrafficSignalWithReentranceLock(Signal.ORANGE)).start();
    }
}
