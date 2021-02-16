package main.java.thread.example.mergesort;

import java.util.Random;

public class ParallelProcessMergeSort {
    public static Integer MAX_ARRAY_SIZE=9000;

    private   Integer [] array;
    private Integer size;

    public ParallelProcessMergeSort(Integer [] array)
    {
        this.array=array;
        this.size=array.length;
    }

    private void parallelMergeSort(int low ,int high,int numberOfThread)
    {
        if(numberOfThread<=1)
        {
            merge(low,high);
            return;
        }
        int middle=(low+high)/2;

        Thread t1=mergeSortParallel(low,high,numberOfThread);
        Thread t2=mergeSortParallel(low,high,numberOfThread);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        merge(low,high);
    }

    private Thread mergeSortParallel(int low ,int high,int numberOfThread)
    {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                parallelMergeSort(low,high,numberOfThread/2);
            }
        });
    }

    public void parallelMergeSort()
    {
        parallelMergeSort(0,size-1,6);
       for(int i=0;i<size;i++)
       {
           System.out.print(array[i]+" ");
       }
    }

    private void merge(Integer low,Integer high)
    {
        if(low>=high)
        {
            return;
        }
        int mid=(low+high)/2;
        merge(low,mid);
        merge(mid+1,high);
        sort(low,high);
    }


    private void sort(Integer low ,Integer high)
    {
        Integer [] temp= new Integer [size];
        for (int i=low;i<=high;i++)
        {
            temp[i]=array[i];
        }

        int i=low;
        int mid=(high+low)/2;
        int j=mid+1;
        int k=low;

        while (i<=mid && j<=high)
        {
            if(temp[i]<temp[j])
            {
                array[k]=temp[i];
                i++;
                k++;

            }
            else {
                array[k]=temp[j];
                j++;
                k++;
            }

        }
        while (i<=mid)
        {
            array[k]=temp[i];
            i++;k++;
        }

        while (j<=high)
        {
            array[k]=temp[j];
            j++;k++;
        }
    }


    public static void main(String[] args) {
        Random random=new Random();
        Integer [] array=new Integer[MAX_ARRAY_SIZE];
        for(int i=0;i<MAX_ARRAY_SIZE;i++)
        {
            array[i]=random.nextInt(5000);
        }
        ParallelProcessMergeSort sequenceMergeSort=new ParallelProcessMergeSort(array);
        long start =System.currentTimeMillis();
        sequenceMergeSort.parallelMergeSort();
        System.out.println("\n end time : "+(System.currentTimeMillis()-start));

    }
}
