package main.java.thread.example.application.philosper.eating;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
    private Integer id;
    private Lock lock;

    public ChopStick(Integer id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    /**
     * always use try lock rater then lock ,
     * @param philosoper
     * @param stick
     * @return
     */
    public boolean pickUp(Philosoper philosoper, Stick stick) {

        try {
            if(this.lock.tryLock(2, TimeUnit.SECONDS))
            {
                System.out.println();
                return true;
            }

        } catch (Exception interruptedException) {
            interruptedException.printStackTrace();
        }
        return false;
    }

    public void putDown(Philosoper philosoper, Stick stick)
    {
        this.lock.unlock();
        System.out.println(" <-philosoper put down chopStick , id:"+philosoper.getId()+" stick "+stick.name()+this);
    }

    @Override
    public String toString() {
        return "ChopStick{" +
                "id=" + id +
                '}';
    }
}
