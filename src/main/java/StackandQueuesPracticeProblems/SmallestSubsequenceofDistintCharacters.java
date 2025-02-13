/*
 * This program finds the smallest subsequence of distinct characters in a given string.
 * It ensures that the result is in lexicographically smallest order.
 *
 * Related Problems:
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Author: Parth
 * Date: 02/11/2025
 */

package StackandQueuesPracticeProblems;
import java.util.*;

public class SmallestSubsequenceofDistintCharacters {

    public static void main(String args[]) {
        // TODO: Code execution logic here (currently empty)
    }

    /**
     * This method returns the lexicographically smallest subsequence of distinct characters.
     * 
     * @param s The input string
     * @return The smallest subsequence of distinct characters
     */
    public String smallestsubsequence(String s) {
        
        // Array to store frequency of each character in the string
        int[] map = new int[26];

        // Populate the frequency map
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        // Boolean array to keep track of characters already added to result
        boolean[] used = new boolean[26];

        // Deque (double-ended queue) to store the resulting sequence
        Deque<Character> deque = new LinkedList<>();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Decrease the frequency of the current character
            map[ch - 'a']--; 

            // If character is already in the result, skip it
            if (used[ch - 'a']) {
                continue;
            }

            // Maintain lexicographical order by removing characters that:
            // - Are greater than the current character
            // - Appear later in the string
            while (!deque.isEmpty() && deque.peekLast() > ch && map[deque.peekLast() - 'a'] > 0) {
                char removed = deque.pollLast();
                used[removed - 'a'] = false; // Mark the removed character as unused
            }

            // Add the current character to the deque
            deque.addLast(ch);
            used[ch - 'a'] = true; // Mark it as used
        }

        // Build the resulting string from the deque
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }
}
