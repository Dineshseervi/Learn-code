package main.java;





//import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.util.*;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        /*String name=new String();
        name="name=dinesh=last=seervi=address=abcder";
        String [] nam=name.split("=",2);
        System.out.println(Arrays.toString(nam));*/
        Scanner input = new Scanner(System.in);

        Map<String,String> person=new HashMap<>();
       // person.put("dinesh","dinesh seervi");
        person.put("DINESH","DINESH SEERVI");

        System.out.println(person.containsKey("DINESH"));
        String values=null;
        System.out.println("value "+values.split(";")[0]);


    }


}
