package main.java.online.assisment.efficent;

import java.util.HashSet;

public class ProductPair {
    public static void main(String[] args) {

        int [] array={10,20,9,40};
        System.out.println("isProduct : "+isProductPairExists(array,array.length,400));
    }

    static boolean isProductPairExists(int [] arr,int size,int product)
    {
        if(size<2)
        {}
        HashSet<Integer> hashSet=new HashSet<>();
        for(int i=0;i<size;i++)
        {
            if(arr[i]==product)
            {
                return true;
            }

            if(hashSet.contains(product/arr[i]))
            {
                return true;
            }
            else {
                hashSet.add(arr[i]);
            }
        }
        return false;
    }
}
