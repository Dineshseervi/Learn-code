package main.java.linklist;

import java.util.LinkedList;

/**
 * 10->23->11->19->9->5->15
 * <p>
 * mid
 * 10->23->11-   >19->9->5->15
 * 10->23-       19->9-
 * <p>
 * <p>
 * --
 * how i will return first
 * if node length is 1 or null return node.
 * <p>
 * node a and node b of size 1
 * <p>
 * --
 * get first half node and second half node ,how to do that?
 * Node middle=getMiddleOfLinkList(Node node)
 * Node nextOfMiddle=middle.next;
 * middle.next=null;
 * <p>
 * --
 * so end of method will have sorting logic
 * if a <b
 * a.next =mergeLinkList(a.next,b)
 * reurn a;
 * or
 * b.next=mergeLinkList(a,b.next)
 * return b;
 * <p>
 * nodeA->
 */
public class MergeSortLinkList {

    private Node linkList=null;

        public Node mergeLinkList(Node nodeA, Node nodeB) {
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

    public Node sortLinkList(Node linkList) {

        if (linkList == null || linkList.next == null) {
            return linkList;
        }
        Node middleNode = getMiddleOfLinkList(linkList);
        Node nextOfMiddleNode = middleNode.next;
        middleNode.next = null; //doing this our linklist will become half
        Node nodeA = sortLinkList(linkList);
        Node nodeB = sortLinkList(nextOfMiddleNode);
        return mergeLinkList(nodeA, nodeB);
    }

    /**
     * 1-2-3-4-5-6-7
     * s=1,2,3
     * f=3,5,7,null-next-off-7
     *
     * @param linkList
     * @return
     */
    public Node getMiddleOfLinkList(Node linkList) {
        if (linkList == null) {
            return linkList;
        }

        Node slow = linkList;  // move 1 next
        Node fast = linkList;  //move 2 next
        while (fast != null && fast.next != null && fast.next.next != null) {
            System.out.println("getMiddleOfLinkList");
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    void push(int new_data)
    {
        System.out.println("...."+new_data);
        /* allocate node */
        Node new_node = new Node(new_data);

        /* link the old list off the new node */
        new_node.next = linkList;   //The list shall be a: 2->3->20->5->10->15
        //15->null
        //linklist= 15 //10->15

        /* move the head to point to the new node */
        linkList = new_node;
    }

    public void printList(Node linkedList)
    {
        Node node=linkedList;
        while(node!=null)
        {
            System.out.print("-"+node.data);
            node=node.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        MergeSortLinkList li = new MergeSortLinkList();
        /*
         * Let us create a unsorted linked list to test the functions
         * created. The list shall be a: 2->3->20->5->10->15
         */
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);

        /*li.linkList =new Node(15);
        li.linkList.next=new Node(10);
        li.linkList.next.next=new Node(5);
        li.linkList.next.next.next=new Node(20);
        li.linkList.next.next.next.next=new Node(3);
        li.linkList.next.next.next.next.next=new Node(2);*/
        // Apply merge Sort
        System.out.print("\n before sorting Linked List is: \n");
        li.printList(li.linkList);
        li.linkList = li.sortLinkList(li.linkList);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.linkList);
    }
}
