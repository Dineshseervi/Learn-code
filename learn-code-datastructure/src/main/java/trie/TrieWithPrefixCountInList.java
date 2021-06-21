package main.java.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieWithPrefixCountInList {

    private class TrieNode {
        Map<Character, TrieNode> map;
        int occurrenceCount ;
        boolean isEndOfWord;

        private TrieNode() {
            this.map = new HashMap<>();
            this.isEndOfWord = false;
        }


    }

    private final TrieNode root;

    public TrieWithPrefixCountInList() {
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
            currentNode.occurrenceCount=currentNode.occurrenceCount +1 ;
          //  System.out.println(" occurrence count : "+currentNode.occurrenceCount);
        }
        currentNode.isEndOfWord = true;

    }

    public boolean searchWord(String word) {

        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
           TrieNode node= currentNode.map.get(word.charAt(i));
           if(node==null)
           {
               return false;
           }
           currentNode=node;
           // System.out.println(" occurrence count : "+currentNode.occurrenceCount +" char :"+word.charAt(i));
        }
        return currentNode.isEndOfWord;
    }

    public void iterateTrie(String search , List<String> list)
    {
        TrieNode currentNode = root;
        String word="";
        iterateTrie(currentNode,word ,search,list);
    }

    public void iterateTrie(TrieNode rootNode, String word, String search, List<String> list) {
        if (rootNode == null) {
            return;
        }
        TrieNode currentNode = rootNode;
        Map<Character, TrieNode> map = currentNode.map;
        {
            for (Map.Entry<Character, TrieNode> entry : map.entrySet()) {


                Character ch = entry.getKey();
                if (search != null && !search.isEmpty()) {
                    if (search.charAt(0) == ch) {
                        TrieNode node = entry.getValue();
                        if (node != null) {
                            if (node.isEndOfWord) {
                                list.add(word + ch);
                            }
                            iterateTrie(entry.getValue(), word + ch, search.substring(1), list);
                        }
                    }
                } else {
                    TrieNode node = entry.getValue();
                    if (node != null) {
                        if (node.isEndOfWord) {
                            list.add(word + ch);
                        }
                        iterateTrie(entry.getValue(), word + ch, null, list);
                    }
                }
            }
        }
    }

    public String getStringForMatchWord(String word)
    {

        return "";
    }


    /**
     *
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
        System.out.println("word : "+word);
        int size =word.length();
        if (word == null || size == 0) {
            return true;
        } else {
            for (int i = 1; i <= size; i++) {
                if (searchWord(word.substring(0, i)) && wordBreak(word.substring(i,size ))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //String [] words= {"Dinesh","Dinsstp","Dimahi","Rakesh","Manoj"};
        String [] words= {"geeikistest", "geeksforgeeks",
                "geeksfortest","geeipssters"};
        TrieWithPrefixCountInList trieWithPrefixCount=new TrieWithPrefixCountInList();
        for (int i=0 ;i<words.length;i++) {

            trieWithPrefixCount.insert(words[i]);
        }

        //search
        String wordToSearch="geeips";
        for (int i=0 ;i<wordToSearch.length();i++) {
            List<String> list=new ArrayList<>();
            trieWithPrefixCount.iterateTrie(wordToSearch.substring(0,i+1),list);
            System.out.println("list size "+list.size());
            System.out.println(" ");
        }


    }
}
