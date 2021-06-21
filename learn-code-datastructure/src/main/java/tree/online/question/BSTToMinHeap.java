package main.java.tree.online.question;

import main.java.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * Converting bst to min-heap
 * first we need to iterate over  bst tree in inorder traversal and store data in array
 * Then we iterate tree in preorder and replace data of node in sequence.
 */
public class BSTToMinHeap {

    TreeNode treeNode;


    Queue<Integer> queue=new ArrayDeque<>();

    public void inorderTraversal(TreeNode treeNode)
    {
        if(treeNode==null)
        {
            return;
        }
        inorderTraversal(treeNode.left);
        queue.add(treeNode.data);
        inorderTraversal(treeNode.right);
    }

    public void replaceNodeData(TreeNode treeNode)
    {
        if(treeNode==null)
        {
            return;
        }

        treeNode.data=queue.poll();
        replaceNodeData(treeNode.left);
        replaceNodeData(treeNode.right);

    }

    public void preporderTraversal(TreeNode node)
    {
        if(node==null)
        {
            return;
        }
        System.out.print(" ->"+node.data );
        preporderTraversal(node.left);
        preporderTraversal(node.right);
    }

    public static void main(String[] args) {
        BSTToMinHeap bstToMinHeap=new BSTToMinHeap();
        bstToMinHeap.treeNode=new TreeNode(4);
        bstToMinHeap.treeNode.left=new TreeNode(2);
        bstToMinHeap.treeNode.right=new TreeNode(6);

        bstToMinHeap.treeNode.left.left=new TreeNode(1);
        bstToMinHeap.treeNode.left.right=new TreeNode(3);

        bstToMinHeap.treeNode.right.left=new TreeNode(5);
        bstToMinHeap.treeNode.right.right=new TreeNode(7);


        bstToMinHeap.inorderTraversal(bstToMinHeap.treeNode);
        bstToMinHeap.replaceNodeData(bstToMinHeap.treeNode);
    bstToMinHeap.preporderTraversal(bstToMinHeap.treeNode);

    }
}
