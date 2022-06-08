package main.java.tree.online.question;

import main.java.tree.TreeNode;

public class BSTOperation {

    //if node to be deleted is leaf node ,then remove the leaf
    //if node to be deleted has only one child .
    //if node had both left and right child present  . get next in-order successor .
    TreeNode root;

    public void deleteNodeFromBST(TreeNode node, Integer key) {
        root = deleteNode(node, key);
    }

    private TreeNode deleteNode(TreeNode node, Integer key) {
        if (node == null) {
            return node;
        }
        if (key > node.data) {
            return deleteNode(node.left, key);
        } else if (key < node.data) {
            return deleteNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            int min=findMin(node.right);
            node.data=min;
            deleteNode(node.right,min);
        }
        return node;

    }

    private int findMin(TreeNode node) {
       int min=root.data;
       while (node.left!=null)
       {
           min=node.data;
           node=node.left;
       }
       return min;
    }

    public TreeNode searchNodeInBST(TreeNode node,int key)
    {
        if(node==null || node.data==key)
        {
            return node;
        }
        if(node.data<key)
        {
            return searchNodeInBST(node.right,key);
        }else{
            return searchNodeInBST(node.left,key);
        }
    }

    public static void main(String[] args) {

    }
}
