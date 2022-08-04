package main.java.thread.example.custompool;

public class TestCustomThreadPool {
    public static void main(String[] args) {
        CustomThreadPoolExecutor customThreadPoolExecutor=new CustomThreadPoolExecutor(5);
        int i=0;
        for (i=0;i<50;i++)
        {
            customThreadPoolExecutor.execute(new Runnable() {
               // int k=i;
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("performed by: "+Thread.currentThread().getName());
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            });
        }
        customThreadPoolExecutor.shutdown();
    }
}
