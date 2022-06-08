package com.learn.online.question;

import java.util.HashSet;
import java.util.Set;

public class AprilTest21 {



    /**
     * abcde
     * bacde
     * bcade
     * bcdae
     * bcdea
     *
     * bacde
     * abcde
     * acbde
     * acdbe
     * acdeb
     *
     * a + bcde
     *
     *
     * abc
     * bac
     * bca
     * acb
     * cab
     *
     *
     * acb
     *
     * bac
     *
     * bac
     * cab
     * @param word
     */
/*    public void printPermutationOfWord(String word)
    {

        Set<String> set=new HashSet<>();
        set.add(word);
        char [] characters=word.toCharArray();
        for(int i=0;i<characters.length;i++)
        {
            characters=word.toCharArray();
            char w=characters[i];
            for(int j=1;j<characters.length ;j++)
            {
                if(i!=j)
                {
                    char temp=characters[j];
                    characters[j-1]=characters[j];
                    characters[j]=w;
                   String val= new String(characters);
                   if(!set.contains(val))
                   {
                       set.add(val);
                       System.out.println(val);
                   }else {
                       //System.out.println("-- ! word already present -- "+val);
                   }

                }
            }
        }

        System.out.println("size "+set.size());

        for (String val:set)
        {
          //  System.out.println(val);
        }

    }*/


    public static Set<String> permutationFinder(String str) {
        System.out.println("-->recurcer :"+str);
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                System.out.println("-->loop :"+str);
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    ///
 /*   public static Set<String> permutationFinderSelf(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        //Set<String> words = permutationFinder(rem);
        for (int i = 0; i < str.length(); i++) {
            char v=str.charAt(i);
            String newStr=removedCharString(str,i);
            for (int j = 0; j <= newStr.length(); j++) {

                    String gen=charInsert(newStr,v,j);
                   perm.add( gen);

            }
        }
        return perm;
    }

    public static String charInsertAndRemove(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static String removedCharString(String str, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j+1);
        return begin  + end;
    }*/

    public static void main(String[] args) {
        AprilTest21 aprilTest21=new AprilTest21();
        //aprilTest21.printPermutationOfWord("abc");
        System.out.println("----------- start ----------");
        Set<String> set = permutationFinder("abc");
        System.out.println("----------- result  ----------");
        System.out.println(set.toString());
        System.out.println("size :"+set.size());
        System.out.println("----------- end ----------");
        StringBuilder stringBuilder=new StringBuilder("fdffdfdfdfdfdd");
        stringBuilder.deleteCharAt(1);

    }
}
