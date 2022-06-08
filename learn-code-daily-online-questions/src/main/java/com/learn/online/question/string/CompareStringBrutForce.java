package com.learn.online.question.string;

import java.util.HashMap;
import java.util.Map;

public class CompareStringBrutForce implements StringCompare {
    @Override
    public int compare(String haystack, String needle) {
        if(haystack == needle || (haystack.length()==0 && needle.length()==0))
        {
            return 0;
        }
        char [] parentChar=haystack.toCharArray();
        char [] childChar=needle.toCharArray();
        int iMax=parentChar.length-1;
        for(int i=0;i<parentChar.length -(childChar.length-1);i++)
        {
            boolean flag=true;
            for(int j=0;j<childChar.length;j++)
            {
                if(iMax<i+j)
                {
                    return -1;
                }
                if(parentChar[i+j]!=childChar[j])
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                return i;
            }
        }
        return -1;
    }

    ///

    public static int strStr(String haystack, String needle) {
        if(needle==null || needle.isEmpty() || haystack.equals(needle)){
            return 0;
        }

        int index = -1;
        int lenH = haystack.length();
        int lenN = needle.length();
        int diff = lenH - lenN;

        if(diff<0){
            return index;
        }

        int i=0;
        int j=lenN;

        while(i<=lenH && j<=lenH){
            String sub = haystack.substring(i,j);
            if(sub.equals(needle)){
                return i;
            }
            i++;
            j++;
        }

        return index;
    }

    //StrStrStringhAlgo
    //StrStringh
    //
    public static int strKma(String haystack, String needle) {
        if(needle==null || needle.length()==0 || haystack==null)
        {
            return 0;
        }

        int lenP=haystack.length();
        int lenC=needle.length();
        int i=0;
        int j=0;
        int num=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while (i<lenP)
        {
            boolean match=true;
            while (j<lenC && match)
            {

                if(i+j>=lenP)
                {return 0;
                }
                if(haystack.charAt(i+j)!=needle.charAt(j))
                {
                    match=false;
                    num=match(j, needle,map);
                }
                if(num==0) {
                    j++;
                }
            }
            if(match)
            {

                return i;
            }

            if(num==0) {
                i++;
                j=0;
            }else{
                i+=num;
                j+=num;
                num=0;
            }
        }

        return 0;
    }

    public static int match(int j,String needle, Map<Integer,Integer> map)
    {
        if(map.containsKey(j-1))
        {
            return map.get(j-1);
        }
        String str=needle.substring(0,j);
        int size=str.length();
        int i=0;
        int num=0;
        while (i<size/2)
        {
            if(str.substring(0,i) ==str.substring(size-(i+1)))
            {
                num=i;
            }
            i++;
        }
        map.put(str.length(),num);
        return num;
    }

    public static void main(String[] args) {
        StringCompare stringCompare=new  CompareStringBrutForce();
        long startTime=System.currentTimeMillis();
        //String parent="KMP string search algorithm searches a pattern in a text. It can search a particular word in a  text paragraph.  It is an efficient algorithm with less time complexity , O(m+n) where m = length of text and n = length of pattern" ;
        String parent="mississipipi";
        String child="issipi";
        int val=strKma(parent,child);
        //int val=stringCompare.compare(parent,child);
        System.out.println("time :"+(System.currentTimeMillis()-startTime));
        System.out.println("val:"+val);

    }
}

interface StringCompare
{
    int compare(String parent,String child);

}