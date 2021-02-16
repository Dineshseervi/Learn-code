package main.java.online.assisment;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        //System.out.println(9%3);
        //int n=null;
       //int val= findSmallestDivisor("abcdabcd","abcdabcd");
        //System.out.println(val);
        int [] array={2,1,2,1,3};
      int val=  countSubarrays(array,array.length,2);
        System.out.println(val);

    }


    public static int findSmallestDivisor(String s, String t) {
        // Write your code here
        int subSetLength=t.length();
        if(s.length()%subSetLength!=0)
        {
            return -1;
        }
        int i=0;
        int j=0;

        while(i<s.length())
        {
            if(s.charAt(i) == t.charAt(j))
            {
                i++;
                j++;
                if(j == subSetLength)
                {
                    j=0;
                }
            }
            else{
                return -1;
            }
        }

        int val=findSmallestDivisor(t,t.substring(0,subSetLength/2));
        if(val==-1)
        {
            return subSetLength;
        }
        else{
            return val;
        }

        //return -1;
    }


    static int countSubarrays(int a[], int n, int m)
    {

        int count = 0;

        // traverse for all possible
        // subarrays
        for (int i = 0; i < n; i++)
        {
            int odd = 0;
            for (int j = i; j < n; j++)
            {
                if (a[j] % 2 == 0)
                    odd++;

                // if count of odd numbers
                // in subarray is m
                if (odd <= m)
                    count++;
            }
        }

        return count;
    }

   /* public static int evenSubarray(List<Integer> numbers, int k) {
        // Write your code here

        for(int i=0;i<numbers.size();i++)
        {
            numbers.get(i);
        }
    }*/
}
