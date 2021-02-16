package main.java.online.assisment;

public class Solution {

    public static void main(String[] args) {
        String s="aaaabbaa";
        System.out.println("Palindrome : "+longestPalindrome(s));
    }

    /**
     * Time com=O(n*n)
     * space complexity O(1)
     * @param S
     * @return
     */
    public static  String longestPalindrome(String S) {
        // code here
        return getPalandrom(S , S.length());
    }

    static String getSubstring(String s,int low,int high)
    {
        return s.substring(low,high);
    }

    static String getPalandrom(String s,Integer length)
    {
        int start= 0;
        int max= 1;

        int low,high;

        for(int i=1;i<length;i++)
        {
            low=i-1;
            high=i;
            while(low>=0 && high<length && (s.charAt(low) == s.charAt(high)))
            {
                if((high-low) + 1>max)
                {
                    start=low;
                    max=(high- low) +1;
                }
                low--;
                high++;
            }

            low =i-1;
            high =i+1;
            while(low>=0 && high<length && (s.charAt(low) == s.charAt(high)))
            {
                if((high - low) +1>max)
                {
                    start=low;
                    max=(high-low)+1;
                }
                low--;
                high++;
            }

        }

        return getSubstring(s,start,start+max);
    }
}
