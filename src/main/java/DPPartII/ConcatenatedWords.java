/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;  // Declares the package in which this class resides

import java.util.*;  // Imports required Java utility classes

/**
 * Date: 02/05/2025
 * @author Parth
 */
// https://leetcode.com/problems/concatenated-words/
import java.util.List;
import java.util.ArrayList;

public class ConcatenatedWords {
    public static void main(String[] args) {
        System.out.println("Hello World");  // Placeholder main method, prints "Hello World"

        // Sample input: a list of words
        String[] words = {
            "cat", "cats", "catsdogcats", "dog", "dogcatsdog", 
            "hippopotamuses", "rat", "ratcatdogcat"
        };

        // Uncomment the below lines to test the function
        // List<String> answer = findAllConcatenatedWordsInADict(words);
        // System.out.println(answer);
    }

    /**
     * This method finds all concatenated words in a dictionary.
     * A concatenated word is a word that can be formed by concatenating two or more words from the dictionary.
     *
     * @param words An array of words.
     * @return A list of concatenated words.
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));  // Convert words array to a HashSet for O(1) lookup
        List<String> answer = new ArrayList<>();  // Stores the concatenated words found

        for (String word : words) {
            set.remove(word);  // Temporarily remove the current word to avoid using itself in the concatenation check
            if (isConcatenated(word, set, new HashMap<>())) {  // Check if the word is a concatenated word
                answer.add(word);  // If true, add it to the answer list
            }
            set.add(word);  // Restore the word after checking
        }

        return answer;
    }

    /**
     * This method checks if a given word can be formed by concatenating other words in the dictionary.
     *
     * @param word The word to check.
     * @param set The set of words to use for forming concatenations.
     * @param memo A hashmap to store computed results for memoization (avoid redundant calculations).
     * @return True if the word is a concatenated word, false otherwise.
     */
    private boolean isConcatenated(String word, HashSet<String> set, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) return memo.get(word);  // Return cached result if already computed

        // Try breaking the word at different positions to check for valid concatenations
        for (int i = 1; i < word.length(); i++) {  // Start from index 1 to avoid empty prefix
            String prefix = word.substring(0, i);  // Extract prefix
            String suffix = word.substring(i);  // Extract suffix

            // Check if prefix is in the set and the suffix is either in the set or can be formed recursively
            if (set.contains(prefix) && (set.contains(suffix) || isConcatenated(suffix, set, memo))) {
                memo.put(word, true);  // Store result in memoization map
                return true;  // The word is a concatenated word
            }
        }

        memo.put(word, false);  // Store result in memoization map
        return false;  // The word is not a concatenated word
    }
}
