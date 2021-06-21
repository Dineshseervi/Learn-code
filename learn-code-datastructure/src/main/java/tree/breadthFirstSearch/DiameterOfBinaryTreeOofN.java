package main.java.tree.breadthFirstSearch;

import main.java.tree.TreeNode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class DiameterOfBinaryTreeOofN {
    TreeNode treeNode;

    class Height{
        int h;
    }

    //This method find the diameter of tree recursively not require  to calculate height separately  , Time complexity of this is  o(n)
    public int diameter(TreeNode node, Height height) {
        if (node == null) {
            height.h=0;
            return 0;
        }

        Height lh = new Height();
        Height rh = new Height();

        int lDia = diameter(node.left, lh);   //Time complexity of this method is o(n)
        int rDia = diameter(node.right, rh);  //Time complexity of this method is o(n)

        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(lDia, rDia));
    }

    public static void main(String[] args) {
        //getClass().getDeclaredFields()
        List<String> list=new ArrayList<>();
        list.add("dinesh");
        list.add("rakesj");
        list.add("mahi");
        System.out.println("test");
        for (final Field field : list.getClass().getDeclaredFields())
        {
             if(!Modifier.isFinal(field.getModifiers()))
            {
                field.setAccessible(true);
                try {
                 Object object=   field.get(list);
                    System.out.println("object"+ object.getClass());

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
