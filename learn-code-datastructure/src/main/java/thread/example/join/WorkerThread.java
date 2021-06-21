package main.java.thread.example.join;

import java.util.concurrent.locks.Lock;

public class WorkerThread  implements Runnable{

    public WorkerThread( String name, long sleepTime,Object lockObject) {
        this.lockObject = lockObject;
        this.name = name;
        this.sleepTime = sleepTime;
    }

    private Object lockObject;

    public String name;
    public long sleepTime=2000;


    public WorkerThread(String name) {
        this.name = name;
    }

    public WorkerThread(String name, long sleepTime) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        while (true)
        {
            synchronized (lockObject) {
                lockObject.notify();
                System.out.println(Thread.currentThread().getName() + ", name:" + name);
                try {

                    lockObject.wait();
                    Thread.sleep(2000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }
}
