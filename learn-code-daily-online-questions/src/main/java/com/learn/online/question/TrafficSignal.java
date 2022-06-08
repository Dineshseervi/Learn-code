package com.learn.online.question;

public class TrafficSignal  implements Runnable{

    public enum Signal
    {
        GREEN,ORANGE,RED;
    }


    private static volatile Signal previous=Signal.ORANGE;
    private Signal signal;
    private static Object lock=new Object();

    public TrafficSignal(Signal signal)
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
        new Thread(new TrafficSignal(Signal.GREEN)).start();
        new Thread(new TrafficSignal(Signal.RED)).start();
        new Thread(new TrafficSignal(Signal.ORANGE)).start();
    }
}
