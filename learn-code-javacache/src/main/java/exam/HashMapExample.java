package main.java.exam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
       Iterator<Map.Entry<Integer,Integer>> entryMapIterator= map.entrySet().iterator();
       while (entryMapIterator.hasNext())
       {
           Map.Entry<Integer,Integer> object=entryMapIterator.next();
           if(object.getKey()==2)
           {
               entryMapIterator.remove();
           }
       }


        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            System.out.println("key : "+ entry.getKey());
            if(entry.getKey()==2)
            {

                //map.remove(2);
            }
        }

    }
}
