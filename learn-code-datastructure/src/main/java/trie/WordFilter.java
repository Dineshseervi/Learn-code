package main.java.trie;

import java.util.*;

class WordFilter {

    class Trie{
        HashMap<Character,Trie> map=new HashMap<>();
        boolean isEndOfWord=false;

        public Trie()
        {}

    }

    private Trie root=new Trie();

    public void insert(String word)
    {
        Trie node=root;
        for(int i=0;i<word.length();i++)
        {
            if(node.map.containsKey(word.charAt(i)))
            {
                node=node.map.get(word.charAt(i));
            }
            else{
                Trie newNode=new Trie();
                node.map.put(word.charAt(i),newNode);
                node=newNode;
            }
        }
        node.isEndOfWord=true;
    }

    public WordFilter(String[] words) {

        for(int i=0;i<words.length;i++)
        {
            this.insert(words[i]);
        }

    }

    public int f(String prefix, String suffix) {
        List<String> list=new ArrayList<>();
        iterateTrie(prefix,list);
        int count=0;
        for(String word:list)
        {
            if(word.endsWith(suffix))
            {
                return count;
            }
            count++;
        }
        return 0;

    }



    public void iterateTrie(String search , List<String> list)
    {
        Trie currentNode = root;
        String word="";
        iterateTrie(currentNode,word ,search,list);
    }

    public void iterateTrie(Trie rootNode, String word, String search, List<String> list) {
        if (rootNode == null) {
            return;
        }
        Trie currentNode = rootNode;
        Map<Character, Trie> map = currentNode.map;
        {
            for (Map.Entry<Character, Trie> entry : map.entrySet()) {


                Character ch = entry.getKey();
                if (search != null && !search.isEmpty()) {
                    if (search.charAt(0) == ch) {
                        Trie node = entry.getValue();
                        if (node != null) {
                            if (node.isEndOfWord) {
                                list.add(word + ch);
                            }
                            iterateTrie(entry.getValue(), word + ch, search.substring(1), list);
                        }
                    }
                } else {
                    Trie node = entry.getValue();
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
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
