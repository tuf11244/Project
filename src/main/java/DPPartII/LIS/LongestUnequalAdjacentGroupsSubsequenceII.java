/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DPPartII.LIS;
import java.util.*;
/**
 *Date: 05/17/2025
 * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/
 * @author parth
 */
public class LongestUnequalAdjacentGroupsSubsequenceII {
    public static void main(String[] args) {
        
    }
    
    //Can be solve using PRINT LIS logic and code but since we Queue it gives TLE on the last 3 test cases
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n]; // to track parent
        Arrays.fill(prev, -1);
        
        int maxLen = 0;
        int endIndex = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    isValid(words[i], words[j]) &&
                    dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }

        // Reconstruct the path using prev[]
        LinkedList<String> result = new LinkedList<>();
        while (endIndex != -1) {
            result.addFirst(words[endIndex]);
            endIndex = prev[endIndex];
        }

        return result;
    }

    private boolean isValid(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
