package com.learn.online.question.array;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CityZero1466 {
    int count=0;
    public int minReorder(int n, int[][] connections) {
        count=0;
        List<Integer> right=new ArrayList<>();
        //boolean [] row=new boolean [connections.length];
        //Map<Integer,Integer> up=new ConcurrentHashMap<>();
        Map<Integer,Integer> down=new ConcurrentHashMap<>();

        //Integer count=0;

        for(int [] a:connections)
        {
            int nn = a[0];
            int m = a[1];
            if(m == 0)
            {
                right.add(nn);
            }
            else if(nn == 0)
            {
                right.add(m);
                count++;
            }else if(right.contains(m))
            {
                right.add(nn);
            }else if(right.contains(nn))
            {
                right.add(m);
                count++;
            }else{
               // up.put(nn,m);
                down.put(m,nn);

            }

        }
        if(down.size()>0)
        {
            resovlePath(right,down);
        }

        return count;
    }

    private void resovlePath(List<Integer> right,Map<Integer,Integer> down )
    {
        Set<Integer> set=down.keySet();
        for(int i:set)
        {
            if(down.containsKey(i))
            {
                if(right.contains(i))
                {
                    right.add(down.get(i));
                    down.remove(i);

                }
                else if(right.contains(down.get(i))){
                    count++;
                    right.add(i);
                    down.remove(i);
                }
                else{
                    int nn=i;
                    int m=down.get(i);
                    down.remove(i);
                    resovlePath(right,down);
                    if(right.contains(nn))
                    {

                        right.add(m);
                    }
                    else{
                        count++;
                        right.add(nn);
                    }
                }

            }
        }

        //for()
    }

    public static void main(String[] args) {
        CityZero1466 cityZero1466=new CityZero1466();
        int [] [] arr={{0,2},{0,3},{4,1},{4,5},{5,0}};
        System.out.println(cityZero1466.minReorder(6,arr));
    }

}
