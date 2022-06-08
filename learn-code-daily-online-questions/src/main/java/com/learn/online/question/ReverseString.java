package com.learn.online.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseString {

/*public static String reverseTheString(String word)
{

    System.out.println("word :"+word);
    String reverse="";
    for (int i=word.length()-1;i>=0;i--)
    {
        reverse =reverse+word.charAt(i);
    }
    return reverse;
}*/


    public static String reverseTheString(String word) {


        return reverseRecursively(word);
    }

    public static String reverseRecursively(String str) {
       /* String val="fdfd";
        String val2="fdfd";
        int j=val.compareTo(val2);
        {

        }*/
        System.out.println("str :" + str);
        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }

    /*public static void main(String[] args) {
        String val="";
        String val2="mfmfmf";
        List<Set<Integer>> list=new ArrayList<>();
        list.add(new HashSet<>());
        list.get(0).add(1);
        list.get(0).add(2);

        list.add(new HashSet<>());
        list.get(1).add(1);
        list.get(1).add(2);

        System.out.println(val.compareTo(val2));
    }*/

}
