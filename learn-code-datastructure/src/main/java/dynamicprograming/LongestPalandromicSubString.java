package main.java.dynamicprograming;

public class LongestPalandromicSubString {

    public static void main(String[] args) {
        //LongestPalandromicSubString longestPalandromicSubString = new LongestPalandromicSubString();
        //total loops483380
        //System.out.println(longestPalandromicSubString.getLongestPalandromicString("abdbca"));
        String url="https://console.dms.preview.usw2.ficoanalyticcloud.com/com.fico.dmp.manager";
        String [] arr=url.split("[a-zA-Z0-9]+/");
        //url.
        System.out.println(arr[0] );
        System.out.println(arr[1] );
        //System.out.println("total loops"+count);
    }

    private int getLongestPalandromicString(String st) {
        return getLongestPalandromicString(st, 0, st.length() - 1);
    }

    //a b d b c a
    //0 1 2 3 4 5
    private int getLongestPalandromicString(String st, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }

        if (st.charAt(start) == st.charAt(end)) {
            int remainingLength = (end) - (start )- 1;
            //System.out.println("remain: " + remainingLength + " __start:" + start + " --end:" + end);
            int come=getLongestPalandromicString(st, start + 1, end - 1);
            //System.out.println("come:"+come);
            if (remainingLength==come)
            {
                //System.out.println("---------------"+remainingLength);
                return remainingLength + 2;
            }
        }
        int a = getLongestPalandromicString(st, start+1, end );
        int b = getLongestPalandromicString(st, start, end-1);
        //System.out.println("a:"+a+"  _____ b:"+b);
        //System.out.println("val"+Math.max(a, b));
        return Math.max(a, b);
    }
}
