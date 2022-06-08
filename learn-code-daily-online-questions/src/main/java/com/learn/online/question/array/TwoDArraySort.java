package com.learn.online.question.array;

import java.util.Arrays;

public class TwoDArraySort {
    public static int[][] sortArray(int [][] array)
    {
        Arrays.sort(array,(a,b)->a[1]-b[1]);
        return array;
    }

    public static void main(String[] args) {
        int [][] array={{100,200},{200,1300},{1000,1250},{2000,3200}};
        int [][] sortedArray=sortArray(array);
        System.out.println(Arrays.deepToString(sortedArray));
    }
}
