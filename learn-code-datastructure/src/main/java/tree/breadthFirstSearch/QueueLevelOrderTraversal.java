package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(n) where n is number of nodes in the binary tree
 * Space Complexity: O(n) where n is number of nodes in the binary tree
 */
public class QueueLevelOrderTraversal {
    TreeNode root;

    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            if (node != null) {
                System.out.print(" " + node.data);
                TreeNode leftNode, rightNode;
                if ((leftNode = node.left) != null) {
                    treeNodeQueue.add(leftNode);
                }
                if ((rightNode = node.right) != null) {
                    treeNodeQueue.add(rightNode);
                }
            }
        }
    }


    public static void main(String[] args) {
        QueueLevelOrderTraversal tree_level = new QueueLevelOrderTraversal();
        tree_level.root = new TreeNode(1);
        tree_level.root.left = new TreeNode(2);
        tree_level.root.right = new TreeNode(3);
        tree_level.root.left.left = new TreeNode(4);
        tree_level.root.left.right = new TreeNode(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.levelOrderTraversal(tree_level.root);
    }
}
