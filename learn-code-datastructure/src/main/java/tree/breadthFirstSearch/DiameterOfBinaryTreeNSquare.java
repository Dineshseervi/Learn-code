package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

public class DiameterOfBinaryTreeNSquare {
    TreeNode treeNode;

    //this method find height of tree recursively Time complexity of this method is o(n)
    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lHeight = height(node.left);
        int rHeight = height(node.right);
        return Math.max(lHeight, rHeight) + 1;
    }

    //This method find the diameter of tree recursively using height method , Time complexity id o(n^2)
    public static int diameter(TreeNode node)
    {
        if (node == null) {
            return 0;
        }

        int lHeight = height(node.left); // Time complexity of this method is o(n)
        int rHeight = height(node.right);// Time complexity of this method is o(n)

        int lDia=diameter(node.left);   //Time complexity of this method is o(n^2)
        int rDia=diameter(node.right);  //Time complexity of this method is o(n^2)


        return Math.max(lHeight+rHeight+1 ,Math.max(lDia,rDia));
    }
}
