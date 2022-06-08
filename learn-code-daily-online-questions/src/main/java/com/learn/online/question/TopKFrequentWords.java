package com.learn.online.question;

/*
Given a non-empty list of words, return the k most frequent elements.
Your answer should be sorted by frequency from highest to lowest.
If two words have the same frequency, then the word with the lower alphabetical order comes first.
Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
*/

import java.util.*;

/**
 * Approach 1: Sorting
 * Count the frequency of each word, and sort the words with a custom ordering relation that uses these frequencies.
 * Then take the best k of them.
 * custom order: descend the frequency of each words.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Complexity Analysis
 * Time Complexity: O(NlogN), where N is the length of words.
 * We count the frequency of each word in O(N) time, then we sort the given words in O(NlogN) time.
 *Space Complexity: O(N), the space used to store our candidates.
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) {
            return new ArrayList<String>();
        }

        Map<String, Integer> map = new HashMap();
        for (String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> candidates = new ArrayList(map.keySet());
        Collections.sort(candidates, (w1, w2) -> map.get(w1) != map.get(w2) ?
                map.get(w2) - map.get(w1) : w1.compareTo(w2));

        return candidates.subList(0, k);
    }


    public List<String> topKFrequentWordsPriorityQueue(String[] words, int k) {
        List<String> rst = new ArrayList<>();
        if (words == null || words.length == 0) {
            return rst;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k,
                (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue()
                        : a.getKey().compareTo(b.getKey()));
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            maxHeap.add(set);
        }

        while (k > 0) {
            rst.add(maxHeap.poll().getKey());
            k--;
        }
        return rst;
    }

}
