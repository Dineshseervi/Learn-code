package main.java.search;

import main.java.sorting.ExampleMergeSort;

public class ExampleBinarySerach {

    public Integer binarySearch(int [] array,int start,int end,int findNumber)
    {
        if(start<=end)
        {
            int middle=(start+end)/2;
            if(array[start]==findNumber)
            {
                return start;
            }
            if(array[end]==findNumber)
            {
                return end;
            }
            if(array[middle]==findNumber)
            {
                return middle;
            }

            if(/*findNumber>array[start] && */findNumber<array[middle])
            {
                return binarySearch(array,start,middle-1,findNumber);
            }
            return binarySearch(array,middle+1,end,findNumber);
            /*else if(findNumber<array[end] && findNumber>array[middle])
            {
                return binarySearch(array,middle+1,end,findNumber);
            }*/
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {32, 5, 12, 2, 55, 1, 67, 99, 6,10};
        ExampleMergeSort exampleMergeSort=new ExampleMergeSort();
        exampleMergeSort.sort(array,0,array.length-1);
        ExampleMergeSort.printArray(array);
        int findNumber= 10;
        ExampleBinarySerach exampleBinarySerach=new ExampleBinarySerach();
        int possition= exampleBinarySerach.binarySearch(array,0,array.length-1,findNumber);
        System.out.println(" position: "+possition);
    }

    // r], else return -1
   /* int binarySearch(int arr[], int l, int r, int x)
    {
        System.out.println("loop");
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        ExampleBinarySerach ob = new ExampleBinarySerach();
        int arr[] = { 1,2,5,6,10,12,32,55,67,99 };
        int n = arr.length;
        int x = 66;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present ");
        else
            System.out.println("Element found at index " + result);
    }*/
}
