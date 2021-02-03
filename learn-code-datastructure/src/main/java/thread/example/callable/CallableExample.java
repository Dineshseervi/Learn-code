package main.java.thread.example.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample implements Callable<Integer> {

    private  Integer id;

    public CallableExample(Integer id) {
        this.id=id;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(9000);
        return id;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ExecutorService executorService= Executors.newFixedThreadPool(2);
        List<Future<Integer>> futures=new ArrayList<>();
        for(int i=0;i<=10;i++) {
            Future<Integer> future=  executorService.submit(new CallableExample(i));
            futures.add(future);
        }
        System.out.println("first loop is over----------------");

        for (Future<Integer> future:futures)
        {
            System.out.println(future.get());
        }
        System.out.println("second loop is over----------------");
        executorService.shutdown();*/
        System.out.println("start");
        boolean val=true;
        while (val)
        {

        }
        System.out.println("complete");
    }


}
