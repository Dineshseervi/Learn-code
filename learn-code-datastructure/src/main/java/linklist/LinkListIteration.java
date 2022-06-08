package main.java.linklist;

public class LinkListIteration {

    // 5-4-3-2-0- 8-7-1->null
    //         9-26-7-1->null


    //tempA-> 5-4- 3-2- 0-8-7-1->9-26-7-1->null
    //TempB-> 9-26-7-1->5-4-3-2- 0- 8-7-1->null


    // 5-4-3-2-0- 8-20-21->null
    //         9-26-7 -1->null

    //tempA-> 5-4- 3- 2- 0-8-20-21->9- 26-7 -1->null
    //TempB-> 9-26-7 -1->5-4- 3- 2- 0- 8- 20-21->null
   // =====

    //   4-1-8-4-5->null
    // 5-6-1-8-4-5->null

    //tempA-> 4-1-8-4-5->null->5    ->6-1-8-4-5->null
    //TempB-> 5-6-1-8-4- 5   ->null-> 4-1-8-4-5->null

    public static Node getIntersectionNode(Node headA, Node headB) {

        Node tempA= headA;
        Node tempB= headB;

        while(tempA!=tempB)
        {
            tempA=tempA!=null ?tempA.next:headB;
            tempB=tempB!=null ?tempB.next:headA;
        }

        return tempA;
    }

    public static void main(String[] args) {
        Node node8=new Node(8);
        Node node1=new Node(1);

        Node nodeA=new Node(4);
        nodeA.next=node1;
        nodeA.next.next=node8;
        nodeA.next.next.next=new Node(4);
        nodeA.next.next.next.next=new Node(5);


        Node nodeB=new Node(5);
        nodeB.next=new Node(6);
        nodeB.next.next=new Node(1);
        nodeB.next.next.next=node8;
        nodeB.next.next.next.next=new Node(4);
        nodeB.next.next.next.next.next=new Node(5);

        Node result=getIntersectionNode(nodeA,nodeB);
        System.out.println("result:"+result.data);

    }
}
