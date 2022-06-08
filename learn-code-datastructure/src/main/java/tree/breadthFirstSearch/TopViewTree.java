package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TopViewTree<E> {
    private Integer leftcount=0;
    private Integer rightcount=0;
    private List<E>  data =new ArrayList<E>();

    private void levelOrder(TreeNode treeNode)
    {
        if(treeNode==null)
        {
            return;
        }
        Queue<TreeNode> queue=new ConcurrentLinkedDeque<>();
        queue.add(treeNode);
        while (queue.peek()!=null)
        {
            TreeNode localNode=queue.poll();
            data.add((E)localNode.data);
            queue.add(localNode.left);
            queue.add(localNode.right) ;
        }
    }

    //private void nodeLevel()


}
