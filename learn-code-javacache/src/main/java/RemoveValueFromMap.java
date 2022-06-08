package main.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RemoveValueFromMap {

    public static void main(String[] args) {
        Map<String,String> userDetailsMap=new HashMap<>();
        userDetailsMap.put("1","dinesh Seervi");
        userDetailsMap.put("2","mahi Seervi");
        userDetailsMap.put("3","kalyan Seervi");
        userDetailsMap.put("4","mk Seervi");
        userDetailsMap.put("5","monika Seervi");
        userDetailsMap.put("6","sunil Seervi");

       Iterator<Map.Entry<String,String>> iterator= userDetailsMap.entrySet().iterator();
       while (iterator.hasNext())
       {
           Map.Entry<String, String> entry = iterator.next();
           String key=entry.getKey();
           if ((key.equals("1")))
           {
               System.out.println("remove : "+key);
               iterator.remove();
           }

       }
        System.out.println("map:"+userDetailsMap.toString());
    }
}
