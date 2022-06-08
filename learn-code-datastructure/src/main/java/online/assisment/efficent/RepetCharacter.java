package main.java.online.assisment.efficent;

import com.sun.tools.javac.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
public class RepetCharacter {
    /**
     * [103, 101, 101, 107, 115, 70, 111, 114, 103, 101, 101, 107, 115]
     * [70, 101, 101, 101, 101, 103, 103, 107, 107, 111, 114, 115, 115]
     *
     * @param args
     */
    public static void main(String[] args) {
        String word ="geeksForgeeks";
        String var="";
        byte [] byteArray=word.getBytes();
        char [] charArray=word.toCharArray();
        System.out.println(Arrays.toString(byteArray));
        Arrays.sort(charArray);
        System.out.println(Arrays.toString(charArray));
        var=var+charArray[1];
        System.out.println("index: "+('b'-'a'));


    }

    public void firstRepeatChar(String word,int length)
    {
        HashSet<Character> hashSet=new HashSet<>();
        for(int i=0;i<length;i++)
        {
            char character=word.charAt(i);
            if(hashSet.contains(character))
            {
                System.out.println("repeated character: "+character);
                break;
            }
            else {
                hashSet.add(character);
            }
        }

    }


}
