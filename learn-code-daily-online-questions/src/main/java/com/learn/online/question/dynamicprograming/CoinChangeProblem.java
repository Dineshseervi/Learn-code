package com.learn.online.question.dynamicprograming;

/**
 *
 */
public class CoinChangeProblem {

    private static int count = 0;

    public static void main(String[] args) {

        CoinChangeProblem coinChangeProblem = new CoinChangeProblem();

        int[] arr = {1, 2, 3};
        int sum = coinChangeProblem.coinChange(arr, 5);
        System.out.println("Sum: " + sum);
    }

    public int coinChange(int[] num, int k) {
        int sum = coinChangeTypeSecond(num, k, 0);
        return sum;
    }

    public int coinChangeTypeSecond(int[] num, int givenNumber, int index) {
        if (givenNumber == 0) {
            return 1;
        }
        if (givenNumber < 0 || index >= num.length) {
            return 0;
        }

        int sum1 = coinChangeTypeSecond(num, givenNumber - num[index], index);

        int sum2 = coinChangeTypeSecond(num, givenNumber, index+1);

        return sum1 + sum2;
    }

    //Tried but not worked
    public void coinChangeSub(int[] num, int k, int index) {
        int sum = 0;
        if (k == 0) {
            System.out.println("index: " + index);
            count++;
            return;
        }
        if (k < 0) {
            return;
        }
        if (k > 0) {
            for (int i = index; i < num.length; i++) {
                if (k >= num[index]) {
                    coinChangeSub(num, k - num[index], i);
                }
            }
        } else {
            return;
        }
        return;
    }
}
