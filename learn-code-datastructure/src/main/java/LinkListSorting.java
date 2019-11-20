package main.java;

public class LinkListSorting {

    static class Node {
        public int val;
        public Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node sortNodes(Node leftNode, Node rightNode) {
        Node node = null;

        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }

        if (leftNode.val <= rightNode.val) {
            node = leftNode;
            node.next = sortNodes(leftNode.next, rightNode);
        } else {
            node = rightNode;
            node.next = sortNodes(leftNode, rightNode.next);
        }

        return node;
    }


    public Node mergeSort(Node node) {

        if (node == null || node.next == null) {
            return node;
        }
        Node defualtNode = node;
        Node firstHalf = middleNode(node);
        Node secondHalf = firstHalf.next;
        firstHalf.next = null;

        Node leftNode = mergeSort(defualtNode);
        Node rightNode = mergeSort(secondHalf);


        return sortNodes(leftNode, rightNode);
    }

    public Node middleNode(Node node) {
        if (node == null && node.next == null) {
            return node;
        }
        Node slow = node;
        Node fast = node;


        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkListSorting linkListSorting = new LinkListSorting();
        Node node1 = new Node(34);
        Node node2 = new Node(20);
        Node node3 = new Node(12);
        Node node4 = new Node(4);
        Node node5 = new Node(50);
        Node node6 = new Node(10);
        Node node7 = new Node(15);
        Node node8 = new Node(8);
        Node node9 = new Node(19);

        node9.next = null;
        node8.next = node9;
        node7.next = node8;
        node6.next = node7;
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        Node sortedNode = linkListSorting.mergeSort(node1);
        while (sortedNode != null) {
            System.out.println("node value " + sortedNode.val);
            sortedNode = sortedNode.next;
        }


    }

}
