package main.java.linklist;

public class FindMiddleOfLinkList {

    Node head;

    public void addNode(Integer data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    /**
     * 85->15->4->20->null
     * 20->4->15->85->null
     * to do this we are next and previous always and current to move forward which will hold node.
     *
     * @return
     */
    public Node reverseNode(Node node) {

        Node previous = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        node = previous;

        return node;

    }

    public void searchTerm(Integer searchNumber) {
        Node pointer = head;
        if (pointer != null) {
            while (pointer != null) {
                if (pointer.data == searchNumber) {
                    System.out.println("number found");
                    break;
                } else {
                    pointer = pointer.next;
                }

            }
        }
    }

    public Node getMiddleNode() {
        Node slowNode = head;
        Node fastNode = head;
        if (head != null) {
            while (fastNode.next != null && fastNode.next.next != null) {
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
            }
            System.out.println("middle node data: " + slowNode.data);
            return slowNode;
        }
        return null; //if middle node not found
    }


    public Node getMiddleNodeForProvidedNode(Node start, Node end) {
        Node slowNode = start;
        Node fastNode = start;
        if (head != null) {
            while (fastNode.next != end && fastNode.next.next != end) {
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
            }
            System.out.println("middle node data: " + slowNode.data);
            return slowNode;
        }
        return null; //if middle node not found
    }

    public Boolean searchDataUsignBinarySearch(int value) {
        Node startNode = head;
        Node endNode = null;
        while (endNode == null || endNode != startNode) {
            if (startNode.data == value) {
                return true;
            }
            Node middle = getMiddleNodeForProvidedNode(startNode, endNode);
            int data = middle.data;
            if (data == value) {
                return true;
            }
            if (data > value) {
                startNode = middle.next;
            } else {
                endNode = middle;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
