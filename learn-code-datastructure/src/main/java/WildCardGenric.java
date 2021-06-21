package main.java;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WildCardGenric {


    //Upper bound wildcard
    public static Number sum(List<? extends Number> list)
    {
        Number sum=0;
        for(Number n:list)
        {
            sum=sum.doubleValue()+n.doubleValue();
        }
        return sum;
    }



    public static void printData(List<?> list)
    {
        System.out.println(list);
    }

    public static void main(String[] args) {

      /*  List<Integer> list1= Arrays.asList(4,5,6,7);

        //printing the sum of elements in list
        System.out.println("Total sum is:"+sum(list1));

        //Double list
        List<Double> list2=Arrays.asList(4.1,5.1,6.1);
        Map<Integer,Integer> map=new HashMap<>();
        //map.containsKey()

        //printing the sum of elements in list
        System.out.print("Total sum is:"+sum(list2));


        System.out.println("");
        //lower bound
        printData(list1);
        printData(list2);*/
        Random random=new Random();
        Map<Integer,Integer> map=new ConcurrentHashMap<>();
        for (int i=0;i<100;i++)
        {
            map.put(random.nextInt(),random.nextInt());
        }
        System.out.println( map.size());
        Set<Integer> set=map.keySet();
        for (Integer n:set)
        {
            map.remove(n);
        }
        System.out.println("size"+map.size());



    }
}
