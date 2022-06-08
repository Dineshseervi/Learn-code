package main.java.thread.example.application.philosper.eating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleMain {
    public static void main(String[] args) throws InterruptedException {

        ChopStick [] chopSticks =new ChopStick[PhilosoperChopStickConstants.MAX_CHOP_STICK];
        for (int i=0;i<chopSticks.length;i++)
        {
            chopSticks[i]=new ChopStick(i);
        }
        Philosoper []  philosopers=new Philosoper[PhilosoperChopStickConstants.MAX_PHILOSOPER];
        for(int i=0;i<philosopers.length;i++)
        {
            philosopers[i]=new Philosoper(i,chopSticks[i],chopSticks[(i+1)%chopSticks.length]);
        }

        ExecutorService executorService= Executors.newFixedThreadPool(philosopers.length);
        for(int i=0;i<philosopers.length;i++)
        {
            executorService.execute(philosopers[i]);

        }
        try {
            Thread.sleep(PhilosoperChopStickConstants.MAX_SUSPENSION_TIME* 1000);
            System.out.println("loop set philosopers full-----------");
            for(int i=0;i<philosopers.length;i++)
            {
                philosopers[i].setFull(true);

            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }finally {
            executorService.shutdown();
            while (!executorService.isTerminated())
            {
                Thread.sleep(1000);
            }
        }





        System.out.println("philosopers eat status-----------");
        for(int i=0;i<philosopers.length;i++)
        {
            philosopers[i].eatCount();

        }
    }
}
