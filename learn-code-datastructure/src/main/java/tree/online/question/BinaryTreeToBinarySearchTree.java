package main.java.tree.online.question;

import main.java.tree.TreeNode;
import main.java.tree.traversal.BinaryTreeDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBinarySearchTree {

    TreeNode root;

    public void convertToBST(TreeNode treeNode)
    {
      //first get all the node data into a list O(n)
        List<Integer> list=new ArrayList<>();
        new BinaryTreeDFS().inOrderTraverse(treeNode,list);

        System.out.println(" step 2");
      //sort the list   O(N logN)
        Collections.sort(list);

        System.out.println("step 3");
      // convert array to tree using inorder way O(n)
       TreeNode treeNodeBST= createBST(0,list.size()-1,list);
        new BinaryTreeDFS().inOrderTraverse(treeNodeBST);

    }

    public TreeNode createBST(int start,int end, List<Integer> list)
    {
        if(start>end)
        {
            return null;
        }

        int mid= (start+end)/2;
        TreeNode node=new TreeNode(list.get(mid));

        node.left=createBST(start,mid-1,list);
        node.right=createBST(mid+1,end,list);

        return node;
    }

    public static void main(String[] args) {
        BinaryTreeToBinarySearchTree tree = new BinaryTreeToBinarySearchTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        tree.convertToBST(tree.root);
    }
}
