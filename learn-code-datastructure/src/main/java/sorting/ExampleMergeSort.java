package main.java.sorting;

public class ExampleMergeSort {

    public void sort(int[] array, int start, int end) {
        //System.out.println("--");
        if (start < end) {
            int middle = (start + end) / 2;
            sort(array, start, middle);   //first half
            sort(array, middle + 1, end);   //second half

            merge(array, start, end, middle);
            // sort();
        }
    }

    public void merge(int[] array, int start, int end, int middle) {
        int arraySizeL = middle - start + 1;
        int arraySizeR = (end - middle);

        int[] L = new int[arraySizeL];
        int[] R = new int[arraySizeR];

        for (int i = 0; i < arraySizeL; i++) {
            //start+i
            L[i] = array[start + i];
        }

        for (int j = 0; j < arraySizeR; j++) {
            //middle+1 +j
            //System.out.println(j +" mid-val:"+(middle + 1) +"   arraySizeR "+arraySizeR);
            R[j] = array[(middle + 1) + j];
        }

        int i = 0, j = 0;

        int k = start;

        while (i < arraySizeL && j < arraySizeR) {

            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < arraySizeL) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < arraySizeR) {
            array[k] = R[j];
            j++;
            k++;
        }

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {32, 5, 12, 2, 55, 1, 67, 99, 6,10};
        printArray(array);
        ExampleMergeSort exampleMergeSort = new ExampleMergeSort();
        exampleMergeSort.sort(array, 0, array.length-1);
        System.out.println("array after sorting");
        printArray(array);

    }
}
