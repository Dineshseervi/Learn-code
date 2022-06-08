package main.java.dynamicprograming;

import java.util.Arrays;

public class LongestSubString {

    public int findLCSLength(String s1, String s2) {
        int maxLength = Math.min(s1.length(), s2.length());
        Integer[][][] dp = new Integer[s1.length()][s2.length()][maxLength];
        return findMaxCommonString(s1,s2); //findLCSLengthRecursive(s1, s2, 0, 0, 0,dp);
    }

    private int findLCSLengthRecursive(String s1, String s2, int i1, int i2, int count, Integer[][][] dp) {
        if(i1 == s1.length() || i2 == s2.length())
            return count;

        //System.out.println("print:"+dp[i1][i2][0]);
        //System.out.println("i j: "+i1 +"=="+i2);
        if(dp[i1][i2][count]==null)
        {
            int cA=count;
            if(s1.charAt(i1) == s2.charAt(i2))
            {
                cA = findLCSLengthRecursive(s1, s2, i1+1, i2+1, count+1,dp);
            }

            int c1 = findLCSLengthRecursive(s1, s2, i1, i2+1, 0,dp);
            int c2 = findLCSLengthRecursive(s1, s2, i1+1, i2, 0,dp);
            dp[i1][i2][count] = Math.max(cA, Math.max(c1,c2));
            //System.out.println("print:"+dp[i1][i2][count]  +"    _____count:"+count);
        }

        return dp[i1][i2][count];
    }

    public int findMaxCommonString(String s1,String s2)
    {
        int maxLen=0;
        int [][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++)
        {
            for (int j=1;j<=s2.length();j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    int val=previousVal(dp,i-1,j-1);
                    System.out.println("val:"+val);
                    dp[i][j] =1+  val;//dp[i-1][j-1];
                    maxLen=Math.max(maxLen,dp[i][j]);
                }
            }
        }

        for (int [] row:dp)
        {
            System.out.println(Arrays.toString(row));
        }
        return maxLen;
    }

    public int previousVal(int [][] dp,int i,int j)
    {
        for(int s=i;s>=0;s--)
        {
            if(dp[s][j]!=0)
            {
                return dp[s][j];
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        LongestSubString lcs = new LongestSubString();
        System.out.println(lcs.findMaxCommonString("abdca", "cbda"));
        //System.out.println(lcs.findLCSLength("passport", "ppsspt"));
        //System.out.println(lcs.findLCSLength("a12345", "6789a"));
    }
}
