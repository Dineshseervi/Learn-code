package com.learn.online.question.array;



import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class MaxMultiOfString {

    /*public int maxProduct(String[] words) {
        ArrayList<Integer> lis = new ArrayList<>();
        HashMap<String, Integer> m = new HashMap<>();
        for(String word : words) {
            int mask=0;
            for(char c : word.toCharArray()) {
                mask = mask | (1<<(c-'a'));
            }
            lis.add(new Integer(mask));
            m.put(word,mask);

        }
        int max=0;
        for(int i=0;i<words.length;i++)
            for(int j=i+1;j<words.length;j++) {
                Integer a = (Integer)m.get(words[i]);
                Integer b = (Integer) m.get(words[j]);
                if((a&b)==0) {
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }

        return max;
    }*/

    public int maxProduct(String[] words) {
        int res[]=new int[words.length];

        for(int i=0;i<words.length;i++)
        {
            String word=words[i];

            int num=0;

            for(int j=0;j<word.length();j++){

                int index=1<<(word.charAt(j)-'a');

                num=num | index;

            }

            res[i]=num;
        }

        int value=0;

        for(int i=0;i<res.length;i++){

            for(int j=i+1;j<res.length;j++){

                if((res[i] & res[j])==0){

                    if(value<words[i].length()*words[j].length())
                        value=words[i].length()*words[j].length();
                }

            }


        }


        return value;

    }


    public int getAndOperation(String first,String second)
    {

        int num1=bitOperation(first);
        int num2=bitOperation(second);
        return  num1 & num2;
    }

    private int bitOperation(String word)
    {
        int num=0;

        for(int j=0;j<word.length();j++){

            int index=1<<(word.charAt(j)-'a');

            num=num | index;

        }
        return num;
    }
}
