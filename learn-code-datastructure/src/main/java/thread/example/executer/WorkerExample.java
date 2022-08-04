package main.java.thread.example.executer;

/**
 * nice
 */
public class WorkerExample implements Runnable{

    private Integer id;
    public WorkerExample(Integer id) {
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("Task ID : " + this.id +" performed by "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
            System.out.println("Tash got completed : ID:"+this.id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
