/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 * Date: 12/20/2023
 *https://leetcode.com/problems/maximum-number-of-removable-characters/
 * @author parth
 */
public class MaximumNumberofRemovableCharacters {

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] removable = {0, 1, 2, 3, 4};
        System.out.println(maximalRemovals("abcab", "abc", removable));
    }

    // Function to find the maximum number of removable characters
    public static int maximalRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length;

        // Binary search to find the maximum number of removable characters
        while (left < right) {
            int mid = (left + right + 1) / 2;

            // Check if p is a subsequence of s after removing mid characters
            if (isSubsequence(s, p, removable, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        // The result is stored in 'left'
        return left;
    }

    // Function to check if p is a subsequence of s after removing k characters
    public static boolean isSubsequence(String s, String p, int[] removable, int k) {
        boolean[] removed = new boolean[s.length()];

        // Mark the first k characters as removed
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }

        int j = 0;
        // Check if p is a subsequence of s after removing the marked characters
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!removed[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }

        // If j equals the length of p, then p is a subsequence of s
        return j == p.length();
    }
}
