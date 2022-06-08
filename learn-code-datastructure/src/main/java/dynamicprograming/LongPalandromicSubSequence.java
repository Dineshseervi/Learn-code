package main.java.dynamicprograming;

/**
 * adbdca
 * ------
 * We need to find max subsequence size we can form from given string
 */
public class LongPalandromicSubSequence {

    private  static int count=0;
    private int getLongestPalandromicSubSequence(String st)
    {
        Integer [][]dp=new Integer[st.length()][st.length()];
        int result= brutForceWithDp(st,0,st.length()-1,dp);
        System.out.println("number of element to be removed:"+(st.length()-result));
        return result;
    }


    //Time complexity is O(n*n) and space complixty is O(N*N) for dp
    private int brutForceWithDp(String st,int startIndex , int endIndex,Integer [][]dp)
    {
        count++;
        if(startIndex>endIndex )
        {
            return 0;
        }
        if(startIndex==endIndex)
        {
            return 1;
        }
        if(dp[startIndex][endIndex]==null)
        {
        if(st.charAt(startIndex)==st.charAt(endIndex))
        {
            System.out.println("start index"+startIndex+" endIndex:"+endIndex);
            dp[startIndex][endIndex] = 2 + brutForceWithDp(st,startIndex+1,endIndex-1,dp);
        }else {
            int a = brutForceWithDp(st, startIndex, endIndex - 1, dp); //exclude endIndex char for endIndex we will reduce by one.
            int b = brutForceWithDp(st, startIndex + 1, endIndex, dp); //exclude start index char,for start of index we will increase by one.
            dp[startIndex][endIndex] = Math.max(a, b);
        }
        }
        return dp[startIndex][endIndex];

    }


    private int brutForce(String st,int startIndex , int endIndex)
    {
        count++;
        if(startIndex>endIndex )
        {
            return 0;
        }
        if(startIndex==endIndex)
        {
            return 1;
        }

            if(st.charAt(startIndex)==st.charAt(endIndex))
            {

                return   2 + brutForce(st,startIndex+1,endIndex-1);
            }else {
                int a = brutForce(st, startIndex, endIndex - 1); //exclude endIndex char for endIndex we will reduce by one.
                int b = brutForce(st, startIndex + 1, endIndex); //exclude start index char,for start of index we will increase by one.
                return   Math.max(a, b);
            }
    }
    public static void main(String[] args) {
        LongPalandromicSubSequence longPalandromicSubSequence=new LongPalandromicSubSequence();
        //total loops483380
        System.out.println( longPalandromicSubSequence.getLongestPalandromicSubSequence("abdbcaabcdefghijklm"));
        System.out.println("total loops"+count);
    }
}
