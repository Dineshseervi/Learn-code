package main.java.thread.example.application.philosper.eating;

import java.util.Random;

public class Philosoper  implements Runnable{
    private Integer id;
    private Random random;
    private ChopStick leftChopStick;
    private ChopStick rightChopStick;
    private Integer count=0;
    private volatile boolean full;

    public Philosoper(Integer id,ChopStick leftChopStick,ChopStick rightChopStick)
    {
        this.id=id;
        this.leftChopStick=leftChopStick;
        this.rightChopStick=rightChopStick;
        this.random=new Random();
    }

    public Integer getId() {
        return id;
    }

    public void think() throws InterruptedException {
        System.out.println("Philosoper is thinking :"+this);
        Thread.sleep(random.nextInt(400));
    }

    public void eat() throws InterruptedException {
        System.out.println("(*)(*) Philosoper is eating :"+this);
        Thread.sleep(random.nextInt(900));
        count++;

    }

    public void setFull(boolean full) {
        this.full = full;
    }

    @Override
    public void run() {


        while (!full) {
            try {
                think();

                if(!full && leftChopStick.pickUp(this,Stick.LEFT))
                {
                    System.out.println(this+"pick  "+Stick.LEFT.name());
                    if(rightChopStick.pickUp(this,Stick.RIGHT))
                    {
                        System.out.println(this+"pick"+Stick.RIGHT.name());
                        eat();
                        rightChopStick.putDown(this,Stick.RIGHT);
                        System.out.println(this+"put down"+Stick.RIGHT.name());
                    }
                    leftChopStick.putDown(this,Stick.LEFT);
                    System.out.println(this+"put down "+Stick.LEFT.name());
                }

            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            /* if(leftChopStick.pickUp(this,Stick.LEFT))
        {
            if(rightChopStick.pickUp(this,Stick.RIGHT))
            {
                Thread.sleep("");
            }

        }*/
        }
    }

    @Override
    public String toString() {
        return "Philosoper{" +
                "id=" + id +
                '}';
    }

    public void eatCount()
    {
        System.out.println( "Philosoper{" +
                "id=" + id +
                "count="+count+
                '}');
    }
}
