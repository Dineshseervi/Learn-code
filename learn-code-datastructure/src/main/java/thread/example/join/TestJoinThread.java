package main.java.thread.example.join;

public class TestJoinThread {
    public static void main(String[] args) {
        Object lock=new Object();
        WorkerThread workerThreadA=new WorkerThread("A",2000,lock);
        WorkerThread workerThreadB=new WorkerThread("B",3000,lock);
        WorkerThread workerThreadC=new WorkerThread("C",1000,lock);
        WorkerThread [] arr={workerThreadA,workerThreadB,workerThreadC};

        for (int i=0;i<3;i++)
        {
            Thread t=new Thread(arr[i]);
            t.start();
            try {
                t.join();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
