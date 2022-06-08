package main.java.CollectionsExample.set.example;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * How does TreeSet work Internally?
 *
 * TreeSet is basically an implementation of a self-balancing binary search tree like a Red-Black Tree.
 * Therefore operations like add, remove, and search take O(log(N)) time.
 * The reason is that in a self-balancing tree, it is made sure that the height of the
 * tree is always O(log(N)) for all the operations.
 * Therefore, this is considered as one of the most efficient data structure in order
 * to store the huge sorted data and perform operations on it.
 * However, operations like printing N elements in the sorted order takes O(N) time.
 */
public class ExampleTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet=new TreeSet<>();
        treeSet.add(11);
        treeSet.add(17);
        treeSet.add(7);
        treeSet.add(13);
        treeSet.add(6);
        treeSet.add(-1);
        treeSet.add(10);
        treeSet.add(4);
        treeSet.add(3);
        treeSet.add(-3);
        treeSet.add(3);

        for (Integer val:treeSet)
        {
            System.out.print(" -> "+val);
        }


        System.out.println("");
     Iterator iterator= treeSet.iterator();
        while (iterator.hasNext())
        {
          int val= (Integer) iterator.next();
            System.out.print(" -> "+val);
        }

    }
}
