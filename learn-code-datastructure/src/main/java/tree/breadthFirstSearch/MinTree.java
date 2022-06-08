package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

/**
 * Tree height iterator
 */
public class MinTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return maxDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return maxDepth(root.left) + 1;
        }
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
