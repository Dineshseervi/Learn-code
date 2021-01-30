package main.java.tree.mirror;

import main.java.tree.BinaryTreeDFS;
import main.java.tree.TreeNode;
import main.java.tree.breadthFirstSearch.QueueLevelOrderTraversal;

public class MirrorTree {

    private TreeNode rootNode;
    private TreeNode mirror(TreeNode node)
    {
        if(node!=null)
        {
            mirror(node.left);
            mirror(node.right);
            TreeNode tempLeft=node.left;
            node.left=node.right;
            node.right=tempLeft;
        }
        return null;
    }

    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree();
        tree.rootNode = new TreeNode(1);
        tree.rootNode.left = new TreeNode(2);
        tree.rootNode.right = new TreeNode(3);
        tree.rootNode.left.left = new TreeNode(4);
        tree.rootNode.left.right = new TreeNode(5);

        /*BinaryTreeDFS bst = new BinaryTreeDFS();

        bst.inOrderTraverse(tree.rootNode);*/
        QueueLevelOrderTraversal tree_level = new QueueLevelOrderTraversal();
        tree_level.levelOrderTraversal(tree.rootNode);
        tree.mirror(tree.rootNode);
        System.out.println("after");
        //bst.inOrderTraverse(tree.rootNode);
        tree_level.levelOrderTraversal(tree.rootNode);


    }
}
