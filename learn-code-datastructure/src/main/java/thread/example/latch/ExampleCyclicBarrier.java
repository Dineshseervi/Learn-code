package main.java.thread.example.latch;

/**
 * Cyclic barrier is just like latch with some extra feature and bulk
 * we can pass  Runnable to CyclicBarrier constructor , so at time of start it self we can define task to do post
 * also we can put cyclicBarrier.await()  in each thread where lines after await will be executed post latch count is completed
 */
public class ExampleCyclicBarrier {
}
