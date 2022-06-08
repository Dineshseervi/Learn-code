package main.java.search;

public class SampleBS {

    private static   boolean isFound=false;
    private static void binarySearch(int [] arr,int key)
    {
        int index =  binarySearchDFS( arr, 0, arr.length-1, key);
        if(!isFound){
            if(index==0){
                System.out.println("number INDEX: "+ -1);
            }else {
                System.out.println("number lower "+ arr[index-1]);
            }
        }else {
            System.out.println("number INDEX: "+ index );
        }

    }

    private static int  binarySearchDFS(int[] arr, int start, int end, int key) {
        if(start>end)
        {
            System.out.println("start :"+start);
            System.out.println("key found KEY:"+key+" , at index : "+(-1));
            return start;
        }
        int middle=(start+end)/2;
        if(key==arr[middle])
        {
            isFound=true;
            System.out.println("... key found KEY:"+key+" , at index :"+(middle+1));
            return middle;
        }
        if(key>arr[middle])
        {
           return binarySearchDFS(arr,middle+1,end,key);
        }else {
           return binarySearchDFS(arr,start,middle-1,key);
        }

    }

    public static void main(String[] args) {

        //Sept19
        int [] arr ={1,2,3,4,5,6,7,9,23,27,35,37,45,47,55,57};
        System.out.println("array length :"+arr.length);
        binarySearch(arr,0);
    }
}
