package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

public class CreateBST {
    //private static int count;

    public static TreeNode createBstFromPostOrder(int[] seq, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = seq[end];
        TreeNode node = new TreeNode(val);
        int newend = Integer.MIN_VALUE;
        for (int i = end; i >= start; i--) {
            if (seq[i] < val) {
                newend = i;
                break;
            }
        }
        if (newend < start) {
            return node;
        }
        if (start <= newend) {
            node.left = createBstFromPostOrder(seq, start, newend);

        }
        if (newend + 1 <= end) {
            node.right = createBstFromPostOrder(seq, newend + 1, end - 1);
        }

        return node;
    }

    public static void printPostOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        printPostOrderTraversal(node.left);
        printPostOrderTraversal(node.right);
        System.out.println("- " + node.data);
    }

    public static void printPreOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("- " + node.data);
        printPreOrderTraversal(node.left);
        printPreOrderTraversal(node.right);

    }

    /**
     *
     * {15,10,8,12,20,16,25}
     * {0, 1, 2,3, 4, 5, 6}
     *
     * @param seq
     * @param start
     * @param end
     * @return
     */

    public static TreeNode createBstFromPreOrder(int[] seq, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = seq[start];
        TreeNode node = new TreeNode(val);
        int newend = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (seq[i] > val) {
                newend = i;
                break;
            }
        }
        if(newend==Integer.MIN_VALUE)
        {
            return node;
        }
        if (newend-1 < start) {
            return node;
        }
        if (start <= newend-1) {
            node.left = createBstFromPreOrder(seq, start+1, newend-1);

        }
        if (newend  <= end) {
            node.right = createBstFromPreOrder(seq, newend , end );
        }

        return node;
    }



    public static void main(String[] args) {
        /*int[] seq = {8, 12, 10, 16, 25, 20, 15};
        System.out.println("create BST");
        //count=seq.length-1;
        TreeNode node = createBstFromPostOrder(seq, 0, seq.length - 1);
        System.out.println("node");
        printPostOrderTraversal(node);*/
        int[] seq = {15,10,8,12,20,16,25};
        System.out.println("create BST");
        //count=seq.length-1;
        TreeNode node = createBstFromPreOrder(seq, 0, seq.length - 1);
        System.out.println("node");
        printPreOrderTraversal(node);


    }


}
