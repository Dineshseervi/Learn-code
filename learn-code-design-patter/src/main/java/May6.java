package main.java;

import java.util.Date;

public class May6 {
    private static class Node {
        int data;
        Node next;

        public Node(int val) {
            data = val;
            next = null;
        }

    }

    // 5->8->9->12->4->null
    public static void main(String[] args) {
        Node node5 = new Node(4);
        Node node4 = new Node(12);
        node4.next = node5;
        Node node3 = new Node(9);
        node3.next = node4;
        Node node2 = new Node(8);
        node2.next = node3;

        Node node = new Node(5);
        node.next = node2;
        May6 may6 = new May6();
        Node sortedNode = may6.mergesort(node);
        while (sortedNode != null) {
            System.out.println("val" + sortedNode.data);
            sortedNode = sortedNode.next;
        }

        System.out.println(new Date());

    }


    private Node mergesort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node middle = getMiddle(node);
        Node secondHalf = middle.next;
        middle.next = null;

        Node nodeA = mergesort(node);
        Node nodeB = mergesort(secondHalf);
        return mergeLinkList(nodeA, nodeB);
    }

    private Node getMiddle(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }


    //to get frist half

//
// 5->8->9->12->4->null

    // 5->8->9   //12-4
    //5->8 //9   // 12- 4
    //5-8->9        // 4-12
    // 4->5->8-9-12
    private Node mergeLinkList(Node nodeA, Node nodeB) {
        if (nodeA == null) {
            return nodeB;
        }
        if (nodeB == null) {
            return nodeA;
        }
        if (nodeA.data < nodeB.data) {
            nodeA.next = mergeLinkList(nodeA.next, nodeB);
            return nodeA;
        } else {
            nodeB.next = mergeLinkList(nodeA, nodeB.next);
            return nodeB;
        }

    }
    //get the middle
    //get two linkList
    //sort the linkList


}


