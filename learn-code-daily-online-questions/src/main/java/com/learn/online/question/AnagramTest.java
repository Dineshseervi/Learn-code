package com.learn.online.question;

public class AnagramTest {
    public static boolean isAnagram(String firstWord, String secondWord)
    {
        if(firstWord==null || secondWord==null)
        {
            return false;
        }
        firstWord=firstWord.toLowerCase().trim();
        secondWord=secondWord.toLowerCase().trim();
        if(firstWord.length()!=secondWord.length())
        {
            return false;
        }

        char [] chars=firstWord.toCharArray();

        for (char f:chars)
        {
           int index= secondWord.indexOf(f);
           if(index==-1)
           {
               return false;
           }
           secondWord=secondWord.substring(0,index)+secondWord.substring(index+1);
        }
        return secondWord.isEmpty();
    }



    public  void main(String[] args) {
        boolean isAnagram=isAnagram("abcd ","ABCD");
        System.out.println("status:"+isAnagram);
    }

}
