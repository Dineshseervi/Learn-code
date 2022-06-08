package com.learn.online.question.dynamicprograming;

public class StairCase {
    public static void main(String[] args) {
        int [] jumps={2,3,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Integer [] dp=new Integer[jumps.length+1];
       int count= StairCase.countJumps(jumps,0,dp);
        System.out.println(count);
    }


    //Bottom Up approch
    public static int countJumps(int [] jumps,int index ,Integer [] dp )
    {
        if(index>=(jumps.length-1))
        {
            return 0;
        }
        int val=jumps[index];
        if(dp[index]==null) {
            int minPumps = Integer.MAX_VALUE;

            for (int i = 1; i <= val; i++) {
                int result = 1 + countJumps(jumps, index + i, dp);
                minPumps = Math.min(result, minPumps);
            }
            dp[index]=minPumps;
        }
        return dp[index];
    }
}
