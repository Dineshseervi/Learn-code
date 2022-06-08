package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveValueFromList {
    public static void main(String[] args) {
        List<Integer> integersList= new ArrayList<>(Arrays.asList(1,24,-2,4,-5));
        int index=0;
        /*for (Integer val:integersList)
        {
            System.out.println("val: "+val);
            if(val<0)
            {
                integersList.remove(index);
            }
            index++;
        }*/
        Iterator<Integer> iterator=integersList.iterator();
        while (iterator.hasNext())
        {
            Integer val=iterator.next();
            if(val<0)
            {
                iterator.remove();
            }
        }
        System.out.println("list :" +integersList);
    }
}
