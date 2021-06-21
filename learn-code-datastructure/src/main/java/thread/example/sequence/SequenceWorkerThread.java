package main.java.thread.example.sequence;

public class SequenceWorkerThread implements Runnable {
    private static volatile Integer threadTdToRun=1;
    private static Object objectLock=new Object();
    private Integer threadId=0;


    public SequenceWorkerThread(Integer threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {

        while (true)
        {
            synchronized (objectLock)
            {
                if(!(this.threadId==threadTdToRun))
                {
                    try {
                        System.out.println("----thread status:"+ Thread.currentThread().getName());
                        objectLock.wait(1000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                else {
                    System.out.println("T:"+threadId  +"             ---"+Thread.currentThread().getName());
                    if(threadId<3)
                    {
                        threadTdToRun=threadId+1;
                    }else{
                        threadTdToRun=1;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    System.out.println("notify---");
                    objectLock.notifyAll();
                }

            }
        }
    }
}
