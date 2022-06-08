package main.java.online.assisment;

public class ReverseWord {
    public static void main(String[] args) {
        /*String words="Hello World how are you";
        System.out.println("length:"+words.length());
        reverseTheString(words.toCharArray());
        System.out.println("");
        reserveStringWithSplit(words);*/
       // char[] s = getArray("Hello World!");
        char[] s = "Hello World".toCharArray();
        System.out.println(s);
        reverseWords(s);
        System.out.println(s);
    }

    /**
     * time complexity is O(n*n) and space is O(1)
     * @param words
     */
    private static void reverseTheString(char [] words) {
        if(words==null || words.length==0)
        {
            return;
        }

        int last=words.length;


        for(int i=words.length-1;i>=0;i--)
        {
            if(i==0 || words[i-1] == ' ' )
            {
                for(int j=i;j<last;j++)
                {
                    System.out.print(""+words[j]);
                }
                if(i!=0 && words[i-1] == ' ')
                {
                    System.out.print(""+words[i-1]);
                    last=i-1;
                }


            }
        }
    }

    /**
     * Time it took is O(n)
     * space it took is O(n)
     * @param words
     */
    public static void reserveStringWithSplit(String words)
    {
        if(words==null || words.length()==0)
        {
            return ;
        }
        String [] wordArray=words.split(" ");
        String reverseWord="";
        for (int i=wordArray.length-1;i>=0;i--)
        {
            reverseWord+=wordArray[i]+ (i==0?"":" ");
        }
        System.out.println(reverseWord);
        System.out.println("reverseWord length:"+reverseWord.length());
    }


    //////
    // Null terminating strings are not used in java
    public static void strRev(char[] str, int start, int end) {
        if (str == null || str.length < 2) {
            return;
        }

        while (start < end) {

            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            start++;
            end--;
        }
    }

    /**
     *Time complexity is O(n) and space complexity is O(1).
     *
     * So reverse the complete string, then iterate each word once space is reached or end of string is there then again reverse the string elements.
     * @param sentence
     */
    public static void reverseWords(char[] sentence) {

        // Here sentence is a null-terminated string ending with char '\0'.
        //- Here we first check a null-terminate string is
        if (sentence == null || sentence.length == 0) {
            return;
        }

        // To reverse all words in the string, we will first reverse
        // the string. Now all the words are in the desired location, but
        // in reverse order: "Hello World" -> "dlroW olleH".

        int len = sentence.length;
        strRev(sentence, 0, len - 1);
        System.out.println(sentence);//print the reverse string

        // Now, let's iterate the sentence and reverse each word in place.
        // "dlroW olleH" -> "World Hello"

        int start = 0;
        int end;
        while (true) {
            // find the  start index of a word while skipping spaces.
            while (sentence[start] == ' ') {
                ++start;
            }
            //check does start index is more then sentence length.
            if (start >= sentence.length - 1) {
                break;
            }

            // find the end index of the word.and check just after word end space is there
            end = start +1;
            while (end < sentence.length - 1 && sentence[end] != ' ') {
                end++;
            }

            // let's reverse the word in-place.
            if(end==sentence.length - 1)
            {
                strRev(sentence, start, end );
            }else{
                strRev(sentence, start, end - 1);
            }

            start = end;
        }
    }

    static char[] getArray(String t) {
        char[] s = new char[t.length() + 1];
        int i = 0;
        for (; i < t.length(); ++i) {
            s[i] = t.charAt(i);
        }
        return s;
    }

}
