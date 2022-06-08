package main.java.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor {
    private BlockingQueue<Runnable> queue;
    private Thread [] workerThread;
    private volatile boolean  isStooped;


    public CustomThreadPoolExecutor(int numberOfThreadPool)
    {
        queue=new LinkedBlockingQueue<>();
        workerThread=new Thread[numberOfThreadPool];
        int i=0;
        for (Thread t:workerThread)
        {
            t=new Worker("Custom pool "+i++);
            t.start();
        }
    }

    public void execute(Runnable task)
    {
        try {
            if(!isStooped) {
                queue.put(task);
            }else {
                System.out.println("No more task can be executed");
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void shutdown()
    {
        this.isStooped=true;
        System.out.println("shutdow requested");
    }

    private class Worker extends Thread{

        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true && (!isStooped || queue.size()!=0))
            {
                try {
                    queue.take().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
