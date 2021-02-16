package main.java.online.assisment.efficent;

public class SubSetSearch {
    public static void main(String[] args) {

        System.out.println("check: "+"check".contains("he"));
    }

    public static String getSubSet(String actual,String set)
    {
        String sub="-1";
        char [] charSet=set.toCharArray();
        for(int i=0;i<charSet.length;i++)
        {
            if(!actual.contains(charSet[i]+""))
            {
                return sub;
            }
        }
        int mid=actual.length()/2;
        String part1=getSubSet(actual.substring(0,mid),set);
        String part2=getSubSet(actual.substring(mid),set);
        if(part1.equals(sub) && part2.equals(sub))
        {
            for(int i=1;i<actual.length();i++)
            {

                int low=i-1;
                int high=i;
                boolean match=false;
                while(low>=0 && high<actual.length() )
                {
                    String ss=actual.substring(low,high+1);
                    for(int j=0;j<set.length();j++)
                    {
                        if(!ss.contains(set.charAt(j)+""))
                        {
                            break;
                        }
                    }
                }
            }
        }


        return sub;
    }
}
