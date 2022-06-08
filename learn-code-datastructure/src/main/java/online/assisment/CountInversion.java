package main.java.online.assisment;

public class CountInversion {

    public static void main(String[] args) {
        Integer [] data={3, 1, 2};
        System.out.println("inversionCount: "+countInversion(data));
    }

    //I went to solution with out looking into time complexity and space complexity
    //time =O(n^2) ,two nested loop are required to count the inversion count
    //max time O(n^2) and min time O(n)
    //space complexity= O(1),No extra space is required.
    // we are checking is there is no element to be sorted then break the outer loop and return the count.this way if array is sorted the we can reutrn in O(n) time

    private static Integer countInversion(Integer[] data) {

        int arrayLength=data.length;
        boolean isSorted=false;
        int inversionCount=0;
       for(int i=0;i<arrayLength;i++)
       {
           isSorted=true;
           for(int j=0;j<arrayLength-1;j++)
           {
               if(data[j]>data[j+1])
               {
                   int temp=data[j];
                   data[j]=data[j+1];
                   data[j+1]=temp;
                   inversionCount++;
                   isSorted=false;
               }
           }
           if(isSorted)
           {
               System.out.println("break");
               break;

           }
       }
        return inversionCount;
    }
}
