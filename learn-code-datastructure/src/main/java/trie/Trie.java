package main.java.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode {
        Map<Character, TrieNode> map;
        boolean isEndOfWord;

        public TrieNode() {
            this.map = new HashMap<>();
            this.isEndOfWord = false;
        }


    }

    private final TrieNode root;

    public Trie() {
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
        }
        return currentNode.isEndOfWord;
    }
}
