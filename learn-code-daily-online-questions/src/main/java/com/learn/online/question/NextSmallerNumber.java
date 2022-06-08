package com.learn.online.question;

import java.util.*;

public class NextSmallerNumber {

    public static int[] printNextSmallerNumber(int[] arr)
    {
        //Null and empty array check
        if(arr!=null && arr.length<=0)
        {
            return arr;
        }
        int result [] =new int[arr.length];

        //time complexity will be o(n*n) in worse case
        //space complexity is o(n)
        for(int i=0;i<arr.length;i++)
        {
            result[i]=-1;
            for (int j=i+1;j<arr.length;j++)
            {
               if( arr[i]>arr[j])
               {
                   result[i]=arr[j];
                   break;
               }
            }
        }
        return result;
    }


    public static int [] printNextSmallerNumberLessComplexTime(int [] arr)
    {
        //Null and empty array check
        if(arr!=null && arr.length<=0)
        {
            return arr;
        }
        //array to return element ns numbers
        int result [] =new int[arr.length];

        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<arr.length;i++)
        {
            //if stack is empty push the element directly
            if(stack.isEmpty())
            {
                stack.push(arr[i]);
                continue;
            }

            // if stack is having is number greater the current number then current number  is next
            // small number for current number , pick the number and mark this number as next lower numeber
            // repeat the same step untill we found a lower number then current number
            while (!stack.isEmpty() && stack.peek()>arr[i])
            {
                map.put(stack.peek(),arr[i]);
                stack.pop();
            }
            //now push the current number in stack
            stack.push(arr[i]);

        }

        // as remaining number not having and next small number assign all number with -1
        while (!stack.isEmpty())
        {
            map.put(stack.peek(),-1);
            stack.pop();
        }
        for(int i=0;i<arr.length;i++)
        {
            result[i]=map.get(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();

    }
 }
