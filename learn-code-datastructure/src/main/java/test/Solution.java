package main.java.test;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] strs={"10","0001","111001"};
       // String[] strs={"011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"};
        int m=5;
        int n=3;
       int val= solution.findMaxForm(strs,m,n);
        System.out.println("val :"+val);
        String dd="fdfd";
        dd.length();
        System.out.println();
    }

    int[] count(String s){
        int[] count=new int[2];
        for(char c: s.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for(String s:strs){
            int[] count = count(s);
            //zero m-count[0]  ---- 0
            //one n - count[1] ---- 0
            for(int zero=m;zero>=count[0];zero--){
                for(int one=n; one>=count[1]; one--){
                    dp[zero][one] = Math.max(dp[zero-count[0]][one-count[1]] +1 , dp[zero][one]);
                }
            }
        }


        return dp[m][n];
       /* Num [] numS=new Num [strs.length];
        System.out.println("length :"+strs.length);
        for(int i=0;i<strs.length;i++)
        {
            int s1=0;
            int s0=0;
            char [] cc=strs[i].toCharArray();
            for(char c:cc)
            {
                if(c=='0')
                {
                    s0++;
                }else{
                    s1++;
                }
            }
            numS[i]=new Num(s1,s0);


        }

        int count=0;

        for(int i=0;i<strs.length;i++)
        {
            int cc=0;
            int ss1=0;
            int ss0=0;

            for(int j=0;j<strs.length;j++)
            {
                if(j==i)
                {
                    continue;
                }
                int s1=numS[j].s1;
                int s0=numS[j].s0;
                if(s1 == n && s0 == m)
                {
                    if(count<1)
                    {
                        count++;
                    }
                    continue;
                }
                if(s1<=n && s0<=m)
                {
                    if((s1+ss1)<=n && (s0+ss0)<=m )
                    {
                        ss1+=s1;
                        ss0+=s0;
                        cc++;
                    }
                }

            }
            System.out.println("ss1+: "+ss1);
            System.out.println("ss0+: "+ss0);
            if(*//*ss1==n && ss0==m &&*//* cc>count)
            {
                count=cc;

            }
        }
        return count;*/
    }

    class Num{
        public int s1;
        public int s0;

        public Num(int s1,int s0)
        {
            this.s1=s1;
            this.s0=s0;
        }
    }
}

