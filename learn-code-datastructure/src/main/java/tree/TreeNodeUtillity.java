package main.java.tree;

public class TreeNodeUtillity {

    enum NodeChild {
        left, right;
    }

    /**
     * Delete a node for given data in binary Tree .
     * node could have 0 child .--> Simply detach the node
     * node could have 1 child  --> Have to choose next(either available left or right) as a root .
     * node could have 2 child  --> Have to check how many children are present. and then find the inorder precedentor of that
     * node .
     * <p>
     * after finding node of element to delete let find inorder pre number of node to be deleted
     */

    public void deleteNodeWithoutChild(TreeNode preNode, NodeChild nodeChild) {
        if (preNode != null) {
            if (nodeChild == NodeChild.left) {
                preNode.left = null;
            } else {
                preNode.right = null;
            }
        }
    }

    public void deleteNodeWithOneChild(TreeNode preNode, NodeChild nodeChildToBeDeleted, NodeChild nodeNextChild) {
        if (preNode != null) {
            if (nodeChildToBeDeleted == NodeChild.left) {
                preNode.left = nodeNextChild == NodeChild.left ? preNode.left.left : preNode.left.right;
            } else {
                preNode.right = (nodeNextChild == NodeChild.left) ? preNode.right.left : preNode.right.right;
            }
        }
    }

    public void deleteNodeWithTwoChild(TreeNode node) {
        Integer dataForNode;
        /*if(node.left!=null && node.left.right!=null)
        {

        }*/
        TreeNode treeNode = node.left;
        while (node != null) {
            dataForNode = node.data;
            treeNode = node.right;
        }
    }


    public TreeNode deleteNode(TreeNode treeNode, Integer data) {
        if (treeNode == null) {
            return treeNode;
        }

        if (data < treeNode.data) {
            treeNode.left = deleteNode(treeNode.left, data);
        } else if (data > treeNode.data) {
            treeNode.right = deleteNode(treeNode.right, data);
        } else {

            if (treeNode.left == null) {
                return treeNode.right;
            } else if (treeNode.right == null) {
                return treeNode.left;
            }

            //inOrder prerequsite
            treeNode.data = minData(treeNode.left);
            //
            treeNode.left = deleteNode(treeNode.left, treeNode.data);


        }
        return treeNode;
    }

    private Integer minData(TreeNode treeNode) {
        Integer minData = null;
        while (treeNode.right != null) {
            minData = treeNode.right.data;
            treeNode = treeNode.right;
        }

        return minData;
    }

    /* A recursive function to
      insert a new key in BST */
    TreeNode insertRec(TreeNode root, int key)
    {

        /* If the tree is empty,
          return a new node */
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }
}
