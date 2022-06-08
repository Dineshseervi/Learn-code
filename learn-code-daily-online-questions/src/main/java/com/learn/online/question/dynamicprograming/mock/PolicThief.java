package com.learn.online.question.dynamicprograming.mock;

import java.util.ArrayList;
import java.util.List;

public class PolicThief {

    // P , T ,T, P , T , K=1
    // 0   1  2  3   4

    // T, T , P ,P , T, p , k=2
    // 0  1   2  3   4  5

    public static void main(String[] args) {

        // P = 0 ,3
        // T=  1 ,2, 4

        //P= 2 ,3, 5
        //T= 0,1,4
        //char [] arr={'P','T','T','P','T'};
        char [] arr={'T','T','P','P','T','P','P','T','T'};
        List<Integer> policeList=new ArrayList<>();
        List<Integer> thiefList= new ArrayList<>();

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='P')
            {
             policeList.add(i);
            }else{
                thiefList.add(i);
            }
        }
        PolicThief policThief=new PolicThief();
    int count=policThief.getCount(policeList,thiefList,2);
        System.out.println("count:"+count);
    }

    private int getCount(List<Integer> policeList,List<Integer> thiefList, int k)
    {
        int count=0;
        for(Integer police:policeList)
        {
            if(thiefList.isEmpty())
            {
                return count;
            }
            boolean flag=true;
            if(thiefList.get(0)<police) {
                int limit=k;
                while (limit >0 && flag) {
                   if( police-limit == thiefList.get(0))
                   {
                       count++;
                       thiefList.remove(0);
                       break;
                   }else {
                       limit--;
                   }
                }
            }else {
                int limit=1;
                while (limit <=k && flag) {
                    if( police+limit == thiefList.get(0))
                    {
                        count++;
                        thiefList.remove(0);
                        break;
                    }else {
                        limit++;
                    }
                }
            }

        }
        return count;
    }


}
