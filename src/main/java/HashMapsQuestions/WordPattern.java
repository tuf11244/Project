/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;

import java.util.HashMap;

/**
 * Date: 03/04/2024
 *https://leetcode.com/problems/word-pattern/
 * @author parth
 */
public class WordPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> wordToCharMap = new HashMap<>();
        HashMap<Character, String> charToWordMap = new HashMap<>();

        String[] strArray = s.split(" ");

        if (pattern.length() != strArray.length) {
            return false; // Different number of characters and words
        }

        for (int i = 0; i < pattern.length(); i++) {
            char charInPattern = pattern.charAt(i);
            String wordInString = strArray[i];

            if (wordToCharMap.containsKey(wordInString)) {
                // Check if the mapping is consistent
                if (wordToCharMap.get(wordInString) != charInPattern) {
                    return false; // Inconsistent mapping, return false
                }
            } else {
                // If the word is not in the map, add it to the map
                wordToCharMap.put(wordInString, charInPattern);
            }

            if (charToWordMap.containsKey(charInPattern)) {
                // Check if the mapping is consistent
                if (!charToWordMap.get(charInPattern).equals(wordInString)) {
                    return false; // Inconsistent mapping, return false
                }
            } else {
                // If the character is not in the map, add it to the map
                charToWordMap.put(charInPattern, wordInString);
            }
        }

        return true; // If the loop completes without finding inconsistencies, return true
    }
}
