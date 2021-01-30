package main.java.linklist;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
