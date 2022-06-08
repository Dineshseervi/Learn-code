package main.java.online.assisment.efficent;

public class UnCommonCharacter {
    public static void main(String[] args) {

        String a="geeksforgeeks";
        String b="geeksquiz";

        String result=getUncommonChar(a,b);
        System.out.println("result: "+result);
    }

    public static String getUncommonChar(String a,String b)
    {
         final int MAX_COUNT=26;
        char [] charArray=new char[MAX_COUNT];
        for(int i=0;i<MAX_COUNT;i++)
        {
            charArray[i]='A';
        }
        for(int i=0;i<a.length();i++)
        {
            //charArray[i]=a.charAt(i);
           char character= a.charAt(i);
           charArray[character-'a']=character;
        }

        //String a="geeksforgeeks";
        //String b="geeksquiz";
        //fioqruz
        for(int i=0;i<b.length();i++)
        {
            //if(charArray[i]
            char character= b.charAt(i);
            if(charArray[character-'a']=='A')
            {
                charArray[character-'a']=character;
            }
            else{
                charArray[character-'a']='B';
            }
        }
        String var="";
        int i=0;
        while (i<MAX_COUNT)
        {
            char character=charArray[i];
            if(character!='A' && character!='B')
            {
                var=var+character;
            }
            i++;
        }

        return var.equals("")?"-1":var;
    }
}
