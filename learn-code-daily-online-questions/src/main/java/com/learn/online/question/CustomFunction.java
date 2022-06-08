package com.learn.online.question;

import java.util.function.BiPredicate;
import java.util.function.Function;

public class CustomFunction {

    private Function<String [] ,Boolean> javServiceFunction= a->a[0].equals(a[1]);
    public  static BiPredicate<String,String> test=(s1,s2)-> { return s1.equals(s2);};



    public static void main(String[] args) {
        CustomFunction customFunction=new CustomFunction();
        //boolean val=customFunction.javServiceFunction.apply(new String[]{"aa", "aa"});
        boolean val=test.test("a","a");
        System.out.println(val);
    }
}
