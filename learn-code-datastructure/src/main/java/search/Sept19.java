package main.java.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * {@link SampleBS} to point to a class
 * {@link IndexPairString indexPair} to point to class with given label .
 * {@link #subsets(int[], int) calculateSet}
 * {@link ExampleBinarySerach#binarySearch(int[], int, int, int)}
 * {@linkplain ExampleRecursiveSubStringSearch#searchSubStringInMainString(char[], char[])}
 *
 *
 * @author dineshseervi
 *
 */
public class Sept19 {

    /**
     * The default value of this field is {@value}
     * When {@link #MAX_SOCKET_TIMEOUT} is {@value MAX_SOCKET_TIMEOUT}
     */
    public static final String MAX_CONNECTION_TIMEOUT="30 could be connection timeout";


    public static final String MAX_SOCKET_TIMEOUT="15 min of socket timeout";


    /**
     *
     * Get the address of burger shop . The address if of following format
     * {@code
     * address line1
     * address line2
     * zip code city
     * }
     * @return the address of Burger shop or {@code null} is invalid input is provided .
     */
    public String getAddress()
    {
        return null;
    }





    //1,2,3,4,5
    // []
    //1 , 1 2 ,1 3 ,1 4 ,1 5 ,1 2 3, 124 ,125 ,134 ,135, 145, 12345, 1345,
    //2 , 2 3 ,24, 25 ,234, 235, 2345
    //3`, 34 ,35,345
    //4 ,45
    //5




    //List<List<Integer>> list=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {


        //for()
       /*
       List<List<Integer>> list = subsets(nums,0);
        list.add(0,new ArrayList<>());
        return list;
        */

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        List<List<Integer>> extra = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            for(List<Integer> r : res){
                List<Integer> rr = new ArrayList<>(r);
                rr.add(nums[i]);

                extra.add(rr);
            }
            res.addAll(extra);
            extra.clear();
        }

        return res;
    }


    public List<List<Integer>> subsets(int[] nums,int count) {

        List<List<Integer>> list=new ArrayList<>();

        if(count == nums.length)
        {
            return list;
        }

        list=subsets(nums,count+1);
        List<List<Integer>> newList1=new ArrayList<>();
        for(List<Integer> oi:list)
        {
            List<Integer> copy = oi.stream().collect(Collectors.toList());
            copy.add(0,nums[count]);
            newList1.add(0,copy);
        }
        list.addAll(newList1);

        List<Integer> newList=new ArrayList<>();
        newList.add(nums[count]);
        list.add(0,newList);

        return list;
    }

    public static void main(String[] args) {
        /*List<Integer> list=new ArrayList<>();
        list.add(10);
        System.out.println(list.size());
        List<Integer> copy = list.stream()
                .collect(Collectors.toList());
        System.out.println(copy.size());
        copy.add(9);
        System.out.println(copy.size());
        System.out.println(list.size());*/

        String var="()";
        List<String> list=new ArrayList<>();
        list.add("()(()())");
        System.out.println(list.contains("()(()())"));


    }
}
