package com.learn.online.question;

import java.util.PriorityQueue;

public class RefullingStop {

    //bfs
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        int n=stations.length;
        int distance=startFuel;
        int i=0,refill=0;
        while(distance<target)
        {
            while (i<n && distance>=stations[i][0])
            {
                pq.add(stations[i]);
                i++;
            }
            if(pq.isEmpty())
            {
                return -1;
            }
            distance+=pq.remove()[1];
            refill++;
        }
        return refill;


    }
}
