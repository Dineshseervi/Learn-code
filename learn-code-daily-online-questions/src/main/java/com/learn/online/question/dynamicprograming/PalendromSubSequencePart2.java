package com.learn.online.question.dynamicprograming;

// abdbca
public class PalendromSubSequencePart2 {

    public static void main(String[] args) {
         String word="abdbca";
         String word2="cddpd";
         String word3="pqr";
            int count=PalendromSubSequencePart2.checkSubString(word2,0,word2.length()-1);
        System.out.println(count);
    }

    public  static int  checkSubString(String word,int i ,int j)
    {
        if(i>j || i>=word.length() || j<0 )
        {
            return 0;
        }
        if(i==j)
        {
            return 1;
        }
        if(word.charAt(i)==word.charAt(j))
        {
            return 2+ checkSubString(word,i+1,j-1);
        }
        else{
            int left=checkSubString(word,i+1,j);
            int right=checkSubString(word,i,j-1);
            return Math.max(left,right);
        }

    }
}
