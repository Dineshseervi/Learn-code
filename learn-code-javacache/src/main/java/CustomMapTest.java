package main.java;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class CustomMapTest {
    public static void main(String[] args) {
        HashMap<Integer,String> studentMap=new HashMap<>();
        CustomMap customMap=new CustomMap<>(studentMap);
        System.out.println("count"+customMap.getAddCount());
        customMap.put(1,"dinesh");
        System.out.println("count"+customMap.getAddCount());
        System.out.println("value: "+customMap.get(1));

    }
}
