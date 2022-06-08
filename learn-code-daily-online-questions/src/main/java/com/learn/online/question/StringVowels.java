package com.learn.online.question;

import java.util.*;

public class StringVowels {
    public static void main(String[] args) {
        String val="AbCdEfGh";

        StringVowels stringVowels=new StringVowels();
       boolean result= stringVowels.halvesAreAlike(val);
        System.out.println("val: "+result);

    }

    public boolean halvesAreAlike(String s) {
        List<Character> list= Arrays.asList('a','A','e','E','i','I','o','O','u','U');
        int countA=0;
        int countB=0;
        int j=s.length()-1;
        for(int i = 0;i<=(s.length()/2) -1;i++,j--)
        {
            boolean r= list.contains( s.charAt(i) );
            if(r){
                countA++;
            }
            r=list.contains(s.charAt(j));
            if(r)
            {
                countB++;
            }
        }

        return countA==countB?true:false;
    }
}
