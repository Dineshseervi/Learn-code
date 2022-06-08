package main.java.test;

class Knapsack {


    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        Integer [][] table=new Integer[capacity+1][weights.length+1];
        return solve(profits,weights,capacity,table);
    }

    public int solve(int[] profits, int[] weights, int capacity,Integer [][] table)
    {
        int maxWeight=0;
        int [] tab=new int[capacity+1];
        for(int i=0;i<capacity;i++)
        {
            int tabMax=0;
            for(int j=0;j<weights.length;j++)
            {
                if(i==0 && weights[j]<=capacity)
                {
                    maxWeight=Math.max(maxWeight,weights[j]);
                }
                int multiple=(i+1)/weights[j];
                table[i][j] = profits[j]*multiple;
                tabMax=Math.max(tabMax,table[i][j]);

            }
            tab[i]=tabMax;
        }
        int sum=0;
        int cap=capacity;

        int div=cap%maxWeight;
        sum=tab[div-1]+tab[maxWeight-1];

        return sum;


    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits ={15,20,50} ;//{ 15, 50, 60, 90 };
        int[] weights = {1,2,3} ;//{ 1, 3, 4, 5 };
        //cap =8
        int maxProfit = ks.solveKnapsack(profits, weights, 5);
        System.out.println(maxProfit);
    }
}

