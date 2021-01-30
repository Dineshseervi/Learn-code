package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Method 1 (Use function to print a given level)
 *                 -->Time complexity= O(n^2)
 *                 -->space complexity= O(n)
 */
public class RecursionLevelOrderTraversal {
    TreeNode treeNode;

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftNodeHeight = height(node.left);
        int rightNodeHeight = height(node.right);
        if (leftNodeHeight < rightNodeHeight) {
            return rightNodeHeight + 1;
        } else {
            return leftNodeHeight + 1;
        }
    }

    public int diameterOfTree(TreeNode node)
    {
        if(node == null)
        {
            return 0;
        }
        int leftSide = height(node.left);
        int rightSide = height(node.right);


        int leftNodeDiamater= Math.max(leftSide+rightSide+1,diameterOfTree(node.left));
        int rightNodeDiamter= Math.max(leftSide+rightSide+1,diameterOfTree(node.right));
        return Math.max(leftNodeDiamater,rightNodeDiamter);
    }

    public void printLevelOrder(TreeNode node) {
        TreeNode nodeRoot=node;
        Integer height = height(nodeRoot);
        System.out.println("height: "+height);
        for (int i = 1; i <= height; i++) {
            printGivenLevelOfTree(node, i);
        }
    }

    public void printGivenLevelOfTree(TreeNode node, Integer level) {
        //System.out.println("level:"+level);
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print("-" + node.data);

        }
        else if(level>1) {
            //System.out.println("cc");
            printGivenLevelOfTree(node.left, level - 1);
            printGivenLevelOfTree(node.right, level - 1);
        }
    }


    public void printLevelRightViewWithQueue(TreeNode node)
    {
        Queue<TreeNode> nodeQueue=new LinkedBlockingQueue<>();
        nodeQueue.add(node);
        Queue<TreeNode> nodeQueueSecond=new LinkedBlockingQueue<>();
        List<Integer> rightView=new ArrayList<>();

        while (!nodeQueue.isEmpty())
        {
            TreeNode inNode=null;
            while (nodeQueue.peek()!=null)
            { inNode= nodeQueue.poll();
                if(inNode.left!=null) {
                    nodeQueueSecond.add(inNode.left);
                }
                if(inNode.right!=null)
                {
                    nodeQueueSecond.add(inNode.right);
                }
            }
            rightView.add(inNode.data);
            while (nodeQueueSecond.peek()!=null)
            {
                nodeQueue.add(nodeQueueSecond.poll());
            }
        }
        System.out.println("right view:"+ rightView.toString());
    }

    public void printLevelWithQueue(TreeNode node)
    {
        Queue<TreeNode> nodeQueue=new LinkedBlockingQueue<>();
        nodeQueue.add(node);
        Queue<TreeNode> nodeQueueSecond=new LinkedBlockingQueue<>();
        List<Integer> rightView=new ArrayList<>();

        while (!nodeQueue.isEmpty())
        {
            TreeNode inNode=null;
            while (nodeQueue.peek()!=null)
            { inNode= nodeQueue.poll();
                if(inNode.left!=null) {
                    nodeQueueSecond.add(inNode.left);
                }
                if(inNode.right!=null)
                {
                    nodeQueueSecond.add(inNode.right);
                }
                System.out.print(" "+inNode.data);
            }
            System.out.println("");
            //rightView.add(inNode.data);
            while (nodeQueueSecond.peek()!=null)
            {
                nodeQueue.add(nodeQueueSecond.poll());
            }
        }
        //System.out.println("right view:"+ rightView.toString());
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        RecursionLevelOrderTraversal tree = new RecursionLevelOrderTraversal();
        //TreeNode treeNode=new TreeNode();
        tree.treeNode= new TreeNode(40);
        tree.treeNode.left= new TreeNode(20);
        tree.treeNode.right= new TreeNode(60);
        tree.treeNode.right.right= new TreeNode(70);
        tree.treeNode.right.left= new TreeNode(50);
        tree.treeNode.right.right.right= new TreeNode(80);
        tree.treeNode.right.left.right= new TreeNode(52);
        tree.treeNode.right.left.right.right= new TreeNode(55);
        tree.treeNode.right.left.right.right.right= new TreeNode(57);
        tree.treeNode.left.left= new TreeNode(10);
        tree.treeNode.left.right= new TreeNode(30);

        /*System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder(tree.treeNode);
        int diameter= tree.diameterOfTree(tree.treeNode);
        System.out.println("");
        System.out.println("Diameter:"+diameter);
        //tree.printLevelRightViewWithQueue(tree.treeNode);
        System.out.println("------------");
        tree.printLevelWithQueue(tree.treeNode);
        System.out.println("------------");
        BoundaryTraversalTree  boundaryTraversalTree=new BoundaryTraversalTree();
        boundaryTraversalTree.boundaryTraversalOfTreeNode(tree.treeNode);*/

        VerticalTreePrint verticalTreePrint=new VerticalTreePrint();
        verticalTreePrint.pintTreeMinMax(tree.treeNode);
    }
}
