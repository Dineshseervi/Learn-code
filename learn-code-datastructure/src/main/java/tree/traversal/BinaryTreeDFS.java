package main.java.tree.traversal;

import main.java.tree.TreeNode;

import java.util.List;

/**
 *       1
 *      / \
 *     2   3
 *    /\
 *   4 5
 *
 * Depth First Traversals:
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class BinaryTreeDFS {


    TreeNode root;

    public BinaryTreeDFS() {
    }

    /**
     * preOrderTraverse ->(Root,Left,Right)
     *
     * @param node
     */
    public void preOrderTraverse(TreeNode node) {

        if (node == null) {
            return;
        }
        printNodeData(node.data);

        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * postOrderTraverse ->(Left,Right,Root)
     *
     * @param node
     */
    public void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        printNodeData(node.data);
    }

    /**
     * inOrderTraverse ->(Left,Root,Right)
     *
     * @param node
     */
    public void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        printNodeData(node.data);
        inOrderTraverse(node.right);

    }

    public void inOrderTraverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left,list);
        printNodeData(node.data);
        list.add(node.data);
        inOrderTraverse(node.right,list);

    }

    public void printNodeData(Integer data) {
        System.out.print("" + data + " ->");
    }



    public static void main(String[] args) {
        BinaryTreeDFS tree = new BinaryTreeDFS();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.preOrderTraverse(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.inOrderTraverse(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.postOrderTraverse(tree.root);
    }
}
