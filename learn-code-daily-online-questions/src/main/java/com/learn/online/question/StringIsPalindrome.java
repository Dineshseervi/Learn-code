package com.learn.online.question;

import org.junit.platform.commons.util.StringUtils;

public class StringIsPalindrome {
    public static boolean isStringPalindrome(String word)
    {
        if(StringUtils.isBlank(word))
        {
            return false;
        }
        if(word.length()==1)
        {
            return true;
        }
        else{
           /* int i=0;
            int j=word.length()-1;
            while (i<j)
            {
                if(word.charAt(i)==word.charAt(j))
                {
                    i++;
                    j--;
                }
                else {
                    return false;
                }

            }*/
            int m=word.length()/2;
            int l=word.length()-1;
            //r a d a r
            //0 1 2 3 4
            for(int i=0;i<m;i++)
            {
                if(word.charAt(i)!=word.charAt(l-i))
                {
                    return false;
                }
            }

        }
        return true;
    }
}
