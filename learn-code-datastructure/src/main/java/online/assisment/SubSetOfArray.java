package main.java.online.assisment;

import java.util.Arrays;
import java.util.HashSet;

public class SubSetOfArray {
    public static void main(String[] args) {
        int [] arra={2,1,2,1,3};
        int [] arra2=arra;
        Arrays.sort(arra2);
        System.out.println(Arrays.toString(arra));
        System.out.println(Arrays.toString(arra2));
        //int count=getSubSet(arra,2);
        //System.out.println("total sub-set: "+count);

    }

    /**
     * time complexity is O(nlogn)
     * space comples O(nlogn)
     * @param arr
     * @param m
     * @return
     */
    public static int getSubSet(int [] arr,int m)
    {
        HashSet<Integer> hashSet=new HashSet<>();
        int cout=0;
        for (int i=0;i<arr.length;i++)
        {
            int high=i;
            int increment=10;
            int number=0;
            int oddCount=0;
            while (high<arr.length)
            {
                int val=arr[high];
                if(val%2!=0)
                {
                    oddCount++;
                }
                if(oddCount>m)
                {
                    System.out.println("break");
                    break;
                }
                number=number*increment+val;
                if((number+"").length()==arr.length)
                {
                    break;
                }
                if(!hashSet.contains(number))
                {
                    cout++;
                    hashSet.add(number);
                    System.out.println("number:"+number);
                }
               // increment=increment*10;
                high++;

            }
        }

        return cout;
    }
}
