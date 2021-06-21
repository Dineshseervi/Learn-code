package main.java.trie;

import java.util.HashMap;
import java.util.Map;

public class PhoneDirectoryTrie {

    private class TrieNode {
        Map<Character, TrieNode> map;
        int occurrenceCount;
        boolean isEndOfWord;

        private TrieNode() {
            this.map = new HashMap<>();
            this.isEndOfWord = false;
        }


    }

    private final TrieNode root;

    public PhoneDirectoryTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.map.get(ch);
            if (node == null) {
                node = new TrieNode();
                currentNode.map.put(ch, node);
            }
            currentNode = node;
            currentNode.occurrenceCount = currentNode.occurrenceCount + 1;
            //  System.out.println(" occurrence count : "+currentNode.occurrenceCount);
        }
        currentNode.isEndOfWord = true;

    }

    public boolean searchWord(String word) {

        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = currentNode.map.get(word.charAt(i));
            if (node == null) {
                return false;
            }
            currentNode = node;
            // System.out.println(" occurrence count : "+currentNode.occurrenceCount +" char :"+word.charAt(i));
        }
        return currentNode.isEndOfWord;
    }

    public void iterateTrie() {
        TrieNode currentNode = root;
        String word = "";
        iterateTrie(currentNode, word);
    }

    public void iterateTrie(TrieNode rootNode, String word) {
        if (rootNode == null) {
            return;
        }
        TrieNode currentNode = rootNode;
        //String  word="";
        Map<Character, TrieNode> map = currentNode.map;
        {
            for (Map.Entry<Character, TrieNode> entry : map.entrySet()) {

                Character ch = entry.getKey();
                TrieNode node = entry.getValue();
                if (node != null) {
                    if (node.isEndOfWord) {
                        System.out.println("word :" + word + ch);
                    }
                    iterateTrie(entry.getValue(), word + ch);
                }

                // System.out.println(ch);


            }
        }


        // return word;
    }

    public String getStringForMatchWord(String word) {

        return "";
    }


    /**
     * ilikesamsungicecream
     * likesamsungicecream
     * samsungicecream
     * sungicecream
     * icecream-> i cecream -> icecream
     *
     * @param word
     * @return
     */
    public boolean wordBreak(String word) {
        System.out.println("word : " + word);
        int size = word.length();
        if (word == null || size == 0) {
            return true;
        } else {
            for (int i = 1; i <= size; i++) {
                if (searchWord(word.substring(0, i)) && wordBreak(word.substring(i, size))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //String [] words= {"Dinesh","Dinsstp","Dimahi","Rakesh","Manoj"};
        String[] words = {"mobile", "samsung",
                "sam", "sung", "ma",
                "mango", "icecream",
                "and", "go", "i", "like",
                "ice"};
        PhoneDirectoryTrie trieWithPrefixCount = new PhoneDirectoryTrie();
        for (int i = 0; i < words.length; i++) {

            trieWithPrefixCount.insert(words[i]);
        }

        String aa = "word";


        //search
        /*for (int i=0 ;i<words.length;i++) {

          boolean val=   trieWithPrefixCount.searchWord(words[i]);
            System.out.println("val :" +val);
        }
*/

        System.out.print(trieWithPrefixCount.wordBreak("ilikesamsungicecream") ?
                "Yes\n" : "No\n");

        trieWithPrefixCount.iterateTrie();

    }
}
