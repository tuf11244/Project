/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;
import java.util.*;
/**
 *Date: 06/04/2024
 * https://leetcode.com/problems/longest-palindrome/
 * @author parth
 */
public class LongestPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public static int longestPalindrome(String s) {
       if (s.length() == 1) {
            return 1;
        }

        // Create a frequency hashmap
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        int length = 0;
        boolean oddFound = false;

        for (int value : hm.values()) {
            if (value % 2 == 0) {
                length += value;
            } else {
                length += value - 1;
                oddFound = true;
            }
        }

        if (oddFound) {
            length += 1;
        }

        return length;
    }
}
