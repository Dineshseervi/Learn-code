package main.java.exam;

public class ThreadExample {

    public static volatile Object lock=new Object();

    public static void main(String[] args) {
        Thread producerThread=new Thread(new Producer());
        Thread consumerThread=new Thread(new Consumer());
        producerThread.start();
        consumerThread.start();
        try {
           Class classProducer=  Class.forName("main.java.exam.Producer");
            System.out.println(classProducer.getName());
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }


}



class Producer implements Runnable
{
    public void run()
    {
        while (true) {
            synchronized (ThreadExample.lock) {

                System.out.println("producer");
                ThreadExample.lock.notifyAll();
                System.out.println("producer after");
                try {
                    ThreadExample.lock.wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }

            }
            try {
                Thread.sleep(10);
            }catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable
{
    public void run()
    {
        while (true) {
            synchronized (ThreadExample.lock) {

                System.out.println("consumer");
                ThreadExample.lock.notifyAll();
                System.out.println("consumer after");
                try {
                    ThreadExample.lock.wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

                try {
                    Thread.sleep(3000);
                }catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }
            try {
                Thread.sleep(10);
            }catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}
