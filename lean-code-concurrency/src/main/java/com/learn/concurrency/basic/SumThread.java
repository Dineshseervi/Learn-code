package com.learn.concurrency.basic;

import java.util.Random;

public class SumThread {


    long startRange;
    long endRange;
    long counter;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumThread(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
        counter=startRange;
    }

    public void add()
    {
        for(long i=startRange;i<=endRange;i++)
        {
            counter++;
        }
    }

    public long getCounter()
    {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {

            SumThread sumThread=new SumThread(1,MAX_NUM/2);
            Thread thread=new Thread(()->{sumThread.add();});
            thread.start();
            thread.join();
        System.out.println(sumThread.counter);

    }
}
