/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsQuestions;
import java.util.*;
/**
 *Date: 01/12/2025
 * https://leetcode.com/problems/minimum-length-of-string-after-operations/
 * @author parth
 */
public class MinimumLengthofStringAfterOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minimumLength(String s) {
        
        // If the string has less than 3 characters, return its length immediately.
        // This is because a string with less than 3 characters cannot contain a group
        // of more than 2 identical characters, so no reduction happens.
        if (s.length() < 3) {
            return s.length();
        }

        // Create a HashMap to store the frequency of each character in the string.
        HashMap<Character, Integer> hm = new HashMap<>();

        // Traverse the string and populate the HashMap with character counts.
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            hm.put(currentChar, hm.getOrDefault(currentChar, 0) + 1);
        }

        // Variable to store the final result, i.e., the minimum length of the string.
        int answer = 0;

        // Iterate through the frequency values of all characters.
        for (int count : hm.values()) {
            // If the frequency of the character is less than 3, 
            // it cannot form a removable pair, so add it directly to the result.
            if (count < 3) {
                answer += count;
            } else {
                // For characters that appear more than 2 times,
                // reduce them in groups of 2 until only 0, 1, or 2 are left.
                // Pairs are "removed" by this operation.
                while (count > 2) {
                    count -= 2;
                }
                // Add the remaining characters (0, 1, or 2) to the result.
                answer += count;
            }
        }

        // Return the computed minimum length of the string.
        return answer;
    }
}
