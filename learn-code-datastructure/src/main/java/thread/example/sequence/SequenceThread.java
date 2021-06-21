package main.java.thread.example.sequence;

public class SequenceThread {


    public static void main(String[] args) {
        Thread threadA=new Thread(new SequenceWorkerThread(1),"T1");
        Thread threadB=new Thread(new SequenceWorkerThread(2),"T2");
        Thread threadC=new Thread(new SequenceWorkerThread(3),"T3");

        threadC.start();
        threadA.start();
        threadB.start();
    }
}
