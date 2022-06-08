package com.example.springapphz.teststream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static String getName(Integer number)
    {
        if(number>100)
        {
            return " "+System.currentTimeMillis();
        }else {
            return null;
        }
    }
    public static void main(String[] args)
    {

        System.out.println("The stream after applying "
                + "the function is : ");

        // Creating a list of Integers
        List<Integer> list = Arrays.asList(3, 6, 9, 12, 35);

        // Using Stream map(Function mapper) and
        // displaying the corresponding new stream
        List<String> nameList= list.stream().map(number -> number * 3).map(num->getName(num)).filter(name->name!=null).collect(Collectors.toList());
        System.out.println("size:"+nameList.size());
        System.out.println("print: "+nameList.toString());
    }
}
