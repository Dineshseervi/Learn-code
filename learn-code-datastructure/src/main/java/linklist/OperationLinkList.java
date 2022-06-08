package main.java.linklist;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class OperationLinkList {
    public static void main(String[] args) {
        Deque<Integer> list=new LinkedList<>();
        //list.add();
        list.push(3);
        list.push(4);
        list.push(5);

        list.removeLast();

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
