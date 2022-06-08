package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelAvgNode {

    TreeNode treeNode;
    public static void main(String[] args) {

       /*int a= 2147483647;
        int b= 2147483647;
        System.out.println("sum:"+ ((double)a+(double) b));*/
        extracted();
    }

    private static void extracted() {
        LevelAvgNode tree = new LevelAvgNode();
        //TreeNode treeNode=new TreeNode();
        tree.treeNode= new TreeNode(4);
        tree.treeNode.left= new TreeNode(2);
        //tree.treeNode.right= new TreeNode(null);

        tree.treeNode.left.left= new TreeNode(3);
        tree.treeNode.left.right= new TreeNode(1);

       // tree.treeNode.right.left= new TreeNode(5);
        //tree.treeNode.right.right= new TreeNode(70);
        // tree.treeNode.right.left= new TreeNode(15);
        // tree.treeNode.right.right= new TreeNode(7);
        /*tree.treeNode.right.left.right= new TreeNode(52);
        tree.treeNode.right.left.right.right= new TreeNode(55);
        tree.treeNode.right.left.right.right.right= new TreeNode(57);
        tree.treeNode.left.left= new TreeNode(10);
        tree.treeNode.left.right= new TreeNode(30);*/


        TreeNode treeNode= tree.addOneRow(tree.treeNode,1,3);
        System.out.println("over"+treeNode.toString());
        //System.out.println(" data"+doubles.toString());
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg=new ArrayList<>();
        if(root==null)
        {
            return avg;
        }
        Queue<TreeNode> queue1=new ArrayDeque<>();
        queue1.add(root);
        Queue<TreeNode> queue2=new ArrayDeque<>();
        while(!queue1.isEmpty())
        {
            double sum=0;
            int count=0;
            while(queue1.peek()!=null)
            {
                TreeNode node= queue1.poll();
                sum+=  node.data;
                count++;
                if(node.left!=null)
                {
                    queue2.add(node.left);
                }
                if(node.right!=null)
                {
                    queue2.add(node.right);

                }
            }
            if(count>0) {
                avg.add((double)(sum)/count);
            }
            sum=0;count=0;

            while(queue2.peek()!=null)
            {
                TreeNode node= queue2.poll();
                sum+=  node.data;
                count++;
                if(node.left!=null)
                {
                    queue1.add(node.left);
                }
                if(node.right!=null)
                {
                    queue1.add(node.right);

                }
            }
            if(count>0) {
                avg.add((double)(sum)/count);
            }

        }
        return avg;
    }


    public  TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> queue1=new ArrayDeque<>();
        int dep=1;
        queue1.add(root);
        if(dep==depth)
        {
            TreeNode newNode=new TreeNode(val);
            newNode.left=root;
            return newNode;
        }
        Queue<TreeNode> queue2=new ArrayDeque<>();
        while (!queue1.isEmpty() )
        {
            dep++;
            while (queue1.peek()!=null)
            {
                TreeNode node=queue1.poll();
                if((dep)==depth)
                {
                    if(node.left!=null)
                    {
                        TreeNode oldLeftNode =node.left;
                        TreeNode newNode=new TreeNode(val);
                        node.left=newNode;
                        newNode.left=oldLeftNode;
                    }else {
                        TreeNode newNode=new TreeNode(val);
                        node.left=newNode;
                    }
                    if(node.right!=null)
                    {
                        TreeNode oldRightNode =node.right;
                        TreeNode newNode=new TreeNode(val);
                        node.right=newNode;
                        newNode.right=oldRightNode;
                    }else {
                        TreeNode newNode=new TreeNode(val);
                        node.right=newNode;
                    }

                }else {
                    if(node.left!=null)
                    {
                        queue2.add(node.left);
                    }
                    if(node.right!=null)
                    {
                        queue2.add(node.right);
                    }
                }
            }
            if((dep)==depth)
            {
                return root;
            }

            dep++;
            while(queue2.peek()!=null)
            {
                queue1.add(queue2.poll());
                TreeNode node=queue2.poll();
                if((dep)==depth)
                {
                    if(node.left!=null)
                    {
                        TreeNode oldLeftNode =node.left;
                        TreeNode newNode=new TreeNode(val);
                        node.left=newNode;
                        newNode.left=oldLeftNode;
                    }else {
                        TreeNode newNode=new TreeNode(val);
                        node.left=newNode;
                    }
                    if(node.right!=null)
                    {
                        TreeNode oldRightNode =node.right;
                        TreeNode newNode=new TreeNode(val);
                        node.right=newNode;
                        newNode.right=oldRightNode;
                    }else {
                        TreeNode newNode=new TreeNode(val);
                        node.right=newNode;
                    }

                }else {
                    if(node.left!=null)
                    {
                        queue1.add(node.left);
                    }
                    if(node.right!=null)
                    {
                        queue1.add(node.right);
                    }
                }
            }
            if((dep)==depth)
            {
                return root;
            }
        }

        return root;

    }


}
