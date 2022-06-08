package main.java.tree.online.question;

import main.java.tree.TreeNode;

public class DeepestLeaveSum {

    int sum=0;
    int maxd=0;
    public int deepestLeavesSum(TreeNode root) {
        findSum(root,1);
        return sum;
    }

    public void findSum(TreeNode root ,int curr)
    {
        if(root!=null)
        {

            if(curr>maxd)
            {
                sum=0;
                maxd=curr;
            }
            if(maxd==curr)
            {
                sum+=root.data;
            }
            findSum(root.left,curr+1);
            findSum(root.right,curr+1);
        }

    }
}
