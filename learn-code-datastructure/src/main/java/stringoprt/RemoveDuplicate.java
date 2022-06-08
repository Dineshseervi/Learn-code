package main.java.stringoprt;

import java.util.LinkedList;

//Remove all the duplicate from strin
public class RemoveDuplicate {

    public static void main(String[] args) {
        String word="abbccpllpag";
        RemoveDuplicate removeDuplicate=new RemoveDuplicate();
       String val= removeDuplicate.optimizeWithList(word);
        System.out.println(val);
    }

    private String optimizeWithList(String word)
    {

        LinkedList<Character> list=new LinkedList<>();
        list.add(word.charAt(0));
        for(int i=1;i<word.length();i++)
        {
            if(list.size()>0) {
                Character ch = list.removeLast();
                if (ch.equals(word.charAt(i))) {


                } else {
                    list.add(ch);
                    list.add(word.charAt(i));
                }
            }else {
                list.add(word.charAt(i));
            }
        }
        return list.toString();
    }
}
