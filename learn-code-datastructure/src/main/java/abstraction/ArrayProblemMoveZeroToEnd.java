package main.java.abstraction;

import java.util.Arrays;

public class ArrayProblemMoveZeroToEnd {

    public static void main(String[] args) {
    int [] arr={1,2,0,4,0,6,0,7,8,9};
    ArrayProblemMoveZeroToEnd arrayProblemMoveZeroToEnd=new ArrayProblemMoveZeroToEnd();
    arrayProblemMoveZeroToEnd.sortZero(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sortZero(int [] arr)
    {
        //int zeroCount=0;
        int currentIndex=0;
        for (int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0) {
                arr[currentIndex]=arr[i];
                currentIndex++;
            }
        }
        for(int i=currentIndex;i<arr.length;i++)
        {
            arr[i]=0;
        }
    }
}
