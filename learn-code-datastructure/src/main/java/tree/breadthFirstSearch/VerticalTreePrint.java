package main.java.tree.breadthFirstSearch;


import main.java.tree.TreeNode;

import java.util.*;

/**
 * 50
 * 25      75
 * 15    27  55   85
 */
public class VerticalTreePrint {

    Map<Integer, String> treeDataCollection = new TreeMap<>();

    class Value {
        int min;
        int max;
    }

    private void findMinMax(TreeNode treeNode, Value value, int level) {
        if (treeNode == null) {
            return;
        }

        if (level < value.min) {
            value.min = level;
        } else if (level > value.max) {
            value.max = level;
        }
        addToCollection(level, treeNode.data);
        findMinMax(treeNode.left, value, level - 1);
        findMinMax(treeNode.right, value, level + 1);
    }

    private void addToCollection(Integer level, Integer data) {
        if (treeDataCollection.containsKey(level)) {
            treeDataCollection.put(level, treeDataCollection.get(level) + "-" + data);
        } else {
            treeDataCollection.put(level, data + "");
        }
    }

    public List<Integer> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
        treeNodeQueue.add(root);
        List<Integer> levelOrderList = new ArrayList<>();

        while (!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            if (node != null) {
                levelOrderList.add(node.data);
                TreeNode leftNode, rightNode;
                if ((leftNode = node.left) != null) {
                    treeNodeQueue.add(leftNode);
                }
                if ((rightNode = node.right) != null) {
                    treeNodeQueue.add(rightNode);
                }
            }
        }
        return levelOrderList;
    }



    private void printTopView(List<Integer> levelOrder) {
        for (Map.Entry<Integer, String> entry : treeDataCollection.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            String printValue="";
            if (value.contains("-")) {
                int index = 0;
                String[] valArray = value.split("-");
                for (int i = 0; i < valArray.length ; i++) {

                    int methodIndex=levelOrder.indexOf(Integer.parseInt(valArray[i]));
                    if(i==0)
                    {
                        index=methodIndex;
                        printValue=valArray[i];
                        continue;
                    }
                    if(methodIndex<=index)
                    {
                        index=methodIndex;
                        printValue=valArray[i];
                    }
                }
            } else {
                printValue = value;
            }
            System.out.print(printValue + " , ");
        }
    }

    private void printBottomView(List<Integer> levelOrder) {
        for (Map.Entry<Integer, String> entry : treeDataCollection.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            String printValue="";
            if (value.contains("-")) {
                int index = 0;
                String[] valArray = value.split("-");
                for (int i = 0; i < valArray.length ; i++) {

                    int methodIndex=levelOrder.indexOf(Integer.parseInt(valArray[i]));
                    if(i==0)
                    {
                        index=methodIndex;
                        printValue=valArray[i];
                        continue;
                    }
                    if(methodIndex>=index)
                    {
                        index=methodIndex;
                        printValue=valArray[i];
                    }
                }
            } else {
                printValue = value;
            }
            System.out.print(printValue + " , ");
        }
    }
    public void pintTreeMinMax(TreeNode treeNode) {
        Value val = new Value();
        findMinMax(treeNode, val, 0);
        List<Integer> levelOrder = levelOrderTraversal(treeNode);

        System.out.println(" min:" + val.min + "  --  max : " + val.max);
        System.out.println("" + treeDataCollection.toString());
        printTopView(levelOrder);
        System.out.println("\n----bottom view----");
        printBottomView(levelOrder);
    }


}

