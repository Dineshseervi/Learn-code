package main.java.thread.example.executer;

import java.util.Arrays;
import java.util.HashMap;

public class UnderGroundRailway {
    public static void main(String[] args) {
        /*int [] min={186,419,83,408};
       int count= coinChange(min,6249);*/

        int [] min={1,2,5};
        int count= coinChange(min,11);
        System.out.println("cout :"+count);
    }

    public  static int coinChange(int[] coins, int amount) {

        if(amount==0)
        {
            return 0;
        }else {

            Arrays.sort(coins);
            int dp[]=new int[amount+1];
            Arrays.fill(dp,amount+1);
            dp[0]=0;
            for (int i=0;i<=amount;i++)
            {
                System.out.println("i  ->"+i);
                for (int j=0;j<coins.length;j++)
                {
                    System.out.println("j  ->"+j);
                    if(coins[j]<=i)
                    {
                        dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                        System.out.println("key : "+i+"  dp[i]: "+dp[i] );
                    }else{
                        break;
                    }
                }
            }
            return dp[amount]>amount?-1:dp[amount];
        }
    }
}

class UndergroundSystem {

    HashMap<Integer,Detail> detailMap=null;
    HashMap<String ,Avg> avgMap=null;
    public UndergroundSystem() {
        detailMap=new HashMap<>();
        avgMap=new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        detailMap.put(id,new Detail(stationName,t));
    }

    public void checkOut(int id, String stationName, int t) {
        Detail d= detailMap.remove(id);
        int time=t-d.t;
        String key=d.stationName+"-"+stationName;
        if(avgMap.containsKey(key))
        {
            Avg avg=avgMap.get(key);
            avg.updateSum(time);
            avgMap.put(key,avg);
        }
        else{
            avgMap.put(key,new Avg(time));
        }

    }

    public double getAverageTime(String startStation, String endStation) {
        String key=startStation+"-"+endStation;
        return avgMap.get(key).getTimeAvg();
    }
}

class Detail{
    public String stationName;
    public Integer t;

    public Detail(String stationName, int t)
    {
        this.stationName=stationName;
        this.t=t;
    }
}

class Avg
{
    public Integer sum=0;
    public Integer count=0;
    public Avg(Integer sum)
    {
        this.sum=sum;
        this.count=1;
    }
    public double getTimeAvg()
    {
        return (double)(sum)/(count);
    }

    public void updateSum(Integer sum)
    {
        this.sum+=sum;
        this.count++;
    }

}


