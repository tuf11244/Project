/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;
import java.util.*;
/**
 *Date:10/04/2024
 * Same code as find all Anagrams
 * https://leetcode.com/problems/permutation-in-string/
 * @author parth
 */
public class PermutationinaString {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public boolean checkInclusion(String s1, String s2) {
    // Create a frequency map for s1
    HashMap<Character, Integer> hm1 = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
        hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
    }

    // Sliding window setup
    int i = 0, j = 0;
    HashMap<Character, Integer> hm2 = new HashMap<>();

    // Traverse through s2
    while (i < s2.length()) {
        // Add the current character to the window
        hm2.put(s2.charAt(i), hm2.getOrDefault(s2.charAt(i), 0) + 1);

        // If the window size is smaller than s1, keep expanding
        if (i - j + 1 < s1.length()) {
            i++;
        }
        // When the window size matches s1.length()
        else if (i - j + 1 == s1.length()) {
            // Check if the two hashmaps are equal
            if (hm2.equals(hm1)) {
                return true;
            }

            // Shrink the window by removing s2.charAt(j)
            char ch = s2.charAt(j);
            if (hm2.get(ch) == 1) {
                hm2.remove(ch);
            } else {
                hm2.put(ch, hm2.get(ch) - 1);
            }

            // Move the window forward
            j++;
            i++;
        }
    }

    return false;
}
}
