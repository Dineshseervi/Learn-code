package com.learn.online.question;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FirstNonRepeatingChar {


    public static char getFirstNonRepeatingChar(String word)
    {

       /* List<Character> collectionOfChar=new ArrayList<>();
        int [] alpha=new int[26];

        char [] chars=word.toCharArray();
        for (char w:chars)
        {
            int i=0;
            if( (i=collectionOfChar.indexOf(w)) !=-1 )
            {
                collectionOfChar.remove(i);
            }else {
                if(alpha[w-'a']==0) {
                    collectionOfChar.add(w);
                    alpha[w - 'a'] = 1;
                }
            }
        }
        if(collectionOfChar.isEmpty())
        {
            throw new RuntimeException("no non repeating char");
        }
        return collectionOfChar.get(0);*/

        Map<Character,Integer> counts = new LinkedHashMap<>(word.length());

        for (char c : word.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");

    }
    public static void main(String[] args) {
        char w=getFirstNonRepeatingChar("ddinesh seervinhrvz");
        System.out.println("char: "+w);
    }


    /**
     * https://howtodoinjava.com/junit-5-tutorial/
     */
    @Test
    public void testAnagram()
    {
        Assert.assertEquals('d',getFirstNonRepeatingChar("dinnesh"));
    }

    @BeforeEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }

    @Test
    public void testOnDev()
    {
        System.setProperty("ENV", "DEV");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), FirstNonRepeatingChar::message);
    }

    @Test
    public void testOnProd()
    {
        System.setProperty("ENV", "PROD");
        Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
    }

    private static String message () {
        return "TEST Execution Failed :: ";
    }
}
