package main.java.thread.example.mergesort;

import java.util.Random;

public class SequenceMergeSort {
    public static Integer MAX_ARRAY_SIZE=9000;

    private   Integer [] array;
    private Integer size;

    public SequenceMergeSort(Integer [] array)
    {
        this.array=array;
        this.size=array.length;
    }

    public void mergeSort()
    {
        merge(0,size-1);
       for(int i=0;i<size;i++)
       {
           //System.out.print(array[i]+" ");
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
        SequenceMergeSort sequenceMergeSort=new SequenceMergeSort(array);
        long start =System.currentTimeMillis();
        sequenceMergeSort.mergeSort();
        System.out.println("\n end time : "+(System.currentTimeMillis()-start));

    }
}
