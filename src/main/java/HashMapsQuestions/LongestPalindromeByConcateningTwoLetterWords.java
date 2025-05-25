/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashMapsQuestions;
import java.util.*;
/**
 *Date: 05/25/2025
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
 * @author parth
 */
public class LongestPalindromeByConcateningTwoLetterWords {
    public static void main(String[] args) {
        
    }
    
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        boolean centralUsed = false;

        for (String key : hm.keySet()) {
            String rev = getReverse(key);

            // Case 1: same characters like "gg"
            if (key.charAt(0) == key.charAt(1)) {
                int freq = hm.get(key);
                count += (freq / 2) * 4; // each pair contributes 4 length
                if (freq % 2 == 1) centralUsed = true;
            }
            // Case 2: different characters like "ab" and "ba"
            else if (key.compareTo(rev) < 0 && hm.containsKey(rev)) {
                int pairCount = Math.min(hm.get(key), hm.get(rev));
                count += pairCount * 4; // each pair "ab" + "ba" contributes 4 length
            }
        }

        if (centralUsed) count += 2;

        return count;
    }

    private String getReverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
