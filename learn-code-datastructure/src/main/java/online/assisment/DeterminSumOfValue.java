package main.java.online.assisment;

import java.util.HashSet;
import java.util.Set;

public class DeterminSumOfValue {

    public static void main(String [] arg)
    {
        Integer [] array={5,7,20,15,13,9,4,2,3};
        Integer value=8;
        boolean isSumExist=isSumOfNumberExistes(value,array);
        System.out.println("value :"+value+" isPresent :"+isSumExist);
    }

    /**
     * Time complexity is O(n)
     * Space complexity is O(n-1)
     *
     * We will check if values-a is present in hashSet or not , as value-a is already visited in hash .
     * If val-a does not present then we will add a in hasSet.
     * so concept here is value-a=c and a are sum of value, If we exhausted all the element in the array then
     * we will return false as sum of value is not found.
     * @param value
     * @param array
     * @return
     */
    public static boolean isSumOfNumberExistes(Integer value,Integer [] array)
    {
        Set<Integer> arraySet=new HashSet<>();// Why we had used set as list is not hash based time of search is more in list
        for (Integer a:array) {
            if (arraySet.contains(value -a))
            {
                return true;
            }
            arraySet.add(a);
        }
        return false;
    }



}
