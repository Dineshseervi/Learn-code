package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintKDistanceNodeFromGivenNode {

    List<TreeNode> path = new ArrayList<>();


    public static void main(String args[]) {
        PrintKDistanceNodeFromGivenNode kDistanceNodeFromGivenNode = new PrintKDistanceNodeFromGivenNode();

        /* Let us construct the tree shown in above diagram */
        /*TreeNode node = new TreeNode(20);
        node.left = new TreeNode(8);
        node.right = new TreeNode(22);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(12);
        node.left.right.left = new TreeNode(10);
        node.left.right.right = new TreeNode(14);
        TreeNode target = node.left.right; //12*/

        TreeNode node = new TreeNode(39);
        node.left = new TreeNode(12);
        node.right = new TreeNode(56);
        node.left.left = new TreeNode(64);
        node.left.right = new TreeNode(73);
        node.left.left.right = new TreeNode(63);
        node.left.right.left = new TreeNode(3);
        node.left.right.right = new TreeNode(54);

        node.right.left = new TreeNode(61);
        node.right.right = new TreeNode(45);
        node.right.right.right = new TreeNode(81);

        TreeNode target = node.left.right;


       /* List<Integer> list= kDistanceNodeFromGivenNode.printkdistanceNode(node, target, 4);
        System.out.println("list size:"+list.size());
        int sum=0;
        for(int val:list)
        {
            System.out.println(val);
            sum=sum+val;
        }
        System.out.println("sum: "+sum);*/

        sum_at_distK(node,target.data,4);
    }

    private boolean findPath(TreeNode node, TreeNode target) {
        if (node == null) {
            return false;
        }
        if (node.data == target.data || findPath(node.left, target) || findPath(node.right, target)) {
            path.add(node);
            return true;
        }
        return false;
    }

    private List<Integer> printkdistanceNode(TreeNode node, TreeNode target, int k) {

        List<Integer> list =new ArrayList<>();
        findPath(node,target);
        for(int i=0;i<path.size();i++)
        {
            findKDistanceFromNode(path.get(i),k-i,list,i==0?null:path.get(i-1));
        }
        return list;
    }

    public void findKDistanceFromNode(TreeNode node,
                                      int dist,
                                      List<Integer> result,
                                      TreeNode blocker) {
        if (node == null) {
            return;
        }

        if (dist < 0 || blocker == node) {
            return;
        }

        if(dist>=0)
        {
            System.out.println("node added :"+node.data);
            result.add(node.data);

        }

        findKDistanceFromNode(node.left, dist - 1, result, blocker);
        findKDistanceFromNode(node.right, dist - 1, result, blocker);
    }


   /* private static boolean fillNodes(TreeNode root,int target)
    {
        if(root==null)
        {
            return false;
        }

        if(root.data==target || fillNodes(root.left,target) || fillNodes(root.right, target))
        {
            path.add(root);
            return true;
        }
    return false;
    }*/


    private static List<TreeNode> pathStatic=new ArrayList<>();

    static int sum_at_distK(TreeNode root, int target, int k){
        // code here
        fillNodes(root,target);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<pathStatic.size();i++)
        {
            fetchNodes(pathStatic.get(i),k-i,list,i==0?null:pathStatic.get(i-1));
        }
        int sum=0;
        for(int val:list)
        {
            sum= sum + val;
        }
        System.out.println("Sum:"+sum);
        return sum;
    }

    private static void fetchNodes(TreeNode root , int dist,List<Integer>  list,TreeNode blocker)
    {

        if(dist<0 || root==null || blocker==root)
        {
            return;
        }
        if(dist>=0)
        {
            list.add(root.data);

        }
        fetchNodes(root.left,dist-1,list,blocker);
        fetchNodes(root.right,dist-1,list,blocker);

    }

    private static boolean fillNodes(TreeNode root,int target)
    {
        if(root==null)
        {
            return false;
        }
        // System.out.println(root.data);
        if(root.data==target || fillNodes(root.left,target) || fillNodes(root.right, target))
        {
            pathStatic.add(root);
            return true;
        }
        return false;
    }

}
