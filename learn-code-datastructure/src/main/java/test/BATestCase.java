package main.java.test;

import java.util.*;

public class BATestCase {


    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("BA5678");
        list.add("BA9999");
        list.add("BA8678");
        list.add("BA7678");
        list.add("BA6678");
        System.out.println(list);
        Collections.sort(list,new CustomComparator());
        System.out.println(list);
    }



}

class CustomComparator implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2) {
         Double aa = Double.parseDouble(o1.replace("BA",""));
        Double bb =Double.parseDouble(o2.replace("BA",""));

         return aa.compareTo(bb);
    }
}