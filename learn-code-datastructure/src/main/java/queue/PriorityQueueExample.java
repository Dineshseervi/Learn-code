package main.java.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

import java.util.PriorityQueue;
public class PriorityQueueExample {

    public static void main (String[] args) {
        // Creating a Priority Queue of String Type
        PriorityQueue<String> pQueue = new PriorityQueue<String>(11) ;
        // Adding the items to a Priority Queue (ENQUEUE) using add()
        pQueue.add("Don Quixote") ;
        pQueue.add("The Master and Margarita") ;
        pQueue.add("The Hobbit") ;
        pQueue.add("Dream of the Red Chamber") ;
        pQueue.add("A Tale of Two Cities7") ;
        pQueue.add("And Then There Were None8") ;
        pQueue.add("A Tale of Two Cities6") ;
        pQueue.add("And Then There Were None7") ;
        pQueue.add("A Tale of Two Cities5") ;
        pQueue.add("And Then There Were None5") ;
        pQueue.add("A Tale of Two Cities4") ;
        pQueue.add("And Then There Were None4") ;
        pQueue.add("A Tale of Two Cities3") ;
        pQueue.add("And Then There Were None3") ;
        pQueue.add("A Tale of Two Cities2") ;
        pQueue.add("And Then There Were None2") ;


        // Removing and printing items from the Priority Queue (DEQUEUE) using remove()
        while (!pQueue.isEmpty()) {
            System.out.println(pQueue.remove()) ;
        }

    }
}
