package com.learn.online.question.card;

public class MaxPointFromCard {

    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        for(int i:cardPoints){
            sum+=i;
        }

        int ans =0, window =0;
        int n = cardPoints.length;

        if(n==k) return sum;

        for(int i=0;i<n-k-1;i++){
            window += cardPoints[i];
        }

        for(int i=n-k-1;i<n;i++){
            window += cardPoints[i];
            ans = Math.max(ans, sum - window);
            window -= cardPoints[i-(n-k-1)];
        }

        return ans;
    }

    public static void main(String[] args) {
        int [] array={1,79,80,1,1,1,200,1};
        MaxPointFromCard maxPointFromCard=new MaxPointFromCard();
        int sum=maxPointFromCard.maxScore(array,3);
        System.out.println("sum : "+sum);
    }
}
