package com.learn.online.question;

//https://leetcode.com/problems/combination-sum-iv/
// https://leetcode.com/problems/combination-sum-ii/ -->cover this (https://www.youtube.com/results?search_query=combination+sum+2)
// https://github.com/Algorithms-Made-Easy/Leetcode-Challenge
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {

        int [] dp = new int [target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++)
        {
            for(int n:nums)
            {
                if(i>=n)
                {
                    dp[i]+=dp[i-n];
                }
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {

    }
}
