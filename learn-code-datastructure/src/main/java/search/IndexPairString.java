package main.java.search;

import java.util.*;

/**
 *
 * https://leetcode.libaoj.in/index-pairs-of-a-string.html
 *
 * Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
 * Output: [[3,7],[9,13],[10,17]]
 * <p>
 * Input: text = "ababa", words = ["aba","ab"]
 * Output: [[0,1],[0,2],[2,3],[2,4]]
 * Explanation:
 * Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].
 * <p>
 * <p>
 * All strings contains only lowercase English letters.
 * It's guaranteed that all strings in words are different.
 * 1 <= text.length <= 100
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 50
 * Return the pairs [i,j] in sorted order (i.e. sort them by their first coordinate in case of ties sort them by their second coordinate).
 */
public class IndexPairString {

    public static int[][] indexPairs(String text, String[] words) {
        List<int[]> res = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;
        for (String s : words) {
            if (s.length() < minLength) {
                minLength = s.length();
            }
        }
        for (int i = 0; i < text.length() - (minLength - 1); i++) {
            //System.out.println("i :"+i);
            /*if(words.length==res.size())
            {
                break;
            }*/
            //System.out.println("i: "+i);
            for (String s : words) {
                if (i + s.length() > text.length()) continue;
                if (text.substring(i, i + s.length()).equals(s)) {
                    res.add(new int[]{i, i + s.length() - 1});
                }
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        Arrays.sort(ans, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return ans;
    }


    /**
     * // Runtime: 2 ms, faster than 96.89% of Java online submissions for Index Pairs of a String.
     * // Memory Usage: 36.4 MB, less than 50.00% of Java online submissions for Index Pairs of a String.
     * @param text
     * @param words
     * @return
     */
    public static int[][] indexPairsV2(String text, String[] words) {
        List<Integer[]> list = new ArrayList<>();
        for (String word: words){
            int firstIndex = 0;
            while (text.indexOf(word, firstIndex) != -1){
                int start = text.indexOf(word, firstIndex);
                Integer[] arr = {start, start + word.length() - 1};
                list.add(arr);
                firstIndex = start + 1;
            }
        }
        Collections.sort(list, (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
            res[i] = new int[]{list.get(i)[0], list.get(i)[1]};
        }
        return res;
    }

    public static void main(String[] args) {

        long curr = System.currentTimeMillis();
        System.out.println("start:" + curr);
        //int[][] arr = IndexPairString.getData("thestoryofleetcodeandme", new String[]{"story", "fleet", "leetcode"});
        //int[][] arr = IndexPairString.getData("ababa", new String[]{"aba", "ab"});
        int[][] arr = IndexPairString.getData("ababa", new String[]{"aba", "ab"});
        System.out.println("" + arr.length);
        System.out.println("end:" + (System.currentTimeMillis() - curr));

    }


    //self
    private static int[][] getData(String temp,String[] words)
    {
        List<Integer[]> list=new ArrayList<>();

        for(String word:words)
        {
            int startCurrentIndex=0;
            while ((startCurrentIndex=temp.indexOf(word,startCurrentIndex))!=-1)
            {
                Integer [] val={startCurrentIndex,startCurrentIndex+word.length()-1};
                startCurrentIndex=startCurrentIndex+word.length()-1;
                list.add(val);

            }

        }

        int[][] res=new int[list.size()][2];
        for (int i=0;i<list.size();i++)
        {
            res[i]= new int[]{list.get(i)[0], list.get(i)[1]};
        }
        return res;
    }
}
