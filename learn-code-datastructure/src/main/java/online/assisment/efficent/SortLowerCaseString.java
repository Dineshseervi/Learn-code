package main.java.online.assisment.efficent;

import  java.util.Arrays;
import java.util.Comparator;

public class SortLowerCaseString {
    public static void main(String [] args)
    {

        String val="geeksForgeeks";
        System.out.println("sorted string : "+sortCustomString(val));
    }

    public static String sortString(String val)
    {
        String sortedString="-1";
        if(val==null || val.length()==0)
        {
            return sortedString;
        }

        sortedString="";

        char [] charArray=val.toCharArray();
        Arrays.sort(charArray);
        sortedString=new String(charArray);
        return sortedString;
    }

    public static String sortCustomString(String val)
    {
        String sortedString="-1";
        if(val==null || val.length()==0)
        {
            return sortedString;
        }

        sortedString="";
        Character [] charArray=new Character[val.length()];
        for (int i=0;i<val.length();i++)
        {
            charArray[i]=val.charAt(i);
        }

        Arrays.sort(charArray,new Comparator<Character>() {
                    @Override
                    public int compare(Character ca, Character cb) {
                        return Character.compare(Character.toLowerCase(ca),Character.toLowerCase(cb));
                    }

                });
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<val.length();i++) {
            sb.append(charArray[i]);
        }

        return sb.toString();
    }
}
