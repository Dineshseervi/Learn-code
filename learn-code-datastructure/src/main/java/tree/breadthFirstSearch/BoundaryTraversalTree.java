package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

/**
 * left-node traversal
 * right node traversal
 * leaf node traversal
 */
public class BoundaryTraversalTree {

    private void leftNodeTraversal(TreeNode treeNode)
    {
        if(treeNode!=null)
        {
            /*leftNodeTraversal(treeNode.left);

            if(treeNode.left!=null || treeNode!=null)*/
            if(treeNode.left!=null)
            {
                System.out.println("l "+treeNode.data);
                leftNodeTraversal(treeNode.left);
            }
            else if(treeNode.right!=null)
            {
                System.out.println("lr "+treeNode.data);
                leftNodeTraversal(treeNode.right);
            }
        }
    }

    private void rightNodeTraversal(TreeNode treeNode)
    {
        if(treeNode!=null)
        {
            if(treeNode.right!=null)
            {
                System.out.println("r "+treeNode.data);
                rightNodeTraversal(treeNode.right);
            }
            else if(treeNode.left!=null)
            {
                System.out.println("rl "+treeNode.data);
                rightNodeTraversal(treeNode.left);
            }
        }
    }

    /**
     * leaf node is node who don't have any child
     * @param treeNode
     */
    private void leafNodeTraversal(TreeNode treeNode)
    {
        if(treeNode==null)
        {
            return;
        }
        if(treeNode.left==null && treeNode.right==null)
        {
            System.out.println("leaf :"+treeNode.data);
            return;
        }
        leafNodeTraversal(treeNode.left);
        leafNodeTraversal(treeNode.right);
    }


    public void boundaryTraversalOfTreeNode(TreeNode treeNode)
    {
        System.out.println("BoundaryTraversalOfTreeNode");
        leftNodeTraversal(treeNode);
        rightNodeTraversal(treeNode.right);
        leafNodeTraversal(treeNode);
    }

}
