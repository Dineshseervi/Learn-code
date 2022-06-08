package main.java.exam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapJava8Example {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,3);
        map.put(5,3);
        map.put(6,3);
        map.put(7,3);
        map.entrySet().removeIf(integerIntegerEntry -> integerIntegerEntry.getKey()%2==0);



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
