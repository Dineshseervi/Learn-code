package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CameraNode {

    TreeNode treeNode;
    public static void main(String[] args) {

       /*int a= 2147483647;
        int b= 2147483647;
        System.out.println("sum:"+ ((double)a+(double) b));*/
        extracted();
    }

    private static void extracted() {
        CameraNode tree = new CameraNode();
        //TreeNode treeNode=new TreeNode();
        tree.treeNode= new TreeNode(0);
        //tree.treeNode.left= new TreeNode(2);
        tree.treeNode.right= new TreeNode(0);

        tree.treeNode.right.left= new TreeNode(0);
        tree.treeNode.right.right= new TreeNode(0);
        tree.treeNode.right.right.right= new TreeNode(0);

       // tree.treeNode.right.left= new TreeNode(5);
        //tree.treeNode.right.right= new TreeNode(70);
        // tree.treeNode.right.left= new TreeNode(15);
        // tree.treeNode.right.right= new TreeNode(7);
        /*tree.treeNode.right.left.right= new TreeNode(52);
        tree.treeNode.right.left.right.right= new TreeNode(55);
        tree.treeNode.right.left.right.right.right= new TreeNode(57);
        tree.treeNode.left.left= new TreeNode(10);
        tree.treeNode.left.right= new TreeNode(30);*/

        int val= tree.minCameraCover(tree.treeNode);
        System.out.println("val:"+val);

        String word="fdfd";
        System.out.println(word.charAt(1));

    }

    public int minCameraCover(TreeNode root) {

        if(root==null)
        {
            return 0;
        }
        int h=height(root);
        if(h==2)
        {
            return 1;
        }
        boolean odd=true;
        System.out.println("height:"+h);
        if(h%2==0)
        {
            odd=false;
        }
        int count=0;
        int cc=0;
        int pp=0;
        Queue<TreeNode> queue1=new ArrayDeque<>();
        queue1.add(root);
        Queue<TreeNode> queue2=new ArrayDeque<>();
        while(!queue1.isEmpty())
        {
            while(queue1.peek()!=null)
            {
                cc++;
                TreeNode node=queue1.poll();
                if(node.left!=null)
                {
                    queue2.add(node.left);
                }
                if(node.right!=null)
                {
                    queue2.add(node.right);
                }
            }
           // pp+=cc;
            while(queue2.peek()!=null)
            {
                count++;
                TreeNode node=queue2.poll();
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
        if(count==0 && cc==0)
        {
            return 1;
        }
        System.out.println("pp:"+pp);
        return Math.min(cc,count);
    }

    private int height(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int left=height(node.left);
        int right=height(node.right);
        return Math.max(left,right) +1;
    }


}
