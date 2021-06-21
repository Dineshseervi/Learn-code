package main.java.thread.example.executer;


import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

public class TestPAttern {

    /*public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,Comparator.comparing(o->o[0]));
        //Arrays.sort(envelopes,(a,b)->a[0]-b[0]);
        int count =1;
        int  [] dp=new int[envelopes.length];
        dp[0]=1;

        for(int i = 1; i <envelopes.length; i++)
        {
            dp[i]=1;
            for (int j = 0; j <i; j++) {
                if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);

                }
            }
            count=Math.max(dp[i],count);
        }
        return count;
    }*/

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);

        int[] dp = new int[envelopes.length];
        int maxlen=0;

        for(int i=0;i<dp.length;i++){

            //find the index of heioght of envelope[i]
            int index = binarySearch ( dp, 0, maxlen, envelopes[i][1]);

            dp[index] = envelopes[i][1];

            if(index == maxlen){
                maxlen++;
            }

        }
        System.out.println("dp"+Arrays.toString(dp));
        return maxlen;
    }

    /*static int  binarySearch(int[] arr , int start, int end, int target){
        int index = Arrays.binarySearch(arr,start,end,target);
        if(index<0){
            index = -(index+1);
        }
        return index;
    }*/

    static  int binarySearch(int[] arr , int start, int end, int target){
        while(start<end){
            int mid= start + (end - start)/2;

            if(arr[mid]==target){
                return mid;
            }

            else if(arr[mid]>target){
                end = mid;
            }
            else{
                start = mid +1 ;
            }
        }
        return start;
    }

    public static void main(String[] args) {

        //int [][] env={{2,3},{1,2},{3,4},{4,5},{5,6},{5,5},{6,7},{7,8}};
        int [][] env={{3,200},{2,100},{4,300},{5,400},{5,500},{6,370},{6,360},{7,380},{7,390}};
        //Arrays.sort(env,Comparator.comparing(o->o[0]));
        // Arrays.sort(env,(a,b)->a[0]-b[0]);
        Arrays.sort(env,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        for (int row = 0; row < env.length; row++) {
            for (int col = 0; col < env[row].length; col++) {
                System.out.print(" "+ env[row][col] );
            }
            System.out.println(" -");
        }
        System.out.println("count : "+TestPAttern.maxEnvelopes(env));
    }
}
