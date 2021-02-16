package main.java.online.assisment;

import java.util.Arrays;
import java.util.Comparator;

public class ActivityCount {

    /**
     * time complexity O(n)
     * total time complexity if not sorted is o(n) + o(nLog-n)=~>O(nlog-n)
     * if sorted then its o(n) +O(n)=O(n)
     * space complexity=>O(1)
     * @param activities
     * @return
     */
    public static Integer getTotalActivity(Activity [] activities)
    {
        Compare.compare(activities);
        int arraySize=activities.length;
        int i=0;
        Integer activity=1;
        for(int j=1;j<arraySize;j++)
        {
            if(activities[i].finished<activities[j].start)
            {
                i=j;
                activity++;
            }
        }



        return activity;
    }

    public static int peakElement(int[] arr,int n)
    {
        //add code here.
        // Your code here
        int indexOfPeek=0;
        int max=arr[0];
        for(int i = 1; i<n ;i++)
        {
            if(max<arr[i])
            {
                max = arr[i];
                indexOfPeek=i;
            }
        }
        System.out.println("indexOfPeek :"+indexOfPeek);
        return indexOfPeek;
    }

    public static void main(String[] args) {
        /*Activity arr[] = new Activity[6];
        arr[0] = new Activity(5, 9);
        arr[1] = new Activity(1, 2);
        arr[2] = new Activity(3, 4);
        arr[3] = new Activity(0, 6);
        arr[4] = new Activity(5, 7);
        arr[5] = new Activity(8, 9);
        System.out.println("Activities: "+getTotalActivity(arr));*/
        int [] array={4,3,6,8,9};
        peakElement(array,5);
    }
}

class Activity
{
     Integer start;
     Integer finished;

    public Activity(int start,int finished)
    {
        this.start=start;
        this.finished=finished;
    }
}

class Compare
{
    /**
     * Time complexity ->O(nlog-n)
     * @param array
     */
    public static void compare(Activity [] array)
    {
        Arrays.sort(array, new Comparator<Activity>() {
            @Override
            public int compare(Activity a, Activity b) {
                return a.finished-b.finished;
            }
        });
    }
}